package com.cardpay.sdk.uat.recurring.scheduled;

import com.cardpay.sdk.api.RecurringsApi;
import com.cardpay.sdk.client.ApiClient;
import com.cardpay.sdk.model.*;
import com.cardpay.sdk.utils.HttpUtils;
import io.codearte.jfairy.Fairy;
import io.codearte.jfairy.producer.BaseProducer;
import io.codearte.jfairy.producer.person.Person;
import io.codearte.jfairy.producer.text.TextProducer;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit2.Response;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.ZoneOffset;

import static com.cardpay.sdk.Config.*;
import static com.cardpay.sdk.Constants.PAYMENT_METHOD_BANKCARD;
import static com.cardpay.sdk.Constants.CARD_3DS_CONFIRMED;
import static com.cardpay.sdk.model.RecurringPlanRequestPlanData.PeriodEnum.WEEK;
import static com.cardpay.sdk.utils.DataUtils.*;
import static java.time.OffsetDateTime.now;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

public class RecurringScheduledGracePeriodSubscriptionUAT {

    private final Logger log = LoggerFactory.getLogger(getClass());

    private Fairy fairy = Fairy.create();
    private Person person = fairy.person();
    private BaseProducer producer = fairy.baseProducer();
    private TextProducer text = fairy.textProducer();

    private RecurringsApi recurrings;

    @Before
    public void setUp() {
        recurrings = new ApiClient(CARDPAY_API_URL, GATEWAY_TERMINAL_CODE, GATEWAY_PASSWORD)
                .addLogging(LOGGING_LEVEL)
                .createService(RecurringsApi.class);
    }

    @Test
    public void scheduledSubscription() throws IOException {
        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        // Phase 1: prepare a new plan
        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


        // perform create recurring plan
        Response<RecurringPlanResponse> recurringPlanResponse = recurrings
                .createPlan(createRecurringPlanRequest())
                .execute();

        RecurringPlanResponse planResponse = recurringPlanResponse.body();
        assertNotNull(planResponse);
        log.info("{}", planResponse);

        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        // Input Data
        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

        // merchant order data
        String merchantOrderId = generateMerchantOrderId();
        String merchantDescription = text.sentence();

        // card data
        String cardPan = CARD_3DS_CONFIRMED;
        String cardHolder = person.getFullName().toUpperCase();
        String securityCode = "100";
        String cardExpiration = formatDate("MM/yyyy", generateCardExpiration());

        // customer data
        String customerId = text.randomString(15);
        String customerEmail = generateEmail();

        // recurring data
        String planId = planResponse.getPlanData().getId();
        String initiator = "cit";

        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        // Phase 2: create scheduled subscription
        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        RecurringCreationRequest recurringRequest = new RecurringCreationRequest()
                .request(ApiClient.uuidRequest())
                .customer(new RecurringCustomer()
                        .id(customerId)
                        .email(customerEmail))
                .merchantOrder(new PaymentRequestMerchantOrder()
                        .id(merchantOrderId)
                        .description(merchantDescription))
                .paymentMethod(PAYMENT_METHOD_BANKCARD)
                .cardAccount(new PaymentRequestCardAccount().card(new PaymentRequestCard()
                        .pan(cardPan)
                        .holder(cardHolder)
                        .securityCode(securityCode)
                        .expiration(cardExpiration)))
                .recurringData(new RecurringRequestRecurringData()
                        .plan(new Plan().id(planId))
                        .initiator(initiator)
                        .subscriptionStart(now().plusMonths(6).withNano(0).atZoneSameInstant(ZoneOffset.UTC).toOffsetDateTime()))
                .returnUrls(new ReturnUrls()
                        .successUrl(SUCCESS_URL)
                        .declineUrl(DECLINE_URL)
                        .cancelUrl(CANCEL_URL)
                        .inprocessUrl(INPROCESS_URL)
                );

        log.info("{}", recurringRequest);

        // perform create create scheduled subscription
        Response<RecurringCreationResponse> response = recurrings
                .createRecurring(recurringRequest)
                .execute();
        log.info("{}", response);

        RecurringCreationResponse body = response.body();
        assertNotNull(body);
        log.info("{}", body);

        // get redirect url
        final String redirectUrl = body.getRedirectUrl();
        assertNotNull(redirectUrl);
        assertFalse(redirectUrl.isEmpty());

        // Emulate customer behaviour performing GET request to redirect url
        HttpUtils.doGet(body.getRedirectUrl());
    }

    private RecurringPlanRequest createRecurringPlanRequest() {
        return new RecurringPlanRequest()
                .request(ApiClient.uuidRequest())
                .planData(new RecurringPlanRequestPlanData()
                        .currency(TERMINAL_CURRENCY)
                        .amount(BigDecimal.valueOf(producer.randomBetween(10, 300)))
                        .interval(producer.randomBetween(1, 52))
                        .name(text.randomString(15))
                        .period(WEEK)
                );
    }
}
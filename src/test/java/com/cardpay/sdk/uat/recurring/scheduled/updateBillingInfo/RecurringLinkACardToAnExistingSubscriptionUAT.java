package com.cardpay.sdk.uat.recurring.scheduled.updateBillingInfo;

import com.cardpay.sdk.api.RecurringsApi;
import com.cardpay.sdk.client.ApiClient;
import com.cardpay.sdk.model.*;
import com.cardpay.sdk.utils.HttpUtils;
import io.codearte.jfairy.Fairy;
import io.codearte.jfairy.producer.BaseProducer;
import io.codearte.jfairy.producer.person.Person;
import io.codearte.jfairy.producer.text.TextProducer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit2.Response;

import java.io.IOException;
import java.math.BigDecimal;

import static com.cardpay.sdk.Config.*;
import static com.cardpay.sdk.Constants.PAYMENT_METHOD_BANKCARD;
import static com.cardpay.sdk.Constants.CARD_NON3DS_CONFIRMED;
import static com.cardpay.sdk.model.RecurringPlanRequestPlanData.PeriodEnum.WEEK;
import static com.cardpay.sdk.utils.DataUtils.*;
import static com.cardpay.sdk.utils.RecurringUtils.doCancelSubscription;
import static com.cardpay.sdk.utils.RecurringUtils.fetchRecurring;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

public class RecurringLinkACardToAnExistingSubscriptionUAT {

    private final Logger log = LoggerFactory.getLogger(getClass());

    private Fairy fairy = Fairy.create();
    private Person person = fairy.person();
    private BaseProducer producer = fairy.baseProducer();
    private TextProducer text = fairy.textProducer();

    private RecurringsApi recurrings;
    private String subscriptionId;

    @Before
    public void setUp() {
        recurrings = new ApiClient(CARDPAY_API_URL, GATEWAY_TERMINAL_CODE, GATEWAY_PASSWORD)
                .addLogging(LOGGING_LEVEL)
                .createService(RecurringsApi.class);
    }

    @After
    public void cleanUp() throws IOException {
        doCancelSubscription(recurrings, subscriptionId);
    }

    @Test
    public void linkACardToAnExistingSubscription() throws IOException {
        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        // Phase 1: prepare a new plan
        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

        // prepare recurring plan request data
        RecurringPlanRequest recurringPlanRequest = createRecurringPlanRequest();

        // perform create recurring plan
        Response<RecurringPlanResponse> recurringPlanResponse = recurrings.createPlan(recurringPlanRequest).execute();
        log.info("{}", recurringPlanResponse);

        assertNotNull(recurringPlanResponse.body());
        log.info("{}", recurringPlanResponse.body());

        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        // Phase 2: create scheduled subscription
        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

        // get paln id
        String planId = recurringPlanResponse.body().getPlanData().getId();

        // prepare scheduled subscription request data
        RecurringCreationRequest recurringRequest = createRecurringRequest(planId);

        log.info("{}", recurringRequest);

        // perform create scheduled subscription
        Response<RecurringCreationResponse> recurringCreationResponse = recurrings.createRecurring(recurringRequest).execute();
        log.info("{}", recurringCreationResponse);

        RecurringCreationResponse creationResponse = recurringCreationResponse.body();
        log.info("{}", creationResponse);

        assertNotNull(creationResponse);

        // get redirect url
        final String redirectUrlRecurring = creationResponse.getRedirectUrl();
        assertNotNull(redirectUrlRecurring);
        assertFalse(redirectUrlRecurring.isEmpty());

        // Emulate customer behaviour performing GET request to redirect url
        HttpUtils.doGet(creationResponse.getRedirectUrl());

        RecurringResponse recurringResponse = fetchRecurring(recurrings, recurringRequest.getMerchantOrder().getId());
        assertNotNull(recurringResponse);
        subscriptionId = recurringResponse.getRecurringData().getSubscription().getId();

        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        // Filling Data
        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

        // merchant order data
        String merchantOrderId = generateMerchantOrderId();
        String merchantDescription = text.sentence();
        String initiator = "cit";

        // card data
        String cardPan = CARD_NON3DS_CONFIRMED;
        String cardHolder = person.getFullName().toUpperCase();
        String securityCode = "100";
        String cardExpiration = formatDate("MM/yyyy", generateCardExpiration());

        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        // Phase 3: link a card to an existing subscription
        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

        // prepare filing request data
        FilingRequest filingRequest = new FilingRequest()
                .request(ApiClient.uuidRequest())
                .merchantOrder(new FilingRequestMerchantOrder()
                        .id(merchantOrderId)
                        .description(merchantDescription))
                .paymentMethod(PAYMENT_METHOD_BANKCARD)
                .cardAccount(new PaymentRequestCardAccount().card(new PaymentRequestCard()
                        .pan(cardPan)
                        .holder(cardHolder)
                        .securityCode(securityCode)
                        .expiration(cardExpiration)))
                .subscriptionData(new FilingRequestSubscriptionData()
                        .id(subscriptionId))
                .recurringData(new FilingRecurringData()
                        .initiator(initiator))
                .returnUrls(new ReturnUrls()
                        .successUrl(SUCCESS_URL)
                        .declineUrl(DECLINE_URL)
                        .cancelUrl(CANCEL_URL)
                        .inprocessUrl(INPROCESS_URL)
                );

        // perform create link a card to an existing subscription
        Response<PaymentCreationResponse> response = recurrings
                .createFiling(filingRequest)
                .execute();
        log.info("{}", response);

        PaymentCreationResponse data = response.body();
        assertNotNull(data);
        log.info("{}", data);

        final String redirectUrl = data.getRedirectUrl();
        assertNotNull(redirectUrl);
        assertFalse(redirectUrl.isEmpty());

        // Emulate customer behaviour performing GET request to redirect url
        HttpUtils.doGet(data.getRedirectUrl());
    }

    private RecurringCreationRequest createRecurringRequest(String planId) {
        return new RecurringCreationRequest()
                .request(ApiClient.uuidRequest())
                .customer(new RecurringCustomer()
                        .id(text.randomString(15))
                        .email(generateEmail()))
                .merchantOrder(new PaymentRequestMerchantOrder()
                        .id(generateMerchantOrderId())
                        .description(text.sentence()))
                .paymentMethod(PAYMENT_METHOD_BANKCARD)
                .cardAccount(new PaymentRequestCardAccount().card(new PaymentRequestCard()
                        .pan(CARD_NON3DS_CONFIRMED)
                        .holder(person.getFullName().toUpperCase())
                        .securityCode("100")
                        .expiration(formatDate("MM/yyyy", generateCardExpiration()))))
                .recurringData(new RecurringRequestRecurringData()
                        .plan(new Plan().id(planId))
                        .initiator("cit"))
                .returnUrls(new ReturnUrls()
                        .successUrl(SUCCESS_URL)
                        .declineUrl(DECLINE_URL)
                        .cancelUrl(CANCEL_URL)
                        .inprocessUrl(INPROCESS_URL)
                );
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

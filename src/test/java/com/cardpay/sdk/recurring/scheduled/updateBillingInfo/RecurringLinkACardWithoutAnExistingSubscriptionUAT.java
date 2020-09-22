package com.cardpay.sdk.recurring.scheduled.updateBillingInfo;

import static com.cardpay.sdk.Config.CARDPAY_API_URL;
import static com.cardpay.sdk.Config.GATEWAY_PASSWORD;
import static com.cardpay.sdk.Config.GATEWAY_TERMINAL_CODE;
import static com.cardpay.sdk.Config.LOGGING_LEVEL;
import static com.cardpay.sdk.Config.TERMINAL_CURRENCY;
import static com.cardpay.sdk.Constants.CARD_NON3DS_CONFIRMED;
import static com.cardpay.sdk.Constants.PAYMENT_METHOD_BANKCARD;
import static com.cardpay.sdk.client.StringUtil.formatExpirationDate;
import static com.cardpay.sdk.utils.DataUtils.generateCardExpiration;
import static com.cardpay.sdk.utils.DataUtils.generateEmail;
import static com.cardpay.sdk.utils.DataUtils.paymentRequestCardAccount;
import static com.cardpay.sdk.utils.DataUtils.returnUrls;
import static com.cardpay.sdk.utils.RecurringUtils.doCancelSubscription;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import com.cardpay.sdk.api.RecurringsApi;
import com.cardpay.sdk.client.ApiClient;
import com.cardpay.sdk.model.FilingRecurringData;
import com.cardpay.sdk.model.FilingRequest;
import com.cardpay.sdk.model.FilingRequestMerchantOrder;
import com.cardpay.sdk.model.RecurringCustomer;
import com.cardpay.sdk.model.RecurringGatewayCreationResponse;
import com.cardpay.sdk.utils.DataUtils;
import com.cardpay.sdk.utils.HttpUtils;
import io.codearte.jfairy.Fairy;
import io.codearte.jfairy.producer.person.Person;
import io.codearte.jfairy.producer.text.TextProducer;
import java.io.IOException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit2.Response;

public class RecurringLinkACardWithoutAnExistingSubscriptionUAT {

    private final Logger log = LoggerFactory.getLogger(getClass());

    private Fairy fairy = Fairy.create();
    private Person person = fairy.person();
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
    public void linkACardWithoutAnExistingSubscription() throws IOException {
        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        // Filling Data
        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

        // merchant order data
        String merchantOrderId = DataUtils.generateMerchantOrderId();
        String merchantDescription = text.sentence();
        String initiator = "cit";
        String currency = TERMINAL_CURRENCY;

        // card data
        String cardPan = CARD_NON3DS_CONFIRMED;
        String cardHolder = person.getFullName().toUpperCase();
        String securityCode = "100";
        String cardExpiration = formatExpirationDate(generateCardExpiration());

        // customer data
        String customerId = text.randomString(15);
        String customerEmail = generateEmail();

        // prepare filing request data
        final FilingRequest filingRequest = new FilingRequest()
                .request(ApiClient.uuidRequest())
                .customer(new RecurringCustomer()
                        .id(customerId)
                        .email(customerEmail))
                .merchantOrder(new FilingRequestMerchantOrder()
                        .id(merchantOrderId)
                        .description(merchantDescription))
                .paymentMethod(PAYMENT_METHOD_BANKCARD)
                .cardAccount(paymentRequestCardAccount(cardPan))
                .recurringData(new FilingRecurringData()
                        .currency(currency)
                        .initiator(initiator))
                .returnUrls(returnUrls());

        log.info("{}", filingRequest);

        // perform create link a card without an existing subscription
        Response<RecurringGatewayCreationResponse> response = recurrings
                .createFiling(filingRequest)
                .execute();
        log.info("{}", response);

        RecurringGatewayCreationResponse data = response.body();
        assertNotNull(data);
        log.info("{}", data);

        final String redirectUrl = data.getRedirectUrl();
        assertNotNull(redirectUrl);
        assertFalse(redirectUrl.isEmpty());

        // Emulate customer behaviour performing GET request to redirect url
        HttpUtils.doGet(data.getRedirectUrl());

        // resolve subscriptionId for clean up
        // TODO
    }

}

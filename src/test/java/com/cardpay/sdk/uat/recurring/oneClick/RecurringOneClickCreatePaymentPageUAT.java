package com.cardpay.sdk.uat.recurring.oneClick;

import com.cardpay.sdk.api.RecurringsApi;
import com.cardpay.sdk.client.ApiClient;
import com.cardpay.sdk.model.*;
import io.codearte.jfairy.Fairy;
import io.codearte.jfairy.producer.BaseProducer;
import io.codearte.jfairy.producer.text.TextProducer;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit2.Response;

import java.io.IOException;
import java.math.BigDecimal;

import static com.cardpay.sdk.Config.*;
import static com.cardpay.sdk.Constants.PAYMENT_METHOD_BANKCARD;
import static com.cardpay.sdk.utils.DataUtils.generateEmail;
import static com.cardpay.sdk.utils.DataUtils.generateMerchantOrderId;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

public class RecurringOneClickCreatePaymentPageUAT {

    private final Logger log = LoggerFactory.getLogger(getClass());

    private Fairy fairy = Fairy.create();
    private BaseProducer producer = fairy.baseProducer();
    private TextProducer text = fairy.textProducer();

    private RecurringsApi recurrings;

    @Before
    public void setUp() {
        recurrings = new ApiClient(CARDPAY_API_URL, PAYMENTPAGE_TERMINAL_CODE, PAYMENTPAGE_PASSWORD)
                .addLogging(LOGGING_LEVEL)
                .createService(RecurringsApi.class);
    }

    @Test
    public void createOneClickPaymentPage() throws IOException {

        // merchant order data
        String merchantOrderId = generateMerchantOrderId();
        String merchantDescription = text.sentence();
        BigDecimal amount = BigDecimal.valueOf(producer.randomBetween(10, 300));
        String currency = TERMINAL_CURRENCY;
        String initiator = "cit";

        // customer data
        String customerId = text.randomString(15);
        String customerEmail = generateEmail();

        // prepare recurring data
        final RecurringCreationRequest request = new RecurringCreationRequest()
                .request(ApiClient.uuidRequest())
                .customer(new RecurringCustomer()
                        .id(customerId)
                        .email(customerEmail))
                .merchantOrder(new PaymentRequestMerchantOrder()
                        .id(merchantOrderId)
                        .description(merchantDescription))
                .paymentMethod(PAYMENT_METHOD_BANKCARD)
                .recurringData(new RecurringRequestRecurringData()
                        .currency(currency)
                        .amount(amount)
                        .initiator(initiator))
                .returnUrls(new ReturnUrls()
                        .successUrl(SUCCESS_URL)
                        .declineUrl(DECLINE_URL)
                        .cancelUrl(CANCEL_URL)
                        .inprocessUrl(INPROCESS_URL)
                );

        log.info("{}", request);

        // preform create recurring
        Response<RecurringCreationResponse> response = recurrings.createRecurring(request).execute();
        log.info("{}", response);
        assertTrue(response.message(), response.isSuccessful());

        assertNotNull(response.body());
        log.info("{}", response.body());

        // explore response result
        final String redirectUrl = response.body().getRedirectUrl();

        assertNotNull(redirectUrl);
        assertFalse(redirectUrl.isEmpty());
    }
}
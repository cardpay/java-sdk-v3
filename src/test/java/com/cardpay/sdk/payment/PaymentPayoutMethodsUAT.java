package com.cardpay.sdk.payment;

import com.cardpay.sdk.api.PaymentsApi;
import com.cardpay.sdk.client.ApiClient;
import com.cardpay.sdk.model.TransactionMethodsList;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit2.Response;

import java.io.IOException;
import java.util.UUID;

import static com.cardpay.sdk.Config.CARDPAY_API_URL;
import static com.cardpay.sdk.Config.LOGGING_LEVEL;
import static com.cardpay.sdk.Config.PAYMENTPAGE_PASSWORD;
import static com.cardpay.sdk.Config.PAYMENTPAGE_TERMINAL_CODE;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class PaymentPayoutMethodsUAT {

    private final Logger log = LoggerFactory.getLogger(getClass());
    private PaymentsApi payments;

    @Before
    public void setup() {
        payments = new ApiClient(CARDPAY_API_URL, PAYMENTPAGE_TERMINAL_CODE, PAYMENTPAGE_PASSWORD)
                .addLogging(LOGGING_LEVEL)
                .createService(PaymentsApi.class);
    }

    @Test
    public void getPaymentPayoutMethods() throws IOException {
        // perform get payment and payout methods
        Response<TransactionMethodsList> response = payments
                .getPaymentMethods(UUID.randomUUID().toString(), false)
                .execute();

        log.info("{}", response);
        assertTrue(response.message(), response.isSuccessful());

        // explore response result
        TransactionMethodsList data = response.body();
        assertNotNull(data);
        log.info("{}", data);
    }
}

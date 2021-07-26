package com.cardpay.sdk.payment;

import com.cardpay.sdk.api.PaymentsApi;
import com.cardpay.sdk.client.ApiClient;
import com.cardpay.sdk.model.PaymentMethodsList;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit2.Response;

import java.io.IOException;

import static com.cardpay.sdk.Config.*;
import static org.junit.Assert.*;

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
        Response<PaymentMethodsList> response = payments
                .getPaymentMethods()
                .execute();

        log.info("{}", response);
        assertTrue(response.message(), response.isSuccessful());

        // explore response result
        PaymentMethodsList data = response.body();
        assertNotNull(data);
        log.info("{}", data);
    }
}

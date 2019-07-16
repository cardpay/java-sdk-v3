package com.cardpay.sdk.client;

import com.cardpay.sdk.model.PaymentCallback;
import com.cardpay.sdk.model.PayoutCallback;
import com.cardpay.sdk.model.RecurringCallback;
import com.cardpay.sdk.model.RefundCallback;
import org.junit.Before;
import org.junit.Test;

import static com.cardpay.sdk.Config.*;
import static com.cardpay.sdk.callback.ResourceUtils.readFile;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class ApiClientTest {

    private ApiClient client;

    @Before
    public void setup() {
        client = new ApiClient(CARDPAY_API_URL, GATEWAY_TERMINAL_CODE, GATEWAY_PASSWORD);
    }

    @Test(expected = ApiClient.CallbackException.class)
    public void testParseNullCallbackJson() {
        // given
        String json = null;

        // when
        client.parseCallback(json);
    }

    @Test(expected = ApiClient.CallbackException.class)
    public void testParseEmptyCallbackJson() {
        // given
        String json = "";

        // when
        client.parseCallback(json);
    }

    @Test(expected = ApiClient.CallbackException.class)
    public void testParseInvalidCallbackJson() {
        // given
        String json = "123";

        // when
        client.parseCallback(json);
    }

    @Test(expected = ApiClient.CallbackException.class)
    public void testParseInvalidCallbackJsonWithMagicWord() {
        // given
        String json = "payment_data";

        // when
        client.parseCallback(json);
    }

    @Test
    public void testParsePaymentCallback() {
        // given
        String json = readFile("fixtures/paymentCallback.json");

        // when
        Object obj = client.parseCallback(json);

        // then
        assertNotNull(obj);
        assertTrue("Expecting object of class" + PaymentCallback.class, obj instanceof PaymentCallback);
    }

    @Test
    public void testParsePayoutCallback() {
        // given
        String json = readFile("fixtures/payoutCallback.json");

        // when
        Object obj = client.parseCallback(json);

        // then
        assertNotNull(obj);
        assertTrue("Expecting object of class" + PayoutCallback.class, obj instanceof PayoutCallback);
    }

    @Test
    public void testParseRefundCallback() {
        // given
        String json = readFile("fixtures/refundCallback.json");

        // when
        Object obj = client.parseCallback(json);

        // then
        assertNotNull(obj);
        assertTrue("Expecting object of class" + RefundCallback.class, obj instanceof RefundCallback);
    }

    @Test
    public void testParseRecurringCallback() {
        // given
        String json = readFile("fixtures/recurringCallback.json");

        // when
        Object obj = client.parseCallback(json);

        // then
        assertNotNull(obj);
        assertTrue("Expecting object of class" + RecurringCallback.class, obj instanceof RecurringCallback);
    }
}
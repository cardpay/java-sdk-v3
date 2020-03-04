package com.cardpay.sdk.client;

import com.cardpay.sdk.model.PaymentCallback;
import com.cardpay.sdk.model.PayoutCallback;
import com.cardpay.sdk.model.RecurringCallback;
import com.cardpay.sdk.model.RefundCallback;
import org.junit.Before;
import org.junit.Test;

import static com.cardpay.sdk.callback.ResourceUtils.readFile;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class ApiClientTest {

    private ApiClient.CallbackProcessor callbackProcessor;

    @Before
    public void setup() {
        callbackProcessor = new ApiClient.CallbackProcessor("");
    }

    @Test(expected = ApiClient.CallbackException.class)
    public void testParseNullCallbackJson() {
        // given
        String json = null;

        // when
        callbackProcessor.parseCallback(json);
    }

    @Test(expected = ApiClient.CallbackException.class)
    public void testParseEmptyCallbackJson() {
        // given
        String json = "";

        // when
        callbackProcessor.parseCallback(json);
    }

    @Test(expected = ApiClient.CallbackException.class)
    public void testParseInvalidCallbackJson() {
        // given
        String json = "123";

        // when
        callbackProcessor.parseCallback(json);
    }

    @Test(expected = ApiClient.CallbackException.class)
    public void testParseInvalidCallbackJsonWithMagicWord() {
        // given
        String json = "payment_data";

        // when
        callbackProcessor.parseCallback(json);
    }

    @Test
    public void testParsePaymentCallback() {
        // given
        String json = readFile("fixtures/paymentCallback.json");

        // when
        Object obj = callbackProcessor.parseCallback(json);

        // then
        assertNotNull(obj);
        assertTrue("Expecting object of class" + PaymentCallback.class, obj instanceof PaymentCallback);
    }

    @Test
    public void testParsePayoutCallback() {
        // given
        String json = readFile("fixtures/payoutCallback.json");

        // when
        Object obj = callbackProcessor.parseCallback(json);

        // then
        assertNotNull(obj);
        assertTrue("Expecting object of class" + PayoutCallback.class, obj instanceof PayoutCallback);
    }

    @Test
    public void testParseRefundCallback() {
        // given
        String json = readFile("fixtures/refundCallback.json");

        // when
        Object obj = callbackProcessor.parseCallback(json);

        // then
        assertNotNull(obj);
        assertTrue("Expecting object of class" + RefundCallback.class, obj instanceof RefundCallback);
    }

    @Test
    public void testParseRecurringCallback() {
        // given
        String json = readFile("fixtures/recurringCallback.json");

        // when
        Object obj = callbackProcessor.parseCallback(json);

        // then
        assertNotNull(obj);
        assertTrue("Expecting object of class" + RecurringCallback.class, obj instanceof RecurringCallback);
    }
}
package com.cardpay.sdk.callback;

import com.cardpay.sdk.client.ApiClient;
import com.cardpay.sdk.model.PaymentCallback;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.cardpay.sdk.Constants.CALLBACK_SECRET;
import static com.cardpay.sdk.callback.ResourceUtils.readFile;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.fail;

public class PaymentCallbackUAT {

    private final Logger log = LoggerFactory.getLogger(getClass());

    private ApiClient.CallbackProcessor callbackProcessor;

    @Before
    public void setup() {
        callbackProcessor = new ApiClient.CallbackProcessor(CALLBACK_SECRET);
    }

    @Test
    public void checkCallbackSignature() {
        String json = readFile("fixtures/paymentCallback.json");
        String signature = readFile("fixtures/paymentCallback.signature");

        assertEquals(callbackProcessor.calcSignature(json), signature);
    }

    @Test
    public void checkCallbackInvalidSignature() {
        String json = readFile("fixtures/paymentCallback.json");
        String signature = readFile("fixtures/paymentCallback_invalid.signature");

        assertNotEquals(callbackProcessor.calcSignature(json), signature);
    }

    @Test
    public void processCallback() {
        // payment callback structure example, JSON body
        String json = readFile("fixtures/paymentCallback.json");

        // 'Signature' header example
        String signature = readFile("fixtures/paymentCallback.signature");

        if (!callbackProcessor.isValidSignature(json, signature)) {

            fail("Incorrect signature");

        } else {
            PaymentCallback callback = callbackProcessor.fromJson(json, PaymentCallback.class);

            log.info("{}", callback);

            switch (callback.getPaymentData().getStatus()) {
                case COMPLETED:
                    // ...
                    break;
                case DECLINED:
                    // ...
                    break;
                default:
                    // unknown action or unsupported status
                    throw new RuntimeException("Unsupported status " + callback.getPaymentData().getStatus());
            }

        }
    }

}
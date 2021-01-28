package com.cardpay.sdk.callback;

import com.cardpay.sdk.client.ApiClient;
import com.cardpay.sdk.model.RefundCallback;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.cardpay.sdk.Constants.CALLBACK_SECRET;
import static com.cardpay.sdk.callback.ResourceUtils.readFile;
import static org.junit.Assert.fail;

public class RefundCallbackUAT {

    private final Logger log = LoggerFactory.getLogger(getClass());

    private ApiClient.CallbackProcessor callbackProcessor;

    @Before
    public void setup() {
        callbackProcessor = new ApiClient.CallbackProcessor(CALLBACK_SECRET);
    }

    @Test
    public void processCallback() {
        // refund callback structure example, JSON body
        String json = readFile("fixtures/refundCallback.json");

        // 'Signature' header example
        String signature = readFile("fixtures/refundCallback.signature");

        if (!callbackProcessor.isValidSignature(json, signature)) {

            fail("Incorrect signature");

        } else {

            RefundCallback callback = callbackProcessor.fromJson(json, RefundCallback.class);

            log.info("{}", callback);

            switch (callback.getRefundData().getStatus()) {
                case COMPLETED:
                    // ...
                    break;
                case DECLINED:
                    // ...
                    break;
                default:
                    // unknown action or unsupported status
                    throw new RuntimeException("Unsupported status " + callback.getRefundData().getStatus());
            }

        }
    }
}
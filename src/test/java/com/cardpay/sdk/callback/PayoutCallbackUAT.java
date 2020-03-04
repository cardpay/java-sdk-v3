package com.cardpay.sdk.callback;

import static com.cardpay.sdk.Config.CARDPAY_API_URL;
import static com.cardpay.sdk.Constants.CALLBACK_SECRET;
import static com.cardpay.sdk.callback.ResourceUtils.readFile;
import static org.junit.Assert.fail;

import com.cardpay.sdk.client.ApiClient;
import com.cardpay.sdk.model.PayoutCallback;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PayoutCallbackUAT {

    private final Logger log = LoggerFactory.getLogger(getClass());

    private ApiClient.CallbackProcessor callbackProcessor;

    @Before
    public void setup() {
        callbackProcessor = new ApiClient.CallbackProcessor(CALLBACK_SECRET);
    }

    @Test
    public void processCallback() {
        // payout callback structure example, JSON body
        String json = readFile("fixtures/payoutCallback.json");

        // 'Signature' header example
        String signature = readFile("fixtures/payoutCallback.signature");

        if (!callbackProcessor.isValidSignature(json, signature)) {

            fail("Incorrect signature");

        } else {

            PayoutCallback callback = callbackProcessor.fromJson(json, PayoutCallback.class);

            log.info("{}", callback);

            switch (callback.getPayoutData().getStatus()) {
                case COMPLETED:
                    // ...
                    break;
                case DECLINED:
                    // ...
                    break;
                default:
                    // unknown action or unsupported status
                    throw new RuntimeException("Unsupported status " + callback.getPayoutData().getStatus());
            }

        }
    }
}
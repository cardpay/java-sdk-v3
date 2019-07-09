package com.cardpay.sdk.uat.callback;

import com.cardpay.sdk.client.ApiClient;
import com.cardpay.sdk.model.PayoutCallback;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.cardpay.sdk.Config.*;
import static com.cardpay.sdk.uat.callback.ResourceUtils.readFile;
import static org.junit.Assert.fail;

public class PayoutCallbackUAT {

    private final Logger log = LoggerFactory.getLogger(getClass());

    private ApiClient client;

    @Before
    public void setup() {
        client = new ApiClient(CARDPAY_API_URL, "", "pzQf529Wa0AV");
    }

    @Test
    public void processCallback() {
        // payout callback structure example, JSON body
        String json = readFile("fixtures/payoutCallback.json");

        // 'Signature' header example
        String signature = readFile("fixtures/payoutCallback.signature");

        if (!client.isValidSignature(json, signature)) {

            fail("Incorrect signature");

        } else {

            PayoutCallback callback = client.fromJson(json, PayoutCallback.class);

            log.info("{}", callback);

            switch (callback.getPayoutData().getStatus()) {
                case COMPLETED:
                    // ...
                    break;
                case DECLINED:
                    // ...
                    break;
                default:
                    // action to unknown or unsupported status
                    throw new RuntimeException("Unsupported status " + callback.getPayoutData().getStatus());
            }

        }
    }
}
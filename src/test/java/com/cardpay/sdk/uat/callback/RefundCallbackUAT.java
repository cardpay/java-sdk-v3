package com.cardpay.sdk.uat.callback;

import com.cardpay.sdk.client.ApiClient;
import com.cardpay.sdk.model.RecurringCallback;
import com.cardpay.sdk.model.RefundCallback;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.cardpay.sdk.Config.*;
import static com.cardpay.sdk.uat.callback.ResourceUtils.readFile;
import static org.junit.Assert.fail;

public class RefundCallbackUAT {

    private final Logger log = LoggerFactory.getLogger(getClass());

    private ApiClient client;

    @Before
    public void setup() {
        client = new ApiClient(CARDPAY_API_URL, "", "pzQf529Wa0AV");
    }

    @Test
    public void processCallback() {
        // refund callback structure example, JSON body
        String json = readFile("fixtures/refundCallback.json");

        // 'Signature' header example
        String signature = readFile("fixtures/refundCallback.signature");

        if (!client.isValidSignature(json, signature)) {

            fail("Incorrect signature");

        } else {

            RefundCallback callback = client.fromJson(json, RefundCallback.class);

            log.info("{}", callback);

            switch (callback.getRefundData().getStatus()) {
                case COMPLETED:
                    // ...
                    break;
                case DECLINED:
                    // ...
                    break;
                default:
                    // action to unknown or unsupported status
                    throw new RuntimeException("Unsupported status " + callback.getRefundData().getStatus());
            }

        }
    }
}
package com.cardpay.sdk.callback;

import com.cardpay.sdk.client.ApiClient;
import com.cardpay.sdk.model.RecurringCallback;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.cardpay.sdk.Config.*;
import static com.cardpay.sdk.callback.ResourceUtils.readFile;
import static org.junit.Assert.fail;

public class RecurringCallbackUAT {

    private final Logger log = LoggerFactory.getLogger(getClass());

    private ApiClient client;

    @Before
    public void setup() {
        client = new ApiClient(CARDPAY_API_URL, "", "pzQf529Wa0AV");
    }

    @Test
    public void processCallback() {
        // recurring callback structure example, JSON body
        String json = readFile("fixtures/recurringCallback.json");

        // 'Signature' header example
        String signature = readFile("fixtures/recurringCallback.signature");

        if (!client.isValidSignature(json, signature)) {

            fail("Incorrect signature");

        } else {

            RecurringCallback callback = client.fromJson(json, RecurringCallback.class);

            log.info("{}", callback);

            switch (callback.getRecurringData().getStatus()) {
                case COMPLETED:
                    // ...
                    break;
                case DECLINED:
                    // ...
                    break;
                default:
                    // unknown action or unsupported status
                    throw new RuntimeException("Unsupported status " + callback.getRecurringData().getStatus());
            }

        }
    }

}
package com.cardpay.sdk.callback;

import com.cardpay.sdk.client.ApiClient;
import com.cardpay.sdk.model.PaymentCallback;
import com.cardpay.sdk.model.PayoutCallback;
import com.cardpay.sdk.model.RecurringCallback;
import com.cardpay.sdk.model.RefundCallback;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.Consumer;

import static com.cardpay.sdk.Config.*;
import static com.cardpay.sdk.callback.ResourceUtils.readFile;

public class CallbacksProcessorUAT {

    private final Logger log = LoggerFactory.getLogger(getClass());

    private ApiClient client;
    private ApiClient.CallbackProcessor callbackProcessor;

    @Before
    public void setup() {
        client = new ApiClient(CARDPAY_API_URL, "", "pzQf529Wa0AV");

        // create instance of callback processor
        callbackProcessor = client.createCallbackProcessor()
                // we can register handler implementation as separate class
                .registerHandler(PaymentCallback.class, new PaymentCallbackHandler())
                // or we can register handler implementation as inline lambda function
                .registerHandler(PayoutCallback.class, (callback -> {
                    log.info("{}", callback);
                    switch (callback.getPayoutData().getStatus()) {
                        case COMPLETED:
                            // ...
                            break;
                        case DECLINED:
                            // ...
                            break;
                        default:
                            throw new ApiClient.CallbackException("Unsupported callback status: " + callback.getPayoutData().getStatus());

                    }
                }))
                // and we can register handler implementation in fluent interface manner
                .registerHandler(RefundCallback.class, (callback) -> {
                    log.info("{}", callback);
                    switch (callback.getRefundData().getStatus()) {
                        case COMPLETED:
                            // ...
                            break;
                        case DECLINED:
                            // ...
                            break;
                        default:
                            throw new ApiClient.CallbackException("Unsupported callback status: " + callback.getRefundData().getStatus());
                    }
                });

        // finally we can register handler implementation by simple method call
        callbackProcessor.registerHandler(RecurringCallback.class, (callback) -> {
            log.info("{}", callback);
            switch (callback.getRecurringData().getStatus()) {
                case COMPLETED:
                    // ...
                    break;
                case DECLINED:
                    // ...
                    break;
                default:
                    throw new ApiClient.CallbackException("Unsupported callback status: " + callback.getRecurringData().getStatus());
            }
        });

    }

    class PaymentCallbackHandler implements Consumer<PaymentCallback> {

        @Override
        public void accept(PaymentCallback callback) {
            log.info("{}", callback);
            switch (callback.getPaymentData().getStatus()) {
                case COMPLETED:
                    // ...
                    break;
                case DECLINED:
                    // ...
                    break;
                default:
                    throw new ApiClient.CallbackException("Unsupported callback status: " + callback.getPaymentData().getStatus());

            }
        }
    }

    @Test(expected = ApiClient.InvalidSignatureException.class)
    public void processCallbackWithInvalidSignature() {
        // payment callback structure example, JSON body
        String json = readFile("fixtures/paymentCallback.json");

        // 'Signature' header example with invalid value
        String signature = readFile("fixtures/paymentCallback_invalid.signature");

        callbackProcessor.process(json, signature);
    }

    @Test
    public void processPaymentCallback() {
        // payment callback structure example, JSON body
        String json = readFile("fixtures/paymentCallback.json");

        // 'Signature' header example
        String signature = readFile("fixtures/paymentCallback.signature");

        callbackProcessor.process(json, signature);
    }

    @Test
    public void processPayoutCallback() {
        // payout callback structure example, JSON body
        String json = readFile("fixtures/payoutCallback.json");

        // 'Signature' header example
        String signature = readFile("fixtures/payoutCallback.signature");

        callbackProcessor.process(json, signature);
    }

    @Test
    public void processRefundCallback() {
        // refund callback structure example, JSON body
        String json = readFile("fixtures/refundCallback.json");

        // 'Signature' header example
        String signature = readFile("fixtures/refundCallback.signature");

        callbackProcessor.process(json, signature);
    }

    @Test
    public void processRecurringCallback() {
        // recurring callback structure example, JSON body
        String json = readFile("fixtures/recurringCallback.json");

        // 'Signature' header example
        String signature = readFile("fixtures/recurringCallback.signature");

        callbackProcessor.process(json, signature);
    }

}

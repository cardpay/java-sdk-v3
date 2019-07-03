package com.cardpay.sdk.uat.recurring.scheduled.retry;

import com.cardpay.sdk.api.RecurringsApi;
import com.cardpay.sdk.client.ApiClient;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.cardpay.sdk.Config.*;

public class RecurringInstallmentSubscriptionUAT {

    private final Logger log = LoggerFactory.getLogger(getClass());


    private RecurringsApi recurrings;

    @Before
    public void setUp() {
        recurrings = new ApiClient(CARDPAY_API_URL, GATEWAY_TERMINAL_CODE, GATEWAY_PASSWORD)
                .addLogging(LOGGING_LEVEL)
                .createService(RecurringsApi.class);
    }

    @Ignore
    @Test
    public void installmentSubscription() {
        // TODO
    }

}
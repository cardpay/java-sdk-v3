package com.cardpay.sdk.uat.recurring.scheduled.retry;

import com.cardpay.sdk.api.RecurringsApi;
import com.cardpay.sdk.client.ApiClient;
import com.cardpay.sdk.model.RecurringPlanRequest;
import com.cardpay.sdk.model.RecurringPlanRequestPlanData;
import com.cardpay.sdk.model.RecurringPlanResponse;
import io.codearte.jfairy.Fairy;
import io.codearte.jfairy.producer.BaseProducer;
import io.codearte.jfairy.producer.text.TextProducer;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit2.Response;

import java.io.IOException;
import java.math.BigDecimal;

import static com.cardpay.sdk.Config.*;
import static com.cardpay.sdk.model.RecurringPlanRequestPlanData.PeriodEnum.WEEK;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class RecurringScheduledWithRetrySubscriptionUAT {

    private final Logger log = LoggerFactory.getLogger(getClass());

    private Fairy fairy = Fairy.create();
    private BaseProducer producer = fairy.baseProducer();
    private TextProducer text = fairy.textProducer();

    private RecurringsApi recurrings;

    @Before
    public void setUp() {
        recurrings = new ApiClient(CARDPAY_API_URL, GATEWAY_TERMINAL_CODE, GATEWAY_PASSWORD)
                .addLogging(LOGGING_LEVEL)
                .createService(RecurringsApi.class);
    }

    @Test
    public void scheduledSubscription() throws IOException {
        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        // Input Data
        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

        // merchant order data
        String planName = text.randomString(15);
        String currency = TERMINAL_CURRENCY;
        BigDecimal amount = BigDecimal.valueOf(producer.randomBetween(10, 300));
        Integer interval = producer.randomBetween(1, 52);
        Integer retries = 2;

        // prepare scheduled subscription request data
        RecurringPlanRequest request = new RecurringPlanRequest()
                .request(ApiClient.uuidRequest())
                .planData(new RecurringPlanRequestPlanData()
                        .name(planName)
                        .currency(currency)
                        .amount(amount)
                        .interval(interval)
                        .period(WEEK)
                        .retries(retries)
                );
        log.info("{}", request);

        // perform create scheduled subscription
        Response<RecurringPlanResponse> response = recurrings.createPlan(request).execute();
        log.info("{}", response);

        assertTrue(response.message(), response.isSuccessful());
        assertNotNull(response.body());

        // explore response result
        RecurringPlanResponse result = response.body();
        log.info("{}", result);
    }
}
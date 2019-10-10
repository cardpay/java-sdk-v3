package com.cardpay.sdk.recurring.scheduled.plan;

import static com.cardpay.sdk.Config.CARDPAY_API_URL;
import static com.cardpay.sdk.Config.GATEWAY_PASSWORD;
import static com.cardpay.sdk.Config.GATEWAY_TERMINAL_CODE;
import static com.cardpay.sdk.Config.LOGGING_LEVEL;
import static com.cardpay.sdk.Config.TERMINAL_CURRENCY;
import static com.cardpay.sdk.model.RecurringPlanRequestPlanData.PeriodEnum.WEEK;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import com.cardpay.sdk.api.RecurringsApi;
import com.cardpay.sdk.client.ApiClient;
import com.cardpay.sdk.model.RecurringPlanRequest;
import com.cardpay.sdk.model.RecurringPlanRequestPlanData;
import com.cardpay.sdk.model.RecurringPlanResponse;
import io.codearte.jfairy.Fairy;
import io.codearte.jfairy.producer.BaseProducer;
import io.codearte.jfairy.producer.text.TextProducer;
import java.io.IOException;
import java.math.BigDecimal;
import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit2.Response;

public class RecurringDeletePlanUAT {

    private final Logger log = LoggerFactory.getLogger(getClass());

    private RecurringsApi recurrings;

    @Before
    public void setUp() {
        recurrings = new ApiClient(CARDPAY_API_URL, GATEWAY_TERMINAL_CODE, GATEWAY_PASSWORD)
                .addLogging(LOGGING_LEVEL)
                .createService(RecurringsApi.class);
    }

    @Test
    public void deletePlan() throws IOException {
        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        // Phase 1: prepare a new plan
        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

        String planId = createRecurringPlan();
        assertTrue(StringUtils.isNotEmpty(planId));

        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        // Phase 2: delete plan
        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

        // perform delete plan
        Response<Void> response = recurrings.deletePlan(planId).execute();
        log.info("{}", response);
        assertTrue(response.message(), response.isSuccessful());

        // explore response result
        assertEquals(200, response.code());
    }

    private String createRecurringPlan() {
        Fairy fairy = Fairy.create();
        BaseProducer producer = fairy.baseProducer();
        TextProducer textProducer = fairy.textProducer();

        RecurringPlanRequest request = new RecurringPlanRequest()
                .request(ApiClient.uuidRequest())
                .planData(new RecurringPlanRequestPlanData()
                        .currency(TERMINAL_CURRENCY)
                        .amount(BigDecimal.valueOf(producer.randomBetween(10, 300)))
                        .interval(producer.randomBetween(1, 52))
                        .name(textProducer.randomString(15))
                        .period(WEEK)
                );

        Response<RecurringPlanResponse> recurringPlanResponse;
        try {
            recurringPlanResponse = recurrings
                    .createPlan(request)
                    .execute();
            log.info("{}", recurringPlanResponse);

            assertNotNull(recurringPlanResponse);

        } catch (IOException e) {
            log.error(e.getMessage(), e);
            fail(e.getMessage());
            return "";
        }

        assertNotNull(recurringPlanResponse.body());

        return recurringPlanResponse.body().getPlanData().getId();
    }
}
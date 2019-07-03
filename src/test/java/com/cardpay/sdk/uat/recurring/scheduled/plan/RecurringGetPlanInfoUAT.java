package com.cardpay.sdk.uat.recurring.scheduled.plan;

import com.cardpay.sdk.api.RecurringsApi;
import com.cardpay.sdk.client.ApiClient;
import com.cardpay.sdk.model.RecurringPlanRequest;
import com.cardpay.sdk.model.RecurringPlanRequestPlanData;
import com.cardpay.sdk.model.RecurringPlanResponse;
import com.cardpay.sdk.model.ResponsePlanData;
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
import static com.cardpay.sdk.utils.AssertUtils.assertSuccessResponse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class RecurringGetPlanInfoUAT {

    private final Logger log = LoggerFactory.getLogger(getClass());

    private RecurringsApi recurrings;

    @Before
    public void setUp() {
        recurrings = new ApiClient(CARDPAY_API_URL, GATEWAY_TERMINAL_CODE, GATEWAY_PASSWORD)
                .addLogging(LOGGING_LEVEL)
                .createService(RecurringsApi.class);
    }

    @Test
    public void getPlanInfo() throws IOException {
        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        // Phase 1: prepare a new plan
        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

        RecurringPlanResponse recurringPlan = createRecurringPlan();

        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        // Phase 2: get plan info
        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

        // prepare data to get plan info
        String planId = recurringPlan.getPlanData().getId();

        // perform getting plan info
        Response<RecurringPlanResponse> response = recurrings
                .getPlan(planId)
                .execute();
        log.info("{}", response);

        assertTrue(response.message(), response.isSuccessful());
        assertNotNull(response.body());

        ResponsePlanData data = response.body().getPlanData();
        log.info("{}", data);
    }

    private RecurringPlanResponse createRecurringPlan() throws IOException {
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

        Response<RecurringPlanResponse> response = recurrings
                .createPlan(request)
                .execute();

        assertSuccessResponse(response);

        assertNotNull(response.body());

        return response.body();
    }

}
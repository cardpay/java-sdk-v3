package com.cardpay.sdk.recurring.scheduled.plan;

import static com.cardpay.sdk.Config.CARDPAY_API_URL;
import static com.cardpay.sdk.Config.GATEWAY_PASSWORD;
import static com.cardpay.sdk.Config.GATEWAY_TERMINAL_CODE;
import static com.cardpay.sdk.Config.LOGGING_LEVEL;
import static com.cardpay.sdk.Config.TERMINAL_CURRENCY;
import static com.cardpay.sdk.model.PlanUpdateRequest.OperationEnum.RENAME;
import static com.cardpay.sdk.model.RecurringPlanRequestPlanData.PeriodEnum.WEEK;
import static com.cardpay.sdk.utils.AssertUtils.assertSuccessResponse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import com.cardpay.sdk.api.RecurringsApi;
import com.cardpay.sdk.client.ApiClient;
import com.cardpay.sdk.model.PlanUpdateRequest;
import com.cardpay.sdk.model.PlanUpdateRequestPlanData;
import com.cardpay.sdk.model.PlanUpdateResponse;
import com.cardpay.sdk.model.RecurringPlanRequest;
import com.cardpay.sdk.model.RecurringPlanRequestPlanData;
import com.cardpay.sdk.model.RecurringPlanResponse;
import io.codearte.jfairy.Fairy;
import io.codearte.jfairy.producer.BaseProducer;
import io.codearte.jfairy.producer.text.TextProducer;
import java.io.IOException;
import java.math.BigDecimal;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit2.Response;

public class RecurringRenamePlanUAT {

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
    public void renamePlan() throws IOException {
        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        // Phase 1: prepare a new plan
        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

        RecurringPlanResponse recurringPlan = createRecurringPlan();

        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        // Phase 2: rename plan
        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

        // prepare plan id
        String planId = recurringPlan.getPlanData().getId();

        // prepare recurring update plan request data
        PlanUpdateRequest request = new PlanUpdateRequest()
                .request(ApiClient.uuidRequest())
                .operation(RENAME)
                .planData(new PlanUpdateRequestPlanData().nameTo(text.randomString(15)));

        // perform rename plan
        Response<PlanUpdateResponse> response = recurrings
                .updatePlan(planId, request)
                .execute();

        log.info("{}", response);
        assertTrue(response.message(), response.isSuccessful());

        // explore response result
        assertNotNull(response.body());
        PlanUpdateResponse updateResponse = response.body();

        log.info("{}", updateResponse);

        assertEquals(request.getPlanData().getNameTo(), updateResponse.getPlanData().getName());
    }

    private RecurringPlanResponse createRecurringPlan() throws IOException {

        RecurringPlanRequest request = new RecurringPlanRequest()
                .request(ApiClient.uuidRequest())
                .planData(new RecurringPlanRequestPlanData()
                        .currency(TERMINAL_CURRENCY)
                        .amount(BigDecimal.valueOf(producer.randomBetween(10, 300)))
                        .interval(producer.randomBetween(1, 52))
                        .name(text.randomString(15))
                        .period(WEEK)
                );

        log.info("{}", request);

        Response<RecurringPlanResponse> response = recurrings
                .createPlan(request)
                .execute();

        assertSuccessResponse(response);

        RecurringPlanResponse recurringPlanResponse = response.body();
        assertNotNull(recurringPlanResponse);

        return recurringPlanResponse;
    }

}
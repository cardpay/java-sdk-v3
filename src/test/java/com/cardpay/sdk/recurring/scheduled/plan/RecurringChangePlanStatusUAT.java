package com.cardpay.sdk.recurring.scheduled.plan;

import com.cardpay.sdk.api.RecurringsApi;
import com.cardpay.sdk.client.ApiClient;
import com.cardpay.sdk.model.*;
import io.codearte.jfairy.Fairy;
import io.codearte.jfairy.producer.BaseProducer;
import io.codearte.jfairy.producer.text.TextProducer;
import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit2.Response;

import java.io.IOException;
import java.math.BigDecimal;

import static com.cardpay.sdk.Config.*;
import static com.cardpay.sdk.model.PlanUpdateRequest.OperationEnum.CHANGE_STATUS;
import static com.cardpay.sdk.model.RecurringPlanRequestPlanData.PeriodEnum.WEEK;
import static com.cardpay.sdk.utils.AssertUtils.assertSuccessResponse;
import static org.junit.Assert.*;

public class RecurringChangePlanStatusUAT {

    private final Logger log = LoggerFactory.getLogger(getClass());

    private RecurringsApi recurrings;

    @Before
    public void setUp() {
        recurrings = new ApiClient(CARDPAY_API_URL, GATEWAY_TERMINAL_CODE, GATEWAY_PASSWORD)
                .addLogging(LOGGING_LEVEL)
                .createService(RecurringsApi.class);
    }

    @Test
    public void changePlanStatus() throws IOException {
        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        // Phase 1: prepare a new plan
        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

        String planId = createRecurringPlan();
        assertTrue(StringUtils.isNotEmpty(planId));

        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        // Phase 2: change plan status
        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

        // prepare change plan status data
        PlanUpdateRequest request = new PlanUpdateRequest()
                .request(ApiClient.uuidRequest())
                .operation(CHANGE_STATUS)
                .planData(new PlanUpdateRequestPlanData()
                        .statusTo(PlanUpdateRequestPlanData.StatusToEnum.INACTIVE)
                );

        Response<PlanUpdateResponse> response = recurrings.updatePlan(planId, request).execute();
        log.info("{}", response);
        assertTrue(response.message(), response.isSuccessful());

        // explore response result
        assertNotNull(response.body());
        log.info("{}", response.body());
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

        Response<RecurringPlanResponse> response;
        try {
            response = recurrings
                    .createPlan(request)
                    .execute();

            assertSuccessResponse(response);

        } catch (IOException e) {
            log.error(e.getMessage(), e);
            fail(e.getMessage());
            return "";
        }

        assertNotNull(response.body());

        return response.body().getPlanData().getId();
    }

}
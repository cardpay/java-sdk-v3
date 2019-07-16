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
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.IntStream;

import static com.cardpay.sdk.Config.*;
import static com.cardpay.sdk.model.RecurringPlanRequestPlanData.PeriodEnum.WEEK;
import static com.cardpay.sdk.utils.AssertUtils.assertSuccessResponse;
import static java.util.stream.Collectors.toSet;
import static org.junit.Assert.*;

public class RecurringGetAllPlansInfoUAT {

    private final Logger log = LoggerFactory.getLogger(getClass());

    private RecurringsApi recurrings;

    @Before
    public void setUp() {
        recurrings = new ApiClient(CARDPAY_API_URL, GATEWAY_TERMINAL_CODE, GATEWAY_PASSWORD)
                .addLogging(LOGGING_LEVEL)
                .createService(RecurringsApi.class);
    }

    @Test
    public void getAllPlansInfo() throws IOException {
        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        // Generate plans
        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        Set<String> ids = IntStream.range(0, 3)
                .parallel()
                .mapToObj(index -> createRecurringPlan())
                .filter(StringUtils::isNotEmpty)
                .collect(toSet());
        log.info("ids: {}", ids);

        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        // Fetch plans
        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

        // prepare request data
        Integer maxCount = 20;
        Integer offset = null;
        String sortOrder = null;

        // perform getting all plans information
        Response<PlanDataList> response = recurrings.getPlans(
                UUID.randomUUID().toString(),
                maxCount,
                offset,
                sortOrder
        ).execute();
        log.info("{}", response);

        assertTrue(response.message(), response.isSuccessful());
        assertNotNull(response.body());

        // explore response result
        List<ResponsePlanData> plans = response.body().getData();

        log.info("Count: {}", plans.size());

        for (ResponsePlanData plan : plans) {
            log.info("{} {}: {} {}", plan.getCreated(), plan.getId(),
                    String.format("%-6.2f %s", plan.getAmount(), plan.getCurrency()),
                    plan.getStatus()
            );
        }

        Set<String> fetchedIds = plans.stream().map(ResponsePlanData::getId).collect(toSet());
        assertTrue(fetchedIds.containsAll(ids));
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
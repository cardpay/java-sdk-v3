package com.cardpay.sdk.recurring.oneClick;

import com.cardpay.sdk.api.RecurringsApi;
import com.cardpay.sdk.client.ApiClient;
import com.cardpay.sdk.model.RecurringResponse;
import com.cardpay.sdk.model.RecurringResponseRecurringData;
import com.cardpay.sdk.model.RecurringsList;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit2.Response;

import java.io.IOException;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

import static com.cardpay.sdk.Config.CARDPAY_API_URL;
import static com.cardpay.sdk.Config.GATEWAY_PASSWORD;
import static com.cardpay.sdk.Config.GATEWAY_TERMINAL_CODE;
import static com.cardpay.sdk.Config.LOGGING_LEVEL;
import static com.cardpay.sdk.Config.TERMINAL_CURRENCY;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class RecurringOneClickGetListInfoUAT {

    private final Logger log = LoggerFactory.getLogger(getClass());

    private RecurringsApi recurrings;

    @Before
    public void setUp() {
        recurrings = new ApiClient(CARDPAY_API_URL, GATEWAY_TERMINAL_CODE, GATEWAY_PASSWORD)
                .addLogging(LOGGING_LEVEL)
                .createService(RecurringsApi.class);
    }

    @Test
    public void getOneClickPaymentsListInformation() throws IOException {
        // TODO generate data

        // prepare request data
        String currency = TERMINAL_CURRENCY;
        OffsetDateTime endTime = null;
        Integer maxCount = 20;
        String merchantOrderId = null;
        String paymentMethod = null;
        List<String> recurringTypes = null;
        String sortOrder = null;
        OffsetDateTime startTime = null;
        String type = null;

        // perform getting One-click payments list information
        Response<RecurringsList> result = recurrings.getRecurrings(
                UUID.randomUUID().toString(),
                currency,
                endTime,
                maxCount,
                merchantOrderId,
                paymentMethod,
                recurringTypes,
                sortOrder,
                startTime,
                type
        ).execute();
        log.info("{}", result);

        assertTrue(result.message(), result.isSuccessful());
        assertNotNull(result.body());

        // explore response result
        List<RecurringResponse> data = result.body().getData();

        log.info("Count: {}", data.size());

        for (RecurringResponse payment : data) {
            RecurringResponseRecurringData r = payment.getRecurringData();
            log.info("{} {}: {} {} @ {}", r.getCreated(), r.getId(),
                    String.format("%-6.2f %s", r.getAmount(), r.getCurrency()),
                    r.getStatus(),
                    r.getSubscription() != null ? r.getSubscription().getId() : "n/a"
            );
        }
    }
}
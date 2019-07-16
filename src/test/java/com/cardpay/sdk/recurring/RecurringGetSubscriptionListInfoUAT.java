package com.cardpay.sdk.recurring;

import com.cardpay.sdk.api.RecurringsApi;
import com.cardpay.sdk.client.ApiClient;
import com.cardpay.sdk.model.SubscriptionGetResponse;
import com.cardpay.sdk.model.SubscriptionList;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit2.Response;

import java.io.IOException;
import java.time.ZoneOffset;
import java.util.List;
import java.util.UUID;

import static com.cardpay.sdk.Config.*;
import static java.time.OffsetDateTime.now;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class RecurringGetSubscriptionListInfoUAT {

    private final Logger log = LoggerFactory.getLogger(getClass());

    private RecurringsApi recurrings;

    @Before
    public void setUp() {
        recurrings = new ApiClient(CARDPAY_API_URL, GATEWAY_TERMINAL_CODE, GATEWAY_PASSWORD)
                .addLogging(LOGGING_LEVEL)
                .createService(RecurringsApi.class);
    }

    @Test
    public void getSubscriptionsListInformation() throws IOException {
        Response<SubscriptionList> response = recurrings.getSubscriptions(
                UUID.randomUUID().toString(),
                null,
                null,
                null,
                50,
                10,
                null,
                "desc",
                now().minusDays(7).atZoneSameInstant(ZoneOffset.UTC).toOffsetDateTime(),
                null,
                null
        ).execute();

        log.info("{}", response);
        assertTrue(response.message(), response.isSuccessful());
        assertNotNull(response.body());

        // explore response result
        List<SubscriptionGetResponse> subscriptions = response.body().getData();

        log.info("Count: {}", subscriptions.size());

        for (SubscriptionGetResponse subscription : subscriptions) {
            log.info("{} {}: {} {}", subscription.getCreated(), subscription.getId(),
                    subscription.getCurrency(),
                    subscription.getStatus()
            );
        }
    }

}
package com.cardpay.sdk.utils;

import com.cardpay.sdk.api.RecurringsApi;
import com.cardpay.sdk.client.ApiClient;
import com.cardpay.sdk.model.RecurringResponse;
import com.cardpay.sdk.model.RecurringsList;
import com.cardpay.sdk.model.SubscriptionUpdateRequest;
import com.cardpay.sdk.model.SubscriptionUpdateRequestSubscriptionData;
import com.cardpay.sdk.model.SubscriptionUpdateResponse;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import static com.cardpay.sdk.model.SubscriptionUpdateRequest.OperationEnum.CHANGE_STATUS;
import static com.cardpay.sdk.model.SubscriptionUpdateRequestSubscriptionData.StatusToEnum.CANCELLED;
import static com.cardpay.sdk.utils.AssertUtils.assertSuccessResponse;
import static org.junit.Assert.assertNotNull;

public class RecurringUtils {

    private static final Logger log = LoggerFactory.getLogger(RecurringUtils.class);

    public static RecurringResponse fetchRecurring(RecurringsApi api, String merchantOrderId) throws IOException {
        if (api == null || StringUtils.isEmpty(merchantOrderId)) return null;

        Response<RecurringsList> response = api.getRecurrings(
                UUID.randomUUID().toString(),
                null,
                null,
                null,
                merchantOrderId,
                null,
                null,
                null,
                null,
                null
        ).execute();

        assertSuccessResponse(response);

        RecurringsList body = response.body();
        assertNotNull(body);

        List<RecurringResponse> data = body.getData();
        return data.size() > 0 ? data.get(0) : null;
    }

    public static void doCancelSubscription(RecurringsApi api, String subscriptionId) throws IOException {
        if (api == null || StringUtils.isEmpty(subscriptionId)) return;

        Response<SubscriptionUpdateResponse> response = api
                .updateSubscription(subscriptionId, new SubscriptionUpdateRequest()
                        .request(ApiClient.uuidRequest())
                        .operation(CHANGE_STATUS)
                        .subscriptionData(new SubscriptionUpdateRequestSubscriptionData()
                                .statusTo(CANCELLED)
                        ))
                .execute();

        assertSuccessResponse(response);

        assertNotNull(response.body());
        log.info("{}", response.body());
    }

}

package com.cardpay.sdk.limits;

import com.cardpay.sdk.api.LimitsApi;
import com.cardpay.sdk.client.ApiClient;
import com.cardpay.sdk.model.LimitInfoResponse;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit2.Response;

import java.io.IOException;
import java.util.UUID;

import static com.cardpay.sdk.Config.CARDPAY_API_URL;
import static com.cardpay.sdk.Config.GATEWAY_PASSWORD;
import static com.cardpay.sdk.Config.GATEWAY_TERMINAL_CODE;
import static com.cardpay.sdk.Config.LOGGING_LEVEL;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class LimitGetInfoUAT {

    private final Logger log = LoggerFactory.getLogger(getClass());

    private LimitsApi limits;

    @Before
    public void setup() {
        limits = new ApiClient(CARDPAY_API_URL, GATEWAY_TERMINAL_CODE, GATEWAY_PASSWORD)
                .addLogging(LOGGING_LEVEL)
                .createService(LimitsApi.class);
    }

    @Test
    public void getLimitsInfo() throws IOException {
        Response<LimitInfoResponse> response = limits.getLimitsInfo(UUID.randomUUID().toString()).execute();

        log.info("{}", response);
        assertTrue(response.message(), response.isSuccessful());

        LimitInfoResponse limitInfoResponse = response.body();
        assertNotNull(limitInfoResponse);

        log.info("{}", limitInfoResponse.getRemainingLimits());
        assertFalse(limitInfoResponse.getRemainingLimits().isEmpty());
    }

}

package com.cardpay.sdk.auth;

import com.cardpay.sdk.api.AuthApi;
import com.cardpay.sdk.client.ApiClient;
import com.cardpay.sdk.model.ApiTokens;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import retrofit2.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import static com.cardpay.sdk.Config.*;
import static org.junit.Assert.assertNotNull;

public class GetAuthTokenUAT {

    private final Logger log = LoggerFactory.getLogger(getClass());

    private AuthApi auth;

    @Before
    public void setup() {
        auth = new ApiClient(CARDPAY_API_URL, PAYMENTPAGE_TERMINAL_CODE, PAYMENTPAGE_PASSWORD)
                .addLogging(LOGGING_LEVEL)
                .createService(AuthApi.class);
    }

    @Test
    public void getAuthToken() throws IOException {
        // request data
        String grantType = "password";
        String refreshToken = "";
        String password = PAYMENTPAGE_PASSWORD;
        String terminalCode = PAYMENTPAGE_TERMINAL_CODE;

        // create token
        Response<ApiTokens> response = auth
                .obtainTokens(grantType, password, refreshToken, terminalCode)
                .execute();

        log.info("{}", response);

        TestCase.assertTrue(response.message(), response.isSuccessful());
        assertNotNull(response.body());

        // explore response result
        ApiTokens data = response.body();
        log.info("{}", data);

        assertNotNull(data.getAccessToken());
    }
}

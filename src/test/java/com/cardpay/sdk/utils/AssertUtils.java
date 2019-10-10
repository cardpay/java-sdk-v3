package com.cardpay.sdk.utils;

import static org.junit.Assert.assertTrue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit2.Response;

public class AssertUtils {
    private static final Logger log = LoggerFactory.getLogger(AssertUtils.class);

    public static <T> void assertSuccessResponse(Response<T> response) {
        assertTrue(response.message(), response.isSuccessful());
        log.info("{}", response);
    }
}

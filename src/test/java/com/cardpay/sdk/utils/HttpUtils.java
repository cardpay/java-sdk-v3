package com.cardpay.sdk.utils;

import com.cardpay.sdk.client.ApiClient;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class HttpUtils {

    private final static Logger log = LoggerFactory.getLogger(HttpUtils.class);

    public static void doGet(String url) {
        doGet(url, false);
    }

    public static void doGetSilent(String url) {
        doGet(url, false);
    }

    public static void doGet(String url, boolean verbose) {
        Request request = new Request.Builder()
                .url(url)
                .addHeader("User-Agent", ApiClient.USER_AGENT)
                .build();

        OkHttpClient client = new OkHttpClient();
        try {
            Response response = client.newCall(request).execute();
            if (verbose) {
                log.info("{}", response);
                if (response.body() != null) {
                    log.info("BODY: {}", response.body().string());
                } else {
                    log.info("BODY IS EMPTY");
                }
            }
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
    }

}

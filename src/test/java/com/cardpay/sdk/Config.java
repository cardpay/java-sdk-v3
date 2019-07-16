package com.cardpay.sdk;

import okhttp3.logging.HttpLoggingInterceptor;

public class Config {

    public static final String CARDPAY_API_URL = System.getProperty("CARDPAY_API_URL", "https://sandbox.cardpay.com");

    public static final String TERMINAL_CURRENCY = System.getProperty("TERMINAL_CURRENCY", "USD");

    public static final String PAYMENTPAGE_TERMINAL_CODE = System.getProperty("PAYMENTPAGE_TERMINAL_CODE", "18397");
    public static final String PAYMENTPAGE_PASSWORD = System.getProperty("PAYMENTPAGE_PASSWORD", "FpK2cy143POj");

    public static final String GATEWAY_TERMINAL_CODE = System.getProperty("GATEWAY_TERMINAL_CODE", "18833");
    public static final String GATEWAY_PASSWORD = System.getProperty("GATEWAY_PASSWORD", "pzQf529Wa0AV");

    public static final String GATEWAY_POSTPONED_TERMINAL_CODE = System.getProperty("GATEWAY_POSTPONED_TERMINAL_CODE", "18399");
    public static final String GATEWAY_POSTPONED_PASSWORD = System.getProperty("GATEWAY_POSTPONED_PASSWORD", "jehE149L7bHU");

    // NONE, BASIC, HEADERS, BODY
    public static final HttpLoggingInterceptor.Level LOGGING_LEVEL = HttpLoggingInterceptor.Level.valueOf(System.getProperty("LOGGING_LEVEL", HttpLoggingInterceptor.Level.NONE.name()));

    public static final String EMAILS_DOMAIN = System.getProperty("EMAILS_DOMAIN", "mailinator.com");

    public static final String SUCCESS_URL = "https://httpbin.org/get?result=success";
    public static final String DECLINE_URL = "https://httpbin.org/get?result=decline";
    public static final String CANCEL_URL = "https://httpbin.org/get?result=cancel";
    public static final String INPROCESS_URL = "https://httpbin.org/get?result=inprocess";
}
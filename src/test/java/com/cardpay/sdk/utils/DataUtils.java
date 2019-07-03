package com.cardpay.sdk.utils;

import io.codearte.jfairy.Fairy;
import io.codearte.jfairy.producer.BaseProducer;
import io.codearte.jfairy.producer.text.TextProducer;

import java.text.SimpleDateFormat;
import java.util.Date;

import static com.cardpay.sdk.Config.EMAILS_DOMAIN;
import static java.time.OffsetDateTime.now;

public class DataUtils {

    private static Fairy fairy = Fairy.create();
    private static BaseProducer producer = fairy.baseProducer();
    private static TextProducer text = fairy.textProducer();

    public static String formatDate(String format, Date date) {
        return new SimpleDateFormat(format).format(date);
    }

    public static String generateMerchantOrderId() {
        return text.randomString(15);
    }

    public static Date generateCardExpiration() {
        return new Date(now().plusYears(1).plusMonths(producer.randomBetween(1, 10)).toInstant().toEpochMilli());
    }

    public static String generateEmail() {
        return text.randomString(20) + "@" + EMAILS_DOMAIN;
    }
}

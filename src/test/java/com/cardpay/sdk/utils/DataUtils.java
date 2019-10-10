package com.cardpay.sdk.utils;

import static com.cardpay.sdk.Config.CANCEL_URL;
import static com.cardpay.sdk.Config.DECLINE_URL;
import static com.cardpay.sdk.Config.EMAILS_DOMAIN;
import static com.cardpay.sdk.Config.INPROCESS_URL;
import static com.cardpay.sdk.Config.SUCCESS_URL;
import static com.cardpay.sdk.client.StringUtil.formatBirthDate;
import static com.cardpay.sdk.client.StringUtil.formatExpirationDate;
import static java.time.OffsetDateTime.now;

import com.cardpay.sdk.Config;
import com.cardpay.sdk.model.BillingAddress;
import com.cardpay.sdk.model.PaymentRequestCard;
import com.cardpay.sdk.model.PaymentRequestCardAccount;
import com.cardpay.sdk.model.PaymentRequestCustomer;
import com.cardpay.sdk.model.PaymentRequestPaymentData;
import com.cardpay.sdk.model.ReturnUrls;
import io.codearte.jfairy.Fairy;
import io.codearte.jfairy.producer.BaseProducer;
import io.codearte.jfairy.producer.person.Person;
import io.codearte.jfairy.producer.text.TextProducer;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataUtils {

    private static Fairy fairy = Fairy.create();
    private static BaseProducer producer = fairy.baseProducer();
    private static TextProducer text = fairy.textProducer();
    private static Person person = fairy.person();

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

    public static PaymentRequestCustomer paymentRequestCustomer() {
        return new PaymentRequestCustomer()
                .id(text.randomString(15))
                .fullName(person.getFullName())
                .birthDate(formatBirthDate(person.getDateOfBirth().toDate()))
                .email(generateEmail())
                .phone(producer.numerify("+###########"))
                .workPhone(producer.numerify("+###########"))
                .homePhone(producer.numerify("+###########"))
                .locale("en");
    }

    public static PaymentRequestPaymentData paymentRequestPaymentData() {
        return new PaymentRequestPaymentData()
                .currency(Config.TERMINAL_CURRENCY)
                .amount(BigDecimal.valueOf(producer.randomBetween(100, 300)))
                .note(text.sentence())
                .transType(PaymentRequestPaymentData.TransTypeEnum._01);
    }

    public static PaymentRequestCard paymentRequestCard(String cardPan) {
        return new PaymentRequestCard()
                .pan(cardPan)
                .holder(person.getFullName().toUpperCase())
                .securityCode("123")
                .expiration(formatExpirationDate(generateCardExpiration()))
                .acctType(PaymentRequestCard.AcctTypeEnum._03);
    }

    public static BillingAddress billingAddress() {
        return new BillingAddress()
                .country("USA")
                .state("NY")
                .zip("10001")
                .city("New York")
                .phone(producer.numerify("+###########"))
                .addrLine1(person.getAddress().getAddressLine1())
                .addrLine2(person.getAddress().getAddressLine2());
    }

    public static PaymentRequestCardAccount paymentRequestCardAccount(String cardPan) {
        return new PaymentRequestCardAccount()
                .card(paymentRequestCard(cardPan))
                .billingAddress(billingAddress());
    }

    public static ReturnUrls returnUrls() {
        return new ReturnUrls()
                .successUrl(SUCCESS_URL)
                .declineUrl(DECLINE_URL)
                .cancelUrl(CANCEL_URL)
                .inprocessUrl(INPROCESS_URL);
    }
}

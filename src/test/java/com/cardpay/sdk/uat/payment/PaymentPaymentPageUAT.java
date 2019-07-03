package com.cardpay.sdk.uat.payment;

import com.cardpay.sdk.api.PaymentsApi;
import com.cardpay.sdk.client.ApiClient;
import com.cardpay.sdk.model.*;
import com.cardpay.sdk.utils.DataUtils;
import io.codearte.jfairy.Fairy;
import io.codearte.jfairy.producer.BaseProducer;
import io.codearte.jfairy.producer.person.Person;
import io.codearte.jfairy.producer.text.TextProducer;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit2.Response;

import java.io.IOException;
import java.math.BigDecimal;

import static com.cardpay.sdk.Config.*;
import static com.cardpay.sdk.Constants.PAYMENT_METHOD_BANKCARD;
import static com.cardpay.sdk.utils.DataUtils.formatDate;
import static com.cardpay.sdk.utils.DataUtils.generateMerchantOrderId;
import static org.junit.Assert.*;

public class PaymentPaymentPageUAT{

    private final Logger log = LoggerFactory.getLogger(getClass());

    private Fairy fairy = Fairy.create();
    private Person person = fairy.person();
    private BaseProducer producer = fairy.baseProducer();
    private TextProducer text = fairy.textProducer();

    private PaymentsApi payments;

    @Before
    public void setup() {
        payments = new ApiClient(CARDPAY_API_URL, PAYMENTPAGE_TERMINAL_CODE, PAYMENTPAGE_PASSWORD)
                .addLogging(LOGGING_LEVEL)
                .createService(PaymentsApi.class);
    }

    @Test
    public void createPaymentPaymentPage() throws IOException {
        // merchant order data
        String merchantOrderId = generateMerchantOrderId();
        String merchantDescription = text.sentence();
        BigDecimal amount = BigDecimal.valueOf(producer.randomBetween(10, 300));
        String currency = TERMINAL_CURRENCY;
        String note = text.sentence();

        // customer data
        String customerId = text.randomString(15);
        String customerFullname = person.getFullName();
        String customerBirthdate = formatDate("yyyy-MM-dd", person.getDateOfBirth().toDate());
        String customerEmail = DataUtils.generateEmail();
        String customerPhoneNumber = producer.numerify("+###########");
        String customerLocale = "en";

        // prepare payment data
        final PaymentRequest paymentRequest = new PaymentRequest()
                .request(ApiClient.uuidRequest())
                .merchantOrder(new PaymentRequestMerchantOrder()
                        .id(merchantOrderId)
                        .description(merchantDescription))
                .paymentMethod(PAYMENT_METHOD_BANKCARD)
                .paymentData(new PaymentRequestPaymentData()
                        .currency(currency)
                        .amount(amount)
                        .note(note))
                .customer(new PaymentRequestCustomer()
                        .id(customerId)
                        .fullName(customerFullname)
                        .birthDate(customerBirthdate)
                        .email(customerEmail)
                        .locale(customerLocale)
                        .phone(customerPhoneNumber))
                .returnUrls(new ReturnUrls()
                        .successUrl(SUCCESS_URL)
                        .declineUrl(DECLINE_URL)
                        .cancelUrl(CANCEL_URL)
                        .inprocessUrl(INPROCESS_URL)
                );
        log.info("{}", paymentRequest);

        // perform create payment
        Response<PaymentCreationResponse> response = payments
                .createPayment(paymentRequest)
                .execute();

        log.info("{}", response);
        assertTrue(response.message(), response.isSuccessful());

        // explore response result
        PaymentCreationResponse data = response.body();
        assertNotNull(data);
        log.info("{}", data);

        final String redirectUrl = data.getRedirectUrl();

        assertNotNull(redirectUrl);
        assertFalse(redirectUrl.isEmpty());
    }
}
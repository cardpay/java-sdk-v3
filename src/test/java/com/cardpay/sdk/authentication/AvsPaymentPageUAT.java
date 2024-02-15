package com.cardpay.sdk.authentication;

import com.cardpay.sdk.api.PaymentsApi;
import com.cardpay.sdk.client.ApiClient;
import com.cardpay.sdk.model.PaymentGatewayCreationResponse;
import com.cardpay.sdk.model.PaymentRequest;
import com.cardpay.sdk.model.PaymentRequestCustomer;
import com.cardpay.sdk.model.PaymentRequestMerchantOrder;
import com.cardpay.sdk.model.PaymentRequestPaymentData;
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

import static com.cardpay.sdk.Config.AVS_PAYMENTPAGE_PASSWORD;
import static com.cardpay.sdk.Config.AVS_PAYMENTPAGE_TERMINAL_CODE;
import static com.cardpay.sdk.Config.CARDPAY_API_URL;
import static com.cardpay.sdk.Config.LOGGING_LEVEL;
import static com.cardpay.sdk.Config.TERMINAL_CURRENCY;
import static com.cardpay.sdk.Constants.PAYMENT_METHOD_BANKCARD;
import static com.cardpay.sdk.client.StringUtil.formatBirthDate;
import static com.cardpay.sdk.utils.DataUtils.generateEmail;
import static com.cardpay.sdk.utils.DataUtils.generateMerchantOrderId;
import static com.cardpay.sdk.utils.DataUtils.returnUrls;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class AvsPaymentPageUAT {

    private final Logger log = LoggerFactory.getLogger(getClass());

    private Fairy fairy = Fairy.create();
    private Person person = fairy.person();
    private BaseProducer producer = fairy.baseProducer();
    private TextProducer text = fairy.textProducer();

    private PaymentsApi payments;

    @Before
    public void setup() {
        payments = new ApiClient(CARDPAY_API_URL, AVS_PAYMENTPAGE_TERMINAL_CODE, AVS_PAYMENTPAGE_PASSWORD)
                .addLogging(LOGGING_LEVEL)
                .createService(PaymentsApi.class);
    }

    @Test
    public void createPaymentAVS() throws IOException {
        // merchant order data
        String merchantOrderId = generateMerchantOrderId();
        String merchantDescription = text.sentence();
        String currency = TERMINAL_CURRENCY;
        String note = text.sentence();

        // customer data
        String customerId = text.randomString(15);
        String customerFullname = person.getFullName();
        String customerBirthdate = formatBirthDate(person.getDateOfBirth().toDate());
        String customerEmail = generateEmail();
        String customerPhoneNumber = producer.numerify("+###########");
        String customerLocale = "en";

        // prepare request data
        PaymentRequest paymentRequest = new PaymentRequest()
                .request(ApiClient.uuidRequest())
                .merchantOrder(new PaymentRequestMerchantOrder()
                        .id(merchantOrderId)
                        .description(merchantDescription))
                .paymentMethod(PAYMENT_METHOD_BANKCARD)
                .paymentData(new PaymentRequestPaymentData()
                        .generateToken(true)
                        .currency(currency)
                        .note(note)
                )
                .customer(new PaymentRequestCustomer()
                        .id(customerId)
                        .fullName(customerFullname)
                        .birthDate(customerBirthdate)
                        .email(customerEmail)
                        .phone(customerPhoneNumber)
                        .workPhone(customerPhoneNumber)
                        .homePhone(customerPhoneNumber)
                        .locale(customerLocale))
                .returnUrls(returnUrls());
        log.info("{}", paymentRequest);

        // perform create payment
        Response<PaymentGatewayCreationResponse> response = payments
                .createPayment(paymentRequest)
                .execute();

        log.info("{}", response);
        assertTrue(response.message(), response.isSuccessful());

        // explore response result
        PaymentGatewayCreationResponse data = response.body();
        assertNotNull(data);
        log.info("{}", data);

        final String redirectUrl = data.getRedirectUrl();

        assertNotNull(redirectUrl);
        assertFalse(redirectUrl.isEmpty());
    }
}

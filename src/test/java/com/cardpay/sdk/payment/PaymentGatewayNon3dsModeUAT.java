package com.cardpay.sdk.payment;

import com.cardpay.sdk.api.PaymentsApi;
import com.cardpay.sdk.client.ApiClient;
import com.cardpay.sdk.model.BillingAddress;
import com.cardpay.sdk.model.PaymentGatewayCreationResponse;
import com.cardpay.sdk.model.PaymentRequest;
import com.cardpay.sdk.model.PaymentRequestCard;
import com.cardpay.sdk.model.PaymentRequestCardAccount;
import com.cardpay.sdk.model.PaymentRequestCustomer;
import com.cardpay.sdk.model.PaymentRequestMerchantOrder;
import com.cardpay.sdk.model.PaymentRequestPaymentData;
import com.cardpay.sdk.model.PaymentResponse;
import com.cardpay.sdk.model.PaymentResponsePaymentData;
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

import static com.cardpay.sdk.Config.CARDPAY_API_URL;
import static com.cardpay.sdk.Config.GATEWAY_PASSWORD;
import static com.cardpay.sdk.Config.GATEWAY_TERMINAL_CODE;
import static com.cardpay.sdk.Config.LOGGING_LEVEL;
import static com.cardpay.sdk.Config.TERMINAL_CURRENCY;
import static com.cardpay.sdk.Constants.CARD_NON3DS_CONFIRMED;
import static com.cardpay.sdk.Constants.PAYMENT_METHOD_BANKCARD;
import static com.cardpay.sdk.client.StringUtil.formatBirthDate;
import static com.cardpay.sdk.client.StringUtil.formatExpirationDate;
import static com.cardpay.sdk.model.PaymentResponsePaymentData.StatusEnum.COMPLETED;
import static com.cardpay.sdk.utils.DataUtils.generateCardExpiration;
import static com.cardpay.sdk.utils.DataUtils.generateEmail;
import static com.cardpay.sdk.utils.DataUtils.generateMerchantOrderId;
import static com.cardpay.sdk.utils.DataUtils.returnUrls;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class PaymentGatewayNon3dsModeUAT {

    private final Logger log = LoggerFactory.getLogger(getClass());

    private Fairy fairy = Fairy.create();
    private Person person = fairy.person();
    private BaseProducer producer = fairy.baseProducer();
    private TextProducer text = fairy.textProducer();

    private PaymentsApi payments;

    @Before
    public void setup() {
        payments = new ApiClient(CARDPAY_API_URL, GATEWAY_TERMINAL_CODE, GATEWAY_PASSWORD)
                .addLogging(LOGGING_LEVEL)
                .createService(PaymentsApi.class);
    }

    @Test
    public void createPaymentConfirmedNon3DS() throws IOException {
        // merchant order data
        String merchantOrderId = generateMerchantOrderId();
        String merchantDescription = text.sentence();
        BigDecimal amount = BigDecimal.valueOf(producer.randomBetween(10, 300));
        String currency = TERMINAL_CURRENCY;
        String note = text.sentence();

        // card data
        String cardPan = CARD_NON3DS_CONFIRMED;
        String cardHolder = person.getFullName().toUpperCase();
        String securityCode = "100";
        String cardExpiration = formatExpirationDate(generateCardExpiration());

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
                        .currency(currency)
                        .amount(amount)
                        .note(note)
                        .transType(PaymentRequestPaymentData.TransTypeEnum._01))
                .cardAccount(new PaymentRequestCardAccount()
                        .card(new PaymentRequestCard()
                                .pan(cardPan)
                                .holder(cardHolder)
                                .securityCode(securityCode)
                                .expiration(cardExpiration)
                                .acctType(PaymentRequestCard.AcctTypeEnum._03))
                        .billingAddress(new BillingAddress()
                                .country("USA")
                                .state("NY")
                                .zip("10001")
                                .city("New York")
                                .addrLine1(person.getAddress().getAddressLine1())
                                .addrLine2(person.getAddress().getAddressLine2()))
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

        // perform api call
        Response<PaymentGatewayCreationResponse> response = payments
                .createPayment(paymentRequest)
                .execute();

        log.info("{}", response);
        assertTrue(response.message(), response.isSuccessful());

        PaymentGatewayCreationResponse creationResponse = response.body();
        assertNotNull(creationResponse);

        // Emulate customer behaviour performing GET request to redirect url
        log.info("{}", ApiClient.doGet(creationResponse.getRedirectUrl()));

        // explore response result
        PaymentResponsePaymentData paymentData = getPaymentByPaymentId(creationResponse.getPaymentData().getId());
        assertNotNull(paymentData);

        assertEquals(COMPLETED, paymentData.getStatus());
    }

    private PaymentResponsePaymentData getPaymentByPaymentId(String paymentId) throws IOException {
        Response<PaymentResponse> response = payments.getPayment(paymentId).execute();
        log.info("{}", response);
        assertTrue(response.message(), response.isSuccessful());

        PaymentResponse body = response.body();
        assertNotNull(body);

        log.info("{}", body);

        assertEquals(paymentId, body.getPaymentData().getId());

        return body.getPaymentData();
    }

}

package com.cardpay.sdk.uat.payment;

import com.cardpay.sdk.api.PaymentsApi;
import com.cardpay.sdk.client.ApiClient;
import com.cardpay.sdk.model.*;
import com.cardpay.sdk.utils.HttpUtils;
import io.codearte.jfairy.Fairy;
import io.codearte.jfairy.producer.BaseProducer;
import io.codearte.jfairy.producer.person.Person;
import io.codearte.jfairy.producer.text.TextProducer;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import static com.cardpay.sdk.Config.*;
import static com.cardpay.sdk.Constants.PAYMENT_METHOD_BANKCARD;
import static com.cardpay.sdk.Constants.CARD_3DS_CONFIRMED;
import static com.cardpay.sdk.model.PaymentResponsePaymentData.StatusEnum.IN_PROGRESS;
import static com.cardpay.sdk.utils.DataUtils.*;
import static org.junit.Assert.*;

public class PaymentGateway3DSModeUAT {

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
    public void createPaymentConfirmed3DS() throws IOException {
        // merchant order data
        String merchantOrderId = generateMerchantOrderId();
        String merchantDescription = text.sentence();
        BigDecimal amount = BigDecimal.valueOf(producer.randomBetween(10, 300));
        String currency = TERMINAL_CURRENCY;
        String note = text.sentence();

        // card data
        String cardPan = CARD_3DS_CONFIRMED;
        String cardHolder = person.getFullName().toUpperCase();
        String securityCode = "100";
        String cardExpiration = formatDate("MM/yyyy", generateCardExpiration());

        // customer data
        String customerId = text.randomString(15);
        String customerFullname = person.getFullName();
        String customerBirthdate = formatDate("yyyy-MM-dd", person.getDateOfBirth().toDate());
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
                        .note(note))
                .cardAccount(new PaymentRequestCardAccount().card(new PaymentRequestCard()
                        .pan(cardPan)
                        .holder(cardHolder)
                        .securityCode(securityCode)
                        .expiration(cardExpiration)))
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
                        .inprocessUrl(INPROCESS_URL));
        log.info("{}", paymentRequest);

        // perform api call
        Response<PaymentCreationResponse> response = payments
                .createPayment(paymentRequest)
                .execute();

        log.info("{}", response);
        assertTrue(response.message(), response.isSuccessful());

        PaymentCreationResponse creationResponse = response.body();
        assertNotNull(creationResponse);

        // Emulate customer behaviour performing GET request to redirect url
        HttpUtils.doGetSilent(creationResponse.getRedirectUrl());

        // explore response result
        PaymentResponsePaymentData paymentData = fetchPaymentByMerchantOrderId(merchantOrderId);
        assertNotNull(paymentData);

        assertEquals(IN_PROGRESS, paymentData.getStatus());
    }

    private PaymentResponsePaymentData fetchPaymentByMerchantOrderId(String merchantOrderId) throws IOException {
        Call<PaymentsList> call = payments.getPayments(
                UUID.randomUUID().toString(),
                null,
                null,
                50,
                merchantOrderId,
                null,
                null,
                null
        );
        Response<PaymentsList> response = call.execute();
        assertTrue(response.message(), response.isSuccessful());

        PaymentsList body = response.body();
        assertNotNull(body);

        log.info("{}", body);

        List<PaymentResponse> data = body.getData();
        assertEquals(1, data.size());

        PaymentResponse result = data.get(0);
        assertEquals(merchantOrderId, result.getMerchantOrder().getId());

        return result.getPaymentData();
    }

}
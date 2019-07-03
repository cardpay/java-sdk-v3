package com.cardpay.sdk.uat.refund;

import com.cardpay.sdk.api.PaymentsApi;
import com.cardpay.sdk.api.RefundsApi;
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
import retrofit2.Response;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import static com.cardpay.sdk.Config.*;
import static com.cardpay.sdk.Constants.PAYMENT_METHOD_BANKCARD;
import static com.cardpay.sdk.Constants.CARD_NON3DS_CONFIRMED;
import static com.cardpay.sdk.utils.AssertUtils.assertSuccessResponse;
import static com.cardpay.sdk.utils.DataUtils.*;
import static java.math.BigDecimal.valueOf;
import static org.junit.Assert.*;

public class RefundInfoUAT {

    private final Logger log = LoggerFactory.getLogger(getClass());

    private Fairy fairy = Fairy.create();
    private Person person = fairy.person();
    private BaseProducer producer = fairy.baseProducer();
    private TextProducer textProducer = fairy.textProducer();

    private RefundsApi refunds;
    private PaymentsApi payments;

    @Before
    public void setup() {
        ApiClient apiClient = new ApiClient(CARDPAY_API_URL, GATEWAY_TERMINAL_CODE, GATEWAY_PASSWORD)
                .addLogging(LOGGING_LEVEL);

        refunds = apiClient.createService(RefundsApi.class);
        payments = apiClient.createService(PaymentsApi.class);
    }

    @Test
    public void getRefundInformation() throws IOException {
        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        // Phase 1: create payment
        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

        // perform payment
        String paymentId = doPayment();

        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        // Phase 2: create refund
        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

        // perform refund
        String refundId = doRefund(paymentId, valueOf(producer.randomBetween(1, 1000)));

        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        // Phase 3: get refund information
        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

        // perform getting refund information
        Response<RefundResponse> result = refunds
                .getRefund(refundId)
                .execute();

        log.info("{}", result.body());
        assertTrue(result.message(), result.isSuccessful());

        // explore response result
        assertNotNull(result.body());
        assertEquals(refundId, result.body().getRefundData().getId());
    }

    private String doPayment() throws IOException {
        // prepare payment request
        PaymentRequest paymentRequest = new PaymentRequest()
                .request(ApiClient.uuidRequest())
                .merchantOrder(new PaymentRequestMerchantOrder()
                        .id(generateMerchantOrderId())
                        .description(textProducer.sentence()))
                .paymentMethod(PAYMENT_METHOD_BANKCARD)
                .paymentData(new PaymentRequestPaymentData()
                        .currency(TERMINAL_CURRENCY)
                        .amount(valueOf(1000))
                        .note(textProducer.sentence()))
                .cardAccount(new PaymentRequestCardAccount().card(new PaymentRequestCard()
                        .pan(CARD_NON3DS_CONFIRMED)
                        .holder(person.getFullName().toUpperCase())
                        .securityCode("100")
                        .expiration(formatDate("MM/yyyy", generateCardExpiration()))))
                .customer(new PaymentRequestCustomer()
                        .id(textProducer.randomString(15))
                        .fullName(person.getFullName())
                        .birthDate(formatDate("yyyy-MM-dd", person.getDateOfBirth().toDate()))
                        .email(generateEmail())
                        .locale("en")
                        .phone(producer.numerify("+###########")))
                .returnUrls(new ReturnUrls()
                        .successUrl(SUCCESS_URL)
                        .declineUrl(DECLINE_URL)
                        .cancelUrl(CANCEL_URL)
                        .inprocessUrl(INPROCESS_URL)
                );

        log.info("{}", paymentRequest);

        Response<PaymentCreationResponse> response = payments.createPayment(paymentRequest).execute();

        assertSuccessResponse(response);

        PaymentCreationResponse creationResponse = response.body();
        assertNotNull(creationResponse);

        // Emulate customer behaviour performing GET request to redirect url
        HttpUtils.doGet(creationResponse.getRedirectUrl());

        String merchantOrderId = paymentRequest.getMerchantOrder().getId();

        PaymentResponse paymentResponse = fetchPaymentByMerchantOrderId(merchantOrderId);
        assertNotNull(paymentResponse);

        return paymentResponse.getPaymentData().getId();
    }

    private PaymentResponse fetchPaymentByMerchantOrderId(String merchantOrderId) throws IOException {
        Response<PaymentsList> response = payments.getPayments(
                UUID.randomUUID().toString(),
                null,
                null,
                50,
                merchantOrderId,
                null,
                null,
                null
        ).execute();

        assertSuccessResponse(response);

        PaymentsList body = response.body();
        log.info("{}", body);

        assertNotNull(body);

        List<PaymentResponse> data = body.getData();
        return data.size() > 0 ? data.get(0) : null;
    }

    private String doRefund(String paymentId, BigDecimal amount) throws IOException {
        RefundRequest refundRequest = new RefundRequest()
                .request(ApiClient.uuidRequest())
                .merchantOrder(new RefundRequestMerchantOrder()
                        .id(generateMerchantOrderId())
                        .description(textProducer.sentence()))
                .paymentData(new RefundRequestPaymentData().id(paymentId))
                .refundData(new RefundRequestRefundData()
                        .amount(amount)
                        .currency(TERMINAL_CURRENCY)
                );
        log.info("{}", refundRequest);

        Response<RefundResponse> response = refunds.createRefund(refundRequest).execute();
        assertSuccessResponse(response);

        RefundResponse creationResponse = response.body();
        assertNotNull(creationResponse);

        return creationResponse.getRefundData().getId();
    }

}
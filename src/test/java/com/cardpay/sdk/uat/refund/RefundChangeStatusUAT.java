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
import static com.cardpay.sdk.model.RequestUpdatedTransactionData.StatusToEnum.REVERSE;
import static com.cardpay.sdk.utils.AssertUtils.assertSuccessResponse;
import static com.cardpay.sdk.utils.DataUtils.*;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class RefundChangeStatusUAT {

    private final Logger log = LoggerFactory.getLogger(getClass());

    private Fairy fairy = Fairy.create();
    private Person person = fairy.person();
    private BaseProducer producer = fairy.baseProducer();
    private TextProducer text = fairy.textProducer();

    private RefundsApi refunds;
    private PaymentsApi payments;

    @Before
    public void setup() {
        ApiClient apiClient = new ApiClient(CARDPAY_API_URL, GATEWAY_POSTPONED_TERMINAL_CODE, GATEWAY_POSTPONED_PASSWORD)
                .addLogging(LOGGING_LEVEL);

        refunds = apiClient.createService(RefundsApi.class);
        payments = apiClient.createService(PaymentsApi.class);
    }

    @Test
    public void changeRefundStatus() throws IOException {
        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        // Phase 1: create payment
        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

        String paymentId = doPayment();

        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        // Phase 2: create postponed refund
        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

        // prepare refund amount
        BigDecimal refundAmount = BigDecimal.valueOf(producer.randomBetween(1, 1000));

        // create refund
        String refundId = doRefund(paymentId, refundAmount);

        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        // Phase 3: change refund status
        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

        // prepare request data
        final RefundUpdateRequest refundUpdateRequest = new RefundUpdateRequest()
                .request(ApiClient.uuidRequest())
                .refundData(new RequestUpdatedTransactionData().statusTo(REVERSE));
        log.info("{}", refundUpdateRequest);

        // perform change refund status
        Response<RefundUpdateResponse> response = refunds
                .updateRefund(refundId, refundUpdateRequest)
                .execute();

        log.info("{}", response);

        assertTrue(response.message(), response.isSuccessful());
        assertNotNull(response.body());

        // explore response result
        log.info("{}", response.body());
        assertEquals(ResponseUpdatedTransactionData.StatusEnum.VOIDED, response.body().getRefundData().getStatus());
    }

    private String doPayment() throws IOException {
        PaymentRequest paymentRequest = new PaymentRequest()
                .request(ApiClient.uuidRequest())
                .merchantOrder(new PaymentRequestMerchantOrder()
                        .id(generateMerchantOrderId())
                        .description(text.sentence()))
                .paymentMethod(PAYMENT_METHOD_BANKCARD)
                .paymentData(new PaymentRequestPaymentData()
                        .currency(TERMINAL_CURRENCY)
                        .amount(BigDecimal.valueOf(1000))
                        .note(text.sentence()))
                .cardAccount(new PaymentRequestCardAccount().card(new PaymentRequestCard()
                        .pan(CARD_NON3DS_CONFIRMED)
                        .holder(person.getFullName().toUpperCase())
                        .securityCode("100")
                        .expiration(formatDate("MM/yyyy", generateCardExpiration()))))
                .customer(new PaymentRequestCustomer()
                        .id(text.randomString(15))
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

        Response<PaymentCreationResponse> response = payments.createPayment(paymentRequest).execute();
        log.info("{}", response);

        assertTrue(response.message(), response.isSuccessful());

        PaymentCreationResponse creationResponse = response.body();
        assertNotNull(creationResponse);

        // Emulate customer behaviour performing GET request to redirect url
        HttpUtils.doGetSilent(creationResponse.getRedirectUrl());

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
        assertNotNull(body);

        List<PaymentResponse> data = body.getData();
        return data.size() > 0 ? data.get(0) : null;
    }

    private String doRefund(String paymentId, BigDecimal amount) throws IOException {
        RefundRequest refundRequest = new RefundRequest()
                .request(ApiClient.uuidRequest())
                .merchantOrder(new RefundRequestMerchantOrder()
                        .id(generateMerchantOrderId())
                        .description(text.sentence()))
                .paymentData(new RefundRequestPaymentData().id(paymentId))
                .refundData(new RefundRequestRefundData()
                        .amount(amount)
                        .currency(TERMINAL_CURRENCY));

        Response<RefundResponse> response = refunds.createRefund(refundRequest).execute();

        assertSuccessResponse(response);

        RefundResponse creationResponse = response.body();
        assertNotNull(creationResponse);

        return creationResponse.getRefundData().getId();
    }

}
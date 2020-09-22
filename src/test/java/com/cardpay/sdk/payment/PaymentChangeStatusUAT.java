package com.cardpay.sdk.payment;

import static com.cardpay.sdk.Config.CARDPAY_API_URL;
import static com.cardpay.sdk.Config.GATEWAY_PASSWORD;
import static com.cardpay.sdk.Config.GATEWAY_TERMINAL_CODE;
import static com.cardpay.sdk.Config.LOGGING_LEVEL;
import static com.cardpay.sdk.Constants.CARD_NON3DS_CONFIRMED;
import static com.cardpay.sdk.Constants.PAYMENT_METHOD_BANKCARD;
import static com.cardpay.sdk.model.PaymentPatchRequest.OperationEnum.CHANGE_STATUS;
import static com.cardpay.sdk.model.PaymentUpdateTransactionData.StatusToEnum.COMPLETE;
import static com.cardpay.sdk.utils.AssertUtils.assertSuccessResponse;
import static com.cardpay.sdk.utils.DataUtils.generateMerchantOrderId;
import static com.cardpay.sdk.utils.DataUtils.paymentRequestCardAccount;
import static com.cardpay.sdk.utils.DataUtils.paymentRequestCustomer;
import static com.cardpay.sdk.utils.DataUtils.paymentRequestPaymentData;
import static com.cardpay.sdk.utils.DataUtils.returnUrls;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import com.cardpay.sdk.api.PaymentsApi;
import com.cardpay.sdk.client.ApiClient;
import com.cardpay.sdk.model.PaymentGatewayCreationResponse;
import com.cardpay.sdk.model.PaymentPatchRequest;
import com.cardpay.sdk.model.PaymentRequest;
import com.cardpay.sdk.model.PaymentRequestMerchantOrder;
import com.cardpay.sdk.model.PaymentResponse;
import com.cardpay.sdk.model.PaymentUpdateResponse;
import com.cardpay.sdk.model.PaymentUpdateTransactionData;
import com.cardpay.sdk.model.PaymentsList;
import com.cardpay.sdk.model.ResponseUpdatedTransactionData;
import com.cardpay.sdk.utils.HttpUtils;
import io.codearte.jfairy.Fairy;
import io.codearte.jfairy.producer.BaseProducer;
import io.codearte.jfairy.producer.person.Person;
import io.codearte.jfairy.producer.text.TextProducer;
import java.io.IOException;
import java.util.List;
import java.util.UUID;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit2.Call;
import retrofit2.Response;

public class PaymentChangeStatusUAT {

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
    public void changePaymentStatus() throws IOException {
        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        // Phase 1: create payment
        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

        // prepare payment in PENDING status
        String paymentId = doPayment(CARD_NON3DS_CONFIRMED);

        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        // Phase 2: update status to COMPLETE for exists payment
        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

        // prepare request data
        final PaymentPatchRequest paymentUpdateRequest = new PaymentPatchRequest()
                .request(ApiClient.uuidRequest())
                .operation(CHANGE_STATUS)
                .paymentData(new PaymentUpdateTransactionData().statusTo(COMPLETE));

        log.info("{}", paymentUpdateRequest);

        // perform api call
        Response<PaymentUpdateResponse> response = payments
                .updatePayment(paymentId, paymentUpdateRequest)
                .execute();

        log.info("{}", response);

        assertTrue(response.message(), response.isSuccessful());
        assertNotNull(response.body());

        // explore response result
        ResponseUpdatedTransactionData data = response.body().getPaymentData();
        log.info("{} {} {}", data.getUpdated(), data.getId(), data.getStatus());
    }

    private PaymentResponse fetchPaymentByMerchantOrderId(String merchantOrderId) throws IOException {
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
        return data.size() > 0 ? data.get(0) : null;
    }

    private String doPayment(String cardPan) throws IOException {
        // prepare payment request data
        PaymentRequest paymentRequest = createPaymentRequest(cardPan);
        log.info("{}", paymentRequest);

        // perform payment
        PaymentGatewayCreationResponse creationResponse = createPayment(paymentRequest);
        assertNotNull(creationResponse);

        // Emulate customer behaviour performing GET request to redirect url
        HttpUtils.doGet(creationResponse.getRedirectUrl());

        String merchantOrderId = paymentRequest.getMerchantOrder().getId();

        PaymentResponse paymentResponse = fetchPaymentByMerchantOrderId(merchantOrderId);
        assertNotNull(paymentResponse);

        return paymentResponse.getPaymentData().getId();
    }

    private PaymentRequest createPaymentRequest(String cardPan) {
        return new PaymentRequest()
                .request(ApiClient.uuidRequest())
                .merchantOrder(new PaymentRequestMerchantOrder()
                        .id(generateMerchantOrderId())
                        .description(text.sentence()))
                .paymentMethod(PAYMENT_METHOD_BANKCARD)
                .paymentData(paymentRequestPaymentData().preauth(true))
                .cardAccount(paymentRequestCardAccount(cardPan))
                .customer(paymentRequestCustomer())
                .returnUrls(returnUrls());
    }

    private PaymentGatewayCreationResponse createPayment(PaymentRequest payment) throws IOException {
        try {

            Response<PaymentGatewayCreationResponse> response = payments.createPayment(payment).execute();
            assertSuccessResponse(response);

            return response.body();
        } catch (IOException e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

}

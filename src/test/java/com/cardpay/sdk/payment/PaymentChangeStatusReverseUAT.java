package com.cardpay.sdk.payment;

import com.cardpay.sdk.api.PaymentsApi;
import com.cardpay.sdk.client.ApiClient;
import com.cardpay.sdk.model.*;
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
import static com.cardpay.sdk.Constants.CARD_NON3DS_CONFIRMED;
import static com.cardpay.sdk.Constants.PAYMENT_METHOD_BANKCARD;
import static com.cardpay.sdk.model.PaymentPatchRequest.OperationEnum.CHANGE_STATUS;
import static com.cardpay.sdk.model.PaymentResponsePaymentData.StatusEnum.AUTHORIZED;
import static com.cardpay.sdk.model.PaymentUpdateTransactionData.StatusToEnum.REVERSE;
import static com.cardpay.sdk.utils.DataUtils.*;
import static org.junit.Assert.*;

public class PaymentChangeStatusReverseUAT {

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
    public void reversePreauthPayment() throws IOException {
        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        // Phase 1: create pre-authorized payment
        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        PaymentResponsePaymentData paymentData = createPreauthPayment();

        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        // Phase 2: reverse payment
        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        // prepare request data
        final PaymentPatchRequest paymentUpdateRequest = new PaymentPatchRequest()
                .request(ApiClient.uuidRequest())
                .operation(CHANGE_STATUS)
                .paymentData(new PaymentUpdateTransactionData().statusTo(REVERSE));

        Response<PaymentUpdateResponse> paymentUpdateResponse = payments.updatePayment(
                        paymentData.getId(),
                        paymentUpdateRequest)
                .execute();

        log.info("{}", paymentUpdateResponse);
        assertTrue(paymentUpdateResponse.message(), paymentUpdateResponse.isSuccessful());

        PaymentUpdateResponse updatedPaymentResponse = paymentUpdateResponse.body();
        assertNotNull(updatedPaymentResponse);

        assertEquals(ResponseUpdatedTransactionData.StatusEnum.VOIDED, updatedPaymentResponse.getPaymentData().getStatus());
    }

    private PaymentResponsePaymentData createPreauthPayment() throws IOException {
        // merchant order data
        String merchantOrderId = generateMerchantOrderId();
        String merchantDescription = text.sentence();
        BigDecimal amount = BigDecimal.valueOf(producer.randomBetween(10, 300));
        String currency = TERMINAL_CURRENCY;
        String note = text.sentence();

        // card data
        String cardPan = CARD_NON3DS_CONFIRMED;

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
                        .transType(PaymentRequestPaymentData.TransTypeEnum._01)
                        .preauth(true))
                .cardAccount(new PaymentRequestCardAccount()
                        .card(paymentRequestCard(cardPan))
                        .billingAddress(billingAddress())
                )
                .customer(paymentRequestCustomer())
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

        assertEquals(AUTHORIZED, paymentData.getStatus());
        return paymentData;
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

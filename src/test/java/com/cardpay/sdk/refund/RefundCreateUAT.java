package com.cardpay.sdk.refund;

import static com.cardpay.sdk.Config.CARDPAY_API_URL;
import static com.cardpay.sdk.Config.GATEWAY_PASSWORD;
import static com.cardpay.sdk.Config.GATEWAY_TERMINAL_CODE;
import static com.cardpay.sdk.Config.LOGGING_LEVEL;
import static com.cardpay.sdk.Config.TERMINAL_CURRENCY;
import static com.cardpay.sdk.Constants.CARD_NON3DS_CONFIRMED;
import static com.cardpay.sdk.Constants.PAYMENT_METHOD_BANKCARD;
import static com.cardpay.sdk.model.RefundResponseRefundData.StatusEnum.COMPLETED;
import static com.cardpay.sdk.utils.AssertUtils.assertSuccessResponse;
import static com.cardpay.sdk.utils.DataUtils.generateMerchantOrderId;
import static com.cardpay.sdk.utils.DataUtils.paymentRequestCardAccount;
import static com.cardpay.sdk.utils.DataUtils.paymentRequestCustomer;
import static com.cardpay.sdk.utils.DataUtils.paymentRequestPaymentData;
import static com.cardpay.sdk.utils.DataUtils.returnUrls;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.cardpay.sdk.api.PaymentsApi;
import com.cardpay.sdk.api.RefundsApi;
import com.cardpay.sdk.client.ApiClient;
import com.cardpay.sdk.model.PaymentGatewayCreationResponse;
import com.cardpay.sdk.model.PaymentRequest;
import com.cardpay.sdk.model.PaymentRequestMerchantOrder;
import com.cardpay.sdk.model.PaymentResponse;
import com.cardpay.sdk.model.PaymentsList;
import com.cardpay.sdk.model.RefundRequest;
import com.cardpay.sdk.model.RefundRequestMerchantOrder;
import com.cardpay.sdk.model.RefundRequestPaymentData;
import com.cardpay.sdk.model.RefundRequestRefundData;
import com.cardpay.sdk.model.RefundResponse;
import com.cardpay.sdk.utils.HttpUtils;
import io.codearte.jfairy.Fairy;
import io.codearte.jfairy.producer.BaseProducer;
import io.codearte.jfairy.producer.person.Person;
import io.codearte.jfairy.producer.text.TextProducer;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit2.Response;

public class RefundCreateUAT {

    private final Logger log = LoggerFactory.getLogger(getClass());

    private Fairy fairy = Fairy.create();
    private Person person = fairy.person();
    private BaseProducer producer = fairy.baseProducer();
    private TextProducer text = fairy.textProducer();

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
    public void createRefund() throws IOException {
        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        // Phase 1: create payment
        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

        // create payment
        final PaymentResponse paymentResponse = doPayment();

        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        // Phase 2: create refund
        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

        // merchant order data
        String merchantOrderId = generateMerchantOrderId();
        String merchantDescription = text.sentence();
        String currency = TERMINAL_CURRENCY;
        BigDecimal amount = BigDecimal.valueOf(producer.randomBetween(1, paymentResponse.getPaymentData().getAmount().intValue()));

        // get payment id
        String paymentId = paymentResponse.getPaymentData().getId();

        // prepare refund request data
        RefundRequest refundRequest = new RefundRequest()
                .request(ApiClient.uuidRequest())
                .merchantOrder(new RefundRequestMerchantOrder()
                        .id(merchantOrderId)
                        .description(merchantDescription))
                .paymentData(new RefundRequestPaymentData().id(paymentId))
                .refundData(new RefundRequestRefundData()
                        .amount(amount)
                        .currency(currency)
                );
        log.info("{}", refundRequest);

        // perform create refund
        Response<RefundResponse> response = refunds
                .createRefund(refundRequest)
                .execute();
        log.info("{}", response);

        assertTrue(response.message(), response.isSuccessful());
        assertNotNull(response.body());

        // explore response result
        RefundResponse data = response.body();
        log.info("{}", data);

        assertEquals(COMPLETED, data.getRefundData().getStatus());
    }

    private PaymentResponse doPayment() throws IOException {
        // prepare payment request
        PaymentRequest paymentRequest = new PaymentRequest()
                .request(ApiClient.uuidRequest())
                .merchantOrder(new PaymentRequestMerchantOrder()
                        .id(generateMerchantOrderId())
                        .description(text.sentence()))
                .paymentMethod(PAYMENT_METHOD_BANKCARD)
                .paymentData(paymentRequestPaymentData())
                .cardAccount(paymentRequestCardAccount(CARD_NON3DS_CONFIRMED))
                .customer(paymentRequestCustomer())
                .returnUrls(returnUrls());

        Response<PaymentGatewayCreationResponse> response = payments.createPayment(paymentRequest).execute();

        assertSuccessResponse(response);

        PaymentGatewayCreationResponse creationResponse = response.body();
        assertNotNull(creationResponse);

        // Emulate customer behaviour performing GET request to redirect url
        HttpUtils.doGetSilent(creationResponse.getRedirectUrl());

        String merchantOrderId = paymentRequest.getMerchantOrder().getId();

        PaymentResponse paymentResponse = fetchPaymentByMerchantOrderId(merchantOrderId);
        assertNotNull(paymentResponse);

        return paymentResponse;
    }

    private PaymentResponse fetchPaymentByMerchantOrderId(String merchantOrderId) throws IOException {
        Response<PaymentsList> response =  payments.getPayments(
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
        assertEquals(1, data.size());

        return data.get(0);
    }

}

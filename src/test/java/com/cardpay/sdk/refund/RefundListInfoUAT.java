package com.cardpay.sdk.refund;

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
import com.cardpay.sdk.model.RefundResponseRefundData;
import com.cardpay.sdk.model.RefundsList;
import com.cardpay.sdk.utils.DataUtils;
import com.cardpay.sdk.utils.HttpUtils;
import io.codearte.jfairy.Fairy;
import io.codearte.jfairy.producer.BaseProducer;
import io.codearte.jfairy.producer.person.Person;
import io.codearte.jfairy.producer.text.TextProducer;
import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit2.Response;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.IntStream;

import static com.cardpay.sdk.Config.CARDPAY_API_URL;
import static com.cardpay.sdk.Config.GATEWAY_PASSWORD;
import static com.cardpay.sdk.Config.GATEWAY_TERMINAL_CODE;
import static com.cardpay.sdk.Config.LOGGING_LEVEL;
import static com.cardpay.sdk.Config.TERMINAL_CURRENCY;
import static com.cardpay.sdk.Constants.CARD_NON3DS_CONFIRMED;
import static com.cardpay.sdk.Constants.PAYMENT_METHOD_BANKCARD;
import static com.cardpay.sdk.utils.AssertUtils.assertSuccessResponse;
import static com.cardpay.sdk.utils.DataUtils.generateMerchantOrderId;
import static com.cardpay.sdk.utils.DataUtils.paymentRequestCardAccount;
import static com.cardpay.sdk.utils.DataUtils.paymentRequestCustomer;
import static com.cardpay.sdk.utils.DataUtils.paymentRequestPaymentData;
import static com.cardpay.sdk.utils.DataUtils.returnUrls;
import static java.math.BigDecimal.valueOf;
import static java.util.stream.Collectors.toSet;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class RefundListInfoUAT {

    private final Logger log = LoggerFactory.getLogger(getClass());

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
    public void getRefundsListInformation() throws IOException {
        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        // Phase 1: create payment
        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        String paymentId = doPayment();

        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        // Phase 2: create refunds
        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        Set<String> ids = IntStream.range(0, 3)
                .mapToObj(index -> doRefund(paymentId, valueOf(Fairy.create().baseProducer().randomBetween(1, 10))))
                .filter(StringUtils::isNotEmpty)
                .collect(toSet());
        log.info("ids: {}", ids);

        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        // Phase 3: fetch refunds
        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

        // prepare request data
        String currency = TERMINAL_CURRENCY;
        OffsetDateTime endTime = null;
        Integer maxCount = 50;
        String merchantOrderId = null;
        String paymentMethod = null;
        String sortOrder = null;
        OffsetDateTime startTime = null;

        // perform getting refunds list information
        Response<RefundsList> response = refunds.getRefunds(
                UUID.randomUUID().toString(),
                currency,
                endTime,
                maxCount,
                merchantOrderId,
                paymentMethod,
                sortOrder,
                startTime
        ).execute();

        log.info("{}", response);

        assertTrue(response.message(), response.isSuccessful());
        assertNotNull(response.body());

        // explore response result
        List<RefundResponse> refunds = response.body().getData();

        log.info("Count: {}", refunds.size());

        for (RefundResponse refund : refunds) {
            RefundResponseRefundData data = refund.getRefundData();
            log.info("{} {}: {} {}", data.getCreated(), data.getId(),
                    String.format("%-6.2f %s", data.getAmount(), data.getCurrency()),
                    data.getStatus()
            );
        }

        Set<String> fetchedIds = refunds.stream().map(p -> p.getRefundData().getId()).collect(toSet());
        assertTrue(fetchedIds.containsAll(ids));
    }

    private String doPayment() throws IOException {
        // prepare payment request
        PaymentRequest paymentRequest = createPaymentRequest(CARD_NON3DS_CONFIRMED);

        Response<PaymentGatewayCreationResponse> response = payments.createPayment(paymentRequest).execute();
        assertSuccessResponse(response);

        PaymentGatewayCreationResponse creationResponse = response.body();
        assertNotNull(creationResponse);

        // Emulate customer behaviour performing GET request to redirect url
        HttpUtils.doGetSilent(creationResponse.getRedirectUrl());

        return fetchPaymentByMerchantOrderId(paymentRequest.getMerchantOrder().getId()).getPaymentData().getId();
    }

    private PaymentRequest createPaymentRequest(String cardPan) {
        Fairy fairy = Fairy.create();
        Person person = fairy.person();
        BaseProducer producer = fairy.baseProducer();
        TextProducer text = fairy.textProducer();

        return new PaymentRequest()
                .request(ApiClient.uuidRequest())
                .merchantOrder(new PaymentRequestMerchantOrder()
                        .id(DataUtils.generateMerchantOrderId())
                        .description(text.sentence()))
                .paymentMethod(PAYMENT_METHOD_BANKCARD)
                .paymentData(paymentRequestPaymentData())
                .cardAccount(paymentRequestCardAccount(cardPan))
                .customer(paymentRequestCustomer())
                .returnUrls(returnUrls());
    }

    private PaymentResponse fetchPaymentByMerchantOrderId(String merchantOrderId) throws IOException {
        Response<PaymentsList> response = payments.getPayments(
                UUID.randomUUID().toString(),
                null,
                null,
                null,
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

    private String doRefund(String paymentId, BigDecimal amount) {
        RefundRequest refundRequest = new RefundRequest()
                .request(ApiClient.uuidRequest())
                .merchantOrder(new RefundRequestMerchantOrder()
                        .id(generateMerchantOrderId())
                        .description(Fairy.create().textProducer().sentence()))
                .paymentData(new RefundRequestPaymentData().id(paymentId))
                .refundData(new RefundRequestRefundData()
                        .amount(amount)
                        .currency(TERMINAL_CURRENCY)
                );

        RefundResponse creationResponse = null;

        try {
            Response<RefundResponse> response = refunds.createRefund(refundRequest).execute();
            assertSuccessResponse(response);

            creationResponse = response.body();
        } catch (IOException e) {
            log.error(e.getMessage(), e);
            return "";
        }

        assertNotNull(creationResponse);

        return creationResponse.getRefundData().getId();
    }

}

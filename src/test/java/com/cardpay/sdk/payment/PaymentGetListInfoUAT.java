package com.cardpay.sdk.payment;

import com.cardpay.sdk.api.PaymentsApi;
import com.cardpay.sdk.client.ApiClient;
import com.cardpay.sdk.model.PaymentGatewayCreationResponse;
import com.cardpay.sdk.model.PaymentRequest;
import com.cardpay.sdk.model.PaymentRequestMerchantOrder;
import com.cardpay.sdk.model.PaymentResponse;
import com.cardpay.sdk.model.PaymentResponsePaymentData;
import com.cardpay.sdk.model.PaymentsList;
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
import static com.cardpay.sdk.utils.DataUtils.generateMerchantOrderId;
import static com.cardpay.sdk.utils.DataUtils.paymentRequestCardAccount;
import static com.cardpay.sdk.utils.DataUtils.paymentRequestCustomer;
import static com.cardpay.sdk.utils.DataUtils.paymentRequestPaymentData;
import static com.cardpay.sdk.utils.DataUtils.returnUrls;
import static java.util.stream.Collectors.toSet;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class PaymentGetListInfoUAT {

    private final Logger log = LoggerFactory.getLogger(getClass());

    private PaymentsApi payments;

    @Before
    public void setup() {
        payments = new ApiClient(CARDPAY_API_URL, GATEWAY_TERMINAL_CODE, GATEWAY_PASSWORD)
                .addLogging(LOGGING_LEVEL)
                .createService(PaymentsApi.class);
    }

    @Test
    public void getPaymentsListInformation() throws IOException {
        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        // Generate payments
        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        Set<String> ids = IntStream.range(0, 3)
                .parallel()
                .mapToObj(index -> doPayment())
                .filter(StringUtils::isNoneEmpty)
                .collect(toSet());
        log.info("ids: {}", ids);

        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        // Fetch payments
        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

        // prepare request data
        String currency = TERMINAL_CURRENCY;
        OffsetDateTime endTime = null;
        Integer maxCount = 50;
        String merchantOrderId = null;
        String paymentMethod = null;
        String sortOrder = null;
        OffsetDateTime startTime = null;

        // perform api call
        Response<PaymentsList> response = payments.getPayments(
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
        List<PaymentResponse> payments = response.body().getData();

        log.info("Count: {}", payments.size());

        for (PaymentResponse payment : payments) {
            PaymentResponsePaymentData data = payment.getPaymentData();
            log.info("{} {}: {} {} {}", data.getCreated(), data.getId(),
                    String.format("%-6.2f %s", data.getAmount(), data.getCurrency()),
                    data.getStatus(),
                    payment.getMerchantOrder().getId()
            );
        }

        Set<String> fetchedIds = payments.stream().map(p -> p.getPaymentData().getId()).collect(toSet());
        assertTrue(fetchedIds.containsAll(ids));
    }

    private String doPayment() {
        try {
            PaymentRequest paymentRequest = createPaymentRequest(CARD_NON3DS_CONFIRMED);

            PaymentGatewayCreationResponse creationResponse = createPayment(paymentRequest);
            assertNotNull(creationResponse);

            // Emulate customer behaviour performing GET request to redirect url
            HttpUtils.doGetSilent(creationResponse.getRedirectUrl());

            return creationResponse.getPaymentData().getId();
        } catch (IOException e) {
            log.error(e.getMessage(), e);
            return "";
        }
    }

    private PaymentRequest createPaymentRequest(String cardPan) {
        Fairy fairy = Fairy.create();
        Person person = fairy.person();
        BaseProducer producer = fairy.baseProducer();
        TextProducer text = fairy.textProducer();

        return new PaymentRequest()
                .request(ApiClient.uuidRequest())
                .merchantOrder(new PaymentRequestMerchantOrder()
                        .id(generateMerchantOrderId())
                        .description(text.sentence()))
                .paymentMethod(PAYMENT_METHOD_BANKCARD)
                .paymentData(paymentRequestPaymentData())
                .cardAccount(paymentRequestCardAccount(cardPan))
                .customer(paymentRequestCustomer())
                .returnUrls(returnUrls());
    }

    private PaymentGatewayCreationResponse createPayment(PaymentRequest payment) throws IOException {
        try {
            Response<PaymentGatewayCreationResponse> response = payments.createPayment(payment).execute();

            log.info("{}", response);

            return response.body();
        } catch (IOException e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }
}

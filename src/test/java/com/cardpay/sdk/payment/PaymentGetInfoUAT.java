package com.cardpay.sdk.payment;

import com.cardpay.sdk.api.PaymentsApi;
import com.cardpay.sdk.client.ApiClient;
import com.cardpay.sdk.model.PaymentGatewayCreationResponse;
import com.cardpay.sdk.model.PaymentRequest;
import com.cardpay.sdk.model.PaymentRequestMerchantOrder;
import com.cardpay.sdk.model.PaymentResponse;
import com.cardpay.sdk.model.PaymentResponsePaymentData;
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

import static com.cardpay.sdk.Config.CARDPAY_API_URL;
import static com.cardpay.sdk.Config.GATEWAY_PASSWORD;
import static com.cardpay.sdk.Config.GATEWAY_TERMINAL_CODE;
import static com.cardpay.sdk.Config.LOGGING_LEVEL;
import static com.cardpay.sdk.Constants.CARD_NON3DS_CONFIRMED;
import static com.cardpay.sdk.Constants.PAYMENT_METHOD_BANKCARD;
import static com.cardpay.sdk.utils.DataUtils.generateMerchantOrderId;
import static com.cardpay.sdk.utils.DataUtils.paymentRequestCardAccount;
import static com.cardpay.sdk.utils.DataUtils.paymentRequestCustomer;
import static com.cardpay.sdk.utils.DataUtils.paymentRequestPaymentData;
import static com.cardpay.sdk.utils.DataUtils.returnUrls;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class PaymentGetInfoUAT {

    private final Logger log = LoggerFactory.getLogger(getClass());

    private PaymentsApi payments;

    @Before
    public void setup() {
        payments = new ApiClient(CARDPAY_API_URL, GATEWAY_TERMINAL_CODE, GATEWAY_PASSWORD)
                .addLogging(LOGGING_LEVEL)
                .createService(PaymentsApi.class);
    }

    @Test
    public void getPaymentInformation() throws IOException {
        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        // Create payment
        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

        String paymentId = doPayment(CARD_NON3DS_CONFIRMED);

        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        // Get payment information
        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

        // perform getting payment information
        Response<PaymentResponse> response = payments
                .getPayment(paymentId)
                .execute();

        log.info("{}", response);
        assertTrue(response.message(), response.isSuccessful());
        assertNotNull(response.body());

        // explore response result
        PaymentResponsePaymentData data = response.body().getPaymentData();
        log.info("{} {}: {} {}", data.getCreated(), data.getId(),
                String.format("%-6.2f %s", data.getAmount(), data.getCurrency()),
                data.getStatus()
        );
    }

    private String doPayment(String cardPan) throws IOException {
        PaymentRequest paymentRequest = createPaymentRequest(cardPan);
        log.info("{}", paymentRequest);

        PaymentGatewayCreationResponse creationResponse = createPayment(paymentRequest);
        assertNotNull(creationResponse);

        // Emulate customer behaviour performing GET request to redirect url
        HttpUtils.doGet(creationResponse.getRedirectUrl());

        return creationResponse.getPaymentData().getId();
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

package com.cardpay.sdk.payment;

import com.cardpay.sdk.api.PaymentsApi;
import com.cardpay.sdk.client.ApiClient;
import com.cardpay.sdk.model.PaymentGatewayCreationResponse;
import com.cardpay.sdk.model.PaymentRequest;
import com.cardpay.sdk.model.PaymentRequestCard;
import com.cardpay.sdk.model.PaymentRequestCardAccount;
import com.cardpay.sdk.model.PaymentRequestMerchantOrder;
import com.cardpay.sdk.model.PaymentRequestPaymentData;
import com.cardpay.sdk.model.PaymentResponse;
import io.codearte.jfairy.Fairy;
import io.codearte.jfairy.producer.BaseProducer;
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
import static com.cardpay.sdk.utils.DataUtils.billingAddress;
import static com.cardpay.sdk.utils.DataUtils.generateMerchantOrderId;
import static com.cardpay.sdk.utils.DataUtils.paymentRequestCard;
import static com.cardpay.sdk.utils.DataUtils.paymentRequestCustomer;
import static com.cardpay.sdk.utils.DataUtils.paymentRequestPaymentData;
import static com.cardpay.sdk.utils.DataUtils.returnUrls;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class PaymentWithTokenGatewayNon3dsUAT {

    private final Logger log = LoggerFactory.getLogger(getClass());

    private Fairy fairy = Fairy.create();
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
    public void createPaymentWithTokenNon3DS() throws IOException {
        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        // Phase 1: create payment
        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        PaymentRequest paymentRequest = createPaymentRequest();
        log.info("{}", paymentRequest);

        String paymentId = createPayment(paymentRequest);

        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        // Phase 2: get token
        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        // perform get payment by id for card token
        Response<PaymentResponse> paymentResponse = payments
                .getPayment(paymentId)
                .execute();

        log.info("{}", paymentResponse);
        assertTrue(paymentResponse.message(), paymentResponse.isSuccessful());

        // get token
        assertNotNull(paymentResponse.body());
        String token = paymentResponse.body().getCardAccount().getToken();

        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        // Phase 3: create payment with card token
        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        PaymentRequest paymentTokenRequest = createPaymentRequestWithToken(token);
        log.info("{}", paymentTokenRequest);

        createPayment(paymentTokenRequest);
    }

    private String createPayment(PaymentRequest paymentRequest) throws IOException {
        Response<PaymentGatewayCreationResponse> response = payments
                .createPayment(paymentRequest)
                .execute();

        log.info("{}", response);
        assertTrue(response.message(), response.isSuccessful());

        PaymentGatewayCreationResponse creationResponse = response.body();
        assertNotNull(creationResponse);

        // Emulate customer behaviour performing GET request to redirect url
        log.info("{}", ApiClient.doGet(creationResponse.getRedirectUrl()));

        return creationResponse.getPaymentData().getId();
    }

    private PaymentRequest createPaymentRequest() {
        // merchant order data
        String merchantOrderId = generateMerchantOrderId();
        String merchantDescription = text.sentence();
        BigDecimal amount = BigDecimal.valueOf(producer.randomBetween(10, 300));
        String currency = TERMINAL_CURRENCY;
        String note = text.sentence();

        // card data
        String cardPan = CARD_NON3DS_CONFIRMED;

        return new PaymentRequest()
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
                        .generateToken(true))
                .cardAccount(new PaymentRequestCardAccount()
                        .card(paymentRequestCard(cardPan))
                        .billingAddress(billingAddress())
                )
                .customer(paymentRequestCustomer())
                .returnUrls(returnUrls());
    }

    private PaymentRequest createPaymentRequestWithToken(String token) {
        // merchant order data
        String merchantOrderId = generateMerchantOrderId();
        String merchantDescription = text.sentence();

        // card data
        String securityCode = "100";

        return new PaymentRequest()
                .request(ApiClient.uuidRequest())
                .merchantOrder(new PaymentRequestMerchantOrder()
                        .id(merchantOrderId)
                        .description(merchantDescription))
                .paymentMethod(PAYMENT_METHOD_BANKCARD)
                .paymentData(paymentRequestPaymentData())
                .cardAccount(new PaymentRequestCardAccount()
                        .card(new PaymentRequestCard()
                                .securityCode(securityCode))
                        .token(token)
                        .billingAddress(billingAddress())
                )
                .customer(paymentRequestCustomer())
                .returnUrls(returnUrls());
    }
}

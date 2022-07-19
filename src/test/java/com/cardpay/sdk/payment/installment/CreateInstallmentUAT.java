package com.cardpay.sdk.payment.installment;

import com.cardpay.sdk.api.PaymentsApi;
import com.cardpay.sdk.client.ApiClient;
import com.cardpay.sdk.model.BillingAddress;
import com.cardpay.sdk.model.Item;
import com.cardpay.sdk.model.PaymentGatewayCreationResponse;
import com.cardpay.sdk.model.PaymentRequest;
import com.cardpay.sdk.model.PaymentRequestCard;
import com.cardpay.sdk.model.PaymentRequestCardAccount;
import com.cardpay.sdk.model.PaymentRequestCustomer;
import com.cardpay.sdk.model.PaymentRequestMerchantOrder;
import com.cardpay.sdk.model.PaymentRequestPaymentData;
import com.cardpay.sdk.model.PaymentResponse;
import com.cardpay.sdk.model.ShippingAddress;
import com.cardpay.sdk.utils.DataUtils;
import com.cardpay.sdk.utils.HttpUtils;
import io.codearte.jfairy.Fairy;
import io.codearte.jfairy.producer.BaseProducer;
import io.codearte.jfairy.producer.person.Person;
import io.codearte.jfairy.producer.text.TextProducer;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit2.Response;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static com.cardpay.sdk.Config.CARDPAY_API_URL;
import static com.cardpay.sdk.Config.GATEWAY_PASSWORD;
import static com.cardpay.sdk.Config.GATEWAY_TERMINAL_CODE;
import static com.cardpay.sdk.Config.LOGGING_LEVEL;
import static com.cardpay.sdk.Config.TERMINAL_CURRENCY;
import static com.cardpay.sdk.Constants.CARD_NON3DS_CONFIRMED;
import static com.cardpay.sdk.Constants.PAYMENT_METHOD_BANKCARD;
import static com.cardpay.sdk.client.StringUtil.formatExpirationDate;
import static com.cardpay.sdk.utils.DataUtils.generateCardExpiration;
import static com.cardpay.sdk.utils.DataUtils.generateMerchantOrderId;
import static com.cardpay.sdk.utils.DataUtils.returnUrls;
import static org.apache.commons.lang3.RandomUtils.nextInt;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class CreateInstallmentUAT {

    private final Logger log = LoggerFactory.getLogger(getClass());

    private Fairy fairy = Fairy.create();
    private Person person = fairy.person();
    private BaseProducer producer = fairy.baseProducer();
    private TextProducer text = fairy.textProducer();

    private PaymentsApi paymentsApi;

    @Before
    public void setUp() {
        paymentsApi = new ApiClient(CARDPAY_API_URL, GATEWAY_TERMINAL_CODE, GATEWAY_PASSWORD)
                .addLogging(LOGGING_LEVEL)
                .createService(PaymentsApi.class);
    }

    @Test
    @Ignore
    public void createInstallmentSubscription() throws IOException {
        // merchant order data
        String merchantOrderId = generateMerchantOrderId();
        String merchantDescription = text.sentence();
        BigDecimal amount = BigDecimal.valueOf(producer.randomBetween(10, 300));
        List<Item> items = new ArrayList<Item>() {{
            add(new Item().name("T-Shirt").description("Funny T-Shirt").count(15).price(new BigDecimal("99.99")));
            add(new Item().name("T-Shirt").description("T-Shirt(red)").count(15).price(new BigDecimal("65.99")));
        }};

        //recurring data
        String installmentType = "MF_HOLD";
        String initiator = "cit";
        String currency = TERMINAL_CURRENCY;

        // card data
        String cardPan = CARD_NON3DS_CONFIRMED;
        String cardHolder = person.getFullName().toUpperCase();
        String securityCode = "100";
        String cardExpiration = formatExpirationDate(generateCardExpiration());
        String installments = String.valueOf(nextInt(2, 10));

        // customer data
        String customerId = text.randomString(15);
        String customerEmail = DataUtils.generateEmail();
        String customerPhoneNumber = producer.numerify("+###########");

        // prepare request data
        final PaymentRequest installmentRequest = new PaymentRequest()
                .request(ApiClient.uuidRequest())
                .merchantOrder(new PaymentRequestMerchantOrder()
                        .id(merchantOrderId)
                        .description(merchantDescription)
                        .shippingAddress(new ShippingAddress()
                                .country("USA")
                                .state("NY")
                                .zip("10001")
                                .city("New York")
                                .phone(producer.numerify("+###########"))
                                .addrLine1(person.getAddress().getAddressLine1()))
                        .items(items))
                .paymentMethod(PAYMENT_METHOD_BANKCARD)
                .cardAccount(new PaymentRequestCardAccount()
                        .card(new PaymentRequestCard()
                                .pan(cardPan)
                                .holder(cardHolder)
                                .securityCode(securityCode)
                                .expiration(cardExpiration)
                                .acctType(PaymentRequestCard.AcctTypeEnum._03))
                        .billingAddress(new BillingAddress()
                                .country("USA")
                                .state("NY")
                                .zip("10001")
                                .city("New York")
                                .addrLine1(person.getAddress().getAddressLine1())
                                .addrLine2(person.getAddress().getAddressLine2())))
                .paymentData(new PaymentRequestPaymentData()
                        .installmentType(installmentType)
                        .installments(installments)
                        .currency(currency)
                        .amount(amount)
                        .transType(PaymentRequestPaymentData.TransTypeEnum._01))
                .customer(new PaymentRequestCustomer()
                        .id(customerId)
                        .email(customerEmail)
                        .phone(customerPhoneNumber)
                        .workPhone(customerPhoneNumber)
                        .homePhone(customerPhoneNumber)
                        .locale("en"))
                .returnUrls(returnUrls());

        log.info("{}", installmentRequest);

        // perform create payment
        Response<PaymentGatewayCreationResponse> response = paymentsApi
                .createPayment(installmentRequest)
                .execute();

        log.info("{}", response);
        assertTrue(response.message(), response.isSuccessful());

        // explore response result
        PaymentGatewayCreationResponse creationResponse = response.body();
        assertNotNull(creationResponse);
        log.info("{}", creationResponse);

        // get redirect url
        final String redirectUrl = creationResponse.getRedirectUrl();
        assertNotNull(redirectUrl);
        assertFalse(redirectUrl.isEmpty());

        // Emulate customer behaviour performing GET request to redirect url
        HttpUtils.doGetSilent(redirectUrl);

        //get recurring id
        String recurringId = creationResponse.getPaymentData().getId();

        // explore response result
        PaymentResponse paymentData = fetchInstallmentPayment(recurringId);
        assertNotNull(paymentData);
        log.info("{}", paymentData);
    }

    private PaymentResponse fetchInstallmentPayment(String recurringId) throws IOException {
        Response<PaymentResponse> response = paymentsApi
                .getPayment(recurringId)
                .execute();
        log.info("{}", response);
        assertTrue(response.message(), response.isSuccessful());

        PaymentResponse body = response.body();
        assertNotNull(body);

        return body;
    }
}

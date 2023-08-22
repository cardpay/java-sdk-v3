package com.cardpay.sdk.payment.installment;

import com.cardpay.sdk.api.PaymentsApi;
import com.cardpay.sdk.client.ApiClient;
import com.cardpay.sdk.model.Item;
import com.cardpay.sdk.model.PaymentGatewayCreationResponse;
import com.cardpay.sdk.model.PaymentRequest;
import com.cardpay.sdk.model.PaymentRequestCardAccount;
import com.cardpay.sdk.model.PaymentRequestCustomer;
import com.cardpay.sdk.model.PaymentRequestMerchantOrder;
import com.cardpay.sdk.model.PaymentRequestPaymentData;
import com.cardpay.sdk.model.PaymentResponse;
import com.cardpay.sdk.model.PaymentResponsePaymentData;
import com.cardpay.sdk.model.PaymentsList;
import com.cardpay.sdk.model.ShippingAddress;
import com.cardpay.sdk.utils.DataUtils;
import io.codearte.jfairy.Fairy;
import io.codearte.jfairy.producer.BaseProducer;
import io.codearte.jfairy.producer.person.Person;
import io.codearte.jfairy.producer.text.TextProducer;
import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit2.Response;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Collections;
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
import static com.cardpay.sdk.utils.DataUtils.billingAddress;
import static com.cardpay.sdk.utils.DataUtils.generateMerchantOrderId;
import static com.cardpay.sdk.utils.DataUtils.paymentRequestCard;
import static com.cardpay.sdk.utils.DataUtils.returnUrls;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;
import static junit.framework.TestCase.assertTrue;
import static org.apache.commons.lang3.RandomUtils.nextInt;
import static org.junit.Assert.assertNotNull;

public class GetInstallmentsUAT {

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
    public void getInstallmentPaymentsInfo() throws IOException {
        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        // Phase 1: create installment payment
        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        List<String> ids = IntStream.range(0, 3)
                .parallel()
                .mapToObj(index -> performInstallmentRequest())
                .filter(StringUtils::isNotEmpty)
                .collect(toList());
        log.info("ids: {}", ids);

        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        // Phase 2: get installment payments information
        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

        // prepare request data
        String requestId = UUID.randomUUID().toString();
        String currency = TERMINAL_CURRENCY;
        OffsetDateTime endTime = null;
        Integer maxCount = 50;
        String merchantOrderId = null;
        String paymentMethod = null;
        String sortOrder = null;
        OffsetDateTime startTime = null;

        // get installment payments information
        Response<PaymentsList> response = paymentsApi
                .getPayments(requestId,
                        currency,
                        endTime,
                        maxCount,
                        merchantOrderId,
                        paymentMethod,
                        sortOrder,
                        startTime)
                .execute();

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

        Set<String> fetchedIds = payments.stream().map(r -> r.getPaymentData().getId()).collect(toSet());
        Assert.assertTrue(fetchedIds.containsAll(ids));
    }

    @SneakyThrows
    private String performInstallmentRequest() {
        PaymentRequest installmentRequest = createInstallmentRequest();
        log.info("{}", installmentRequest);

        Response<PaymentGatewayCreationResponse> response = paymentsApi
                .createPayment(installmentRequest)
                .execute();
        log.info("{}", response);

        PaymentGatewayCreationResponse creationResponse = response.body();
        assertNotNull(creationResponse);

        return creationResponse.getPaymentData().getId();
    }

    private PaymentRequest createInstallmentRequest() {
        // merchant order data
        String merchantOrderId = generateMerchantOrderId();
        String merchantDescription = text.sentence();
        BigDecimal amount = BigDecimal.valueOf(producer.randomBetween(10, 300));
        List<Integer> installments = Collections.singletonList(nextInt(2, 10));

        List<Item> items = new ArrayList<Item>() {{
            add(new Item().name("T-Shirt").description("Funny T-Shirt").count(15).price(new BigDecimal("99.99")));
            add(new Item().name("T-Shirt").description("T-Shirt(red)").count(15).price(new BigDecimal("65.99")));
        }};

        //recurring data
        String installmentType = "MF_HOLD";
        String currency = TERMINAL_CURRENCY;

        // customer data
        String customerId = text.randomString(15);
        String customerEmail = DataUtils.generateEmail();
        String customerPhoneNumber = producer.numerify("+###########");

        return new PaymentRequest()
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
                        .card(paymentRequestCard(CARD_NON3DS_CONFIRMED))
                        .billingAddress(billingAddress()))
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
    }
}

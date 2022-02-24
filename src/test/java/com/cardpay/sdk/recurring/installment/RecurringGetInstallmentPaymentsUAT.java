package com.cardpay.sdk.recurring.installment;

import com.cardpay.sdk.api.RecurringsInstallmentsApi;
import com.cardpay.sdk.client.ApiClient;
import com.cardpay.sdk.model.InstallmentData;
import com.cardpay.sdk.model.InstallmentSubscriptionRequest;
import com.cardpay.sdk.model.Item;
import com.cardpay.sdk.model.PaymentRequestCardAccount;
import com.cardpay.sdk.model.RecurringCustomer;
import com.cardpay.sdk.model.RecurringGatewayCreationResponse;
import com.cardpay.sdk.model.RecurringRequestMerchantOrder;
import com.cardpay.sdk.model.RecurringResponse;
import com.cardpay.sdk.model.RecurringResponseRecurringData;
import com.cardpay.sdk.model.RecurringsList;
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
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit2.Response;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
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
import static org.junit.Assert.assertNotNull;

public class RecurringGetInstallmentPaymentsUAT {

    private final Logger log = LoggerFactory.getLogger(getClass());

    private Fairy fairy = Fairy.create();
    private Person person = fairy.person();
    private BaseProducer producer = fairy.baseProducer();
    private TextProducer text = fairy.textProducer();

    private RecurringsInstallmentsApi recurringsInstallments;

    @Before
    public void setUp() {
        recurringsInstallments = new ApiClient(CARDPAY_API_URL, GATEWAY_TERMINAL_CODE, GATEWAY_PASSWORD)
                .addLogging(LOGGING_LEVEL)
                .createService(RecurringsInstallmentsApi.class);
    }

    @Test
    public void getInstallmentPaymentsInfo() throws IOException {
        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        // Phase 1: create installment subscriptions
        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        List<String> ids = IntStream.range(0, 3)
                .parallel()
                .mapToObj(index -> createInstallmentSubscription())
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
        List<String> recurringTypes = null;
        String sortOrder = null;
        OffsetDateTime startTime = null;
        String type = null;

        // perform getting installment payments information
        Response<RecurringsList> response = recurringsInstallments
                .getInstallmentPayments(
                        requestId,
                        currency,
                        endTime,
                        maxCount,
                        merchantOrderId,
                        paymentMethod,
                        recurringTypes,
                        sortOrder,
                        startTime,
                        type)
                .execute();

        log.info("{}", response);

        assertTrue(response.message(), response.isSuccessful());
        assertNotNull(response.body());

        // explore response result
        List<RecurringResponse> recurrings = response.body().getData();
        log.info("Count: {}", recurrings.size());

        for (RecurringResponse recurring : recurrings) {
            RecurringResponseRecurringData data = recurring.getRecurringData();
            log.info("{} {}: {} {} {}", data.getCreated(), data.getId(),
                    String.format("%-6.2f %s", data.getAmount(), data.getCurrency()),
                    data.getStatus(),
                    recurring.getMerchantOrder().getId()
            );
        }

        Set<String> fetchedIds = recurrings.stream().map(r -> r.getRecurringData().getId()).collect(toSet());
        Assert.assertTrue(fetchedIds.containsAll(ids));
    }

    @SneakyThrows
    private String createInstallmentSubscription() {
        InstallmentSubscriptionRequest installmentSubscriptionRequest = createInstallmentSubscriptionRequest();
        log.info("{}", installmentSubscriptionRequest);

        Response<RecurringGatewayCreationResponse> response = recurringsInstallments
                .createInstallment(installmentSubscriptionRequest)
                .execute();
        log.info("{}", response);

        RecurringGatewayCreationResponse creationResponse = response.body();
        assertNotNull(creationResponse);

        return creationResponse.getRecurringData().getId();
    }

    private InstallmentSubscriptionRequest createInstallmentSubscriptionRequest() {
        // merchant order data
        String merchantOrderId = generateMerchantOrderId();
        String merchantDescription = text.sentence();
        BigDecimal amount = BigDecimal.valueOf(producer.randomBetween(10, 300));
        List<Item> items = new ArrayList<Item>() {{
            add(new Item().name("T-Shirt").description("Funny T-Shirt").count(15).price(new BigDecimal(99.99)));
            add(new Item().name("T-Shirt").description("T-Shirt(red)").count(15).price(new BigDecimal(65.99)));
        }};

        //recurring data
        String installmentType = "MF_HOLD";
        String initiator = "cit";
        String currency = TERMINAL_CURRENCY;

        // customer data
        String customerId = text.randomString(15);
        String customerEmail = DataUtils.generateEmail();
        String customerPhoneNumber = producer.numerify("+###########");

        return new InstallmentSubscriptionRequest()
                .request(ApiClient.uuidRequest())
                .merchantOrder(new RecurringRequestMerchantOrder()
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
                .recurringData(new InstallmentData()
                        .installmentType(installmentType)
                        .initiator(initiator)
                        .currency(currency)
                        .amount(amount)
                        .payments(10)
                        .transType(InstallmentData.TransTypeEnum._01)
                        .preauth(true))
                .customer(new RecurringCustomer()
                        .id(customerId)
                        .email(customerEmail)
                        .phone(customerPhoneNumber)
                        .workPhone(customerPhoneNumber)
                        .homePhone(customerPhoneNumber)
                        .locale(RecurringCustomer.LocaleEnum.EN))
                .returnUrls(returnUrls());
    }
}
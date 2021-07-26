package com.cardpay.sdk.recurring.installment;

import com.cardpay.sdk.api.PaymentsApi;
import com.cardpay.sdk.api.RecurringsInstallmentsApi;
import com.cardpay.sdk.client.ApiClient;
import com.cardpay.sdk.model.*;
import com.cardpay.sdk.utils.DataUtils;
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
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static com.cardpay.sdk.Config.*;
import static com.cardpay.sdk.Constants.CARD_NON3DS_CONFIRMED;
import static com.cardpay.sdk.Constants.PAYMENT_METHOD_BANKCARD;
import static com.cardpay.sdk.client.StringUtil.formatExpirationDate;
import static com.cardpay.sdk.utils.DataUtils.*;
import static org.junit.Assert.*;

public class RecurringInstallmentSubscriptionUAT {

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
    public void createInstallmentSubscription() throws IOException {
        // merchant order data
        String merchantOrderId = generateMerchantOrderId();
        String merchantDescription = text.sentence();
        BigDecimal amount = BigDecimal.valueOf(producer.randomBetween(10, 300));
        List<Item> items = new ArrayList<Item>(){{
                add(new Item().name("T-Shirt").description("Funny T-Shirt").count(15).price(new BigDecimal(99.99)));
                add(new Item().name("T-Shirt").description("T-Shirt(red)").count(15).price(new BigDecimal(65.99)));
        }};

        //recurring data
        String installmentType = "MF_WITHOUT_HOLD";
        String initiator = "cit";
        String currency = TERMINAL_CURRENCY;

        // card data
        String cardPan = CARD_NON3DS_CONFIRMED;
        String cardHolder = person.getFullName().toUpperCase();
        String securityCode = "100";
        String cardExpiration = formatExpirationDate(generateCardExpiration());

        // customer data
        String customerId = text.randomString(15);
        String customerEmail = DataUtils.generateEmail();
        String customerPhoneNumber = producer.numerify("+###########");

        // prepare request data
        final InstallmentSubscriptionRequest installmentSubscriptionRequest = new InstallmentSubscriptionRequest()
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
                .recurringData(new InstallmentData()
                        .installmentType(installmentType)
                        .initiator(initiator)
                        .period(InstallmentData.PeriodEnum.MONTH)
                        .interval(1)
                        .currency(currency)
                        .amount(amount)
                        .payments(10)
                        .retries(3)
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

        log.info("{}", installmentSubscriptionRequest);

        // perform create payment
        Response<RecurringGatewayCreationResponse> response = recurringsInstallments
                .createInstallment(installmentSubscriptionRequest)
                .execute();

        log.info("{}", response);
        assertTrue(response.message(), response.isSuccessful());

        // explore response result
        RecurringGatewayCreationResponse creationResponse = response.body();
        assertNotNull(creationResponse);
        log.info("{}", creationResponse);

        // get redirect url
        final String redirectUrl = creationResponse.getRedirectUrl();
        assertNotNull(redirectUrl);
        assertFalse(redirectUrl.isEmpty());

        // Emulate customer behaviour performing GET request to redirect url
        HttpUtils.doGetSilent(redirectUrl);

        //get recurring id
        String recurringId = creationResponse.getRecurringData().getId();

        // explore response result
        RecurringResponse paymentData = fetchInstallmentPayment(recurringId);
        assertNotNull(paymentData);
        log.info("{}", paymentData);
    }

    private RecurringResponse fetchInstallmentPayment(String recurringId) throws IOException {
        Response<RecurringResponse> response= recurringsInstallments
                .getInstallmentPayment(recurringId)
                .execute();
        log.info("{}", response);
        assertTrue(response.message(), response.isSuccessful());

        RecurringResponse body = response.body();
        assertNotNull(body);

        return body;
    }
}
package com.cardpay.sdk.recurring.installment;

import static com.cardpay.sdk.Config.CARDPAY_API_URL;
import static com.cardpay.sdk.Config.GATEWAY_PASSWORD;
import static com.cardpay.sdk.Config.GATEWAY_TERMINAL_CODE;
import static com.cardpay.sdk.Config.LOGGING_LEVEL;
import static com.cardpay.sdk.Config.TERMINAL_CURRENCY;
import static com.cardpay.sdk.Constants.CARD_NON3DS_CONFIRMED;
import static com.cardpay.sdk.Constants.PAYMENT_METHOD_BANKCARD;
import static com.cardpay.sdk.utils.DataUtils.generateEmail;
import static com.cardpay.sdk.utils.DataUtils.generateMerchantOrderId;
import static com.cardpay.sdk.utils.DataUtils.paymentRequestCardAccount;
import static com.cardpay.sdk.utils.DataUtils.returnUrls;
import static org.junit.Assert.assertNotNull;

import com.cardpay.sdk.api.RecurringsApi;
import com.cardpay.sdk.client.ApiClient;
import com.cardpay.sdk.model.PaymentRequestMerchantOrder;
import com.cardpay.sdk.model.RecurringCreationRequest;
import com.cardpay.sdk.model.RecurringCreationResponse;
import com.cardpay.sdk.model.RecurringCustomer;
import com.cardpay.sdk.model.RecurringRequestRecurringData;
import io.codearte.jfairy.Fairy;
import io.codearte.jfairy.producer.BaseProducer;
import io.codearte.jfairy.producer.person.Person;
import io.codearte.jfairy.producer.text.TextProducer;
import java.io.IOException;
import java.math.BigDecimal;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit2.Response;

public class RecurringCreateSubscriptionUAT {

    private final Logger log = LoggerFactory.getLogger(getClass());

    private Fairy fairy = Fairy.create();
    private Person person = fairy.person();
    private BaseProducer producer = fairy.baseProducer();
    private TextProducer text = fairy.textProducer();

    private RecurringsApi recurrings;

    @Before
    public void setUp() {
        recurrings = new ApiClient(CARDPAY_API_URL, GATEWAY_TERMINAL_CODE, GATEWAY_PASSWORD)
                .addLogging(LOGGING_LEVEL)
                .createService(RecurringsApi.class);
    }

    @After
    public void cleanUp() {
        // TODO
    }

    @Ignore
    @Test
    public void createInstallmentSubscription() throws IOException {
        RecurringCreationRequest recurringRequest = new RecurringCreationRequest()
                .request(ApiClient.uuidRequest())
                .customer(new RecurringCustomer()
                        .email(generateEmail())
                        .id(text.randomString(15)))
                .merchantOrder(new PaymentRequestMerchantOrder()
                        .id(generateMerchantOrderId())
                        .description(text.sentence()))
                .paymentMethod(PAYMENT_METHOD_BANKCARD)
                .cardAccount(paymentRequestCardAccount(CARD_NON3DS_CONFIRMED))
                .recurringData(new RecurringRequestRecurringData()
                        .currency(TERMINAL_CURRENCY)
                        .amount(BigDecimal.valueOf(producer.randomBetween(10, 300)))
                        .payments(10)
                        .initiator("cit")
                        .period(RecurringRequestRecurringData.PeriodEnum.MONTH)
                        .interval(1))
                .returnUrls(returnUrls());

        log.info("{}", recurringRequest);

        Response<RecurringCreationResponse> response = recurrings
                .createRecurring(recurringRequest)
                .execute();
        log.info("{}", response);

        RecurringCreationResponse creationResponse = response.body();
        assertNotNull(creationResponse);

        log.info("{}", creationResponse);
    }

}
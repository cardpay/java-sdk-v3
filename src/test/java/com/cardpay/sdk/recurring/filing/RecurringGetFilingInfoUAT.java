package com.cardpay.sdk.recurring.filing;

import com.cardpay.sdk.api.RecurringsApi;
import com.cardpay.sdk.client.ApiClient;
import com.cardpay.sdk.model.FilingRecurringData;
import com.cardpay.sdk.model.FilingRequest;
import com.cardpay.sdk.model.FilingRequestMerchantOrder;
import com.cardpay.sdk.model.RecurringCustomer;
import com.cardpay.sdk.model.RecurringGatewayCreationResponse;
import com.cardpay.sdk.model.RecurringResponse;
import com.cardpay.sdk.utils.HttpUtils;
import io.codearte.jfairy.Fairy;
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
import static com.cardpay.sdk.Config.TERMINAL_CURRENCY;
import static com.cardpay.sdk.Constants.CARD_NON3DS_CONFIRMED;
import static com.cardpay.sdk.Constants.PAYMENT_METHOD_BANKCARD;
import static com.cardpay.sdk.utils.DataUtils.generateEmail;
import static com.cardpay.sdk.utils.DataUtils.generateMerchantOrderId;
import static com.cardpay.sdk.utils.DataUtils.paymentRequestCardAccount;
import static com.cardpay.sdk.utils.DataUtils.returnUrls;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class RecurringGetFilingInfoUAT {

    private final Logger log = LoggerFactory.getLogger(getClass());

    private final Fairy fairy = Fairy.create();
    private final TextProducer text = fairy.textProducer();

    private RecurringsApi recurrings;

    @Before
    public void setUp() {
        recurrings = new ApiClient(CARDPAY_API_URL, GATEWAY_TERMINAL_CODE, GATEWAY_PASSWORD)
                .addLogging(LOGGING_LEVEL)
                .createService(RecurringsApi.class);
    }

    @Test
    public void getFilingInformation() throws IOException {
        String recurringId = createFiling();

        Response<RecurringResponse> response = recurrings
                .getRecurring(recurringId)
                .execute();

        assertTrue(response.message(), response.isSuccessful());
        assertNotNull(response.body());

        log.info("{}", response.body());
    }

    public String createFiling() throws IOException {
        String merchantOrderId = generateMerchantOrderId();
        String merchantDescription = text.sentence();
        String initiator = "cit";

        // customer data
        String customerId = text.randomString(15);
        String customerEmail = generateEmail();

        // prepare filing request data
        FilingRequest filingRequest = new FilingRequest()
                .request(ApiClient.uuidRequest())
                .merchantOrder(new FilingRequestMerchantOrder()
                        .id(merchantOrderId)
                        .description(merchantDescription))
                .paymentMethod(PAYMENT_METHOD_BANKCARD)
                .cardAccount(paymentRequestCardAccount(CARD_NON3DS_CONFIRMED))
                .customer(new RecurringCustomer()
                        .id(customerId)
                        .email(customerEmail)
                )
                .recurringData(new FilingRecurringData()
                        .currency(TERMINAL_CURRENCY)
                        .initiator(initiator))
                .returnUrls(returnUrls());

        // create filing
        Response<RecurringGatewayCreationResponse> response = recurrings
                .createFiling(filingRequest)
                .execute();
        log.info("{}", response);

        RecurringGatewayCreationResponse data = response.body();
        assertNotNull(data);
        log.info("{}", data);

        final String redirectUrl = data.getRedirectUrl();
        assertNotNull(redirectUrl);
        assertFalse(redirectUrl.isEmpty());

        // emulate customer behaviour performing GET request to redirect url
        HttpUtils.doGet(data.getRedirectUrl());

        return data.getRecurringData().getId();
    }
}

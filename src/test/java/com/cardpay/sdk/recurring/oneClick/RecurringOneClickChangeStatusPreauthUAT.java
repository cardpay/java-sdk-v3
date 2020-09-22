package com.cardpay.sdk.recurring.oneClick;

import static com.cardpay.sdk.Config.CARDPAY_API_URL;
import static com.cardpay.sdk.Config.GATEWAY_PASSWORD;
import static com.cardpay.sdk.Config.GATEWAY_TERMINAL_CODE;
import static com.cardpay.sdk.Config.LOGGING_LEVEL;
import static com.cardpay.sdk.Config.TERMINAL_CURRENCY;
import static com.cardpay.sdk.Constants.CARD_NON3DS_CONFIRMED;
import static com.cardpay.sdk.Constants.PAYMENT_METHOD_BANKCARD;
import static com.cardpay.sdk.model.PaymentUpdateTransactionData.StatusToEnum.COMPLETE;
import static com.cardpay.sdk.model.RecurringPatchRequest.OperationEnum.CHANGE_STATUS;
import static com.cardpay.sdk.utils.DataUtils.generateEmail;
import static com.cardpay.sdk.utils.DataUtils.generateMerchantOrderId;
import static com.cardpay.sdk.utils.DataUtils.paymentRequestCardAccount;
import static com.cardpay.sdk.utils.DataUtils.returnUrls;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import com.cardpay.sdk.api.RecurringsApi;
import com.cardpay.sdk.client.ApiClient;
import com.cardpay.sdk.model.PaymentRequestMerchantOrder;
import com.cardpay.sdk.model.PaymentUpdateTransactionData;
import com.cardpay.sdk.model.RecurringCreationRequest;
import com.cardpay.sdk.model.RecurringCustomer;
import com.cardpay.sdk.model.RecurringGatewayCreationResponse;
import com.cardpay.sdk.model.RecurringPatchRequest;
import com.cardpay.sdk.model.RecurringRequestRecurringData;
import com.cardpay.sdk.model.RecurringResponse;
import com.cardpay.sdk.model.RecurringResponseRecurringData;
import com.cardpay.sdk.model.RecurringUpdateResponse;
import com.cardpay.sdk.model.RecurringsList;
import com.cardpay.sdk.model.ResponseUpdatedTransactionData;
import com.cardpay.sdk.utils.HttpUtils;
import io.codearte.jfairy.Fairy;
import io.codearte.jfairy.producer.BaseProducer;
import io.codearte.jfairy.producer.person.Person;
import io.codearte.jfairy.producer.text.TextProducer;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit2.Response;

public class RecurringOneClickChangeStatusPreauthUAT {

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

    @Test
    public void changeOneClickStatusPreauth() throws IOException {
        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        // Phase 1: create initial recurring
        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

        // prepare request data
        RecurringResponse recurringResponse = doOneClickPayment(CARD_NON3DS_CONFIRMED);

        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        // Phase 2: change one-click status (preauth complete operation)
        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

        // prepare update request data
        RecurringPatchRequest recurringPatchRequest = new RecurringPatchRequest()
                .request(ApiClient.uuidRequest())
                .operation(CHANGE_STATUS)
                .recurringData(new PaymentUpdateTransactionData().statusTo(COMPLETE));

        // prepare request data to change one-click status
        String recurringId = recurringResponse.getRecurringData().getId();

        // prepare request data to change one-click status (preauth complete operation)
        Response<RecurringUpdateResponse> result = recurrings
                .updateRecurring(recurringId, recurringPatchRequest)
                .execute();

        assertTrue(result.message(), result.isSuccessful());
        assertNotNull(result.body());

        // explore response result
        ResponseUpdatedTransactionData data = result.body().getRecurringData();
        log.info("{}", data);

        assertEquals(ResponseUpdatedTransactionData.StatusEnum.COMPLETED, data.getStatus());
    }

    private RecurringResponse fetchRecurring(String merchantOrderId) throws IOException {
        Response<RecurringsList> response = recurrings.getRecurrings(
                UUID.randomUUID().toString(),
                null,
                null,
                null,
                merchantOrderId,
                null,
                null,
                null,
                null,
                null
        ).execute();
        assertTrue(response.message(), response.isSuccessful());

        RecurringsList body = response.body();
        assertNotNull(body);

        log.info("{}", body);

        List<RecurringResponse> data = body.getData();
        return data.size() > 0 ? data.get(0) : null;
    }

    private RecurringResponse doOneClickPayment(String cardPan) throws IOException {
        RecurringCreationRequest recurringRequest = createRecurringRequest(cardPan);

        log.info("{}", recurringRequest);

        RecurringGatewayCreationResponse creationResponse = createRecurring(recurringRequest);
        assertNotNull(creationResponse);

        log.info("{}", creationResponse);

        assertNotNull(creationResponse);

        // Emulate customer behaviour performing GET request to redirect url
        HttpUtils.doGet(creationResponse.getRedirectUrl());

        String merchantOrderId = recurringRequest.getMerchantOrder().getId();

        RecurringResponse recurringResponse = fetchRecurring(merchantOrderId);
        assertNotNull(recurringResponse);

        RecurringResponseRecurringData recurringData = recurringResponse.getRecurringData();
        assertNotNull(recurringData);

        return recurringResponse;
    }

    private RecurringCreationRequest createRecurringRequest(String cardPan) {
        return new RecurringCreationRequest()
                .request(ApiClient.uuidRequest())
                .customer(new RecurringCustomer()
                        .id(text.randomString(15))
                        .email(generateEmail()))
                .merchantOrder(new PaymentRequestMerchantOrder()
                        .id(generateMerchantOrderId())
                        .description(text.sentence()))
                .paymentMethod(PAYMENT_METHOD_BANKCARD)
                .cardAccount(paymentRequestCardAccount(cardPan))
                .recurringData(new RecurringRequestRecurringData()
                        .currency(TERMINAL_CURRENCY)
                        .amount(BigDecimal.valueOf(producer.randomBetween(10, 300)))
                        .initiator("cit")
                        .preauth(true))
                .returnUrls(returnUrls());
    }

    private RecurringGatewayCreationResponse createRecurring(RecurringCreationRequest recurringRequest) throws IOException {
        try {
            Response<RecurringGatewayCreationResponse> response = recurrings.createRecurring(recurringRequest).execute();

            log.info("{}", response);

            return response.body();
        } catch (IOException e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }
}

package com.cardpay.sdk.uat.recurring.oneClick;

import com.cardpay.sdk.api.RecurringsApi;
import com.cardpay.sdk.client.ApiClient;
import com.cardpay.sdk.model.*;
import com.cardpay.sdk.utils.HttpUtils;
import io.codearte.jfairy.Fairy;
import io.codearte.jfairy.producer.BaseProducer;
import io.codearte.jfairy.producer.person.Person;
import io.codearte.jfairy.producer.text.TextProducer;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import static com.cardpay.sdk.Config.*;
import static com.cardpay.sdk.Constants.PAYMENT_METHOD_BANKCARD;
import static com.cardpay.sdk.Constants.CARD_NON3DS_CONFIRMED;
import static com.cardpay.sdk.model.PaymentUpdateTransactionData.StatusToEnum.REVERSE;
import static com.cardpay.sdk.model.RecurringPatchRequest.OperationEnum.CHANGE_STATUS;
import static com.cardpay.sdk.utils.DataUtils.*;
import static org.junit.Assert.*;

public class RecurringOneClickChangeStatusReverseUAT {

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
    public void changeOneClickStatusReverse() throws IOException {
        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        // Phase 1: create initial recurring
        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

        // prepare request data
        RecurringResponse recurringResponse = doOneClickPayment(CARD_NON3DS_CONFIRMED);

        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        // Phase 2: change One-click status (reverse)
        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

        // prepare update request data
        RecurringPatchRequest recurringPatchRequest = new RecurringPatchRequest()
                .request(ApiClient.uuidRequest())
                .operation(CHANGE_STATUS)
                .recurringData(new PaymentUpdateTransactionData().statusTo(REVERSE));

        // prepare request data to change one-click status (reverse)
        String recurringId = recurringResponse.getRecurringData().getId();

        // perform getting continue one-click recurring operation
        Response<RecurringUpdateResponse> result = recurrings
                .updateRecurring(recurringId, recurringPatchRequest)
                .execute();

        assertTrue(result.message(), result.isSuccessful());
        assertNotNull(result.body());

        // explore response result
        RecurringUpdateResponse data = result.body();
        log.info("{}", data);

        assertEquals(ResponseUpdatedTransactionData.StatusEnum.VOIDED, data.getRecurringData().getStatus());
    }

    private RecurringResponse fetchRecurring(String merchantOrderId) throws IOException {
        Call<RecurringsList> call = recurrings.getRecurrings(
                UUID.randomUUID().toString(),
                null,
                null,
                null,
                merchantOrderId,
                null,
                null,
                null,
                null
        );
        Response<RecurringsList> response = call.execute();
        assertTrue(response.message(), response.isSuccessful());

        RecurringsList body = response.body();
        assertNotNull(body);

        log.info("{}", body);

        List<RecurringResponse> data = body.getData();
        return data.size() > 0 ? data.get(0) : null;
    }

    private RecurringResponse doOneClickPayment(String cardPpan) throws IOException {
        RecurringCreationRequest recurringRequest = createRecurringRequest(cardPpan);

        log.info("{}", recurringRequest);

        RecurringCreationResponse creationResponse = createRecurring(recurringRequest);
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
                .cardAccount(new PaymentRequestCardAccount().card(new PaymentRequestCard()
                        .pan(cardPan)
                        .holder(person.getFullName().toUpperCase())
                        .securityCode("100")
                        .expiration(formatDate("MM/yyyy", generateCardExpiration()))))
                .recurringData(new RecurringRequestRecurringData()
                        .currency(TERMINAL_CURRENCY)
                        .amount(BigDecimal.valueOf(producer.randomBetween(10, 300)))
                        .initiator("cit")
                        .preauth(true))
                .returnUrls(new ReturnUrls()
                        .successUrl(SUCCESS_URL)
                        .declineUrl(DECLINE_URL)
                        .cancelUrl(CANCEL_URL)
                        .inprocessUrl(INPROCESS_URL)
                );
    }

    private RecurringCreationResponse createRecurring(RecurringCreationRequest recurringRequest) throws IOException {
        try {
            Response<RecurringCreationResponse> response = recurrings.createRecurring(recurringRequest).execute();

            log.info("{}", response);

            return response.body();
        } catch (IOException e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }
}
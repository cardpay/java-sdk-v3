package com.cardpay.sdk.recurring.scheduled;

import static com.cardpay.sdk.Config.CARDPAY_API_URL;
import static com.cardpay.sdk.Config.GATEWAY_PASSWORD;
import static com.cardpay.sdk.Config.GATEWAY_TERMINAL_CODE;
import static com.cardpay.sdk.Config.LOGGING_LEVEL;
import static com.cardpay.sdk.Config.TERMINAL_CURRENCY;
import static com.cardpay.sdk.Constants.CARD_NON3DS_CONFIRMED;
import static com.cardpay.sdk.Constants.PAYMENT_METHOD_BANKCARD;
import static com.cardpay.sdk.model.RecurringPlanRequestPlanData.PeriodEnum.WEEK;
import static com.cardpay.sdk.model.SubscriptionUpdateRequestSubscriptionData.StatusToEnum.INACTIVE;
import static com.cardpay.sdk.utils.AssertUtils.assertSuccessResponse;
import static com.cardpay.sdk.utils.DataUtils.generateEmail;
import static com.cardpay.sdk.utils.DataUtils.generateMerchantOrderId;
import static com.cardpay.sdk.utils.DataUtils.paymentRequestCardAccount;
import static com.cardpay.sdk.utils.DataUtils.returnUrls;
import static com.cardpay.sdk.utils.RecurringUtils.fetchRecurring;
import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import com.cardpay.sdk.api.RecurringsApi;
import com.cardpay.sdk.client.ApiClient;
import com.cardpay.sdk.model.PaymentRequestMerchantOrder;
import com.cardpay.sdk.model.Plan;
import com.cardpay.sdk.model.RecurringCreationRequest;
import com.cardpay.sdk.model.RecurringCreationResponse;
import com.cardpay.sdk.model.RecurringCustomer;
import com.cardpay.sdk.model.RecurringPlanRequest;
import com.cardpay.sdk.model.RecurringPlanRequestPlanData;
import com.cardpay.sdk.model.RecurringPlanResponse;
import com.cardpay.sdk.model.RecurringRequestRecurringData;
import com.cardpay.sdk.model.RecurringResponse;
import com.cardpay.sdk.model.SubscriptionUpdateRequest;
import com.cardpay.sdk.model.SubscriptionUpdateRequestSubscriptionData;
import com.cardpay.sdk.model.SubscriptionUpdateResponse;
import com.cardpay.sdk.model.UpdatedSubscriptionData;
import com.cardpay.sdk.utils.HttpUtils;
import io.codearte.jfairy.Fairy;
import io.codearte.jfairy.producer.BaseProducer;
import io.codearte.jfairy.producer.person.Person;
import io.codearte.jfairy.producer.text.TextProducer;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.concurrent.locks.LockSupport;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit2.Response;

public class RecurringCancelScheduledSubscriptionUAT {

    private final Logger log = LoggerFactory.getLogger(getClass());

    private Fairy fairy = Fairy.create();
    private BaseProducer producer = fairy.baseProducer();
    private Person person = fairy.person();
    private TextProducer text = fairy.textProducer();

    private RecurringsApi recurrings;

    @Before
    public void setUp() {
        recurrings = new ApiClient(CARDPAY_API_URL, GATEWAY_TERMINAL_CODE, GATEWAY_PASSWORD)
                .addLogging(LOGGING_LEVEL)
                .createService(RecurringsApi.class);
    }

    @Test
    public void cancelScheduledSubscription() throws IOException {
        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        // Phase 1: prepare a new plan
        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

        // prepare recurring plan request data
        RecurringPlanRequest recurringPlanRequest = createRecurringPlanRequest();

        // perform create plan
        Response<RecurringPlanResponse> recurringPlanResponse = recurrings
                .createPlan(recurringPlanRequest)
                .execute();

        assertSuccessResponse(recurringPlanResponse);

        RecurringPlanResponse body = recurringPlanResponse.body();
        assertNotNull(body);

        log.info("{}", body);

        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        // Phase 2: create scheduled subscription
        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

        assertNotNull(body.getPlanData());

        // get plan id
        String planId = body.getPlanData().getId();

        // prepare scheduled subscription request data
        RecurringCreationRequest recurringRequest = createRecurringRequest(planId);
        log.info("{}", recurringRequest);

        // perform create recurring operation
        Response<RecurringCreationResponse> response = recurrings.createRecurring(recurringRequest).execute();

        assertSuccessResponse(response);

        RecurringCreationResponse creationResponse = response.body();
        log.info("{}", creationResponse);

        assertNotNull(creationResponse);

        // get redirect url
        final String redirectUrl = creationResponse.getRedirectUrl();
        assertNotNull(redirectUrl);
        assertFalse(redirectUrl.isEmpty());

        // Emulate customer behaviour performing GET request to redirect url
        HttpUtils.doGet(creationResponse.getRedirectUrl());

        RecurringResponse recurringResponse = fetchRecurring(recurrings, recurringRequest.getMerchantOrder().getId());
        assertNotNull(recurringResponse);

        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        // Phase 3:  cancel scheduled subscription
        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

        LockSupport.parkNanos(MILLISECONDS.toNanos(1000));

        // get subscription id
        String subscriptionId = recurringResponse.getRecurringData().getSubscription().getId();

        // prepare subscription cancel request data
        SubscriptionUpdateRequest subscriptionUpdateRequest = new SubscriptionUpdateRequest()
                .request(ApiClient.uuidRequest())
                .operation(SubscriptionUpdateRequest.OperationEnum.CHANGE_STATUS)
                .subscriptionData(new SubscriptionUpdateRequestSubscriptionData()
                        .statusTo(INACTIVE));

        log.info("{}", subscriptionUpdateRequest);

        // perform cancel scheduled subscription
        Response<SubscriptionUpdateResponse> subscriptionUpdateResponse = recurrings
                .updateSubscription(subscriptionId, subscriptionUpdateRequest)
                .execute();

        assertSuccessResponse(subscriptionUpdateResponse);

        SubscriptionUpdateResponse data = subscriptionUpdateResponse.body();
        assertNotNull(data);
        log.info("{}", data);

        // explore response result
        assertTrue(data.getSubscriptionData().getIsExecuted());
        assertEquals(UpdatedSubscriptionData.StatusToEnum.INACTIVE, data.getSubscriptionData().getStatusTo());
    }

    private RecurringPlanRequest createRecurringPlanRequest() {
        return new RecurringPlanRequest()
                .request(ApiClient.uuidRequest())
                .planData(new RecurringPlanRequestPlanData()
                        .currency(TERMINAL_CURRENCY)
                        .amount(BigDecimal.valueOf(producer.randomBetween(10, 300)))
                        .interval(producer.randomBetween(1, 52))
                        .name(text.randomString(15))
                        .period(WEEK)
                );
    }

    private RecurringCreationRequest createRecurringRequest(String planId) {
        return new RecurringCreationRequest()
                .request(ApiClient.uuidRequest())
                .customer(new RecurringCustomer()
                        .id(text.randomString(15))
                        .email(generateEmail()))
                .merchantOrder(new PaymentRequestMerchantOrder()
                        .id(generateMerchantOrderId())
                        .description(text.sentence()))
                .paymentMethod(PAYMENT_METHOD_BANKCARD)
                .cardAccount(paymentRequestCardAccount(CARD_NON3DS_CONFIRMED))
                .recurringData(new RecurringRequestRecurringData()
                        .plan(new Plan().id(planId))
                        .initiator("cit"))
                .returnUrls(returnUrls());
    }
}
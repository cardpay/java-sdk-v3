package com.cardpay.sdk.recurring.scheduled.holdResume;

import com.cardpay.sdk.api.RecurringsApi;
import com.cardpay.sdk.client.ApiClient;
import com.cardpay.sdk.model.PaymentRequestMerchantOrder;
import com.cardpay.sdk.model.Plan;
import com.cardpay.sdk.model.RecurringCreationRequest;
import com.cardpay.sdk.model.RecurringCustomer;
import com.cardpay.sdk.model.RecurringGatewayCreationResponse;
import com.cardpay.sdk.model.RecurringPlanRequest;
import com.cardpay.sdk.model.RecurringPlanRequestPlanData;
import com.cardpay.sdk.model.RecurringPlanResponse;
import com.cardpay.sdk.model.RecurringRequestRecurringData;
import com.cardpay.sdk.model.RecurringResponse;
import com.cardpay.sdk.model.SubscriptionUpdateRequest;
import com.cardpay.sdk.model.SubscriptionUpdateRequestSubscriptionData;
import com.cardpay.sdk.model.SubscriptionUpdateResponse;
import com.cardpay.sdk.utils.HttpUtils;
import io.codearte.jfairy.Fairy;
import io.codearte.jfairy.producer.BaseProducer;
import io.codearte.jfairy.producer.person.Person;
import io.codearte.jfairy.producer.text.TextProducer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit2.Response;

import java.io.IOException;
import java.math.BigDecimal;

import static com.cardpay.sdk.Config.CARDPAY_API_URL;
import static com.cardpay.sdk.Config.GATEWAY_POSTPONED_PASSWORD;
import static com.cardpay.sdk.Config.GATEWAY_POSTPONED_TERMINAL_CODE;
import static com.cardpay.sdk.Config.LOGGING_LEVEL;
import static com.cardpay.sdk.Config.TERMINAL_CURRENCY;
import static com.cardpay.sdk.Constants.CARD_NON3DS_CONFIRMED;
import static com.cardpay.sdk.Constants.PAYMENT_METHOD_BANKCARD;
import static com.cardpay.sdk.model.RecurringPlanRequestPlanData.PeriodEnum.WEEK;
import static com.cardpay.sdk.model.SubscriptionUpdateRequest.OperationEnum.CHANGE_STATUS;
import static com.cardpay.sdk.utils.DataUtils.generateEmail;
import static com.cardpay.sdk.utils.DataUtils.generateMerchantOrderId;
import static com.cardpay.sdk.utils.DataUtils.paymentRequestCardAccount;
import static com.cardpay.sdk.utils.DataUtils.returnUrls;
import static com.cardpay.sdk.utils.RecurringUtils.doCancelSubscription;
import static com.cardpay.sdk.utils.RecurringUtils.fetchRecurring;
import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.locks.LockSupport.parkNanos;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class RecurringResumeUAT {

    private final Logger log = LoggerFactory.getLogger(getClass());

    private Fairy fairy = Fairy.create();
    private Person person = fairy.person();
    private TextProducer text = fairy.textProducer();

    private RecurringsApi recurrings;

    private String subscriptionId;

    @Before
    public void setUp() {
        recurrings = new ApiClient(CARDPAY_API_URL, GATEWAY_POSTPONED_TERMINAL_CODE, GATEWAY_POSTPONED_PASSWORD)
                .addLogging(LOGGING_LEVEL)
                .createService(RecurringsApi.class);
    }

    @After
    public void cleanUp() throws IOException {
        // cancel test subscription
        doCancelSubscription(recurrings, subscriptionId);
    }

    @Test
    public void resumeSubscription() throws IOException {
        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        // Phase 1:  prepare a new plan
        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

        //perform create a new plan
        Response<RecurringPlanResponse> recurringPlanResponse = recurrings
                .createPlan(createRecurringPlanRequest())
                .execute();
        log.info("{}", recurringPlanResponse);

        RecurringPlanResponse planResponse = recurringPlanResponse.body();
        assertNotNull(planResponse);
        log.info("{}", planResponse);

        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        // Phase 2:  create scheduled subscription
        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        final String planId = planResponse.getPlanData().getId();

        // prepare scheduled subscription request data
        RecurringCreationRequest recurringRequest = createRecurringRequest(planId);

        log.info("{}", recurringRequest);

        // perform create scheduled subscription
        Response<RecurringGatewayCreationResponse> recurringGatewayCreationResponse = recurrings
                .createRecurring(recurringRequest)
                .execute();
        log.info("{}", recurringGatewayCreationResponse);

        RecurringGatewayCreationResponse creationResponse = recurringGatewayCreationResponse.body();
        assertNotNull(creationResponse);
        log.info("{}", creationResponse);

        // get redirect url
        final String redirectUrlRecurring = creationResponse.getRedirectUrl();
        assertNotNull(redirectUrlRecurring);
        assertFalse(redirectUrlRecurring.isEmpty());

        // Emulate customer behaviour performing GET request to redirect url
        HttpUtils.doGet(creationResponse.getRedirectUrl());

        RecurringResponse recurringResponse = fetchRecurring(recurrings, recurringRequest.getMerchantOrder().getId());
        assertNotNull(recurringResponse);

        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        // Phase 3: Change status of Scheduled subscription to INACTIVE
        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

        parkNanos(MILLISECONDS.toNanos(10000));

        subscriptionId = recurringResponse.getRecurringData().getSubscription().getId();

        // prepare subscription update request data
        SubscriptionUpdateRequest subscriptionUpdateRequest = createSubscriptionUpdateRequest(SubscriptionUpdateRequestSubscriptionData.StatusToEnum.INACTIVE);
        log.info("{}", subscriptionUpdateRequest);

        // preform change status of Scheduled subscription to INACTIVE
        Response<SubscriptionUpdateResponse> response = recurrings
                .updateSubscription(subscriptionId, subscriptionUpdateRequest)
                .execute();

        log.info("{}", response.body());

        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        // Phase 4: Change status of Scheduled subscription to ACTIVE
        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

        // prepare subscription update request data
        SubscriptionUpdateRequest changeStatusRequest = new SubscriptionUpdateRequest()
                .request(ApiClient.uuidRequest())
                .operation(CHANGE_STATUS)
                .subscriptionData(new SubscriptionUpdateRequestSubscriptionData()
                        .statusTo(SubscriptionUpdateRequestSubscriptionData.StatusToEnum.ACTIVE)
                );

        log.info("{}", changeStatusRequest);

        // preform change status of Scheduled subscription to ACTIVE
        Response<SubscriptionUpdateResponse> result = recurrings
                .updateSubscription(subscriptionId, changeStatusRequest)
                .execute();

        log.info("{}", result.body());

        assertNotNull(result.body());
        assertTrue(result.body().getSubscriptionData().getIsExecuted());
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

    private RecurringPlanRequest createRecurringPlanRequest() {
        Fairy fairy = Fairy.create();
        BaseProducer producer = fairy.baseProducer();
        TextProducer text = fairy.textProducer();

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

    private SubscriptionUpdateRequest createSubscriptionUpdateRequest(SubscriptionUpdateRequestSubscriptionData.StatusToEnum status) {
        return new SubscriptionUpdateRequest()
                .request(ApiClient.uuidRequest())
                .operation(CHANGE_STATUS)
                .subscriptionData(new SubscriptionUpdateRequestSubscriptionData()
                        .statusTo(status)
                );
    }

}

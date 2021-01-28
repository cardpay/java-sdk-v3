package com.cardpay.sdk.payout;

import com.cardpay.sdk.api.PayoutsApi;
import com.cardpay.sdk.client.ApiClient;
import com.cardpay.sdk.model.PayoutRequest;
import com.cardpay.sdk.model.PayoutRequestCard;
import com.cardpay.sdk.model.PayoutRequestCardAccount;
import com.cardpay.sdk.model.PayoutRequestMerchantOrder;
import com.cardpay.sdk.model.PayoutRequestPayoutData;
import com.cardpay.sdk.model.PayoutResponse;
import com.cardpay.sdk.model.PayoutUpdateRequest;
import com.cardpay.sdk.model.PayoutUpdateResponse;
import com.cardpay.sdk.model.RequestUpdatedTransactionData;
import com.cardpay.sdk.model.ResponseUpdatedTransactionData;
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

import static com.cardpay.sdk.Config.CARDPAY_API_URL;
import static com.cardpay.sdk.Config.GATEWAY_POSTPONED_PASSWORD;
import static com.cardpay.sdk.Config.GATEWAY_POSTPONED_TERMINAL_CODE;
import static com.cardpay.sdk.Config.LOGGING_LEVEL;
import static com.cardpay.sdk.Config.TERMINAL_CURRENCY;
import static com.cardpay.sdk.Constants.CARD_NON3DS_CONFIRMED;
import static com.cardpay.sdk.Constants.PAYMENT_METHOD_BANKCARD;
import static com.cardpay.sdk.client.StringUtil.formatExpirationDate;
import static com.cardpay.sdk.model.RequestUpdatedTransactionData.StatusToEnum.REVERSE;
import static com.cardpay.sdk.utils.DataUtils.generateCardExpiration;
import static com.cardpay.sdk.utils.DataUtils.generateMerchantOrderId;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class PayoutChangeStatusUAT {

    private final Logger log = LoggerFactory.getLogger(getClass());

    private Fairy fairy = Fairy.create();
    private Person person = fairy.person();
    private BaseProducer producer = fairy.baseProducer();
    private TextProducer text = fairy.textProducer();

    private PayoutsApi payouts;

    @Before
    public void setup() {
        payouts = new ApiClient(CARDPAY_API_URL, GATEWAY_POSTPONED_TERMINAL_CODE, GATEWAY_POSTPONED_PASSWORD)
                .addLogging(LOGGING_LEVEL)
                .createService(PayoutsApi.class);
    }

    @Test
    public void changePayoutStatus() throws IOException {
        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        // Phase 1: create payout
        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

        // perform payout
        String payoutId = createPayout();

        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        // Phase 2: update status to COMPLETE for exists payout
        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

        // prepare update request data
        final PayoutUpdateRequest payoutUpdateRequest = new PayoutUpdateRequest()
                .request(ApiClient.uuidRequest())
                .payoutData(new RequestUpdatedTransactionData().statusTo(REVERSE));

        log.info("{}", payoutUpdateRequest);

        // perform api call
        Response<PayoutUpdateResponse> response = payouts
                .updatePayout(payoutId, payoutUpdateRequest)
                .execute();

        log.info("{}", response);

        assertTrue(response.message(), response.isSuccessful());
        assertNotNull(response.body());

        // explore response result
        PayoutUpdateResponse data = response.body();

        log.info("{}", data);
        assertEquals(ResponseUpdatedTransactionData.StatusToEnum.REVERSE, data.getPayoutData().getStatusTo());
        assertEquals(ResponseUpdatedTransactionData.StatusEnum.VOIDED, data.getPayoutData().getStatus());
    }

    private String createPayout() throws IOException {
        PayoutRequest payoutRequest = new PayoutRequest()
                .request(ApiClient.uuidRequest())
                .merchantOrder(new PayoutRequestMerchantOrder()
                        .id(generateMerchantOrderId())
                        .description(text.sentence()))
                .paymentMethod(PAYMENT_METHOD_BANKCARD)
                .payoutData(new PayoutRequestPayoutData()
                        .currency(TERMINAL_CURRENCY)
                        .amount(BigDecimal.valueOf(producer.randomBetween(10, 300)))
                        .note(text.sentence()))
                .cardAccount(new PayoutRequestCardAccount()
                        .recipientInfo(person.getFullName().toUpperCase())
                        .card(new PayoutRequestCard()
                                .pan(CARD_NON3DS_CONFIRMED)
                                .expiration(formatExpirationDate(generateCardExpiration())))
                );

        log.info("{}", payoutRequest);

        Response<PayoutResponse> response = payouts.createPayout(payoutRequest).execute();
        log.info("{}", response);

        PayoutResponse creationResponse = response.body();
        assertNotNull(creationResponse);

        return creationResponse.getPayoutData().getId();
    }

}
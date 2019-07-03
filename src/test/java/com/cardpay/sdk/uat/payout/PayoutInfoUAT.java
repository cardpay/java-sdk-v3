package com.cardpay.sdk.uat.payout;

import com.cardpay.sdk.api.PayoutsApi;
import com.cardpay.sdk.client.ApiClient;
import com.cardpay.sdk.model.*;
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

import static com.cardpay.sdk.Config.*;
import static com.cardpay.sdk.Constants.PAYMENT_METHOD_BANKCARD;
import static com.cardpay.sdk.Constants.CARD_NON3DS_CONFIRMED;
import static com.cardpay.sdk.utils.DataUtils.*;
import static java.time.OffsetDateTime.now;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertNotNull;

public class PayoutInfoUAT {

    private final Logger log = LoggerFactory.getLogger(getClass());
    private PayoutsApi payouts;

    private Fairy fairy = Fairy.create();
    private Person person = fairy.person();
    private BaseProducer producer = fairy.baseProducer();
    private TextProducer text = fairy.textProducer();

    @Before
    public void setup() {
        payouts = new ApiClient(CARDPAY_API_URL, GATEWAY_TERMINAL_CODE, GATEWAY_PASSWORD)
                .addLogging(LOGGING_LEVEL)
                .createService(PayoutsApi.class);
    }

    @Test
    public void getPayoutInformation() throws IOException {
        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        // Phase 1: create payout
        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

        // perform payout
        String payoutId = createPayout();

        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        // Phase 2: get payout information
        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

        // perform getting payout information
        Response<PayoutResponse> response = payouts
                .getPayout(payoutId)
                .execute();

        log.info("{}", response);

        assertTrue(response.message(), response.isSuccessful());
        assertNotNull(response.body());

        // explore response result
        PayoutResponsePayoutData data = response.body().getPayoutData();
        log.info("{} {}: {} {}", data.getCreated(), data.getId(),
                String.format("%-6.2f %s", data.getAmount(), data.getCurrency()),
                data.getStatus()
        );
    }

    private String createPayout() throws IOException {
        PayoutRequest payoutRequest = createPayoutRequest(CARD_NON3DS_CONFIRMED);

        log.info("{}", payoutRequest);

        PayoutResponse creationResponse;

        try {
            Response<PayoutResponse> response = payouts.createPayout(payoutRequest).execute();

            log.info("{}", response);

            creationResponse = response.body();
        } catch (IOException e) {
            log.error(e.getMessage(), e);
            throw e;
        }

        assertNotNull(creationResponse);

        return creationResponse.getPayoutData().getId();
    }

    private PayoutRequest createPayoutRequest(String cardPan) {
        return new PayoutRequest()
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
                                        .pan(cardPan)
                                        .expiration(formatDate("MM/yyyy", generateCardExpiration())))

                );
    }
}
package com.cardpay.sdk.payout;

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
import static com.cardpay.sdk.client.StringUtil.formatExpirationDate;
import static com.cardpay.sdk.utils.DataUtils.*;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class PayoutCreateUAT {

    private final Logger log = LoggerFactory.getLogger(getClass());

    private Fairy fairy = Fairy.create();
    private BaseProducer producer = fairy.baseProducer();
    private Person person = fairy.person();
    private TextProducer text = fairy.textProducer();

    private PayoutsApi payouts;

    @Before
    public void setup() {
        payouts = new ApiClient(CARDPAY_API_URL, GATEWAY_TERMINAL_CODE, GATEWAY_PASSWORD)
                .addLogging(LOGGING_LEVEL)
                .createService(PayoutsApi.class);
    }

    @Test
    public void createPayout() throws IOException {
        // merchant order data
        String merchantOrderId = generateMerchantOrderId();
        String merchantDescription = text.sentence();
        BigDecimal amount = BigDecimal.valueOf(producer.randomBetween(10, 300));
        String currency = TERMINAL_CURRENCY;
        String note = text.sentence();

        // card data
        String cardPan = CARD_NON3DS_CONFIRMED;
        String cardHolder = person.getFullName().toUpperCase();
        String cardExpiration = formatExpirationDate(generateCardExpiration());

        // prepare request data
        PayoutRequest payoutRequest = new PayoutRequest()
                .request(ApiClient.uuidRequest())
                .merchantOrder(new PayoutRequestMerchantOrder()
                        .id(merchantOrderId)
                        .description(merchantDescription))
                .paymentMethod(PAYMENT_METHOD_BANKCARD)
                .payoutData(new PayoutRequestPayoutData()
                        .currency(currency)
                        .amount(amount)
                        .note(note))
                .cardAccount(new PayoutRequestCardAccount()
                        .recipientInfo(cardHolder)
                        .card(new PayoutRequestCard()
                                .pan(cardPan)
                                .expiration(cardExpiration))
                );

        log.info("{}", payoutRequest);

        // perform create payment
        Response<PayoutResponse> response = payouts
                .createPayout(payoutRequest)
                .execute();

        log.info("{}", response);

        assertTrue(response.message(), response.isSuccessful());

        // explore response result
        PayoutResponse data = response.body();

        log.info("{}", data);

        assertNotNull(data);
        assertEquals(PayoutResponsePayoutData.StatusEnum.COMPLETED, data.getPayoutData().getStatus());
    }
}
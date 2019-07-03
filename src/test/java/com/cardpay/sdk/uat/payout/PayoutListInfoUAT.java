package com.cardpay.sdk.uat.payout;

import com.cardpay.sdk.api.PayoutsApi;
import com.cardpay.sdk.client.ApiClient;
import com.cardpay.sdk.model.*;
import io.codearte.jfairy.Fairy;
import io.codearte.jfairy.producer.BaseProducer;
import io.codearte.jfairy.producer.person.Person;
import io.codearte.jfairy.producer.text.TextProducer;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit2.Response;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

import static com.cardpay.sdk.Config.*;
import static com.cardpay.sdk.Constants.CARD_NON3DS_CONFIRMED;
import static com.cardpay.sdk.Constants.PAYMENT_METHOD_BANKCARD;
import static com.cardpay.sdk.utils.DataUtils.*;
import static java.lang.String.valueOf;
import static java.lang.System.currentTimeMillis;
import static java.util.stream.Collectors.toSet;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertNotNull;

public class PayoutListInfoUAT {

    private final Logger log = LoggerFactory.getLogger(getClass());

    private Fairy fairy = Fairy.create();
    private Person person = fairy.person();
    private BaseProducer producer = fairy.baseProducer();
    private TextProducer text = fairy.textProducer();

    private PayoutsApi payouts;

    @Before
    public void setup() {
        payouts = new ApiClient(CARDPAY_API_URL, GATEWAY_TERMINAL_CODE, GATEWAY_PASSWORD)
                .addLogging(LOGGING_LEVEL)
                .createService(PayoutsApi.class);
    }

    @Test
    public void getPayoutsListInformation() throws IOException {
        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        // Generate payouts
        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        Set<String> ids = IntStream.range(0, 3)
                .parallel()
                .mapToObj(index -> createPayout())
                .filter(StringUtils::isNotEmpty)
                .collect(toSet());
        log.info("ids: {}", ids);

        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        // Fetch payouts
        // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

        // prepare request data
        String currency = TERMINAL_CURRENCY;
        OffsetDateTime endTime = null;
        Integer maxCount = 50;
        String merchantOrderId = null;
        String paymentMethod = null;
        String sortOrder = null;
        OffsetDateTime startTime = null;

        // perform getting payouts list information
        Response<PayoutsList> result = payouts.getPayouts(
                valueOf(currentTimeMillis()),
                currency,
                endTime,
                maxCount,
                merchantOrderId,
                paymentMethod,
                sortOrder,
                startTime
        ).execute();

        assertTrue(result.message(), result.isSuccessful());
        assertNotNull(result.body());

        // explore response result
        List<PayoutResponse> payouts = result.body().getData();

        log.info("Count: {}", payouts.size());

        for (PayoutResponse payout : payouts) {
            PayoutResponsePayoutData data = payout.getPayoutData();
            log.info("{} {}: {} {}", data.getCreated(), data.getId(),
                    String.format("%-6.2f %s", data.getAmount(), data.getCurrency()),
                    data.getStatus()
            );
        }

        Set<String> fetchedIds = payouts.stream().map(p -> p.getPayoutData().getId()).collect(toSet());
        Assert.assertTrue(fetchedIds.containsAll(ids));
    }

    private String createPayout() {
        PayoutResponse creationResponse = null;
        try {
            Response<PayoutResponse> response = payouts
                    .createPayout(createPayoutRequest(CARD_NON3DS_CONFIRMED))
                    .execute();
            log.info("{}", response);

            creationResponse = response.body();
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }

        return creationResponse != null ? creationResponse.getPayoutData().getId() : "";
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
                        .amount(BigDecimal.valueOf(producer.randomBetween(1, 10)))
                        .note(text.sentence()))
                .cardAccount(new PayoutRequestCardAccount()
                        .recipientInfo(person.getFullName().toUpperCase())
                        .card(new PayoutRequestCard()
                                .pan(cardPan)
                                .expiration(formatDate("MM/yyyy", generateCardExpiration())))

                );
    }
}
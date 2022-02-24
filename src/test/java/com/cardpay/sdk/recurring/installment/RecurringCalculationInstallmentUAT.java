package com.cardpay.sdk.recurring.installment;

import com.cardpay.sdk.api.RecurringsInstallmentsApi;
import com.cardpay.sdk.client.ApiClient;
import com.cardpay.sdk.model.ScheduleOptionsResponse;
import io.codearte.jfairy.Fairy;
import io.codearte.jfairy.producer.BaseProducer;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit2.Response;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.UUID;

import static com.cardpay.sdk.Config.CARDPAY_API_URL;
import static com.cardpay.sdk.Config.GATEWAY_PASSWORD;
import static com.cardpay.sdk.Config.GATEWAY_TERMINAL_CODE;
import static com.cardpay.sdk.Config.LOGGING_LEVEL;
import static com.cardpay.sdk.Config.TERMINAL_CURRENCY;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class RecurringCalculationInstallmentUAT {

    private final Logger log = LoggerFactory.getLogger(getClass());

    private Fairy fairy = Fairy.create();
    private BaseProducer producer = fairy.baseProducer();

    private RecurringsInstallmentsApi recurringsInstallments;

    @Before
    public void setUp() {
        recurringsInstallments = new ApiClient(CARDPAY_API_URL, GATEWAY_TERMINAL_CODE, GATEWAY_PASSWORD)
                .addLogging(LOGGING_LEVEL)
                .createService(RecurringsInstallmentsApi.class);
    }

    @Test
    public void getPaymentSchedule() throws IOException {
        // prepare request data
        String requestId = UUID.randomUUID().toString();
        BigDecimal amount = BigDecimal.valueOf(producer.randomBetween(1000, 5000));
        String currency = TERMINAL_CURRENCY;

        // perform get calculation of installments options
        Response<ScheduleOptionsResponse> response = recurringsInstallments
                .calculateSchedule(currency, requestId, amount)
                .execute();

        log.info("{}", response);
        assertTrue(response.message(), response.isSuccessful());

        // explore response result
        ScheduleOptionsResponse data = response.body();
        assertNotNull(data);
        log.info("{}", data);
    }
}

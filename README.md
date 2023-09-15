# Unlimit API v3 Java SDK

You can sign up for a Unlimit account at https://www.unlimit.com

## Getting Started

Please follow the [installation](#installation) instruction and take a look at [usage examples](src/test/java/com/cardpay/sdk).


## Requirements

Building the API client library requires:
1. Java 1.8+
2. Maven

### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
  <groupId>com.cardpay</groupId>
  <artifactId>java-sdk</artifactId>
  <version>3.56.20</version>
  <scope>compile</scope>
</dependency>
```

### Gradle users

Add this dependency to your project's build file:

```groovy
compile "com.cardpay:java-sdk:3.56.20"
```

Example for Auth
```java
import com.cardpay.sdk.api.AuthApi;
import com.cardpay.sdk.client.ApiClient;
import com.cardpay.sdk.model.ApiTokens;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Response;

import java.io.IOException;

public class AuthServiceExample {

    public static final String CARDPAY_API_URL = System.getProperty("CARDPAY_API_URL", "https://sandbox.cardpay.com");
    public static final String GATEWAY_TERMINAL_CODE = System.getProperty("GATEWAY_TERMINAL_CODE", "00000");
    public static final String GATEWAY_PASSWORD = System.getProperty("GATEWAY_PASSWORD", "password");
    public static final HttpLoggingInterceptor.Level LOGGING_LEVEL =
            HttpLoggingInterceptor.Level.valueOf(System.getProperty("LOGGING_LEVEL", HttpLoggingInterceptor.Level.NONE.name()));

    public ApiTokens createAuthToken() throws IOException {
        //get AuthApi
        AuthApi authApi = new ApiClient(CARDPAY_API_URL, GATEWAY_TERMINAL_CODE, GATEWAY_PASSWORD)
                .addLogging(LOGGING_LEVEL)
                .createService(AuthApi .class);

        //get tokens from api
        Response<ApiTokens> response = authApi
                .obtainTokens("password", GATEWAY_PASSWORD, "", GATEWAY_TERMINAL_CODE)
                .execute();

        assert response.isSuccessful();
        assert response.body() != null;

        return response.body();
    }

}
```
Example for payment

```java
import com.cardpay.sdk.api.PaymentsApi;
import com.cardpay.sdk.client.ApiClient;
import com.cardpay.sdk.model.BillingAddress;
import com.cardpay.sdk.model.PaymentGatewayCreationResponse;
import com.cardpay.sdk.model.PaymentRequest;
import com.cardpay.sdk.model.PaymentRequestCard;
import com.cardpay.sdk.model.PaymentRequestCardAccount;
import com.cardpay.sdk.model.PaymentRequestCustomer;
import com.cardpay.sdk.model.PaymentRequestMerchantOrder;
import com.cardpay.sdk.model.PaymentRequestPaymentData;
import com.cardpay.sdk.model.PaymentResponse;
import com.cardpay.sdk.model.PaymentResponsePaymentData;
import com.cardpay.sdk.model.ReturnUrls;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Response;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Objects;

import static com.cardpay.sdk.model.PaymentResponsePaymentData.StatusEnum.COMPLETED;

public class PaymentServiceExample {

    public static final String CARDPAY_API_URL = System.getProperty("CARDPAY_API_URL", "https://sandbox.cardpay.com");
    public static final String GATEWAY_TERMINAL_CODE = System.getProperty("GATEWAY_TERMINAL_CODE", "00000");
    public static final String GATEWAY_PASSWORD = System.getProperty("GATEWAY_PASSWORD", "password");
    public static final HttpLoggingInterceptor.Level LOGGING_LEVEL =
            HttpLoggingInterceptor.Level.valueOf(System.getProperty("LOGGING_LEVEL", HttpLoggingInterceptor.Level.NONE.name()));

    private final PaymentsApi paymentsApi;

    public PaymentServiceExample() {
        this.paymentsApi = new ApiClient(CARDPAY_API_URL, GATEWAY_TERMINAL_CODE, GATEWAY_PASSWORD)
                .addLogging(LOGGING_LEVEL)
                .createService(PaymentsApi.class);
    }

    public void createPayment() throws IOException {

        // merchant order data
        String merchantOrderId = "merchant order id";
        String merchantDescription = "merchant description";
        BigDecimal amount = BigDecimal.valueOf(0);
        String currency = "currency";
        String note = "note";

        // card data
        String cardPan = "card pan";
        String cardHolder = "cardholder in Upper Case";
        String securityCode = "100";
        String cardExpiration = "expiration date";

        // customer data
        String customerId = "000";
        String customerFullname = "full name";
        String customerBirthdate = "birth date";
        String customerEmail = "e-mail";
        String customerPhoneNumber = "+###########";
        String customerLocale = "en";

        // prepare request data
        PaymentRequest paymentRequest = new PaymentRequest()
                .request(ApiClient.uuidRequest())
                .merchantOrder(new PaymentRequestMerchantOrder()
                        .id(merchantOrderId)
                        .description(merchantDescription))
                .paymentMethod("BANKCARD")
                .paymentData(new PaymentRequestPaymentData()
                        .currency(currency)
                        .amount(amount)
                        .note(note)
                        .transType(PaymentRequestPaymentData.TransTypeEnum._01))
                .cardAccount(new PaymentRequestCardAccount()
                        .card(new PaymentRequestCard()
                                .pan(cardPan)
                                .holder(cardHolder)
                                .securityCode(securityCode)
                                .expiration(cardExpiration)
                                .acctType(PaymentRequestCard.AcctTypeEnum._03))
                        .billingAddress(new BillingAddress()
                                .country("USA")
                                .state("NY")
                                .zip("10001")
                                .city("New York")
                                .addrLine1("address1")
                                .addrLine2("address2"))
                )
                .customer(new PaymentRequestCustomer()
                        .id(customerId)
                        .fullName(customerFullname)
                        .birthDate(customerBirthdate)
                        .email(customerEmail)
                        .phone(customerPhoneNumber)
                        .workPhone(customerPhoneNumber)
                        .homePhone(customerPhoneNumber)
                        .locale(customerLocale))
                .returnUrls(new ReturnUrls());

        // perform api call
        Response<PaymentGatewayCreationResponse> response = paymentsApi
                .createPayment(paymentRequest)
                .execute();

        assert response.isSuccessful();

        PaymentGatewayCreationResponse creationResponse = response.body();
        assert creationResponse != null;


        // explore response result
        PaymentResponsePaymentData paymentData = getPaymentByPaymentId(creationResponse.getPaymentData().getId());

        assert paymentData != null;
        assert paymentData.getStatus() == COMPLETED;
    }

    private PaymentResponsePaymentData getPaymentByPaymentId(String paymentId) throws IOException {
        Response<PaymentResponse> response = paymentsApi.getPayment(paymentId).execute();
        assert response.isSuccessful();

        PaymentResponse body = response.body();
        assert body != null;

        assert Objects.equals(body.getPaymentData().getId(), paymentId);
        return body.getPaymentData();
    }

}
```


## Proxy usage

The SDK will automatically use a proxy if the `HTTPS_PROXY` or `HTTP_PROXY` environment variable is set.

If the `NO_PROXY` env variable is set, the SDK won't use the proxy for hosts from this variable. The format of
`NO_PROXY`: comma separated domain names (e.g. "cardpay.com,.example.com").

# PaymentsApi

All URIs are relative to *https://sandbox.cardpay.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createPayment**](PaymentsApi.md#createPayment) | **POST** api/payments | Create payment
[**getPayment**](PaymentsApi.md#getPayment) | **GET** api/payments/{paymentId} | Get payment information
[**getPayments**](PaymentsApi.md#getPayments) | **GET** api/payments | Get payments information
[**updatePayment**](PaymentsApi.md#updatePayment) | **PATCH** api/payments/{paymentId} | Update payment


<a name="createPayment"></a>
# **createPayment**
> PaymentCreationResponse createPayment(paymentRequest)

Create payment

Endpoint for creation payments. Request example presented for Gateway mode.

### Example
```java
// Import classes:
//import com.cardpay.sdk.client.ApiClient;
//import com.cardpay.sdk.client.ApiException;
//import com.cardpay.sdk.client.Configuration;
//import com.cardpay.sdk.client.auth.*;
//import com.cardpay.sdk.api.PaymentsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

PaymentsApi apiInstance = new PaymentsApi();
PaymentRequest paymentRequest = new PaymentRequest(); // PaymentRequest | paymentRequest
try {
    PaymentCreationResponse result = apiInstance.createPayment(paymentRequest);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PaymentsApi#createPayment");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **paymentRequest** | [**PaymentRequest**](PaymentRequest.md)| paymentRequest |

### Return type

[**PaymentCreationResponse**](PaymentCreationResponse.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getPayment"></a>
# **getPayment**
> PaymentResponse getPayment(paymentId)

Get payment information

### Example
```java
// Import classes:
//import com.cardpay.sdk.client.ApiClient;
//import com.cardpay.sdk.client.ApiException;
//import com.cardpay.sdk.client.Configuration;
//import com.cardpay.sdk.client.auth.*;
//import com.cardpay.sdk.api.PaymentsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

PaymentsApi apiInstance = new PaymentsApi();
String paymentId = "paymentId_example"; // String | Payment ID
try {
    PaymentResponse result = apiInstance.getPayment(paymentId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PaymentsApi#getPayment");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **paymentId** | **String**| Payment ID |

### Return type

[**PaymentResponse**](PaymentResponse.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getPayments"></a>
# **getPayments**
> PaymentsList getPayments(requestId, currency, endTime, maxCount, merchantOrderId, paymentMethod, sortOrder, startTime)

Get payments information

### Example
```java
// Import classes:
//import com.cardpay.sdk.client.ApiClient;
//import com.cardpay.sdk.client.ApiException;
//import com.cardpay.sdk.client.Configuration;
//import com.cardpay.sdk.client.auth.*;
//import com.cardpay.sdk.api.PaymentsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

PaymentsApi apiInstance = new PaymentsApi();
String requestId = "\"2253145\""; // String | Request ID
String currency = "\"USD\""; // String | [ISO 4217](https://en.wikipedia.org/wiki/ISO_4217) currency code of transactions currency
OffsetDateTime endTime = new OffsetDateTime(); // OffsetDateTime | Date and time up to milliseconds (in [ISO 8601](https://en.wikipedia.org/wiki/ISO_8601) format) when requested period ends (not inclusive), UTC time, must be less than 7 days after 'start_time', default is current time (format: yyyy-MM-dd'T'HH:mm:ss'Z')
Integer maxCount = 10; // Integer | Limit number of returned transactions (must be less than 10000, default is 1000)
String merchantOrderId = "\"order00017\""; // String | Merchant order number from the merchant system
String paymentMethod = "\"BANKCARD\""; // String | Used payment method type name from payment methods list
String sortOrder = "\"asc\""; // String | Sort based on order of results. `asc` for ascending order or `desc` for descending order (default value)
OffsetDateTime startTime = new OffsetDateTime(); // OffsetDateTime | Date and time up to milliseconds (in [ISO 8601](https://en.wikipedia.org/wiki/ISO_8601) format) when requested period starts (inclusive), UTC time, default is 24 hours before 'end_time' (format: yyyy-MM-dd'T'HH:mm:ss'Z')
try {
    PaymentsList result = apiInstance.getPayments(requestId, currency, endTime, maxCount, merchantOrderId, paymentMethod, sortOrder, startTime);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PaymentsApi#getPayments");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **requestId** | **String**| Request ID |
 **currency** | **String**| [ISO 4217](https://en.wikipedia.org/wiki/ISO_4217) currency code of transactions currency | [optional]
 **endTime** | **OffsetDateTime**| Date and time up to milliseconds (in [ISO 8601](https://en.wikipedia.org/wiki/ISO_8601) format) when requested period ends (not inclusive), UTC time, must be less than 7 days after &#39;start_time&#39;, default is current time (format: yyyy-MM-dd&#39;T&#39;HH:mm:ss&#39;Z&#39;) | [optional]
 **maxCount** | **Integer**| Limit number of returned transactions (must be less than 10000, default is 1000) | [optional]
 **merchantOrderId** | **String**| Merchant order number from the merchant system | [optional]
 **paymentMethod** | **String**| Used payment method type name from payment methods list | [optional]
 **sortOrder** | **String**| Sort based on order of results. &#x60;asc&#x60; for ascending order or &#x60;desc&#x60; for descending order (default value) | [optional] [enum: asc, desc]
 **startTime** | **OffsetDateTime**| Date and time up to milliseconds (in [ISO 8601](https://en.wikipedia.org/wiki/ISO_8601) format) when requested period starts (inclusive), UTC time, default is 24 hours before &#39;end_time&#39; (format: yyyy-MM-dd&#39;T&#39;HH:mm:ss&#39;Z&#39;) | [optional]

### Return type

[**PaymentsList**](PaymentsList.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="updatePayment"></a>
# **updatePayment**
> PaymentUpdateResponse updatePayment(paymentId, paymentPatchRequest)

Update payment

### Example
```java
// Import classes:
//import com.cardpay.sdk.client.ApiClient;
//import com.cardpay.sdk.client.ApiException;
//import com.cardpay.sdk.client.Configuration;
//import com.cardpay.sdk.client.auth.*;
//import com.cardpay.sdk.api.PaymentsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

PaymentsApi apiInstance = new PaymentsApi();
String paymentId = "paymentId_example"; // String | Payment ID
PaymentPatchRequest paymentPatchRequest = new PaymentPatchRequest(); // PaymentPatchRequest | paymentPatchRequest
try {
    PaymentUpdateResponse result = apiInstance.updatePayment(paymentId, paymentPatchRequest);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PaymentsApi#updatePayment");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **paymentId** | **String**| Payment ID |
 **paymentPatchRequest** | [**PaymentPatchRequest**](PaymentPatchRequest.md)| paymentPatchRequest |

### Return type

[**PaymentUpdateResponse**](PaymentUpdateResponse.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


# PaymentsApi

All URIs are relative to *https://sandbox.cardpay.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createPayment**](PaymentsApi.md#createPayment) | **POST** api/payments | Create payment
[**getAuthenticationData1**](PaymentsApi.md#getAuthenticationData1) | **GET** api/payments/{paymentId}/threedsecure | Get payment 3DS result information
[**getDispute**](PaymentsApi.md#getDispute) | **GET** api/disputes/{paymentId} | Get a list of disputes by payment id
[**getDisputes**](PaymentsApi.md#getDisputes) | **GET** api/disputes | Get a list of disputes
[**getPayment**](PaymentsApi.md#getPayment) | **GET** api/payments/{paymentId} | Get payment information
[**getPaymentMethods**](PaymentsApi.md#getPaymentMethods) | **GET** api/payment_methods | Get payment methods
[**getPayments**](PaymentsApi.md#getPayments) | **GET** api/payments | Get payments information
[**updatePayment**](PaymentsApi.md#updatePayment) | **PATCH** api/payments/{paymentId} | Update payment


<a name="createPayment"></a>
# **createPayment**
> PaymentGatewayCreationResponse createPayment(paymentRequest)

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
    PaymentGatewayCreationResponse result = apiInstance.createPayment(paymentRequest);
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

[**PaymentGatewayCreationResponse**](PaymentGatewayCreationResponse.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getAuthenticationData1"></a>
# **getAuthenticationData1**
> AuthenticationDataResponse getAuthenticationData1(paymentId)

Get payment 3DS result information

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
    AuthenticationDataResponse result = apiInstance.getAuthenticationData1(paymentId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PaymentsApi#getAuthenticationData1");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **paymentId** | **String**| Payment ID |

### Return type

[**AuthenticationDataResponse**](AuthenticationDataResponse.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getDispute"></a>
# **getDispute**
> DisputeList getDispute(paymentId)

Get a list of disputes by payment id

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
String paymentId = "paymentId_example"; // String | Payment ID (or refund ID, or recurring ID)
try {
    DisputeList result = apiInstance.getDispute(paymentId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PaymentsApi#getDispute");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **paymentId** | **String**| Payment ID (or refund ID, or recurring ID) |

### Return type

[**DisputeList**](DisputeList.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getDisputes"></a>
# **getDisputes**
> DisputeList getDisputes(requestId, type, maxCount, offset, regEndTime, regStartTime, sortOrder)

Get a list of disputes

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
String requestId = "5467653"; // String | Request ID
String type = "CB"; // String | Defines dispute entity type: `CB` - for chargebacks `RR` - for retrieval requests `FR` - for fraud reports
Integer maxCount = 10; // Integer | Limit number of returned dispute entities Must be less or equal to 1000, default is 100, minimal value is 1
Integer offset = 10; // Integer | Starting position (offset) in the list of dispute entities. Must be less or equal to 10000, default is 0, minimal value is 0
OffsetDateTime regEndTime = OffsetDateTime.now(); // OffsetDateTime | Dispute registration date & time up to milliseconds (in [ISO 8601](https://en.wikipedia.org/wiki/ISO_8601) format) when requested period ends (inclusive); the default is current time UTC (format - yyyy-MM-dd'T'HH:mm:ss.SSS'Z') Must be less than 10 days after reg_start_time
OffsetDateTime regStartTime = OffsetDateTime.now(); // OffsetDateTime | Dispute registration date & time up to milliseconds (in [ISO 8601](https://en.wikipedia.org/wiki/ISO_8601) format) when requested period starts (inclusive); the default is 24 hours before reg_end_time UTC (format - yyyy-MM-dd'T'HH:mm:ss.SSS'Z') (in UTC format)
String sortOrder = "asc"; // String | Sort based on order of results. `asc` for ascending order or `desc` for descending order (default value) by dispute registration date
try {
    DisputeList result = apiInstance.getDisputes(requestId, type, maxCount, offset, regEndTime, regStartTime, sortOrder);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PaymentsApi#getDisputes");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **requestId** | **String**| Request ID |
 **type** | **String**| Defines dispute entity type: &#x60;CB&#x60; - for chargebacks &#x60;RR&#x60; - for retrieval requests &#x60;FR&#x60; - for fraud reports |
 **maxCount** | **Integer**| Limit number of returned dispute entities Must be less or equal to 1000, default is 100, minimal value is 1 | [optional]
 **offset** | **Integer**| Starting position (offset) in the list of dispute entities. Must be less or equal to 10000, default is 0, minimal value is 0 | [optional]
 **regEndTime** | **OffsetDateTime**| Dispute registration date &amp; time up to milliseconds (in [ISO 8601](https://en.wikipedia.org/wiki/ISO_8601) format) when requested period ends (inclusive); the default is current time UTC (format - yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSS&#39;Z&#39;) Must be less than 10 days after reg_start_time | [optional]
 **regStartTime** | **OffsetDateTime**| Dispute registration date &amp; time up to milliseconds (in [ISO 8601](https://en.wikipedia.org/wiki/ISO_8601) format) when requested period starts (inclusive); the default is 24 hours before reg_end_time UTC (format - yyyy-MM-dd&#39;T&#39;HH:mm:ss.SSS&#39;Z&#39;) (in UTC format) | [optional]
 **sortOrder** | **String**| Sort based on order of results. &#x60;asc&#x60; for ascending order or &#x60;desc&#x60; for descending order (default value) by dispute registration date | [optional] [enum: asc, desc]

### Return type

[**DisputeList**](DisputeList.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
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

<a name="getPaymentMethods"></a>
# **getPaymentMethods**
> PaymentMethodsList getPaymentMethods()

Get payment methods

Endpoint for get payment methods by current terminal code

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
try {
    PaymentMethodsList result = apiInstance.getPaymentMethods();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PaymentsApi#getPaymentMethods");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**PaymentMethodsList**](PaymentMethodsList.md)

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
String requestId = "2253145"; // String | Request ID
String currency = "USD"; // String | [ISO 4217](https://en.wikipedia.org/wiki/ISO_4217) currency code of transactions currency
OffsetDateTime endTime = OffsetDateTime.now(); // OffsetDateTime | Date and time up to milliseconds (in [ISO 8601](https://en.wikipedia.org/wiki/ISO_8601) format) when requested period ends (not inclusive), UTC time, must be less than 7 days after 'start_time', default is current time (format: yyyy-MM-dd'T'HH:mm:ss'Z')
Integer maxCount = 10; // Integer | Limit number of returned transactions (must be less than 10000, default is 1000)
String merchantOrderId = "order00017"; // String | Merchant order number from the merchant system
String paymentMethod = "BANKCARD"; // String | Used payment method type name from payment methods list
String sortOrder = "asc"; // String | Sort based on order of results. `asc` for ascending order or `desc` for descending order (default value)
OffsetDateTime startTime = OffsetDateTime.now(); // OffsetDateTime | Date and time up to milliseconds (in [ISO 8601](https://en.wikipedia.org/wiki/ISO_8601) format) when requested period starts (inclusive), UTC time, default is 24 hours before 'end_time' (format: yyyy-MM-dd'T'HH:mm:ss'Z')
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


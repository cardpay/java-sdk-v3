# PayoutsApi

All URIs are relative to *https://sandbox.cardpay.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createPayout**](PayoutsApi.md#createPayout) | **POST** api/payouts | Create payout
[**getPayout**](PayoutsApi.md#getPayout) | **GET** api/payouts/{payoutId} | Read payout information
[**getPayouts**](PayoutsApi.md#getPayouts) | **GET** api/payouts | Get payouts information
[**updatePayout**](PayoutsApi.md#updatePayout) | **PATCH** api/payouts/{payoutId} | Update payout


<a name="createPayout"></a>
# **createPayout**
> PayoutResponse createPayout(payoutRequest)

Create payout

### Example
```java
// Import classes:
//import com.cardpay.sdk.client.ApiClient;
//import com.cardpay.sdk.client.ApiException;
//import com.cardpay.sdk.client.Configuration;
//import com.cardpay.sdk.client.auth.*;
//import com.cardpay.sdk.api.PayoutsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

PayoutsApi apiInstance = new PayoutsApi();
PayoutRequest payoutRequest = new PayoutRequest(); // PayoutRequest | payoutRequest
try {
    PayoutResponse result = apiInstance.createPayout(payoutRequest);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PayoutsApi#createPayout");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **payoutRequest** | [**PayoutRequest**](PayoutRequest.md)| payoutRequest |

### Return type

[**PayoutResponse**](PayoutResponse.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getPayout"></a>
# **getPayout**
> PayoutResponse getPayout(payoutId)

Read payout information

### Example
```java
// Import classes:
//import com.cardpay.sdk.client.ApiClient;
//import com.cardpay.sdk.client.ApiException;
//import com.cardpay.sdk.client.Configuration;
//import com.cardpay.sdk.client.auth.*;
//import com.cardpay.sdk.api.PayoutsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

PayoutsApi apiInstance = new PayoutsApi();
String payoutId = "payoutId_example"; // String | Payout ID
try {
    PayoutResponse result = apiInstance.getPayout(payoutId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PayoutsApi#getPayout");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **payoutId** | **String**| Payout ID |

### Return type

[**PayoutResponse**](PayoutResponse.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getPayouts"></a>
# **getPayouts**
> PayoutsList getPayouts(requestId, currency, endTime, maxCount, merchantOrderId, paymentMethod, sortOrder, startTime)

Get payouts information

### Example
```java
// Import classes:
//import com.cardpay.sdk.client.ApiClient;
//import com.cardpay.sdk.client.ApiException;
//import com.cardpay.sdk.client.Configuration;
//import com.cardpay.sdk.client.auth.*;
//import com.cardpay.sdk.api.PayoutsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

PayoutsApi apiInstance = new PayoutsApi();
String requestId = "2253145"; // String | Request ID
String currency = "USD"; // String | [ISO 4217](https://en.wikipedia.org/wiki/ISO_4217) currency code of transactions currency
OffsetDateTime endTime = OffsetDateTime.now(); // OffsetDateTime | Date and time up to milliseconds (in [ISO 8601](https://en.wikipedia.org/wiki/ISO_8601) format) when requested period ends (not inclusive), UTC time, must be less than 7 days after 'start_time', default is current time (format: yyyy-MM-dd'T'HH:mm:ss'Z')
Integer maxCount = 10; // Integer | Limit number of returned transactions (must be less than 10000, default is 1000, minimal value is 1)
String merchantOrderId = "order00017"; // String | Merchant order number from the merchant system
String paymentMethod = "BANKCARD"; // String | Used payment method type name from payment methods list
String sortOrder = "asc"; // String | Sort based on order of results. `asc` for ascending order or `desc` for descending order (default value)
OffsetDateTime startTime = OffsetDateTime.now(); // OffsetDateTime | Date and time up to milliseconds (in [ISO 8601](https://en.wikipedia.org/wiki/ISO_8601) format) when requested period starts (inclusive), UTC time, default is 24 hours before 'end_time' (format: yyyy-MM-dd'T'HH:mm:ss'Z')
try {
    PayoutsList result = apiInstance.getPayouts(requestId, currency, endTime, maxCount, merchantOrderId, paymentMethod, sortOrder, startTime);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PayoutsApi#getPayouts");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **requestId** | **String**| Request ID |
 **currency** | **String**| [ISO 4217](https://en.wikipedia.org/wiki/ISO_4217) currency code of transactions currency | [optional]
 **endTime** | **OffsetDateTime**| Date and time up to milliseconds (in [ISO 8601](https://en.wikipedia.org/wiki/ISO_8601) format) when requested period ends (not inclusive), UTC time, must be less than 7 days after &#39;start_time&#39;, default is current time (format: yyyy-MM-dd&#39;T&#39;HH:mm:ss&#39;Z&#39;) | [optional]
 **maxCount** | **Integer**| Limit number of returned transactions (must be less than 10000, default is 1000, minimal value is 1) | [optional]
 **merchantOrderId** | **String**| Merchant order number from the merchant system | [optional]
 **paymentMethod** | **String**| Used payment method type name from payment methods list | [optional]
 **sortOrder** | **String**| Sort based on order of results. &#x60;asc&#x60; for ascending order or &#x60;desc&#x60; for descending order (default value) | [optional] [enum: asc, desc]
 **startTime** | **OffsetDateTime**| Date and time up to milliseconds (in [ISO 8601](https://en.wikipedia.org/wiki/ISO_8601) format) when requested period starts (inclusive), UTC time, default is 24 hours before &#39;end_time&#39; (format: yyyy-MM-dd&#39;T&#39;HH:mm:ss&#39;Z&#39;) | [optional]

### Return type

[**PayoutsList**](PayoutsList.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="updatePayout"></a>
# **updatePayout**
> PayoutUpdateResponse updatePayout(payoutId, payoutUpdateRequest)

Update payout

### Example
```java
// Import classes:
//import com.cardpay.sdk.client.ApiClient;
//import com.cardpay.sdk.client.ApiException;
//import com.cardpay.sdk.client.Configuration;
//import com.cardpay.sdk.client.auth.*;
//import com.cardpay.sdk.api.PayoutsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

PayoutsApi apiInstance = new PayoutsApi();
String payoutId = "payoutId_example"; // String | Payout ID
PayoutUpdateRequest payoutUpdateRequest = new PayoutUpdateRequest(); // PayoutUpdateRequest | payoutUpdateRequest
try {
    PayoutUpdateResponse result = apiInstance.updatePayout(payoutId, payoutUpdateRequest);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PayoutsApi#updatePayout");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **payoutId** | **String**| Payout ID |
 **payoutUpdateRequest** | [**PayoutUpdateRequest**](PayoutUpdateRequest.md)| payoutUpdateRequest |

### Return type

[**PayoutUpdateResponse**](PayoutUpdateResponse.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


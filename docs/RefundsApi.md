# RefundsApi

All URIs are relative to *https://sandbox.cardpay.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createRefund**](RefundsApi.md#createRefund) | **POST** api/refunds | Create refund
[**getRefund**](RefundsApi.md#getRefund) | **GET** api/refunds/{refundId} | Get refund information
[**getRefunds**](RefundsApi.md#getRefunds) | **GET** api/refunds | Get list of refunds
[**updateRefund**](RefundsApi.md#updateRefund) | **PATCH** api/refunds/{refundId} | Update refund


<a name="createRefund"></a>
# **createRefund**
> RefundResponse createRefund(refundRequest)

Create refund

### Example
```java
// Import classes:
//import com.cardpay.sdk.client.ApiClient;
//import com.cardpay.sdk.client.ApiException;
//import com.cardpay.sdk.client.Configuration;
//import com.cardpay.sdk.client.auth.*;
//import com.cardpay.sdk.api.RefundsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

RefundsApi apiInstance = new RefundsApi();
RefundRequest refundRequest = new RefundRequest(); // RefundRequest | refundRequest
try {
    RefundResponse result = apiInstance.createRefund(refundRequest);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RefundsApi#createRefund");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **refundRequest** | [**RefundRequest**](RefundRequest.md)| refundRequest |

### Return type

[**RefundResponse**](RefundResponse.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getRefund"></a>
# **getRefund**
> RefundResponse getRefund(refundId)

Get refund information

### Example
```java
// Import classes:
//import com.cardpay.sdk.client.ApiClient;
//import com.cardpay.sdk.client.ApiException;
//import com.cardpay.sdk.client.Configuration;
//import com.cardpay.sdk.client.auth.*;
//import com.cardpay.sdk.api.RefundsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

RefundsApi apiInstance = new RefundsApi();
String refundId = "refundId_example"; // String | Refund ID
try {
    RefundResponse result = apiInstance.getRefund(refundId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RefundsApi#getRefund");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **refundId** | **String**| Refund ID |

### Return type

[**RefundResponse**](RefundResponse.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getRefunds"></a>
# **getRefunds**
> RefundsList getRefunds(requestId, currency, endTime, maxCount, merchantOrderId, paymentMethod, sortOrder, startTime)

Get list of refunds

### Example
```java
// Import classes:
//import com.cardpay.sdk.client.ApiClient;
//import com.cardpay.sdk.client.ApiException;
//import com.cardpay.sdk.client.Configuration;
//import com.cardpay.sdk.client.auth.*;
//import com.cardpay.sdk.api.RefundsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

RefundsApi apiInstance = new RefundsApi();
String requestId = "2253145"; // String | Request ID
String currency = "USD"; // String | [ISO 4217](https://en.wikipedia.org/wiki/ISO_4217) currency code of transactions currency
OffsetDateTime endTime = OffsetDateTime.now(); // OffsetDateTime | Date and time up to milliseconds (in [ISO 8601](https://en.wikipedia.org/wiki/ISO_8601) format) when requested period ends (not inclusive), UTC time, must be less than 7 days after 'start_time', default is current time (format: yyyy-MM-dd'T'HH:mm:ss'Z')
Integer maxCount = 10; // Integer | Limit number of returned transactions (must be less than 10000, default is 1000, minimal value is 1)
String merchantOrderId = "order00017"; // String | Merchant order number from the merchant system
String paymentMethod = "BANKCARD"; // String | Used payment method type name from payment methods list
String sortOrder = "asc"; // String | Sort based on order of results. `asc` for ascending order or `desc` for descending order (default value)
OffsetDateTime startTime = OffsetDateTime.now(); // OffsetDateTime | Date and time up to milliseconds (in [ISO 8601](https://en.wikipedia.org/wiki/ISO_8601) format) when requested period starts (inclusive), UTC time, default is 24 hours before 'end_time' (format: yyyy-MM-dd'T'HH:mm:ss'Z')
try {
    RefundsList result = apiInstance.getRefunds(requestId, currency, endTime, maxCount, merchantOrderId, paymentMethod, sortOrder, startTime);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RefundsApi#getRefunds");
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

[**RefundsList**](RefundsList.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="updateRefund"></a>
# **updateRefund**
> RefundUpdateResponse updateRefund(refundId, refundUpdateRequest)

Update refund

### Example
```java
// Import classes:
//import com.cardpay.sdk.client.ApiClient;
//import com.cardpay.sdk.client.ApiException;
//import com.cardpay.sdk.client.Configuration;
//import com.cardpay.sdk.client.auth.*;
//import com.cardpay.sdk.api.RefundsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

RefundsApi apiInstance = new RefundsApi();
String refundId = "refundId_example"; // String | Refund ID
RefundUpdateRequest refundUpdateRequest = new RefundUpdateRequest(); // RefundUpdateRequest | refundUpdateRequest
try {
    RefundUpdateResponse result = apiInstance.updateRefund(refundId, refundUpdateRequest);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RefundsApi#updateRefund");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **refundId** | **String**| Refund ID |
 **refundUpdateRequest** | [**RefundUpdateRequest**](RefundUpdateRequest.md)| refundUpdateRequest |

### Return type

[**RefundUpdateResponse**](RefundUpdateResponse.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


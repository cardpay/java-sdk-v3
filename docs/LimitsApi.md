# LimitsApi

All URIs are relative to *https://sandbox.cardpay.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getLimitsInfo**](LimitsApi.md#getLimitsInfo) | **GET** api/limits | Get limits information


<a name="getLimitsInfo"></a>
# **getLimitsInfo**
> LimitInfoResponse getLimitsInfo(requestId)

Get limits information

### Example
```java
// Import classes:
//import com.cardpay.sdk.client.ApiClient;
//import com.cardpay.sdk.client.ApiException;
//import com.cardpay.sdk.client.Configuration;
//import com.cardpay.sdk.client.auth.*;
//import com.cardpay.sdk.api.LimitsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

LimitsApi apiInstance = new LimitsApi();
String requestId = "requestId_example"; // String | request_id
try {
    LimitInfoResponse result = apiInstance.getLimitsInfo(requestId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling LimitsApi#getLimitsInfo");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **requestId** | **String**| request_id | [optional]

### Return type

[**LimitInfoResponse**](LimitInfoResponse.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


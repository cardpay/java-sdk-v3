# MobileApi

All URIs are relative to *https://sandbox.cardpay.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getMobileToken**](MobileApi.md#getMobileToken) | **POST** api/mobile/token | Generate mobile token


<a name="getMobileToken"></a>
# **getMobileToken**
> MobileTokenResponse getMobileToken(mobileTokenRequest)

Generate mobile token

### Example
```java
// Import classes:
//import com.cardpay.sdk.client.ApiClient;
//import com.cardpay.sdk.client.ApiException;
//import com.cardpay.sdk.client.Configuration;
//import com.cardpay.sdk.client.auth.*;
//import com.cardpay.sdk.api.MobileApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

MobileApi apiInstance = new MobileApi();
MobileTokenRequest mobileTokenRequest = new MobileTokenRequest(); // MobileTokenRequest | mobileTokenRequest
try {
    MobileTokenResponse result = apiInstance.getMobileToken(mobileTokenRequest);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling MobileApi#getMobileToken");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **mobileTokenRequest** | [**MobileTokenRequest**](MobileTokenRequest.md)| mobileTokenRequest |

### Return type

[**MobileTokenResponse**](MobileTokenResponse.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


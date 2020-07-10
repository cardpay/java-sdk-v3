# MobileApi

All URIs are relative to *https://sandbox.cardpay.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**executeCardBinding**](MobileApi.md#executeCardBinding) | **POST** api/mobile/cardbinding | Execute card binding process
[**generateMobileToken**](MobileApi.md#generateMobileToken) | **POST** api/mobile/token | Generate mobile token 


<a name="executeCardBinding"></a>
# **executeCardBinding**
> CardBindingResponse executeCardBinding(request)

Execute card binding process

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
CardBindingRequest request = new CardBindingRequest(); // CardBindingRequest | request
try {
    CardBindingResponse result = apiInstance.executeCardBinding(request);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling MobileApi#executeCardBinding");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **request** | [**CardBindingRequest**](CardBindingRequest.md)| request |

### Return type

[**CardBindingResponse**](CardBindingResponse.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="generateMobileToken"></a>
# **generateMobileToken**
> MobileTokenResponse generateMobileToken(request)

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
MobileTokenRequest request = new MobileTokenRequest(); // MobileTokenRequest | request
try {
    MobileTokenResponse result = apiInstance.generateMobileToken(request);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling MobileApi#generateMobileToken");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **request** | [**MobileTokenRequest**](MobileTokenRequest.md)| request |

### Return type

[**MobileTokenResponse**](MobileTokenResponse.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


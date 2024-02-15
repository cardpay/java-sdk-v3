# AuthenticationApi

All URIs are relative to *https://sandbox.cardpay.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createAuthentication**](AuthenticationApi.md#createAuthentication) | **POST** api/authentication | Create authentication
[**getAuthentication**](AuthenticationApi.md#getAuthentication) | **GET** api/authentication/{authId} | Get authentication information


<a name="createAuthentication"></a>
# **createAuthentication**
> AuthenticationCreateResponse createAuthentication(authenticationDataRequest)

Create authentication

### Example
```java
// Import classes:
//import com.cardpay.sdk.client.ApiClient;
//import com.cardpay.sdk.client.ApiException;
//import com.cardpay.sdk.client.Configuration;
//import com.cardpay.sdk.client.auth.*;
//import com.cardpay.sdk.api.AuthenticationApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AuthenticationApi apiInstance = new AuthenticationApi();
AuthenticationDataRequest authenticationDataRequest = new AuthenticationDataRequest(); // AuthenticationDataRequest | authenticationDataRequest
try {
    AuthenticationCreateResponse result = apiInstance.createAuthentication(authenticationDataRequest);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AuthenticationApi#createAuthentication");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **authenticationDataRequest** | [**AuthenticationDataRequest**](AuthenticationDataRequest.md)| authenticationDataRequest |

### Return type

[**AuthenticationCreateResponse**](AuthenticationCreateResponse.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getAuthentication"></a>
# **getAuthentication**
> AuthenticationDataResponse getAuthentication(authId)

Get authentication information

### Example
```java
// Import classes:
//import com.cardpay.sdk.client.ApiClient;
//import com.cardpay.sdk.client.ApiException;
//import com.cardpay.sdk.client.Configuration;
//import com.cardpay.sdk.client.auth.*;
//import com.cardpay.sdk.api.AuthenticationApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AuthenticationApi apiInstance = new AuthenticationApi();
String authId = "authId_example"; // String | Authentication ID
try {
    AuthenticationDataResponse result = apiInstance.getAuthentication(authId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AuthenticationApi#getAuthentication");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **authId** | **String**| Authentication ID |

### Return type

[**AuthenticationDataResponse**](AuthenticationDataResponse.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


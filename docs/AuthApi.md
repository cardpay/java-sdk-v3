# AuthApi

All URIs are relative to *https://sandbox.cardpay.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**obtainTokens**](AuthApi.md#obtainTokens) | **POST** api/auth/token | Get authorization token


<a name="obtainTokens"></a>
# **obtainTokens**
> ApiTokens obtainTokens(grantType, password, refreshToken, terminalCode)

Get authorization token

### Example
```java
// Import classes:
//import com.cardpay.sdk.client.ApiClient;
//import com.cardpay.sdk.client.ApiException;
//import com.cardpay.sdk.client.Configuration;
//import com.cardpay.sdk.client.auth.*;
//import com.cardpay.sdk.api.AuthApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

AuthApi apiInstance = new AuthApi();
String grantType = "grantType_example"; // String | Token request credentials representation
String password = "secret"; // String | Terminal password value (only for [password] grant type)
String refreshToken = "eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJ2bWRoQz"; // String | Refresh token string (only for [refresh_token] grant type)
String terminalCode = "1001"; // String | Terminal code value
try {
    ApiTokens result = apiInstance.obtainTokens(grantType, password, refreshToken, terminalCode);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AuthApi#obtainTokens");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **grantType** | **String**| Token request credentials representation | [enum: password, refresh_token]
 **password** | **String**| Terminal password value (only for [password] grant type) | [optional]
 **refreshToken** | **String**| Refresh token string (only for [refresh_token] grant type) | [optional]
 **terminalCode** | **String**| Terminal code value | [optional]

### Return type

[**ApiTokens**](ApiTokens.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded
 - **Accept**: application/json


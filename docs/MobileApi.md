# MobileApi

All URIs are relative to *https://sandbox.cardpay.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createMobilePayment**](MobileApi.md#createMobilePayment) | **POST** api/mobile/payment | Create mobile payment 
[**executeCardBinding**](MobileApi.md#executeCardBinding) | **POST** api/mobile/cardbinding | Execute card binding process
[**generateMobileToken**](MobileApi.md#generateMobileToken) | **POST** api/mobile/token | Generate mobile token 
[**getMobilePayment**](MobileApi.md#getMobilePayment) | **GET** api/mobile/payments/{paymentId} | get mobile payment
[**getMobilePaymentMethods**](MobileApi.md#getMobilePaymentMethods) | **GET** api/mobile/payment_methods | get mobile payment methods


<a name="createMobilePayment"></a>
# **createMobilePayment**
> MobilePaymentResponse createMobilePayment(authorization, request)

Create mobile payment 

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
String authorization = "authorization_example"; // String | Authorization
MobilePaymentRequest request = new MobilePaymentRequest(); // MobilePaymentRequest | request
try {
    MobilePaymentResponse result = apiInstance.createMobilePayment(authorization, request);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling MobileApi#createMobilePayment");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **authorization** | **String**| Authorization |
 **request** | [**MobilePaymentRequest**](MobilePaymentRequest.md)| request |

### Return type

[**MobilePaymentResponse**](MobilePaymentResponse.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="executeCardBinding"></a>
# **executeCardBinding**
> CardBindingResponse executeCardBinding(authorization, request)

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
String authorization = "authorization_example"; // String | Authorization
CardBindingRequest request = new CardBindingRequest(); // CardBindingRequest | request
try {
    CardBindingResponse result = apiInstance.executeCardBinding(authorization, request);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling MobileApi#executeCardBinding");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **authorization** | **String**| Authorization |
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

<a name="getMobilePayment"></a>
# **getMobilePayment**
> MobilePaymentResponse getMobilePayment(authorization, paymentId)

get mobile payment

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
String authorization = "authorization_example"; // String | Authorization
String paymentId = "paymentId_example"; // String | paymentId
try {
    MobilePaymentResponse result = apiInstance.getMobilePayment(authorization, paymentId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling MobileApi#getMobilePayment");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **authorization** | **String**| Authorization |
 **paymentId** | **String**| paymentId |

### Return type

[**MobilePaymentResponse**](MobilePaymentResponse.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getMobilePaymentMethods"></a>
# **getMobilePaymentMethods**
> MobilePaymentResponse getMobilePaymentMethods(authorization)

get mobile payment methods

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
String authorization = "authorization_example"; // String | Authorization
try {
    MobilePaymentResponse result = apiInstance.getMobilePaymentMethods(authorization);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling MobileApi#getMobilePaymentMethods");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **authorization** | **String**| Authorization |

### Return type

[**MobilePaymentResponse**](MobilePaymentResponse.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


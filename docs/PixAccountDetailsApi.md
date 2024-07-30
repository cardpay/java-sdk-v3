# PixAccountDetailsApi

All URIs are relative to *https://sandbox.cardpay.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**accountDetails**](PixAccountDetailsApi.md#accountDetails) | **POST** api/account_details/{method} | Get methods account details
[**banks**](PixAccountDetailsApi.md#banks) | **GET** api/banks/{method}/{currency} | Get adapter banks list


<a name="accountDetails"></a>
# **accountDetails**
> PixAccountDetailsResponse accountDetails(detailsRequest, method)

Get methods account details

### Example
```java
// Import classes:
//import com.cardpay.sdk.client.ApiClient;
//import com.cardpay.sdk.client.ApiException;
//import com.cardpay.sdk.client.Configuration;
//import com.cardpay.sdk.client.auth.*;
//import com.cardpay.sdk.api.PixAccountDetailsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

PixAccountDetailsApi apiInstance = new PixAccountDetailsApi();
AccountDetailsRequest detailsRequest = new AccountDetailsRequest(); // AccountDetailsRequest | detailsRequest
String method = "method_example"; // String | method
try {
    PixAccountDetailsResponse result = apiInstance.accountDetails(detailsRequest, method);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PixAccountDetailsApi#accountDetails");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **detailsRequest** | [**AccountDetailsRequest**](AccountDetailsRequest.md)| detailsRequest |
 **method** | **String**| method |

### Return type

[**PixAccountDetailsResponse**](PixAccountDetailsResponse.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="banks"></a>
# **banks**
> Object banks(currency, method)

Get adapter banks list

### Example
```java
// Import classes:
//import com.cardpay.sdk.client.ApiClient;
//import com.cardpay.sdk.client.ApiException;
//import com.cardpay.sdk.client.Configuration;
//import com.cardpay.sdk.client.auth.*;
//import com.cardpay.sdk.api.PixAccountDetailsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

PixAccountDetailsApi apiInstance = new PixAccountDetailsApi();
String currency = "currency_example"; // String | currency
String method = "method_example"; // String | method
try {
    Object result = apiInstance.banks(currency, method);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PixAccountDetailsApi#banks");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **currency** | **String**| currency |
 **method** | **String**| method |

### Return type

**Object**

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


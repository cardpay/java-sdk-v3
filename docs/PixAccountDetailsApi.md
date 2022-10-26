# PixAccountDetailsApi

All URIs are relative to *https://sandbox.cardpay.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**accountDetails**](PixAccountDetailsApi.md#accountDetails) | **POST** api/account_details/pix | Get pix account details


<a name="accountDetails"></a>
# **accountDetails**
> PixAccountDetailsResponse accountDetails(detailsRequest)

Get pix account details

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
PixAccountDetailsRequest detailsRequest = new PixAccountDetailsRequest(); // PixAccountDetailsRequest | detailsRequest
try {
    PixAccountDetailsResponse result = apiInstance.accountDetails(detailsRequest);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PixAccountDetailsApi#accountDetails");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **detailsRequest** | [**PixAccountDetailsRequest**](PixAccountDetailsRequest.md)| detailsRequest |

### Return type

[**PixAccountDetailsResponse**](PixAccountDetailsResponse.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


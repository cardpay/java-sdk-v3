# CardInfoApi

All URIs are relative to *https://sandbox.cardpay.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**cardInfo**](CardInfoApi.md#cardInfo) | **POST** api/card_info | Get card information


<a name="cardInfo"></a>
# **cardInfo**
> List&lt;CardInfoResponse&gt; cardInfo(cardInfoRequest)

Get card information

### Example
```java
// Import classes:
//import com.cardpay.sdk.client.ApiClient;
//import com.cardpay.sdk.client.ApiException;
//import com.cardpay.sdk.client.Configuration;
//import com.cardpay.sdk.client.auth.*;
//import com.cardpay.sdk.api.CardInfoApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

CardInfoApi apiInstance = new CardInfoApi();
CardInfoRequest cardInfoRequest = new CardInfoRequest(); // CardInfoRequest | cardInfoRequest
try {
    List<CardInfoResponse> result = apiInstance.cardInfo(cardInfoRequest);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CardInfoApi#cardInfo");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **cardInfoRequest** | [**CardInfoRequest**](CardInfoRequest.md)| cardInfoRequest |

### Return type

[**List&lt;CardInfoResponse&gt;**](CardInfoResponse.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


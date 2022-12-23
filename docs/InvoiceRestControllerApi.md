# InvoiceRestControllerApi

All URIs are relative to *https://sandbox.cardpay.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createInvoiceUsingPOST**](InvoiceRestControllerApi.md#createInvoiceUsingPOST) | **POST** api/invoices | createInvoice
[**getInvoiceInfoUsingGET**](InvoiceRestControllerApi.md#getInvoiceInfoUsingGET) | **GET** api/invoices/{invoiceId} | getInvoiceInfo


<a name="createInvoiceUsingPOST"></a>
# **createInvoiceUsingPOST**
> InvoiceCreationResponse createInvoiceUsingPOST(invoiceRequest)

createInvoice

### Example
```java
// Import classes:
//import com.cardpay.sdk.client.ApiClient;
//import com.cardpay.sdk.client.ApiException;
//import com.cardpay.sdk.client.Configuration;
//import com.cardpay.sdk.client.auth.*;
//import com.cardpay.sdk.api.InvoiceRestControllerApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

InvoiceRestControllerApi apiInstance = new InvoiceRestControllerApi();
InvoiceRequest invoiceRequest = new InvoiceRequest(); // InvoiceRequest | invoiceRequest
try {
    InvoiceCreationResponse result = apiInstance.createInvoiceUsingPOST(invoiceRequest);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling InvoiceRestControllerApi#createInvoiceUsingPOST");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **invoiceRequest** | [**InvoiceRequest**](InvoiceRequest.md)| invoiceRequest |

### Return type

[**InvoiceCreationResponse**](InvoiceCreationResponse.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

<a name="getInvoiceInfoUsingGET"></a>
# **getInvoiceInfoUsingGET**
> InvoiceGetResponse getInvoiceInfoUsingGET(invoiceId)

getInvoiceInfo

### Example
```java
// Import classes:
//import com.cardpay.sdk.client.ApiClient;
//import com.cardpay.sdk.client.ApiException;
//import com.cardpay.sdk.client.Configuration;
//import com.cardpay.sdk.client.auth.*;
//import com.cardpay.sdk.api.InvoiceRestControllerApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

InvoiceRestControllerApi apiInstance = new InvoiceRestControllerApi();
String invoiceId = "invoiceId_example"; // String | invoiceId
try {
    InvoiceGetResponse result = apiInstance.getInvoiceInfoUsingGET(invoiceId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling InvoiceRestControllerApi#getInvoiceInfoUsingGET");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **invoiceId** | **String**| invoiceId |

### Return type

[**InvoiceGetResponse**](InvoiceGetResponse.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*


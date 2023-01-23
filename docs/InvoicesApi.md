# InvoicesApi

All URIs are relative to *https://sandbox.cardpay.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createInvoice**](InvoicesApi.md#createInvoice) | **POST** api/invoices | Create invoice
[**getInvoice**](InvoicesApi.md#getInvoice) | **GET** api/invoices/{invoiceId} | Get invoice information


<a name="createInvoice"></a>
# **createInvoice**
> InvoiceCreationResponse createInvoice(invoiceRequest)

Create invoice

Endpoint for invoice creation

### Example
```java
// Import classes:
//import com.cardpay.sdk.client.ApiClient;
//import com.cardpay.sdk.client.ApiException;
//import com.cardpay.sdk.client.Configuration;
//import com.cardpay.sdk.client.auth.*;
//import com.cardpay.sdk.api.InvoicesApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

InvoicesApi apiInstance = new InvoicesApi();
InvoiceRequest invoiceRequest = new InvoiceRequest(); // InvoiceRequest | invoiceRequest
try {
    InvoiceCreationResponse result = apiInstance.createInvoice(invoiceRequest);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling InvoicesApi#createInvoice");
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
 - **Accept**: application/json

<a name="getInvoice"></a>
# **getInvoice**
> InvoiceGetResponse getInvoice(invoiceId)

Get invoice information

Method allows to get information about single invoice.

### Example
```java
// Import classes:
//import com.cardpay.sdk.client.ApiClient;
//import com.cardpay.sdk.client.ApiException;
//import com.cardpay.sdk.client.Configuration;
//import com.cardpay.sdk.client.auth.*;
//import com.cardpay.sdk.api.InvoicesApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

InvoicesApi apiInstance = new InvoicesApi();
String invoiceId = "invoiceId_example"; // String | Invoice ID
try {
    InvoiceGetResponse result = apiInstance.getInvoice(invoiceId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling InvoicesApi#getInvoice");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **invoiceId** | **String**| Invoice ID |

### Return type

[**InvoiceGetResponse**](InvoiceGetResponse.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json


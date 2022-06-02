# ReportsApiControllerApi

All URIs are relative to *https://sandbox.cardpay.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**gETReports**](ReportsApiControllerApi.md#gETReports) | **GET** api/reports/{id} | Gets actual state of processing of requested settlement reports
[**gETReportsContent**](ReportsApiControllerApi.md#gETReportsContent) | **GET** api/reports/download/{id} | Download the report file
[**pOSTReports**](ReportsApiControllerApi.md#pOSTReports) | **POST** api/reports | Initiate the reports&#39; preparation


<a name="gETReports"></a>
# **gETReports**
> ReportsResponse gETReports(id)

Gets actual state of processing of requested settlement reports

### Example
```java
// Import classes:
//import com.cardpay.sdk.client.ApiClient;
//import com.cardpay.sdk.client.ApiException;
//import com.cardpay.sdk.client.Configuration;
//import com.cardpay.sdk.client.auth.*;
//import com.cardpay.sdk.api.ReportsApiControllerApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

ReportsApiControllerApi apiInstance = new ReportsApiControllerApi();
String id = "id_example"; // String | id
try {
    ReportsResponse result = apiInstance.gETReports(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ReportsApiControllerApi#gETReports");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| id |

### Return type

[**ReportsResponse**](ReportsResponse.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="gETReportsContent"></a>
# **gETReportsContent**
> byte[] gETReportsContent(id)

Download the report file

### Example
```java
// Import classes:
//import com.cardpay.sdk.client.ApiClient;
//import com.cardpay.sdk.client.ApiException;
//import com.cardpay.sdk.client.Configuration;
//import com.cardpay.sdk.client.auth.*;
//import com.cardpay.sdk.api.ReportsApiControllerApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

ReportsApiControllerApi apiInstance = new ReportsApiControllerApi();
String id = "id_example"; // String | id
try {
    byte[] result = apiInstance.gETReportsContent(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ReportsApiControllerApi#gETReportsContent");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| id |

### Return type

**byte[]**

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="pOSTReports"></a>
# **pOSTReports**
> ReportsResponse pOSTReports(request)

Initiate the reports&#39; preparation

### Example
```java
// Import classes:
//import com.cardpay.sdk.client.ApiClient;
//import com.cardpay.sdk.client.ApiException;
//import com.cardpay.sdk.client.Configuration;
//import com.cardpay.sdk.client.auth.*;
//import com.cardpay.sdk.api.ReportsApiControllerApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

ReportsApiControllerApi apiInstance = new ReportsApiControllerApi();
ReportsRequest request = new ReportsRequest(); // ReportsRequest | request
try {
    ReportsResponse result = apiInstance.pOSTReports(request);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ReportsApiControllerApi#pOSTReports");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **request** | [**ReportsRequest**](ReportsRequest.md)| request |

### Return type

[**ReportsResponse**](ReportsResponse.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*


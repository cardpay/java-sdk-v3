# RecurringsInstallmentsApi

All URIs are relative to *https://sandbox.cardpay.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**calculateSchedule**](RecurringsInstallmentsApi.md#calculateSchedule) | **GET** api/installments/options_calculator | Get calculation of installment payment options
[**createInstallment**](RecurringsInstallmentsApi.md#createInstallment) | **POST** api/installments | Create installment
[**getInstallmentPayment**](RecurringsInstallmentsApi.md#getInstallmentPayment) | **GET** api/installments/{recurringId} | Get installment payment
[**getInstallmentPayments**](RecurringsInstallmentsApi.md#getInstallmentPayments) | **GET** api/installments | Get installment payments
[**updateInstallmentPayment**](RecurringsInstallmentsApi.md#updateInstallmentPayment) | **PATCH** api/installments/{recurringId} | Update installment payment


<a name="calculateSchedule"></a>
# **calculateSchedule**
> ScheduleOptionsResponse calculateSchedule(currency, requestId, totalAmount)

Get calculation of installment payment options

### Example
```java
// Import classes:
//import com.cardpay.sdk.client.ApiClient;
//import com.cardpay.sdk.client.ApiException;
//import com.cardpay.sdk.client.Configuration;
//import com.cardpay.sdk.client.auth.*;
//import com.cardpay.sdk.api.RecurringsInstallmentsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

RecurringsInstallmentsApi apiInstance = new RecurringsInstallmentsApi();
String currency = "USD"; // String | [ISO 4217](https://en.wikipedia.org/wiki/ISO_4217) currency code
String requestId = "2253145"; // String | Request ID
BigDecimal totalAmount = new BigDecimal(); // BigDecimal | Total amount of subscription to be calculated to options; can have dot as a decimal separator.
try {
    ScheduleOptionsResponse result = apiInstance.calculateSchedule(currency, requestId, totalAmount);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RecurringsInstallmentsApi#calculateSchedule");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **currency** | **String**| [ISO 4217](https://en.wikipedia.org/wiki/ISO_4217) currency code |
 **requestId** | **String**| Request ID |
 **totalAmount** | **BigDecimal**| Total amount of subscription to be calculated to options; can have dot as a decimal separator. | [optional]

### Return type

[**ScheduleOptionsResponse**](ScheduleOptionsResponse.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="createInstallment"></a>
# **createInstallment**
> RecurringGatewayCreationResponse createInstallment(subscriptionRequest)

Create installment

### Example
```java
// Import classes:
//import com.cardpay.sdk.client.ApiClient;
//import com.cardpay.sdk.client.ApiException;
//import com.cardpay.sdk.client.Configuration;
//import com.cardpay.sdk.client.auth.*;
//import com.cardpay.sdk.api.RecurringsInstallmentsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

RecurringsInstallmentsApi apiInstance = new RecurringsInstallmentsApi();
InstallmentSubscriptionRequest subscriptionRequest = new InstallmentSubscriptionRequest(); // InstallmentSubscriptionRequest | subscriptionRequest
try {
    RecurringGatewayCreationResponse result = apiInstance.createInstallment(subscriptionRequest);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RecurringsInstallmentsApi#createInstallment");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **subscriptionRequest** | [**InstallmentSubscriptionRequest**](InstallmentSubscriptionRequest.md)| subscriptionRequest |

### Return type

[**RecurringGatewayCreationResponse**](RecurringGatewayCreationResponse.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getInstallmentPayment"></a>
# **getInstallmentPayment**
> RecurringResponse getInstallmentPayment(recurringId)

Get installment payment

### Example
```java
// Import classes:
//import com.cardpay.sdk.client.ApiClient;
//import com.cardpay.sdk.client.ApiException;
//import com.cardpay.sdk.client.Configuration;
//import com.cardpay.sdk.client.auth.*;
//import com.cardpay.sdk.api.RecurringsInstallmentsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

RecurringsInstallmentsApi apiInstance = new RecurringsInstallmentsApi();
String recurringId = "recurringId_example"; // String | Recurring ID
try {
    RecurringResponse result = apiInstance.getInstallmentPayment(recurringId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RecurringsInstallmentsApi#getInstallmentPayment");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **recurringId** | **String**| Recurring ID |

### Return type

[**RecurringResponse**](RecurringResponse.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getInstallmentPayments"></a>
# **getInstallmentPayments**
> RecurringsList getInstallmentPayments(requestId, currency, endTime, maxCount, merchantOrderId, paymentMethod, recurringTypes, sortOrder, startTime, type)

Get installment payments

### Example
```java
// Import classes:
//import com.cardpay.sdk.client.ApiClient;
//import com.cardpay.sdk.client.ApiException;
//import com.cardpay.sdk.client.Configuration;
//import com.cardpay.sdk.client.auth.*;
//import com.cardpay.sdk.api.RecurringsInstallmentsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

RecurringsInstallmentsApi apiInstance = new RecurringsInstallmentsApi();
String requestId = "2253145"; // String | Request ID
String currency = "USD"; // String | [ISO 4217](https://en.wikipedia.org/wiki/ISO_4217) currency code of transactions currency
OffsetDateTime endTime = OffsetDateTime.now(); // OffsetDateTime | Date and time up to milliseconds (in [ISO 8601](https://en.wikipedia.org/wiki/ISO_8601) format) when requested period ends (not inclusive), UTC time, must be less than 7 days after 'start_time', default is current time (format: yyyy-MM-dd'T'HH:mm:ss'Z')
Integer maxCount = 10; // Integer | Limit number of returned transactions (must be less than 10000, default is 1000)
String merchantOrderId = "order00017"; // String | Merchant order number from the merchant system
String paymentMethod = "BANKCARD"; // String | Used payment method type name from payment methods list
List<String> recurringTypes = Arrays.asList("recurringTypes_example"); // List<String> | 
String sortOrder = "asc"; // String | Sort based on order of results. `asc` for ascending order or `desc` for descending order (default value)
OffsetDateTime startTime = OffsetDateTime.now(); // OffsetDateTime | Date and time up to milliseconds (in [ISO 8601](https://en.wikipedia.org/wiki/ISO_8601) format) when requested period starts (inclusive), UTC time, default is 24 hours before 'end_time' (format: yyyy-MM-dd'T'HH:mm:ss'Z')
String type = "SCHEDULED"; // String | Filter recurring payments by certain type (applicable to /api/recurrings endpoint only): `SCHEDULED` for scheduled recurring payments `ONECLICK` for one-click payments `INSTALLMENT` for installment payments
try {
    RecurringsList result = apiInstance.getInstallmentPayments(requestId, currency, endTime, maxCount, merchantOrderId, paymentMethod, recurringTypes, sortOrder, startTime, type);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RecurringsInstallmentsApi#getInstallmentPayments");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **requestId** | **String**| Request ID |
 **currency** | **String**| [ISO 4217](https://en.wikipedia.org/wiki/ISO_4217) currency code of transactions currency | [optional]
 **endTime** | **OffsetDateTime**| Date and time up to milliseconds (in [ISO 8601](https://en.wikipedia.org/wiki/ISO_8601) format) when requested period ends (not inclusive), UTC time, must be less than 7 days after &#39;start_time&#39;, default is current time (format: yyyy-MM-dd&#39;T&#39;HH:mm:ss&#39;Z&#39;) | [optional]
 **maxCount** | **Integer**| Limit number of returned transactions (must be less than 10000, default is 1000) | [optional]
 **merchantOrderId** | **String**| Merchant order number from the merchant system | [optional]
 **paymentMethod** | **String**| Used payment method type name from payment methods list | [optional]
 **recurringTypes** | [**List&lt;String&gt;**](String.md)|  | [optional] [enum: ONECLICK, SCHEDULED, INSTALLMENT]
 **sortOrder** | **String**| Sort based on order of results. &#x60;asc&#x60; for ascending order or &#x60;desc&#x60; for descending order (default value) | [optional] [enum: asc, desc]
 **startTime** | **OffsetDateTime**| Date and time up to milliseconds (in [ISO 8601](https://en.wikipedia.org/wiki/ISO_8601) format) when requested period starts (inclusive), UTC time, default is 24 hours before &#39;end_time&#39; (format: yyyy-MM-dd&#39;T&#39;HH:mm:ss&#39;Z&#39;) | [optional]
 **type** | **String**| Filter recurring payments by certain type (applicable to /api/recurrings endpoint only): &#x60;SCHEDULED&#x60; for scheduled recurring payments &#x60;ONECLICK&#x60; for one-click payments &#x60;INSTALLMENT&#x60; for installment payments | [optional] [enum: ONECLICK, SCHEDULED, INSTALLMENT]

### Return type

[**RecurringsList**](RecurringsList.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="updateInstallmentPayment"></a>
# **updateInstallmentPayment**
> RecurringResponse updateInstallmentPayment(recurringId, recurringPatchRequest)

Update installment payment

### Example
```java
// Import classes:
//import com.cardpay.sdk.client.ApiClient;
//import com.cardpay.sdk.client.ApiException;
//import com.cardpay.sdk.client.Configuration;
//import com.cardpay.sdk.client.auth.*;
//import com.cardpay.sdk.api.RecurringsInstallmentsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

RecurringsInstallmentsApi apiInstance = new RecurringsInstallmentsApi();
String recurringId = "recurringId_example"; // String | Recurring ID
RecurringPatchRequest recurringPatchRequest = new RecurringPatchRequest(); // RecurringPatchRequest | Recurring patch request
try {
    RecurringResponse result = apiInstance.updateInstallmentPayment(recurringId, recurringPatchRequest);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RecurringsInstallmentsApi#updateInstallmentPayment");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **recurringId** | **String**| Recurring ID |
 **recurringPatchRequest** | [**RecurringPatchRequest**](RecurringPatchRequest.md)| Recurring patch request |

### Return type

[**RecurringResponse**](RecurringResponse.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


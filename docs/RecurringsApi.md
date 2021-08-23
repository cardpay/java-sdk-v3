# RecurringsApi

All URIs are relative to *https://sandbox.cardpay.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createFiling**](RecurringsApi.md#createFiling) | **POST** api/recurring_filings | Create filing
[**createPlan**](RecurringsApi.md#createPlan) | **POST** api/recurring_plans | Create recurring plan
[**createRecurring**](RecurringsApi.md#createRecurring) | **POST** api/recurrings | Create recurring
[**deletePlan**](RecurringsApi.md#deletePlan) | **DELETE** api/recurring_plans/{plan_id} | Delete plan
[**getAuthenticationData2**](RecurringsApi.md#getAuthenticationData2) | **GET** api/recurrings/{recurringId}/threedsecure | Get recurring payment 3DS result information
[**getChangeStatusClaim**](RecurringsApi.md#getChangeStatusClaim) | **GET** api/recurring_subscriptions/{subscriptionId}/change_status_claims/{claimId} | Get information about Change subscription status claim
[**getFiling**](RecurringsApi.md#getFiling) | **GET** api/recurring_filings/{filingId} | Get filing order information
[**getPlan**](RecurringsApi.md#getPlan) | **GET** api/recurring_plans/{plan_id} | Get plan information
[**getPlans**](RecurringsApi.md#getPlans) | **GET** api/recurring_plans | Get plans information
[**getRecurring**](RecurringsApi.md#getRecurring) | **GET** api/recurrings/{recurringId} | Get recurring information
[**getRecurrings**](RecurringsApi.md#getRecurrings) | **GET** api/recurrings | Get recurring list information
[**getSubscription**](RecurringsApi.md#getSubscription) | **GET** api/recurring_subscriptions/{subscriptionId} | Get subscription information
[**getSubscriptions**](RecurringsApi.md#getSubscriptions) | **GET** api/recurring_subscriptions | Get subscription information
[**updatePlan**](RecurringsApi.md#updatePlan) | **PATCH** api/recurring_plans/{plan_id} | Update plan
[**updateRecurring**](RecurringsApi.md#updateRecurring) | **PATCH** api/recurrings/{recurringId} | Update recurring
[**updateSubscription**](RecurringsApi.md#updateSubscription) | **PATCH** api/recurring_subscriptions/{subscriptionId} | Update subscription


<a name="createFiling"></a>
# **createFiling**
> RecurringGatewayCreationResponse createFiling(filingRequest)

Create filing

### Example
```java
// Import classes:
//import com.cardpay.sdk.client.ApiClient;
//import com.cardpay.sdk.client.ApiException;
//import com.cardpay.sdk.client.Configuration;
//import com.cardpay.sdk.client.auth.*;
//import com.cardpay.sdk.api.RecurringsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

RecurringsApi apiInstance = new RecurringsApi();
FilingRequest filingRequest = new FilingRequest(); // FilingRequest | Filing request parameters
try {
    RecurringGatewayCreationResponse result = apiInstance.createFiling(filingRequest);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RecurringsApi#createFiling");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **filingRequest** | [**FilingRequest**](FilingRequest.md)| Filing request parameters | [optional]

### Return type

[**RecurringGatewayCreationResponse**](RecurringGatewayCreationResponse.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="createPlan"></a>
# **createPlan**
> RecurringPlanResponse createPlan(recurringPlanRequest)

Create recurring plan

### Example
```java
// Import classes:
//import com.cardpay.sdk.client.ApiClient;
//import com.cardpay.sdk.client.ApiException;
//import com.cardpay.sdk.client.Configuration;
//import com.cardpay.sdk.client.auth.*;
//import com.cardpay.sdk.api.RecurringsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

RecurringsApi apiInstance = new RecurringsApi();
RecurringPlanRequest recurringPlanRequest = new RecurringPlanRequest(); // RecurringPlanRequest | recurringPlanRequest
try {
    RecurringPlanResponse result = apiInstance.createPlan(recurringPlanRequest);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RecurringsApi#createPlan");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **recurringPlanRequest** | [**RecurringPlanRequest**](RecurringPlanRequest.md)| recurringPlanRequest |

### Return type

[**RecurringPlanResponse**](RecurringPlanResponse.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="createRecurring"></a>
# **createRecurring**
> RecurringGatewayCreationResponse createRecurring(recurringRequest)

Create recurring

### Example
```java
// Import classes:
//import com.cardpay.sdk.client.ApiClient;
//import com.cardpay.sdk.client.ApiException;
//import com.cardpay.sdk.client.Configuration;
//import com.cardpay.sdk.client.auth.*;
//import com.cardpay.sdk.api.RecurringsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

RecurringsApi apiInstance = new RecurringsApi();
RecurringCreationRequest recurringRequest = new RecurringCreationRequest(); // RecurringCreationRequest | Recurring Request
try {
    RecurringGatewayCreationResponse result = apiInstance.createRecurring(recurringRequest);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RecurringsApi#createRecurring");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **recurringRequest** | [**RecurringCreationRequest**](RecurringCreationRequest.md)| Recurring Request |

### Return type

[**RecurringGatewayCreationResponse**](RecurringGatewayCreationResponse.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deletePlan"></a>
# **deletePlan**
> deletePlan(planId)

Delete plan

### Example
```java
// Import classes:
//import com.cardpay.sdk.client.ApiClient;
//import com.cardpay.sdk.client.ApiException;
//import com.cardpay.sdk.client.Configuration;
//import com.cardpay.sdk.client.auth.*;
//import com.cardpay.sdk.api.RecurringsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

RecurringsApi apiInstance = new RecurringsApi();
String planId = "planId_example"; // String | Plan ID
try {
    apiInstance.deletePlan(planId);
} catch (ApiException e) {
    System.err.println("Exception when calling RecurringsApi#deletePlan");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **planId** | **String**| Plan ID |

### Return type

null (empty response body)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*

<a name="getAuthenticationData2"></a>
# **getAuthenticationData2**
> AuthenticationDataResponse getAuthenticationData2(recurringId)

Get recurring payment 3DS result information

### Example
```java
// Import classes:
//import com.cardpay.sdk.client.ApiClient;
//import com.cardpay.sdk.client.ApiException;
//import com.cardpay.sdk.client.Configuration;
//import com.cardpay.sdk.client.auth.*;
//import com.cardpay.sdk.api.RecurringsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

RecurringsApi apiInstance = new RecurringsApi();
String recurringId = "recurringId_example"; // String | Recurring ID
try {
    AuthenticationDataResponse result = apiInstance.getAuthenticationData2(recurringId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RecurringsApi#getAuthenticationData2");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **recurringId** | **String**| Recurring ID |

### Return type

[**AuthenticationDataResponse**](AuthenticationDataResponse.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getChangeStatusClaim"></a>
# **getChangeStatusClaim**
> ChangeSubscriptionStatusClaimResponse getChangeStatusClaim(claimId, subscriptionId)

Get information about Change subscription status claim

### Example
```java
// Import classes:
//import com.cardpay.sdk.client.ApiClient;
//import com.cardpay.sdk.client.ApiException;
//import com.cardpay.sdk.client.Configuration;
//import com.cardpay.sdk.client.auth.*;
//import com.cardpay.sdk.api.RecurringsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

RecurringsApi apiInstance = new RecurringsApi();
String claimId = "claimId_example"; // String | claimId
String subscriptionId = "subscriptionId_example"; // String | subscription id
try {
    ChangeSubscriptionStatusClaimResponse result = apiInstance.getChangeStatusClaim(claimId, subscriptionId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RecurringsApi#getChangeStatusClaim");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **claimId** | **String**| claimId |
 **subscriptionId** | **String**| subscription id |

### Return type

[**ChangeSubscriptionStatusClaimResponse**](ChangeSubscriptionStatusClaimResponse.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getFiling"></a>
# **getFiling**
> RecurringResponse getFiling(filingId)

Get filing order information

### Example
```java
// Import classes:
//import com.cardpay.sdk.client.ApiClient;
//import com.cardpay.sdk.client.ApiException;
//import com.cardpay.sdk.client.Configuration;
//import com.cardpay.sdk.client.auth.*;
//import com.cardpay.sdk.api.RecurringsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

RecurringsApi apiInstance = new RecurringsApi();
String filingId = "filingId_example"; // String | filing order id
try {
    RecurringResponse result = apiInstance.getFiling(filingId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RecurringsApi#getFiling");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **filingId** | **String**| filing order id |

### Return type

[**RecurringResponse**](RecurringResponse.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getPlan"></a>
# **getPlan**
> RecurringPlanResponse getPlan(planId)

Get plan information

### Example
```java
// Import classes:
//import com.cardpay.sdk.client.ApiClient;
//import com.cardpay.sdk.client.ApiException;
//import com.cardpay.sdk.client.Configuration;
//import com.cardpay.sdk.client.auth.*;
//import com.cardpay.sdk.api.RecurringsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

RecurringsApi apiInstance = new RecurringsApi();
String planId = "planId_example"; // String | Plan ID
try {
    RecurringPlanResponse result = apiInstance.getPlan(planId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RecurringsApi#getPlan");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **planId** | **String**| Plan ID |

### Return type

[**RecurringPlanResponse**](RecurringPlanResponse.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getPlans"></a>
# **getPlans**
> PlanDataList getPlans(requestId, maxCount, offset, sortOrder)

Get plans information

### Example
```java
// Import classes:
//import com.cardpay.sdk.client.ApiClient;
//import com.cardpay.sdk.client.ApiException;
//import com.cardpay.sdk.client.Configuration;
//import com.cardpay.sdk.client.auth.*;
//import com.cardpay.sdk.api.RecurringsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

RecurringsApi apiInstance = new RecurringsApi();
String requestId = "2253145"; // String | Request ID
Integer maxCount = 10; // Integer | Limit number of returned plans (must be less than 10000, default is 1000)
Integer offset = 10; // Integer | Offset (must be less than 10000)
String sortOrder = "asc"; // String | Sort based on order of results. 'asc' for ascending order or 'desc' for descending order (default value)
try {
    PlanDataList result = apiInstance.getPlans(requestId, maxCount, offset, sortOrder);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RecurringsApi#getPlans");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **requestId** | **String**| Request ID |
 **maxCount** | **Integer**| Limit number of returned plans (must be less than 10000, default is 1000) | [optional]
 **offset** | **Integer**| Offset (must be less than 10000) | [optional]
 **sortOrder** | **String**| Sort based on order of results. &#39;asc&#39; for ascending order or &#39;desc&#39; for descending order (default value) | [optional]

### Return type

[**PlanDataList**](PlanDataList.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getRecurring"></a>
# **getRecurring**
> RecurringResponse getRecurring(recurringId)

Get recurring information

### Example
```java
// Import classes:
//import com.cardpay.sdk.client.ApiClient;
//import com.cardpay.sdk.client.ApiException;
//import com.cardpay.sdk.client.Configuration;
//import com.cardpay.sdk.client.auth.*;
//import com.cardpay.sdk.api.RecurringsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

RecurringsApi apiInstance = new RecurringsApi();
String recurringId = "recurringId_example"; // String | Recurring ID
try {
    RecurringResponse result = apiInstance.getRecurring(recurringId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RecurringsApi#getRecurring");
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

<a name="getRecurrings"></a>
# **getRecurrings**
> RecurringsList getRecurrings(requestId, currency, endTime, maxCount, merchantOrderId, paymentMethod, recurringTypes, sortOrder, startTime, type)

Get recurring list information

### Example
```java
// Import classes:
//import com.cardpay.sdk.client.ApiClient;
//import com.cardpay.sdk.client.ApiException;
//import com.cardpay.sdk.client.Configuration;
//import com.cardpay.sdk.client.auth.*;
//import com.cardpay.sdk.api.RecurringsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

RecurringsApi apiInstance = new RecurringsApi();
String requestId = "2253145"; // String | Request ID
String currency = "USD"; // String | [ISO 4217](https://en.wikipedia.org/wiki/ISO_4217) currency code of transactions currency
OffsetDateTime endTime = OffsetDateTime.now(); // OffsetDateTime | Date and time up to milliseconds (in [ISO 8601](https://en.wikipedia.org/wiki/ISO_8601) format) when requested period ends (not inclusive), UTC time, must be less than 7 days after 'start_time', default is current time (format: yyyy-MM-dd'T'HH:mm:ss'Z')
Integer maxCount = 10; // Integer | Limit number of returned transactions (must be less than 10000, default is 1000, minimal value is 1)
String merchantOrderId = "order00017"; // String | Merchant order number from the merchant system
String paymentMethod = "BANKCARD"; // String | Used payment method type name from payment methods list
List<String> recurringTypes = Arrays.asList("recurringTypes_example"); // List<String> | 
String sortOrder = "asc"; // String | Sort based on order of results. `asc` for ascending order or `desc` for descending order (default value)
OffsetDateTime startTime = OffsetDateTime.now(); // OffsetDateTime | Date and time up to milliseconds (in [ISO 8601](https://en.wikipedia.org/wiki/ISO_8601) format) when requested period starts (inclusive), UTC time, default is 24 hours before 'end_time' (format: yyyy-MM-dd'T'HH:mm:ss'Z')
String type = "SCHEDULED"; // String | Filter recurring payments by certain type (applicable to /api/recurrings endpoint only): `SCHEDULED` for scheduled recurring payments `ONECLICK` for one-click payments `INSTALLMENT` for installment payments
try {
    RecurringsList result = apiInstance.getRecurrings(requestId, currency, endTime, maxCount, merchantOrderId, paymentMethod, recurringTypes, sortOrder, startTime, type);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RecurringsApi#getRecurrings");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **requestId** | **String**| Request ID |
 **currency** | **String**| [ISO 4217](https://en.wikipedia.org/wiki/ISO_4217) currency code of transactions currency | [optional]
 **endTime** | **OffsetDateTime**| Date and time up to milliseconds (in [ISO 8601](https://en.wikipedia.org/wiki/ISO_8601) format) when requested period ends (not inclusive), UTC time, must be less than 7 days after &#39;start_time&#39;, default is current time (format: yyyy-MM-dd&#39;T&#39;HH:mm:ss&#39;Z&#39;) | [optional]
 **maxCount** | **Integer**| Limit number of returned transactions (must be less than 10000, default is 1000, minimal value is 1) | [optional]
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

<a name="getSubscription"></a>
# **getSubscription**
> SubscriptionGetResponse getSubscription(subscriptionId)

Get subscription information

### Example
```java
// Import classes:
//import com.cardpay.sdk.client.ApiClient;
//import com.cardpay.sdk.client.ApiException;
//import com.cardpay.sdk.client.Configuration;
//import com.cardpay.sdk.client.auth.*;
//import com.cardpay.sdk.api.RecurringsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

RecurringsApi apiInstance = new RecurringsApi();
String subscriptionId = "subscriptionId_example"; // String | subscription id
try {
    SubscriptionGetResponse result = apiInstance.getSubscription(subscriptionId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RecurringsApi#getSubscription");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **subscriptionId** | **String**| subscription id |

### Return type

[**SubscriptionGetResponse**](SubscriptionGetResponse.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getSubscriptions"></a>
# **getSubscriptions**
> SubscriptionList getSubscriptions(requestId, accountId, currency, endTime, maxCount, offset, planId, sortOrder, startTime, status, type)

Get subscription information

### Example
```java
// Import classes:
//import com.cardpay.sdk.client.ApiClient;
//import com.cardpay.sdk.client.ApiException;
//import com.cardpay.sdk.client.Configuration;
//import com.cardpay.sdk.client.auth.*;
//import com.cardpay.sdk.api.RecurringsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

RecurringsApi apiInstance = new RecurringsApi();
String requestId = "2253145"; // String | Request ID
String accountId = "1234"; // String | Merchant identifier of customer account
String currency = "USD"; // String | [ISO 4217](https://en.wikipedia.org/wiki/ISO_4217) currency code of transactions currency
OffsetDateTime endTime = OffsetDateTime.now(); // OffsetDateTime | Date and time up to milliseconds (in [ISO 8601](https://en.wikipedia.org/wiki/ISO_8601) format) when requested period ends (not inclusive), UTC time, must be less than 7 days after 'start_time', default is current time (format: yyyy-MM-dd'T'HH:mm:ss'Z')
Integer maxCount = 10; // Integer | Limit number of returned subscriptions (must be less than 10000, default is 1000)
Integer offset = 10; // Integer | Offset (must be less than 10000)
String planId = "Xb12aF1"; // String | Id of plan. Use for searching scheduled subscriptions by plan
String sortOrder = "asc"; // String | Sort based on order of results. 'asc' for ascending order or 'desc' for descending order (default value)
OffsetDateTime startTime = OffsetDateTime.now(); // OffsetDateTime | Date and time up to milliseconds (in [ISO 8601](https://en.wikipedia.org/wiki/ISO_8601) format) when requested period starts (inclusive), UTC time, default is 24 hours before 'end_time' (format: yyyy-MM-dd'T'HH:mm:ss'Z')
String status = "CANCELLED"; // String | Status of subscription
String type = "SCHEDULED"; // String | Type of subscription. 'ONECLICK' type will be ignored.
try {
    SubscriptionList result = apiInstance.getSubscriptions(requestId, accountId, currency, endTime, maxCount, offset, planId, sortOrder, startTime, status, type);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RecurringsApi#getSubscriptions");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **requestId** | **String**| Request ID |
 **accountId** | **String**| Merchant identifier of customer account | [optional]
 **currency** | **String**| [ISO 4217](https://en.wikipedia.org/wiki/ISO_4217) currency code of transactions currency | [optional]
 **endTime** | **OffsetDateTime**| Date and time up to milliseconds (in [ISO 8601](https://en.wikipedia.org/wiki/ISO_8601) format) when requested period ends (not inclusive), UTC time, must be less than 7 days after &#39;start_time&#39;, default is current time (format: yyyy-MM-dd&#39;T&#39;HH:mm:ss&#39;Z&#39;) | [optional]
 **maxCount** | **Integer**| Limit number of returned subscriptions (must be less than 10000, default is 1000) | [optional]
 **offset** | **Integer**| Offset (must be less than 10000) | [optional]
 **planId** | **String**| Id of plan. Use for searching scheduled subscriptions by plan | [optional]
 **sortOrder** | **String**| Sort based on order of results. &#39;asc&#39; for ascending order or &#39;desc&#39; for descending order (default value) | [optional]
 **startTime** | **OffsetDateTime**| Date and time up to milliseconds (in [ISO 8601](https://en.wikipedia.org/wiki/ISO_8601) format) when requested period starts (inclusive), UTC time, default is 24 hours before &#39;end_time&#39; (format: yyyy-MM-dd&#39;T&#39;HH:mm:ss&#39;Z&#39;) | [optional]
 **status** | **String**| Status of subscription | [optional] [enum: ACTIVE, INACTIVE, CANCELLED, PAST_DUE, PENDING, COMPLETED, CARD_EXPIRED, ACTIVATION_FAILED]
 **type** | **String**| Type of subscription. &#39;ONECLICK&#39; type will be ignored. | [optional] [enum: ONECLICK, SCHEDULED, INSTALLMENT]

### Return type

[**SubscriptionList**](SubscriptionList.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="updatePlan"></a>
# **updatePlan**
> PlanUpdateResponse updatePlan(planId, planUpdateRequest)

Update plan

### Example
```java
// Import classes:
//import com.cardpay.sdk.client.ApiClient;
//import com.cardpay.sdk.client.ApiException;
//import com.cardpay.sdk.client.Configuration;
//import com.cardpay.sdk.client.auth.*;
//import com.cardpay.sdk.api.RecurringsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

RecurringsApi apiInstance = new RecurringsApi();
String planId = "planId_example"; // String | Plan ID
PlanUpdateRequest planUpdateRequest = new PlanUpdateRequest(); // PlanUpdateRequest | planUpdateRequest
try {
    PlanUpdateResponse result = apiInstance.updatePlan(planId, planUpdateRequest);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RecurringsApi#updatePlan");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **planId** | **String**| Plan ID |
 **planUpdateRequest** | [**PlanUpdateRequest**](PlanUpdateRequest.md)| planUpdateRequest |

### Return type

[**PlanUpdateResponse**](PlanUpdateResponse.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateRecurring"></a>
# **updateRecurring**
> RecurringUpdateResponse updateRecurring(recurringId, recurringPatchRequest)

Update recurring

### Example
```java
// Import classes:
//import com.cardpay.sdk.client.ApiClient;
//import com.cardpay.sdk.client.ApiException;
//import com.cardpay.sdk.client.Configuration;
//import com.cardpay.sdk.client.auth.*;
//import com.cardpay.sdk.api.RecurringsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

RecurringsApi apiInstance = new RecurringsApi();
String recurringId = "recurringId_example"; // String | Recurring ID
RecurringPatchRequest recurringPatchRequest = new RecurringPatchRequest(); // RecurringPatchRequest | recurringPatchRequest
try {
    RecurringUpdateResponse result = apiInstance.updateRecurring(recurringId, recurringPatchRequest);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RecurringsApi#updateRecurring");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **recurringId** | **String**| Recurring ID |
 **recurringPatchRequest** | [**RecurringPatchRequest**](RecurringPatchRequest.md)| recurringPatchRequest |

### Return type

[**RecurringUpdateResponse**](RecurringUpdateResponse.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateSubscription"></a>
# **updateSubscription**
> SubscriptionUpdateResponse updateSubscription(subscriptionId, subscriptionUpdateRequest)

Update subscription

### Example
```java
// Import classes:
//import com.cardpay.sdk.client.ApiClient;
//import com.cardpay.sdk.client.ApiException;
//import com.cardpay.sdk.client.Configuration;
//import com.cardpay.sdk.client.auth.*;
//import com.cardpay.sdk.api.RecurringsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: Bearer
ApiKeyAuth Bearer = (ApiKeyAuth) defaultClient.getAuthentication("Bearer");
Bearer.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//Bearer.setApiKeyPrefix("Token");

RecurringsApi apiInstance = new RecurringsApi();
String subscriptionId = "subscriptionId_example"; // String | Subscription ID
SubscriptionUpdateRequest subscriptionUpdateRequest = new SubscriptionUpdateRequest(); // SubscriptionUpdateRequest | subscriptionUpdateRequest
try {
    SubscriptionUpdateResponse result = apiInstance.updateSubscription(subscriptionId, subscriptionUpdateRequest);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling RecurringsApi#updateSubscription");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **subscriptionId** | **String**| Subscription ID |
 **subscriptionUpdateRequest** | [**SubscriptionUpdateRequest**](SubscriptionUpdateRequest.md)| subscriptionUpdateRequest |

### Return type

[**SubscriptionUpdateResponse**](SubscriptionUpdateResponse.md)

### Authorization

[Bearer](../README.md#Bearer)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json


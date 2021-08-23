
# RecurringFilterParameters

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**requestId** | **String** | Request ID | 
**merchantOrderId** | **String** | Merchant order number from the merchant system |  [optional]
**paymentMethod** | **String** | Used payment method type name from payment methods list |  [optional]
**startTime** | [**OffsetDateTime**](OffsetDateTime.md) | Date and time up to milliseconds (in [ISO 8601](https://en.wikipedia.org/wiki/ISO_8601) format) when requested period starts (inclusive), UTC time, default is 24 hours before &#39;end_time&#39; (format: yyyy-MM-dd&#39;T&#39;HH:mm:ss&#39;Z&#39;) |  [optional]
**endTime** | [**OffsetDateTime**](OffsetDateTime.md) | Date and time up to milliseconds (in [ISO 8601](https://en.wikipedia.org/wiki/ISO_8601) format) when requested period ends (not inclusive), UTC time, must be less than 7 days after &#39;start_time&#39;, default is current time (format: yyyy-MM-dd&#39;T&#39;HH:mm:ss&#39;Z&#39;) |  [optional]
**maxCount** | **Integer** | Limit number of returned transactions (must be less than 10000, default is 1000, minimal value is 1) |  [optional]
**sortOrder** | [**SortOrderEnum**](#SortOrderEnum) | Sort based on order of results. &#x60;asc&#x60; for ascending order or &#x60;desc&#x60; for descending order (default value) |  [optional]
**currency** | **String** | [ISO 4217](https://en.wikipedia.org/wiki/ISO_4217) currency code of transactions currency |  [optional]
**type** | [**TypeEnum**](#TypeEnum) | Filter recurring payments by certain type (applicable to /api/recurrings endpoint only): &#x60;SCHEDULED&#x60; for scheduled recurring payments &#x60;ONECLICK&#x60; for one-click payments &#x60;INSTALLMENT&#x60; for installment payments |  [optional]


<a name="SortOrderEnum"></a>
## Enum: SortOrderEnum
Name | Value
---- | -----
ASC | &quot;asc&quot;
DESC | &quot;desc&quot;


<a name="TypeEnum"></a>
## Enum: TypeEnum
Name | Value
---- | -----
ONECLICK | &quot;ONECLICK&quot;
SCHEDULED | &quot;SCHEDULED&quot;
INSTALLMENT | &quot;INSTALLMENT&quot;




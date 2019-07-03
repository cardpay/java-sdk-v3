
# SubscriptionFilterParameters

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**requestId** | **String** | Request ID | 
**maxCount** | **Integer** | Limit number of returned subscriptions (must be less than 10000, default is 1000) |  [optional]
**offset** | **Integer** | Offset (must be less than 10000) |  [optional]
**sortOrder** | **String** | Sort based on order of results. &#39;asc&#39; for ascending order or &#39;desc&#39; for descending order (default value) |  [optional]
**customerId** | **String** | Merchant identifier of customer account |  [optional]
**planId** | **String** | Id of plan. Use for searching scheduled subscriptions by plan |  [optional]
**startTime** | [**OffsetDateTime**](OffsetDateTime.md) | Date and time up to milliseconds (in [ISO 8601](https://en.wikipedia.org/wiki/ISO_8601) format) when requested period starts (inclusive), UTC time, default is 24 hours before &#39;end_time&#39; (format: yyyy-MM-dd&#39;T&#39;HH:mm:ss&#39;Z&#39;) |  [optional]
**endTime** | [**OffsetDateTime**](OffsetDateTime.md) | Date and time up to milliseconds (in [ISO 8601](https://en.wikipedia.org/wiki/ISO_8601) format) when requested period ends (not inclusive), UTC time, must be less than 7 days after &#39;start_time&#39;, default is current time (format: yyyy-MM-dd&#39;T&#39;HH:mm:ss&#39;Z&#39;) |  [optional]
**currency** | **String** | [ISO 4217](https://en.wikipedia.org/wiki/ISO_4217) currency code of transactions currency |  [optional]
**status** | [**StatusEnum**](#StatusEnum) | Status of subscription |  [optional]
**type** | [**TypeEnum**](#TypeEnum) | Type of subscription. &#39;ONECLICK&#39; type will be ignored. |  [optional]


<a name="StatusEnum"></a>
## Enum: StatusEnum
Name | Value
---- | -----
ACTIVE | &quot;ACTIVE&quot;
INACTIVE | &quot;INACTIVE&quot;
CANCELLED | &quot;CANCELLED&quot;
PAST_DUE | &quot;PAST_DUE&quot;
PENDING | &quot;PENDING&quot;
COMPLETED | &quot;COMPLETED&quot;
CARD_EXPIRED | &quot;CARD_EXPIRED&quot;


<a name="TypeEnum"></a>
## Enum: TypeEnum
Name | Value
---- | -----
ONECLICK | &quot;ONECLICK&quot;
SCHEDULED | &quot;SCHEDULED&quot;
INSTALLMENT | &quot;INSTALLMENT&quot;




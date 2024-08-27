
# ResponsePlanData

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **String** | ID of created plan |  [optional]
**name** | **String** | Name of created plan |  [optional]
**created** | [**OffsetDateTime**](OffsetDateTime.md) | Creation time, [ISO 8601](https://en.wikipedia.org/wiki/ISO_8601) format |  [optional]
**status** | [**StatusEnum**](#StatusEnum) | Status of created plan: &#39;ACTIVE&#39; or &#39;INACTIVE&#39; |  [optional]
**period** | [**PeriodEnum**](#PeriodEnum) | Period of created plan |  [optional]
**interval** | **Integer** | Interval of plan |  [optional]
**currency** | **String** | [ISO 4217](https://en.wikipedia.org/wiki/ISO_4217) currency code of created plan |  [optional]
**amount** | [**BigDecimal**](BigDecimal.md) | The total amount of created plan |  [optional]
**retries** | **Integer** | Number of daily basis retry attempts in case of payment has not been captured successfully, from 1 to 15 attempts |  [optional]
**pricingModel** | **String** | Parameter regulates the price calculation pricing_model depending on the number of units. Possible values: &#x60;FIXED&#x60; &#x60;TIERED&#x60; &#x60;VOLUME&#x60; |  [optional]
**quantity** | [**List&lt;PlanQuantity&gt;**](PlanQuantity.md) | Array with units params |  [optional]
**subscriptionDeclineLogic** | [**PlanSubscriptionDeclineLogic**](PlanSubscriptionDeclineLogic.md) | Subscription decline logic |  [optional]


<a name="StatusEnum"></a>
## Enum: StatusEnum
Name | Value
---- | -----
ACTIVE | &quot;ACTIVE&quot;
INACTIVE | &quot;INACTIVE&quot;


<a name="PeriodEnum"></a>
## Enum: PeriodEnum
Name | Value
---- | -----
MINUTE | &quot;minute&quot;
DAY | &quot;day&quot;
WEEK | &quot;week&quot;
MONTH | &quot;month&quot;
YEAR | &quot;year&quot;




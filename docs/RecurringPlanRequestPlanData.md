
# RecurringPlanRequestPlanData

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**amount** | [**BigDecimal**](BigDecimal.md) | The amount charged per period defined in plan in selected currency with dot as a decimal separator, limit is defined by payment method and transaction details. | 
**currency** | **String** | [ISO 4217](https://en.wikipedia.org/wiki/ISO_4217) currency code of plan | 
**interval** | **Integer** | The frequency interval of period, can be 1-365 depending on selected period value. Maximum value of period + interval can be 365 days / 52 weeks / 12 months / 1 year. From 1 to 60 minutes - for **sandbox** environment and testing purpose only | 
**name** | **String** | Plan name | 
**period** | [**PeriodEnum**](#PeriodEnum) | Initial period of recurring, can be &#x60;day&#x60;, &#x60;week&#x60;, &#x60;month&#x60;, &#x60;year&#x60;. Additional period: &#x60;minute&#x60; - for **sandbox** and testing purpose only. | 
**pricingModel** | **String** | Parameter regulates the price calculation pricing_model depending on the number of units Possible values: &#x60;FIXED&#x60; &#x60;TIERED&#x60; &#x60;VOLUME&#x60; By default - &#x60;FIXED&#x60; |  [optional]
**quantity** | [**List&lt;PlanQuantity&gt;**](PlanQuantity.md) | Array with units quantity. Mandatory if &#x60;pricing_model&#x60; is &#x60;TIERED&#x60; or &#x60;VOLUME&#x60; |  [optional]
**retries** | **Integer** | Number of daily basis retry attempts in case of payment has not been captured successfully, from 1 to 15 attempts can be specified. |  [optional]
**retry** | [**PlanRetry**](PlanRetry.md) | Structure for establishing the logic of retries for subscription based on created plan |  [optional]
**subscriptionDeclineLogic** | [**PlanSubscriptionDeclineLogic**](PlanSubscriptionDeclineLogic.md) | Subscription decline logic |  [optional]


<a name="PeriodEnum"></a>
## Enum: PeriodEnum
Name | Value
---- | -----
MINUTE | &quot;minute&quot;
DAY | &quot;day&quot;
WEEK | &quot;week&quot;
MONTH | &quot;month&quot;
YEAR | &quot;year&quot;




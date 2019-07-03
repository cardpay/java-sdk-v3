
# RecurringRequestRecurringData

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**amount** | [**BigDecimal**](BigDecimal.md) | The total transaction amount in selected currency with dot as a decimal separator, must be less than 100 millions |  [optional]
**begin** | **Boolean** |  |  [optional]
**currency** | **String** | [ISO 4217](https://en.wikipedia.org/wiki/ISO_4217) currency code | 
**dynamicDescriptor** | **String** | Short description of the service or product, must be enabled by CardPay manager to be used |  [optional]
**filing** | [**RecurringRequestFiling**](RecurringRequestFiling.md) | Filing data, should be send in all recurring requests besides first recurring request First recurring request should be send without filing attribute |  [optional]
**generateToken** | **Boolean** | If set to &#x60;true&#x60;, token will be generated and returned in the response |  [optional]
**initiator** | **String** | Can be only 2 values: &#x60;mit&#x60; (merchant initiated transaction), &#x60;cit&#x60; (cardholder initiated transaction) |  [optional]
**interval** | **Integer** | Frequency interval of period, can be 1-365 depending on selected period value. Minimum value of period + interval can be 7 days / 1 week. Maximum value of period + interval plan can be 365 days / 52 weeks / 12 months / 1 year. 1-60 minutes - for **sandbox environment** and testing purpose only. |  [optional]
**note** | **String** | Note about the transaction that will not be displayed to customer |  [optional]
**payments** | **Integer** | Number of total payments to be charged per defined interval, can be 2-200. |  [optional]
**period** | [**PeriodEnum**](#PeriodEnum) | Initial period of recurring, can be &#x60;day&#x60;, &#x60;week&#x60;, &#x60;month&#x60;, &#x60;year&#x60;.  &#x60;minute&#x60; - for **sandbox environment** and testing purpose only. |  [optional]
**plan** | [**Plan**](Plan.md) | Plan data |  [optional]
**preauth** | **Boolean** | This parameter is allowed to be used only for first recurring payment. If set to &#x60;true&#x60;, the amount will not be captured but only blocked *(for BANKCARD payment method only)*. |  [optional]
**retries** | **Integer** | Number of daily basis retry attempts in case of payment has not been captured successfully, from 1 to 15 attempts can be specified. |  [optional]
**subscriptionStart** | [**OffsetDateTime**](OffsetDateTime.md) | The date in yyyy-MM-dd format when subscription will actually become activated (grace period). Auth request will be created but Customer will be charged only when subscription start date comes. Leave it empty or specify the current date to activate subscription at once without any grace period applied. |  [optional]


<a name="PeriodEnum"></a>
## Enum: PeriodEnum
Name | Value
---- | -----
MINUTE | &quot;minute&quot;
DAY | &quot;day&quot;
WEEK | &quot;week&quot;
MONTH | &quot;month&quot;
YEAR | &quot;year&quot;




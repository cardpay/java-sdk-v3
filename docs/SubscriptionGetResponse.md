
# SubscriptionGetResponse

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**amountDue** | [**BigDecimal**](BigDecimal.md) | Amount of payments left to be captured |  [optional]
**amountTotal** | [**BigDecimal**](BigDecimal.md) | Total amount of subscription to be paid before completion |  [optional]
**created** | [**OffsetDateTime**](OffsetDateTime.md) | Creation time [ISO 8601](https://en.wikipedia.org/wiki/ISO_8601) format |  [optional]
**currency** | **String** | [ISO 4217](https://en.wikipedia.org/wiki/ISO_4217) currency code |  [optional]
**customer** | [**PayoutResponseCustomer**](PayoutResponseCustomer.md) | Customer data |  [optional]
**description** | **String** | Description of subscription |  [optional]
**id** | **String** | ID of subscription |  [optional]
**interval** | **Integer** | Interval of subscription |  [optional]
**nextPayment** | [**NextSubscriptionPayment**](NextSubscriptionPayment.md) | Next payment data |  [optional]
**paymentsDue** | **Integer** | Number of payments left to be captured |  [optional]
**period** | [**PeriodEnum**](#PeriodEnum) | Period of subscription |  [optional]
**plan** | [**Plan**](Plan.md) | Plan data |  [optional]
**retries** | **Integer** | Number of daily basis retry attempts in case of payment has not been captured successfully. |  [optional]
**status** | [**StatusEnum**](#StatusEnum) | Status of subscription |  [optional]
**statusReason** | **String** | Reason of subscription cancellation that was made by CardPay |  [optional]
**subscriptionStart** | [**OffsetDateTime**](OffsetDateTime.md) | The time in &#39;yyyy-MM-dd&#39; format when subscription actually becomes activated (grace period) |  [optional]
**type** | [**TypeEnum**](#TypeEnum) | Recurring payment type name; can be ONECLICK, SCHEDULED, INSTALLMENT |  [optional]


<a name="PeriodEnum"></a>
## Enum: PeriodEnum
Name | Value
---- | -----
MINUTE | &quot;minute&quot;
DAY | &quot;day&quot;
WEEK | &quot;week&quot;
MONTH | &quot;month&quot;
YEAR | &quot;year&quot;


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





# UpdatedSubscriptionData

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**changeStatusClaimId** | **String** | ID of claim; appears in case of request change was processed asynchronously and put in queue. Mandatory if request was put in queue. |  [optional]
**details** | **String** | Operation details, errors, etc. |  [optional]
**filing** | [**RecurringResponseFiling**](RecurringResponseFiling.md) | Filing data |  [optional]
**id** | **String** | ID of subscription |  [optional]
**isExecuted** | **Boolean** | Status of operation |  [optional]
**nextPaymentDate** | [**OffsetDateTime**](OffsetDateTime.md) |  |  [optional]
**plan** | [**Plan**](Plan.md) | Plan data |  [optional]
**recurringData** | [**UpdatedSubscriptionRecurringData**](UpdatedSubscriptionRecurringData.md) | Recurring data |  [optional]
**remainingAmount** | [**BigDecimal**](BigDecimal.md) | The amount remained to be paid after repayment operation. Mandatory for &#x60;REPAYMENT&#x60; operation only |  [optional]
**status** | [**StatusEnum**](#StatusEnum) | Resulted status of subscription |  [optional]
**statusTo** | [**StatusToEnum**](#StatusToEnum) | Requested status of subscription. Mandatory for &#x60;CHANGE_STATUS&#x60; operation only. |  [optional]
**units** | **Integer** | New quantity of subscription units |  [optional]
**updated** | [**OffsetDateTime**](OffsetDateTime.md) | If request is successful then date and time returned in [ISO 8601](https://en.wikipedia.org/wiki/ISO_8601) format (format - yyyy-MM-dd&#39;T&#39;HH:mm:ss&#39;Z&#39;). |  [optional]


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
ACTIVATION_FAILED | &quot;ACTIVATION_FAILED&quot;
UNPAID | &quot;UNPAID&quot;
WAITING | &quot;WAITING&quot;


<a name="StatusToEnum"></a>
## Enum: StatusToEnum
Name | Value
---- | -----
ACTIVE | &quot;ACTIVE&quot;
INACTIVE | &quot;INACTIVE&quot;
CANCELLED | &quot;CANCELLED&quot;
PAST_DUE | &quot;PAST_DUE&quot;
PENDING | &quot;PENDING&quot;
COMPLETED | &quot;COMPLETED&quot;
CARD_EXPIRED | &quot;CARD_EXPIRED&quot;
ACTIVATION_FAILED | &quot;ACTIVATION_FAILED&quot;
UNPAID | &quot;UNPAID&quot;
WAITING | &quot;WAITING&quot;




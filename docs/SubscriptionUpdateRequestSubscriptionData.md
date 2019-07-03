
# SubscriptionUpdateRequestSubscriptionData

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**amount** | [**BigDecimal**](BigDecimal.md) | Set amount of repayment with dot as a decimal separator. Skip this attribute from request to repay the rest of subscription&#39;s amount and complete it. Mandatory for &#x60;REPAYMENT&#x60; operation only with exact payment amount. |  [optional]
**filing** | [**RecurringRequestFiling**](RecurringRequestFiling.md) | Filing data. Mandatory for &#x60;CHANGE_FILING&#x60; operation only. |  [optional]
**statusTo** | [**StatusToEnum**](#StatusToEnum) | Set status and action on subscription. Mandatory for &#x60;CHANGE_STATUS&#x60; operation only: &#x60;CANCELLED&#x60; - cancels and ends &#x60;INACTIVE&#x60; - **for scheduled only**; suspends &#x60;ACTIVE&#x60; - **for scheduled only**; resumes after suspend |  [optional]


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




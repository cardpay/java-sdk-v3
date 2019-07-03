
# SubscriptionUpdateRequest

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**request** | [**Request**](Request.md) | Request | 
**operation** | [**OperationEnum**](#OperationEnum) | Set operation on subscription: &#x60;CHANGE_STATUS&#x60; - initiates status changing &#x60;REPAYMENT&#x60; - **for installment only**; makes repayment in advance &#x60;CHANGE_FILING&#x60; - replaces card binding via new filing id. | 
**subscriptionData** | [**SubscriptionUpdateRequestSubscriptionData**](SubscriptionUpdateRequestSubscriptionData.md) | Subscription data | 


<a name="OperationEnum"></a>
## Enum: OperationEnum
Name | Value
---- | -----
CHANGE_STATUS | &quot;CHANGE_STATUS&quot;
REPAYMENT | &quot;REPAYMENT&quot;
CHANGE_FILING | &quot;CHANGE_FILING&quot;





# ChangeSubscriptionStatusClaimResponse

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**created** | [**OffsetDateTime**](OffsetDateTime.md) | Creation time, [ISO 8601](https://en.wikipedia.org/wiki/ISO_8601) format. |  [optional]
**details** | **String** | Change claim details, errors etc. |  [optional]
**id** | **String** | ID of claim |  [optional]
**status** | [**StatusEnum**](#StatusEnum) | Status of claim: &#x60;IN_PROCESS&#x60; - claim is in queue to being processed &#x60;STOPPED&#x60; - claim failed to be processed &#x60;COMPLETED&#x60; - claim successfully processed |  [optional]
**subscriptionData** | [**ClaimResponseSubscriptionData**](ClaimResponseSubscriptionData.md) | Subscription data |  [optional]
**updated** | [**OffsetDateTime**](OffsetDateTime.md) | Time when claim got the new status, [ISO 8601](https://en.wikipedia.org/wiki/ISO_8601) format. |  [optional]


<a name="StatusEnum"></a>
## Enum: StatusEnum
Name | Value
---- | -----
IN_PROCESS | &quot;IN_PROCESS&quot;
STOPPED | &quot;STOPPED&quot;
COMPLETED | &quot;COMPLETED&quot;




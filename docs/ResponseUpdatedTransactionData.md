
# ResponseUpdatedTransactionData

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**details** | **String** | The reason why request was unsuccessful |  [optional]
**id** | **String** | Represents the ID of the modified transaction |  [optional]
**isExecuted** | **Boolean** | Indicates was the request successful or not |  [optional]
**status** | [**StatusEnum**](#StatusEnum) | Status of modified or created transaction |  [optional]
**statusTo** | [**StatusToEnum**](#StatusToEnum) | Requested action (status to be set).  Payment: &#x60;COMPLETE&#x60; or &#x60;REVERSE&#x60;.  Refund, payout: &#x60;REVERSE&#x60;. |  [optional]
**updated** | [**OffsetDateTime**](OffsetDateTime.md) | Transaction update date and time in [ISO 8601](https://en.wikipedia.org/wiki/ISO_8601) format. Returned only for successful update operations. |  [optional]


<a name="StatusEnum"></a>
## Enum: StatusEnum
Name | Value
---- | -----
NEW | &quot;NEW&quot;
IN_PROGRESS | &quot;IN_PROGRESS&quot;
DECLINED | &quot;DECLINED&quot;
AUTHORIZED | &quot;AUTHORIZED&quot;
COMPLETED | &quot;COMPLETED&quot;
CANCELLED | &quot;CANCELLED&quot;
REFUNDED | &quot;REFUNDED&quot;
VOIDED | &quot;VOIDED&quot;
TERMINATED | &quot;TERMINATED&quot;
CHARGED_BACK | &quot;CHARGED_BACK&quot;
CHARGEBACK_RESOLVED | &quot;CHARGEBACK_RESOLVED&quot;
UNPAID | &quot;UNPAID&quot;
WAITING | &quot;WAITING&quot;


<a name="StatusToEnum"></a>
## Enum: StatusToEnum
Name | Value
---- | -----
REVERSE | &quot;REVERSE&quot;
COMPLETE | &quot;COMPLETE&quot;
TERMINATE | &quot;TERMINATE&quot;




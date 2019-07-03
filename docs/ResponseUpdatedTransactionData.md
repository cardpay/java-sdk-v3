
# ResponseUpdatedTransactionData

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**details** | **String** | The reason why request was unsuccessful |  [optional]
**id** | **String** | Represents the ID of the modified transaction | 
**isExecuted** | **Boolean** | Indicates was the request successful or not | 
**status** | [**StatusEnum**](#StatusEnum) | Status of modified or created transaction | 
**statusTo** | [**StatusToEnum**](#StatusToEnum) | Requested action (status to be set).  Payment: &#x60;COMPLETE&#x60; or &#x60;REVERSE&#x60;.  Refund, payout: &#x60;REVERSE&#x60;. | 
**updated** | [**OffsetDateTime**](OffsetDateTime.md) | Transaction update date and time up to milliseconds in ISO 8601 format. Return only for successful updates operations. |  [optional]


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
PARTIALLY_REFUNDED | &quot;PARTIALLY_REFUNDED&quot;
VOIDED | &quot;VOIDED&quot;
CHARGED_BACK | &quot;CHARGED_BACK&quot;
CHARGEBACK_RESOLVED | &quot;CHARGEBACK_RESOLVED&quot;


<a name="StatusToEnum"></a>
## Enum: StatusToEnum
Name | Value
---- | -----
REVERSE | &quot;REVERSE&quot;
COMPLETE | &quot;COMPLETE&quot;




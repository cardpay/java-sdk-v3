
# AuthenticationUpdateResponse

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**operation** | [**OperationEnum**](#OperationEnum) | &#x60;CHANGE_STATUS&#x60; value |  [optional]
**merchantOrder** | [**TransactionResponseMerchantOrder**](TransactionResponseMerchantOrder.md) |  |  [optional]
**paymentData** | [**ResponseUpdatedTransactionData**](ResponseUpdatedTransactionData.md) |  |  [optional]


<a name="OperationEnum"></a>
## Enum: OperationEnum
Name | Value
---- | -----
CHANGE_STATUS | &quot;CHANGE_STATUS&quot;
CONFIRM_3DS | &quot;CONFIRM_3DS&quot;
EXECUTE | &quot;EXECUTE&quot;
INCREMENT | &quot;INCREMENT&quot;





# PaymentUpdateRequest

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**request** | [**Request**](Request.md) | Request | 
**operation** | [**OperationEnum**](#OperationEnum) | &#x60;CHANGE_STATUS&#x60; value | 
**paymentData** | [**PaymentUpdateTransactionData**](PaymentUpdateTransactionData.md) | Payment data |  [optional]
**transactionData** | [**PaymentUpdateTransactionData**](PaymentUpdateTransactionData.md) |  |  [optional]


<a name="OperationEnum"></a>
## Enum: OperationEnum
Name | Value
---- | -----
CHANGE_STATUS | &quot;CHANGE_STATUS&quot;
CONFIRM_3DS | &quot;CONFIRM_3DS&quot;
EXECUTE | &quot;EXECUTE&quot;
INCREMENT | &quot;INCREMENT&quot;




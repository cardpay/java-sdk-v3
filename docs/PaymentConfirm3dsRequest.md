
# PaymentConfirm3dsRequest

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**request** | [**Request**](Request.md) | Request | 
**operation** | [**OperationEnum**](#OperationEnum) | &#x60;CONFIRM_3DS&#x60; value | 
**paymentData** | [**PaymentUpdateTransactionData**](PaymentUpdateTransactionData.md) | Payment data |  [optional]
**paRes** | **String** | Bank authentication result *(for BANKCARD payment method only)* | 


<a name="OperationEnum"></a>
## Enum: OperationEnum
Name | Value
---- | -----
CHANGE_STATUS | &quot;CHANGE_STATUS&quot;
CONFIRM_3DS | &quot;CONFIRM_3DS&quot;




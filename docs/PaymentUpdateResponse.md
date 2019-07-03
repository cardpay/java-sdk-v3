
# PaymentUpdateResponse

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**merchantOrder** | [**TransactionResponseMerchantOrder**](TransactionResponseMerchantOrder.md) | Merchant order data |  [optional]
**operation** | [**OperationEnum**](#OperationEnum) | Operation |  [optional]
**paymentData** | [**ResponseUpdatedTransactionData**](ResponseUpdatedTransactionData.md) | Transaction data |  [optional]


<a name="OperationEnum"></a>
## Enum: OperationEnum
Name | Value
---- | -----
CHANGE_STATUS | &quot;CHANGE_STATUS&quot;
CONFIRM_3DS | &quot;CONFIRM_3DS&quot;




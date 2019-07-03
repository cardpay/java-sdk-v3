
# RefundCallback

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**callbackTime** | **String** | Date and time of created callback in [ISO 8601](https://en.wikipedia.org/wiki/ISO_8601) format |  [optional]
**cardAccount** | [**RefundResponseCardAccount**](RefundResponseCardAccount.md) | Card account data *(for BANKCARD payment method only)* |  [optional]
**customer** | [**RefundResponseCustomer**](RefundResponseCustomer.md) | Customer data |  [optional]
**ewalletAccount** | [**TransactionResponseEWalletAccount**](TransactionResponseEWalletAccount.md) | eWallet account data *(for ALIPAY and QIWI payment methods only)* |  [optional]
**merchantOrder** | [**TransactionResponseMerchantOrder**](TransactionResponseMerchantOrder.md) | Merchant order data | 
**paymentData** | [**RefundResponsePaymentData**](RefundResponsePaymentData.md) | Payment data | 
**paymentMethod** | **String** | Used payment method type name from payment methods list | 
**refundData** | [**RefundResponseRefundData**](RefundResponseRefundData.md) | Refund data | 




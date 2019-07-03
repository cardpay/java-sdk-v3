
# RefundResponse

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**cardAccount** | [**RefundResponseCardAccount**](RefundResponseCardAccount.md) | Card account data *(for BANKCARD payment method only)* |  [optional]
**customer** | [**RefundResponseCustomer**](RefundResponseCustomer.md) | Customer data |  [optional]
**ewalletAccount** | [**TransactionResponseEWalletAccount**](TransactionResponseEWalletAccount.md) | eWallet account data *(for ALIPAY and QIWI payment methods only)* |  [optional]
**paymentData** | [**RefundResponsePaymentData**](RefundResponsePaymentData.md) | Payment data | 
**refundData** | [**RefundResponseRefundData**](RefundResponseRefundData.md) | Refund data | 
**paymentMethod** | **String** | Used payment method type name from payment methods list |  [optional]
**merchantOrder** | [**TransactionResponseMerchantOrder**](TransactionResponseMerchantOrder.md) | Merchant order data |  [optional]




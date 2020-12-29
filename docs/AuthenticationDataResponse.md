
# AuthenticationDataResponse

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**merchantOrder** | [**TransactionResponseMerchantOrder**](TransactionResponseMerchantOrder.md) | Merchant order data |  [optional]
**paymentMethod** | **String** | Used payment method type name from payment methods list |  [optional]
**authenticationData** | [**AuthenticationData**](AuthenticationData.md) | Payment authentication data |  [optional]
**cardAccount** | [**PaymentResponseCardAccount**](PaymentResponseCardAccount.md) | Bank card data *(for BANKCARD payment method only)* |  [optional]
**customer** | [**AuthenticationCustomer**](AuthenticationCustomer.md) | Customer data |  [optional]





# PayoutResponse

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**cardAccount** | [**PayoutResponseCardAccount**](PayoutResponseCardAccount.md) | Card account data *(for BANKCARD method only)* |  [optional]
**cryptocurrencyAccount** | [**PayoutResponseCryptocurrencyAccount**](PayoutResponseCryptocurrencyAccount.md) | Cryptocurrency account data *(for BITCOIN method only)* |  [optional]
**customer** | [**PayoutResponseCustomer**](PayoutResponseCustomer.md) | Customer data |  [optional]
**ewalletAccount** | [**PayoutResponseEWalletAccount**](PayoutResponseEWalletAccount.md) | eWallet account data *(for payout methods only)* |  [optional]
**paymentData** | [**PayoutPaymentData**](PayoutPaymentData.md) | Payment data |  [optional]
**payoutData** | [**PayoutResponsePayoutData**](PayoutResponsePayoutData.md) | Payout data | 
**redirectUrl** | **String** | URL Customer should be redirected to |  [optional]
**paymentMethod** | **String** | Used payment method type name from payment methods list |  [optional]
**merchantOrder** | [**TransactionResponseMerchantOrder**](TransactionResponseMerchantOrder.md) | Merchant order data |  [optional]




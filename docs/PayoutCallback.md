
# PayoutCallback

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**callbackTime** | **String** | Date and time of created callback in [ISO 8601](https://en.wikipedia.org/wiki/ISO_8601) format |  [optional]
**cardAccount** | [**PayoutResponseCardAccount**](PayoutResponseCardAccount.md) | Card account data *(for BANKCARD method only)* |  [optional]
**cryptocurrencyAccount** | [**PayoutResponseCryptocurrencyAccount**](PayoutResponseCryptocurrencyAccount.md) | Cryptocurrency account data *(for BITCOIN method only)* |  [optional]
**customer** | [**PayoutResponseCustomer**](PayoutResponseCustomer.md) | Customer data |  [optional]
**ewalletAccount** | [**PayoutResponseEWalletAccount**](PayoutResponseEWalletAccount.md) | eWallet account data *(for payout methods only)* |  [optional]
**merchantOrder** | [**TransactionResponseMerchantOrder**](TransactionResponseMerchantOrder.md) | Merchant order data |  [optional]
**paymentData** | [**PayoutPaymentData**](PayoutPaymentData.md) | Payment data |  [optional]
**paymentMethod** | **String** | Used payment method type name from payment methods list |  [optional]
**payoutData** | [**PayoutResponsePayoutData**](PayoutResponsePayoutData.md) | Payout data |  [optional]




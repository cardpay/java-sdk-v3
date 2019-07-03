
# PayoutRequest

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**request** | [**Request**](Request.md) | Request | 
**cardAccount** | [**PayoutRequestCardAccount**](PayoutRequestCardAccount.md) | Bank card account data *(for BANKCARD method only)* |  [optional]
**cryptocurrencyAccount** | [**PayoutRequestCryptocurrencyAccount**](PayoutRequestCryptocurrencyAccount.md) | Cryptocurrency account data *(for BITCOIN method only)* |  [optional]
**customer** | [**PayoutRequestCustomer**](PayoutRequestCustomer.md) | Customer data |  [optional]
**ewalletAccount** | [**PayoutRequestEWalletAccount**](PayoutRequestEWalletAccount.md) | eWallet account data *(for payout methods only)* |  [optional]
**merchantOrder** | [**PayoutRequestMerchantOrder**](PayoutRequestMerchantOrder.md) | Merchant order | 
**paymentData** | [**PayoutPaymentData**](PayoutPaymentData.md) | Payment data *(for BANKCARD method only)* |  [optional]
**paymentMethod** | **String** | Used payment method type name from methods list | 
**payoutData** | [**PayoutRequestPayoutData**](PayoutRequestPayoutData.md) | Payout data | 




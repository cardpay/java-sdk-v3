
# PaymentCallback

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**callbackTime** | **String** | Date and time of created callback in [ISO 8601](https://en.wikipedia.org/wiki/ISO_8601) format |  [optional]
**cardAccount** | [**PaymentResponseCardAccount**](PaymentResponseCardAccount.md) | Card account data *(for BANKCARD payment method only)* |  [optional]
**cryptocurrencyAccount** | [**PaymentResponseCryptocurrencyAccount**](PaymentResponseCryptocurrencyAccount.md) | Cryptocurrency account data *(for BITCOIN payment method only)* |  [optional]
**customer** | [**PaymentRequestCustomer**](PaymentRequestCustomer.md) | Customer data |  [optional]
**ewalletAccount** | [**TransactionResponseEWalletAccount**](TransactionResponseEWalletAccount.md) | eWallet account data *(for QIWI, WEBMONEY, NETELLER, DIRECTBANKINGNGA, AQRCODE, AIRTEL, MPESA, MTN, UGANDAMOBILE, VODAFONE, TIGO and &#39;Latin America&#39; payment methods only)* |  [optional]
**merchantOrder** | [**TransactionResponseMerchantOrder**](TransactionResponseMerchantOrder.md) | Merchant order data |  [optional]
**paymentData** | [**PaymentResponsePaymentData**](PaymentResponsePaymentData.md) | Payment data |  [optional]
**paymentMethod** | **String** | Used payment method type name from payment methods list |  [optional]




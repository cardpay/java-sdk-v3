
# PaymentResponse

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**ewalletAccount** | [**TransactionResponseEWalletAccount**](TransactionResponseEWalletAccount.md) | eWallet account data *(for ALIPAY, QIWI, WEBMONEY, NETELLER, YANDEXMONEY, DIRECTBANKINGNGA, AQRCODE, AIRTEL, MPESA, MTN, UGANDAMOBILE, VODAFONE, TIGO and &#39;Latin America&#39; payment methods only)* |  [optional]
**paymentMethod** | **String** | Used payment method type name from payment methods list |  [optional]
**merchantOrder** | [**TransactionResponseMerchantOrder**](TransactionResponseMerchantOrder.md) | Merchant order data |  [optional]
**paymentData** | [**PaymentResponsePaymentData**](PaymentResponsePaymentData.md) | Payment data |  [optional]
**cardAccount** | [**PaymentResponseCardAccount**](PaymentResponseCardAccount.md) | Bank card data *(for BANKCARD payment method only)* |  [optional]
**cryptocurrencyAccount** | [**PaymentResponseCryptocurrencyAccount**](PaymentResponseCryptocurrencyAccount.md) | Cryptocurrency account data *(for BITCOIN payment method only)* |  [optional]
**customer** | [**PaymentResponseCustomer**](PaymentResponseCustomer.md) | Customer data |  [optional]




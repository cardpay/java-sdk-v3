
# PaymentResponse

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**customer** | [**PaymentRequestCustomer**](PaymentRequestCustomer.md) | Customer data |  [optional]
**paymentMethod** | **String** | Payment method |  [optional]
**merchantOrder** | [**TransactionResponseMerchantOrder**](TransactionResponseMerchantOrder.md) | Merchant order data |  [optional]
**paymentData** | [**PaymentResponsePaymentData**](PaymentResponsePaymentData.md) | Payment data |  [optional]
**cardAccount** | [**PaymentResponseCardAccount**](PaymentResponseCardAccount.md) | Card account data *(for BANKCARD payment method only)* |  [optional]
**cryptocurrencyAccount** | [**PaymentResponseCryptocurrencyAccount**](PaymentResponseCryptocurrencyAccount.md) | Cryptocurrency account data *(for BITCOIN payment method only)* |  [optional]
**ewalletAccount** | [**TransactionResponseEWalletAccount**](TransactionResponseEWalletAccount.md) | eWallet account data *(for ALIPAY, QIWI, WEBMONEY, NETELLER, YANDEXMONEY, DIRECTBANKINGNGA, AQRCODE, AIRTEL, MPESA, MTN, UGANDAMOBILE, VODAFONE, TIGO and &#39;Latin America&#39; payment methods only)* |  [optional]




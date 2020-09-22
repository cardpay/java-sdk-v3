
# PaymentRequest

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**request** | [**Request**](Request.md) | Request | 
**authenticationData** | [**AuthenticationData**](AuthenticationData.md) | Authentication data |  [optional]
**cardAccount** | [**PaymentRequestCardAccount**](PaymentRequestCardAccount.md) | Information about card *(for BANKCARD payment method only)* | 
**cryptocurrencyAccount** | [**PaymentRequestCryptocurrencyAccount**](PaymentRequestCryptocurrencyAccount.md) | Cryptocurrency data *(for BITCOIN payment method only)* |  [optional]
**customer** | [**PaymentRequestCustomer**](PaymentRequestCustomer.md) | Customer data | 
**ewalletAccount** | [**PaymentRequestEWalletAccount**](PaymentRequestEWalletAccount.md) | eWallet account data *(for all payment method, excluding BANKCARD, BITCOIN, DIRECTBANKINGEU) |  [optional]
**merchantOrder** | [**PaymentRequestMerchantOrder**](PaymentRequestMerchantOrder.md) | Merchant order data | 
**paymentByAuthentication** | **Boolean** |  |  [optional]
**paymentData** | [**PaymentRequestPaymentData**](PaymentRequestPaymentData.md) | Payment data | 
**paymentMethod** | **String** | Used payment method type name from payment methods list |  [optional]
**paymentMethods** | **List&lt;String&gt;** | Array of payment methods to display on Checkout Page. If it is not set then all available methods will be displayed |  [optional]
**returnUrls** | [**ReturnUrls**](ReturnUrls.md) | Return URLs are the URLs where Customer returns by pressing &#39;Back to the shop&#39; or &#39;Cancel&#39; button in Payment page mode and redirected automatically in Gateway mode |  [optional]





# AuthenticationDataRequest

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**request** | [**Request**](Request.md) | Request | 
**authenticationData** | [**AuthDataRequest**](AuthDataRequest.md) | Authentication data | 
**cardAccount** | [**PaymentRequestCardAccount**](PaymentRequestCardAccount.md) | Information about card *(for BANKCARD payment method only)* | 
**customer** | [**PaymentRequestCustomer**](PaymentRequestCustomer.md) | Customer data | 
**merchantOrder** | [**PaymentRequestMerchantOrder**](PaymentRequestMerchantOrder.md) | Merchant order data | 
**paymentMethod** | **String** | Used payment method type name from payment methods list |  [optional]
**returnUrls** | [**ReturnUrls**](ReturnUrls.md) | Return URLs are the URLs where Customer returns by pressing &#39;Back to the shop&#39; or &#39;Cancel&#39; button in Payment page mode and redirected automatically in Gateway mode |  [optional]





# MobilePaymentRequest

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**request** | [**Request**](Request.md) | Request | 
**cardAccount** | [**PaymentRequestCardAccount**](PaymentRequestCardAccount.md) | Information about card *(for BANKCARD payment method only)* |  [optional]
**customer** | [**PaymentRequestCustomer**](PaymentRequestCustomer.md) | Customer data | 
**merchantOrder** | [**MobilePaymentMerchantOrder**](MobilePaymentMerchantOrder.md) | Merchant order data | 
**paymentData** | [**PaymentRequestPaymentData**](PaymentRequestPaymentData.md) | Payment data | 
**paymentMethod** | **String** | Used payment method type name from payment methods list |  [optional]
**returnUrls** | [**ReturnUrls**](ReturnUrls.md) | Return URLs are the URLs where Customer returns by pressing &#39;Back to the shop&#39; or &#39;Cancel&#39; button in Payment page mode and redirected automatically in Gateway mode |  [optional]





# PaymentRequestMerchantOrder

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**cryptocurrencyIndicator** | **Boolean** | Indicator should be added if there will be cryptocurrency purchase in transaction |  [optional]
**description** | **String** | Description of product/service being sold | 
**expireAt** | [**OffsetDateTime**](OffsetDateTime.md) | Payment expiration date and time in ISO 8601 format (example of format - yyyy-MM-dd&#39;T&#39;HH:mm:ss&#39;Z&#39;) Should be UTC time.  Not all payment methods support this options, contact the Unlimit manager for details. |  [optional]
**flights** | [**Flights**](Flights.md) | Flights data *(for BANKCARD payment method only)* |  [optional]
**id** | **String** | Order ID used by Merchant&#39;s shopping cart | 
**items** | [**List&lt;Item&gt;**](Item.md) | Array of items (in the shopping cart) |  [optional]
**shippingAddress** | [**ShippingAddress**](ShippingAddress.md) | Shipping Address |  [optional]




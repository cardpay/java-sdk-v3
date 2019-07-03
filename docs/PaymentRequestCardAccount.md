
# PaymentRequestCardAccount

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**billingAddress** | [**BillingAddress**](BillingAddress.md) | Billing Address |  [optional]
**card** | [**PaymentRequestCard**](PaymentRequestCard.md) | Represents a payment card data. Card section shouldn&#39;t be present if element &#39;token&#39; was presented. Shouldn&#39;t be used in Payment Page mode. For recurring: all card elements should presented only for first recurring payment. |  [optional]
**token** | **String** | Card token value used instead of card information, except card.security_code (it&#39;s mandatory). For payment: see PaymentRequestPaymentData for token generation. For recurring: this attribute is valid only for first recurring payment. It isn&#39;t valid for continue recurring payments (with filing id), see RecurringRequestRecurringData for token generation. |  [optional]




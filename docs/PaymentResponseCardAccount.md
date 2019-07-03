
# PaymentResponseCardAccount

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**expiration** | **String** | Customer’s card expiration date. Format: mm/yyyy. Returned only if setting &#39;Callback: card expiry&#39; in a wallet in PM system is ON |  [optional]
**holder** | **String** | Customer&#39;s cardholder name. Any valid cardholder name. Not present by default, ask CardPay manager to enable it if needed. |  [optional]
**issuingCountryCode** | **String** | Country code of issuing card country |  [optional]
**maskedPan** | **String** | Masked PAN (shows first 6 digits and 4 last digits) |  [optional]
**token** | **String** | Generated card token value. For payment: PaymentResponsePaymentData, for recurring: RecurringResponseRecurringData. Token can be returned only for successful transactions (not for declined transactions) |  [optional]




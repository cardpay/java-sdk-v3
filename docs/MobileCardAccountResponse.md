
# MobileCardAccountResponse

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**acctType** | **String** |  |  [optional]
**expiration** | **String** | Customer’s card expiration date. Format: &#x60;mm/yyyy&#x60; |  [optional]
**holder** | **String** | Customer&#39;s cardholder name. Any valid cardholder name. Not present by default, ask CardPay manager to enable it if needed. |  [optional]
**issuingCountryCode** | **String** | Country code of issuing card country |  [optional]
**maskedPan** | **String** | Masked PAN (shows first 6 digits and 4 last digits) |  [optional]
**token** | **String** | Generated card token value. Token can be returned only for successful transactions (not for declined transactions). For payment: PaymentResponsePaymentData, for recurring: RecurringResponseRecurringData.  |  [optional]




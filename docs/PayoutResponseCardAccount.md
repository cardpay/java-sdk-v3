
# PayoutResponseCardAccount

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**cardBrand** | **String** | Card brand |  [optional]
**cardType** | [**CardTypeEnum**](#CardTypeEnum) | Card type |  [optional]
**expiration** | **String** | Customer’s card expiration date. Format: &#x60;mm/yyyy&#x60; |  [optional]
**holder** | **String** | Customer&#39;s cardholder name. Any valid cardholder name. Not present by default, ask CardPay manager to enable it if needed. |  [optional]
**issuer** | **String** | Card issuer |  [optional]
**issuingCountryCode** | **String** | Country code of issuing card country |  [optional]
**maskedPan** | **String** | Masked PAN (shows first 6 digits and 4 last digits of the PAN) |  [optional]
**token** | **String** | Generated card token value. Token can be returned only for successful transactions (not for declined transactions).  |  [optional]


<a name="CardTypeEnum"></a>
## Enum: CardTypeEnum
Name | Value
---- | -----
DEBIT | &quot;DEBIT&quot;
CREDIT | &quot;CREDIT&quot;
PREPAID | &quot;PREPAID&quot;
OTHER | &quot;OTHER&quot;
UNKNOWN | &quot;UNKNOWN&quot;




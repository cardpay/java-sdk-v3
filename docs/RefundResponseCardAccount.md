
# RefundResponseCardAccount

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**cardBrand** | **String** | Card brand |  [optional]
**cardType** | [**CardTypeEnum**](#CardTypeEnum) | Card type |  [optional]
**issuer** | **String** | Card issuer |  [optional]
**issuingCountryCode** | **String** | Country code of issuing card country |  [optional]
**maskedPan** | **String** | Masked PAN (shows first 6 digits and 4 last digits) |  [optional]


<a name="CardTypeEnum"></a>
## Enum: CardTypeEnum
Name | Value
---- | -----
DEBIT | &quot;DEBIT&quot;
CREDIT | &quot;CREDIT&quot;
PREPAID | &quot;PREPAID&quot;
OTHER | &quot;OTHER&quot;
UNKNOWN | &quot;UNKNOWN&quot;




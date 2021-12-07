
# PaymentRequestCard

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**acctType** | [**AcctTypeEnum**](#AcctTypeEnum) |  |  [optional]
**expiration** | **String** | Customer&#39;s card expiration date. Format: &#x60;mm/yyyy&#x60; |  [optional]
**holder** | **String** | Customer&#39;s cardholder name. Any valid cardholder name |  [optional]
**pan** | **String** | Customer&#39;s card number (PAN). Any valid card number, may contain spaces |  [optional]
**pinCode** | **String** |  |  [optional]
**securityCode** | **String** | Customer&#39;s CVV2 / CVC2 / CAV2 |  [optional]


<a name="AcctTypeEnum"></a>
## Enum: AcctTypeEnum
Name | Value
---- | -----
_01 | &quot;01&quot;
_02 | &quot;02&quot;
_03 | &quot;03&quot;




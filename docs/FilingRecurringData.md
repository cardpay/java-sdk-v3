
# FilingRecurringData

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**currency** | **String** | [ISO 4217](https://en.wikipedia.org/wiki/ISO_4217) currency code |  [optional]
**dynamicDescriptor** | **String** | Short description of the service or product, must be enabled by CardPay manager to be used |  [optional]
**initiator** | **String** | Can be only &#x60;cit&#x60; (cardholder initiated transaction) |  [optional]
**note** | **String** | Note about the transaction that will not be displayed to Customer |  [optional]
**threeDsChallengeIndicator** | **String** |  |  [optional]
**transType** | [**TransTypeEnum**](#TransTypeEnum) |  |  [optional]


<a name="TransTypeEnum"></a>
## Enum: TransTypeEnum
Name | Value
---- | -----
_01 | &quot;01&quot;
_03 | &quot;03&quot;
_10 | &quot;10&quot;
_11 | &quot;11&quot;
_28 | &quot;28&quot;





# ScheduledByMerchantData

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**amount** | [**BigDecimal**](BigDecimal.md) | The amount of scheduled payment to be charged | 
**contractNumber** | **String** | Contract number between customer and merchant. Required for Mexican merchants for scheduled payments. |  [optional]
**currency** | **String** | [ISO 4217](https://en.wikipedia.org/wiki/ISO_4217) currency code | 
**dynamicDescriptor** | **String** | Short description of the service or product, must be enabled by CardPay manager to be used. |  [optional]
**filing** | [**RecurringResponseFiling**](RecurringResponseFiling.md) | Card filing data |  [optional]
**generateToken** | **Boolean** | This attribute can be received only in first recurring request. In all requests with recurring_id card.token can&#39;t be generated. If set to &#39;true&#39;, Card token will be generated and returned in GET response. Will be generated only for successful transactions (not for declined). |  [optional]
**initiator** | **String** | Use &#x60;cit&#x60; for initiator attribute for cardholder initiated transactions (first scheduled payment by merchant transactions) Use &#x60;mit&#x60; for initiator attribute for merchant initiated transactions (continue scheduled payment by merchant transactions) | 
**networkTransId** | **String** | Network Reference Number of original transaction |  [optional]
**note** | **String** | Note about the recurring that will not be displayed to customer. |  [optional]
**scheduledType** | **String** | Scheduled payment type attribute. For scheduled payments by merchant value should be &#x60;SM&#x60; - scheduled by merchant | 
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




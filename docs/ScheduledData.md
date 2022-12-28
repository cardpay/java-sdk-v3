
# ScheduledData

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**contractNumber** | **String** | Contract number between customer and merchant. Required for Mexican merchants for scheduled payments. |  [optional]
**dynamicDescriptor** | **String** | Short description of the service or product, must be enabled by CardPay manager to be used. |  [optional]
**encryptedData** | **String** | The encrypted payment credentials encoded in base64. *(for APPLEPAY payment method only)* |  [optional]
**generateToken** | **Boolean** | This attribute can be received only in first recurring request. In all requests with recurring_id card.token can&#39;t be generated. If set to &#39;true&#39;, Card token will be generated and returned in GET response. Will be generated only for successful transactions (not for declined). |  [optional]
**initialAmount** | [**BigDecimal**](BigDecimal.md) | The amount of subscription initiated transaction in selected currency with dot as a decimal separator, must be less than 100 millions |  [optional]
**initiator** | **String** | Use &#x60;cit&#x60; for initiator attribute (cardholder initiated transaction). | 
**note** | **String** | Note about the recurring that will not be displayed to customer. |  [optional]
**plan** | [**Plan**](Plan.md) | Plan data |  [optional]
**scheduledType** | **String** | Scheduled payment type attribute. For typical scheduled payments should be absent or &#x60;SA&#x60; - scheduled by acquirer |  [optional]
**subscriptionStart** | [**OffsetDateTime**](OffsetDateTime.md) | The time in &#39;yyyy-MM-dd&#39; format when subscription will actually become activated (grace period).Leave it empty to activate subscription at once without any grace period applied. |  [optional]
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




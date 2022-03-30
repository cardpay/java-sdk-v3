
# InstallmentData

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**amount** | [**BigDecimal**](BigDecimal.md) | The total transaction amount in selected currency with dot as a decimal separator, must be less than 100 millions |  [optional]
**currency** | **String** | [ISO 4217](https://en.wikipedia.org/wiki/ISO_4217) currency code | 
**dynamicDescriptor** | **String** | Short description of the service or product, must be enabled by CardPay manager to be used. |  [optional]
**generateToken** | **Boolean** | This attribute can be received only in first recurring request. In all requests with recurring_id card.token can&#39;t be generated. If set to &#39;true&#39;, Card token will be generated and returned in GET response. Will be generated only for successful transactions (not for declined). |  [optional]
**initiator** | **String** | Use &#x60;cit&#x60; for initiator attribute (cardholder initiated transaction). | 
**installmentAmount** | [**BigDecimal**](BigDecimal.md) | Amount of 1 installment payment, should be less or equal to total amount of subscription, can have dot as a decimal separator. Mandatory for Payment Page Mode only. |  [optional]
**installmentType** | **String** | Installment type, 2 possible values: &#x60;IF&#x60; - issuer financed &#x60;MF_HOLD&#39; - merchant financed hold |  [optional]
**note** | **String** | Note about the recurring that will not be displayed to customer. |  [optional]
**payments** | **Integer** | Number of total payments, to be charged per defined interval. For installment subscription with installment_type &#x3D; &#x60;MF_HOLD&#x60; can be 2-12. For Mexican installment subscription (installment_type &#x3D; &#x60;IF&#x60;) should be 1-99. |  [optional]
**preauth** | **Boolean** | If set to &#x60;true&#x60;, the amount will not be captured but only blocked. Installment with &#x60;preauth&#x60; attribute will be voided automatically in 7 days from the time of creating the preauth transaction. |  [optional]
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




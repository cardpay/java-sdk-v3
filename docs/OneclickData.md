
# OneclickData

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**amount** | [**BigDecimal**](BigDecimal.md) | The total transaction amount in selected currency with dot as a decimal separator, must be less than 100 millions |  [optional]
**currency** | **String** | [ISO 4217](https://en.wikipedia.org/wiki/ISO_4217) currency code | 
**dynamicDescriptor** | **String** | Short description of the service or product, must be enabled by CardPay manager to be used. |  [optional]
**filing** | [**RecurringRequestFiling**](RecurringRequestFiling.md) | Filing data, should be send in all recurring requests besides first recurring request First recurring request should be send without filing attribute |  [optional]
**generateToken** | **Boolean** | This attribute can be received only in first recurring request. If set to &#39;true&#39;, Card token will be generated and returned in GET response for all successful transactions (can&#39;t be generated for declined transactions). In all requests with filing_id card.token can&#39;t be generated. |  [optional]
**initiator** | **String** | Can be only 2 values - &#39;mit&#39; (merchant initiated transaction), &#39;cit&#39; (cardholder initiated transaction). | 
**note** | **String** | Note about the recurring that will not be displayed to customer. |  [optional]
**preauth** | **Boolean** | This parameter allowed to be used only for first recurring payment. If set to &#39;true&#39;, the amount will not be captured but only blocked. One-click payments with &#39;preauth&#39; attribute will be captured automatically in 7 days from the time of creating the preauth transaction. In continue recurring request (with &#39;filing_id&#39;) this parameter shouldn&#39;t be used. |  [optional]
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




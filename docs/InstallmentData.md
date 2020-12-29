
# InstallmentData

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**amount** | [**BigDecimal**](BigDecimal.md) | The total transaction amount in selected currency with dot as a decimal separator, must be less than 100 millions |  [optional]
**currency** | **String** | [ISO 4217](https://en.wikipedia.org/wiki/ISO_4217) currency code | 
**dynamicDescriptor** | **String** | Short description of the service or product, must be enabled by CardPay manager to be used. |  [optional]
**generateToken** | **Boolean** | This attribute can be received only in first recurring request. In all requests with recurring_id card.token can&#39;t be generated. If set to &#39;true&#39;, Card token will be generated and returned in GET response. Will be generated only for successful transactions (not for declined). |  [optional]
**holdRestAmount** | **Boolean** | For SplitPay subscription - \&quot;true\&quot; |  [optional]
**initiator** | **String** | Use &#x60;cit&#x60; for initiator attribute (cardholder initiated transaction). | 
**installmentAmount** | [**BigDecimal**](BigDecimal.md) | Amount of 1 installment payment, should be less or equal to total amount of subscription, can have dot as a decimal separator. Mandatory for Payment Page Mode only. |  [optional]
**installmentType** | **String** | Installment type, 2 possible values: &#x60;IF&#x60; - issuer financed &#x60;MF&#x60; - merchant financed For installments by merchant should be only &#x60;MF&#x60; installment_type |  [optional]
**interval** | **Integer** | Frequency interval of period, can be 1-365 depending on selected period value. Minimum value of period + interval can be 7 days / 1 week. Maximum value of period + interval plan can be 365 days / 52 weeks / 12 months / 1 year. 1-60 minutes - for **sandbox environment** and testing purpose only. |  [optional]
**note** | **String** | Note about the recurring that will not be displayed to customer. |  [optional]
**payments** | **Integer** | Number of total payments to be charged per defined interval, can be 2-200. For Mexican installment subscription (installment_type &#x3D; &#x60;IF&#x60;) should be 1-99. |  [optional]
**period** | [**PeriodEnum**](#PeriodEnum) | Initial period of recurring, can be &#x60;day&#x60;, &#x60;week&#x60;, &#x60;month&#x60;, &#x60;year&#x60; |  [optional]
**retries** | **Integer** | Number of daily basis retry attempts in case of payment has not been captured successfully, from 1 to 15 attempts can be specified. |  [optional]
**subscriptionStart** | [**OffsetDateTime**](OffsetDateTime.md) | The date in yyyy-MM-dd format when subscription will actually become activated (grace period). Auth request will be created but Customer will be charged only when subscription start date comes. Leave it empty or specify the current date to activate subscription at once without any grace period applied. |  [optional]
**transType** | [**TransTypeEnum**](#TransTypeEnum) |  |  [optional]


<a name="PeriodEnum"></a>
## Enum: PeriodEnum
Name | Value
---- | -----
MINUTE | &quot;minute&quot;
DAY | &quot;day&quot;
WEEK | &quot;week&quot;
MONTH | &quot;month&quot;
YEAR | &quot;year&quot;


<a name="TransTypeEnum"></a>
## Enum: TransTypeEnum
Name | Value
---- | -----
_01 | &quot;01&quot;
_03 | &quot;03&quot;
_10 | &quot;10&quot;
_11 | &quot;11&quot;
_28 | &quot;28&quot;




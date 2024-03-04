
# AuthDataRequest

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**amount** | [**BigDecimal**](BigDecimal.md) | The total invoice amount in selected currency with dot as a decimal separator, must be less than 10 billion | 
**currency** | **String** | [ISO 4217](https://en.wikipedia.org/wiki/ISO_4217) currency code | 
**dynamicDescriptor** | **String** |  |  [optional]
**generateToken** | **Boolean** | If set to &#x60;true&#x60;, token will be generated and returned in the response (callback). Token can be generated only for successful transactions (not for declined transactions) *(for BANKCARD payment method only)* |  [optional]
**installmentAmount** | [**BigDecimal**](BigDecimal.md) | Amount of 1 installment authentication, should be less or equal to total amount of subscription, can have dot as a decimal separator. Mandatory for Payment Page Mode only. |  [optional]
**installmentType** | **String** | Installment type, 2 possible values: &#x60;IF&#x60; - issuer financed &#x60;MF_HOLD&#39; - merchant financed. For installment subscription with hold rest amount. |  [optional]
**installments** | **List&lt;Integer&gt;** | Number of total installment payments, to be charged per defined interval. For installment subscription with installment_type &#x3D; &#x60;MF_HOLD&#x60; can be 1-12. For installment subscription with installment_type &#x3D; &#x60;IF&#x60; can be 1-99. |  [optional]
**note** | **String** | Note about the authentication, not shown to Customer |  [optional]
**recurringData** | [**RecurringData**](RecurringData.md) | Recurring data |  [optional]
**scaExemption** | **String** | Indicates the exemption type that you want to request for the authentication. Possible value: LOW_VALUE |  [optional]
**threeDsChallengeIndicator** | **String** |  |  [optional]
**transType** | **String** | Identifies the type of transaction being authenticated. |  [optional]
**type** | [**TypeEnum**](#TypeEnum) |  |  [optional]


<a name="TypeEnum"></a>
## Enum: TypeEnum
Name | Value
---- | -----
AVS | &quot;AVS&quot;
THREE_DS_PA | &quot;THREE_DS_PA&quot;
THREE_DS_NPA | &quot;THREE_DS_NPA&quot;




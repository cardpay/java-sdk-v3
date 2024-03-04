
# PaymentRequestPaymentData

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**amount** | [**BigDecimal**](BigDecimal.md) | The total transaction amount in selected currency with dot as a decimal separator, must be less than 10 billion If &#39;payment_method&#39; &#x3D; &#x60;BITCOIN&#x60; then minimum order amount is approximately 0.003 bitcoins or its equivalent. The exact value should be provided by the account manager. | 
**currency** | **String** | [ISO 4217](https://en.wikipedia.org/wiki/ISO_4217) currency code | 
**dynamicDescriptor** | **String** | Short description of the service or product, must be enabled by CardPay manager to be used *(for BANKCARD payment method only)* |  [optional]
**encryptedData** | **String** | The encrypted payment credentials encoded in base64. *(for APPLEPAY payment method only)* |  [optional]
**generateToken** | **Boolean** | If set to &#x60;true&#x60;, token will be generated and returned in the response. Token can be generated only for successful transactions (not for declined transactions) *(for BANKCARD payment method only)* |  [optional]
**holdPeriod** | **Integer** | The delay between the authorisation and scheduled auto-capture or auto-void, specified in hours. The minimum hold period is 1 hour, maximum hold period is 7 days (168 hours). |  [optional]
**installmentAmount** | [**BigDecimal**](BigDecimal.md) | Amount of 1 installment payment, should be less or equal to total amount of subscription, can have dot as a decimal separator. Mandatory for Payment Page Mode only. |  [optional]
**installmentType** | **String** | Installment type, 2 possible values: &#x60;IF&#x60; - issuer financed &#x60;MF_HOLD&#39; - merchant financed. For installment subscription with hold rest amount. |  [optional]
**installments** | **List&lt;Integer&gt;** | Number of total installment payments, to be charged per defined interval. For installment subscription with installment_type &#x3D; &#x60;MF_HOLD&#x60; can be 1-12. For installment subscription with installment_type &#x3D; &#x60;IF&#x60; can be 1-99. |  [optional]
**note** | **String** | Note about the transaction that will not be displayed to Customer |  [optional]
**postauthStatus** | [**PostauthStatusEnum**](#PostauthStatusEnum) | The value contains payment status after hold period if payment has not been completed. Possible values: COMPLETE, REVERSE |  [optional]
**preauth** | **Boolean** | If set to &#x60;true&#x60;, the amount will not be captured but only blocked. Payments with &#39;preauth&#39; attribute will be captured automatically in 7 days from the time of creating the preauth transaction. *(for BANKCARD payment method only)*. |  [optional]
**scaExemption** | **String** | Indicates the exemption type that you want to request for the transaction. Possible value: LOW_VALUE |  [optional]
**threeDsChallengeIndicator** | **String** |  |  [optional]
**threeDsMode** | **String** | Parameter &#39;three_ds_mode&#39; indicates desire to conduct the transaction with full 3-D Secure, partial 3-D Secure, or without it, possible values: &#x60;01&#x60; - FULL 3-D Secure &#x60;02&#x60; - 3DS required but can be skipped &#x60;03&#x60; - NON 3-D Secure |  [optional]
**transType** | [**TransTypeEnum**](#TransTypeEnum) |  |  [optional]


<a name="PostauthStatusEnum"></a>
## Enum: PostauthStatusEnum
Name | Value
---- | -----
REVERSE | &quot;REVERSE&quot;
COMPLETE | &quot;COMPLETE&quot;


<a name="TransTypeEnum"></a>
## Enum: TransTypeEnum
Name | Value
---- | -----
_01 | &quot;01&quot;
_03 | &quot;03&quot;
_10 | &quot;10&quot;
_11 | &quot;11&quot;
_28 | &quot;28&quot;




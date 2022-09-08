
# PaymentRequestPaymentData

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**amount** | [**BigDecimal**](BigDecimal.md) | The total transaction amount in selected currency with dot as a decimal separator, must be less than 10 billion If &#39;payment_method&#39; &#x3D; &#x60;BITCOIN&#x60; then minimum order amount is approximately 0.003 bitcoins or its equivalent. The exact value should be provided by the account manager. | 
**authenticationRequest** | **Boolean** | If set to &#x60;true&#x60;, amount must not be presented in request, no payment will be made, only cardholder authentication will be performed. Also can be used to generate token. *(for BANKCARD payment method only)* |  [optional]
**currency** | **String** | [ISO 4217](https://en.wikipedia.org/wiki/ISO_4217) currency code | 
**dynamicDescriptor** | **String** | Short description of the service or product, must be enabled by CardPay manager to be used *(for BANKCARD payment method only)* |  [optional]
**encryptedData** | **String** | The encrypted payment credentials encoded in base64. *(for APPLEPAY payment method only)* |  [optional]
**generateToken** | **Boolean** | If set to &#x60;true&#x60;, token will be generated and returned in the response. Token can be generated only for successful transactions (not for declined transactions) *(for BANKCARD payment method only)* |  [optional]
**installmentAmount** | [**BigDecimal**](BigDecimal.md) | Amount of 1 installment payment, should be less or equal to total amount of subscription, can have dot as a decimal separator. Mandatory for Payment Page Mode only. |  [optional]
**installmentType** | **String** | Installment type, 2 possible values: &#x60;IF&#x60; - issuer financed &#x60;MF_HOLD&#39; - merchant financed. For installment subscription with hold rest amount. |  [optional]
**installments** | **String** | Number of total installment payments, to be charged per defined interval. For installment subscription with installment_type &#x3D; &#x60;MF_HOLD&#x60; can be 1-12. For installment subscription with installment_type &#x3D; &#x60;IF&#x60; can be 1-99. |  [optional]
**note** | **String** | Note about the transaction that will not be displayed to Customer |  [optional]
**preauth** | **Boolean** | If set to &#x60;true&#x60;, the amount will not be captured but only blocked. Payments with &#39;preauth&#39; attribute will be captured automatically in 7 days from the time of creating the preauth transaction. *(for BANKCARD payment method only)*. |  [optional]
**scaExemption** | **String** | Indicates the exemption type that you want to request for the transaction. Possible value: LOW_VALUE |  [optional]
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




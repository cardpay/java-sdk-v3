
# PaymentRequestPaymentData

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**amount** | [**BigDecimal**](BigDecimal.md) | The total transaction amount in selected currency with dot as a decimal separator, must be less than 100 millions If &#39;payment_method&#39; &#x3D; &#x60;BITCOIN&#x60; then minimum order amount is approximately 0.003 bitcoins or its equivalent. The exact value should be provided by the account manager. |  [optional]
**authenticationRequest** | **Boolean** | If set to &#x60;true&#x60;, amount must not be presented in request, no payment will be made, only cardholder authentication will be performed. Also can be used to generate token. *(for BANKCARD payment method only)* |  [optional]
**currency** | **String** | [ISO 4217](https://en.wikipedia.org/wiki/ISO_4217) currency code | 
**dynamicDescriptor** | **String** | Short description of the service or product, must be enabled by CardPay manager to be used *(for BANKCARD payment method only)* |  [optional]
**encryptedData** | **String** | The encrypted payment credentials encoded in base64. *(for APPLEPAY payment method only)* |  [optional]
**generateToken** | **Boolean** | If set to &#x60;true&#x60;, token will be generated and returned in the response. Token can be generated only for successful transactions (not for declined transactions) *(for BANKCARD payment method only)* |  [optional]
**note** | **String** | Note about the transaction that will not be displayed to Customer |  [optional]
**preauth** | **Boolean** | If set to &#x60;true&#x60;, the amount will not be captured but only blocked. Payments with &#39;preauth&#39; attribute will be captured automatically in 7 days from the time of creating the preauth transaction. *(for BANKCARD payment method only)*. |  [optional]
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




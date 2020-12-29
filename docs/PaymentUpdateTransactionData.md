
# PaymentUpdateTransactionData

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**amount** | [**BigDecimal**](BigDecimal.md) | The total transaction amount in selected currency with dot as a decimal separator, must be less than 100 millions |  [optional]
**statusTo** | [**StatusToEnum**](#StatusToEnum) | Payment, one-click recurring: &#x60;COMPLETE&#x60; or &#x60;REVERSE&#x60; status to be set. Refund, payout: &#x60;REVERSE&#x60; status to be set. |  [optional]


<a name="StatusToEnum"></a>
## Enum: StatusToEnum
Name | Value
---- | -----
REVERSE | &quot;REVERSE&quot;
COMPLETE | &quot;COMPLETE&quot;
TERMINATE | &quot;TERMINATE&quot;




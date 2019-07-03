
# OneclickData

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**amount** | [**BigDecimal**](BigDecimal.md) | The total transaction amount in selected currency with dot as a decimal separator, must be less than 100 millions |  [optional]
**begin** | **Boolean** |  |  [optional]
**currency** | **String** | [ISO 4217](https://en.wikipedia.org/wiki/ISO_4217) currency code | 
**dynamicDescriptor** | **String** |  |  [optional]
**filing** | [**RecurringRequestFiling**](RecurringRequestFiling.md) | Filing data, should be send in all recurring requests besides first recurring request First recurring request should be send without filing attribute |  [optional]
**generateToken** | **Boolean** |  |  [optional]
**initiator** | **String** |  | 
**note** | **String** |  |  [optional]
**preauth** | **Boolean** | If set to &#x60;true&#x60;, the amount will not be captured but only blocked *(for BANKCARD payment method only)*. |  [optional]




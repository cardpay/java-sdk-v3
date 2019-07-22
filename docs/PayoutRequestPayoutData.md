
# PayoutRequestPayoutData

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**amount** | [**BigDecimal**](BigDecimal.md) | Represents the amount to be transferred to Customer&#39;s card, must be less than 100 millions. | 
**currency** | **String** | [ISO 4217](https://en.wikipedia.org/wiki/ISO_4217) currency code of the payout transaction. Must match terminal currency | 
**dynamicDescriptor** | **String** | Short description of the service or product, must be enabled by CardPay manager to be used *(for BANKCARD, QIWI, WEBMONEY and BITCOIN methods only)* |  [optional]
**note** | **String** | Note about the payout, not shown to Customer |  [optional]




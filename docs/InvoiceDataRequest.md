
# InvoiceDataRequest

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**amount** | [**BigDecimal**](BigDecimal.md) | The total invoice amount in selected currency with dot as a decimal separator, must be less than 10 billion | 
**currency** | **String** | ISO 4217 currency code | 
**expireAt** | [**OffsetDateTime**](OffsetDateTime.md) | Date of invoice expiring. Invoice cannot be used after this date. |  [optional]




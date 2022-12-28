
# InvoiceGetDataResponse

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**amount** | [**BigDecimal**](BigDecimal.md) | The total invoice amount in selected currency with dot as a decimal separator | 
**currency** | **String** | ISO 4217 currency code | 
**expireAt** | [**OffsetDateTime**](OffsetDateTime.md) | Date of invoice expiring. Invoice cannot be used after this date. |  [optional]
**id** | **String** | Identifier of created invoice. | 
**status** | **String** | Status of invoice. |  [optional]




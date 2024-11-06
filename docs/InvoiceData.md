
# InvoiceData

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**amount** | [**BigDecimal**](BigDecimal.md) | The total invoice amount in selected currency with dot as a decimal separator, must be less than 10 billion | 
**currency** | **String** | [ISO 4217](https://en.wikipedia.org/wiki/ISO_4217) currency code | 
**expireAt** | [**OffsetDateTime**](OffsetDateTime.md) | Date and time of invoice expiring. Invoice cannot be used after this date and time. |  [optional]
**installmentType** | **String** | Installment type |  [optional]
**installments** | **List&lt;Integer&gt;** | Number of installments. It depends on country. |  [optional]
**reusable** | **Boolean** | The flag that can be used for enabling payment link multiple times |  [optional]
**reuseCount** | **Integer** | The number that customer can pay by this link. Default value 10 |  [optional]




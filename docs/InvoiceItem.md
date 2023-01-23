
# InvoiceItem

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**count** | **Integer** | The count of product / service, provided to the customer. Any positive number | 
**name** | **String** | The name of product / service, provided to the customer | 
**price** | [**BigDecimal**](BigDecimal.md) | Price of product / service with dot as a decimal separator, must be less than a 1000000 (one million, NOT inclusive)  For currencies with 0 digits after digital separator (like VND, IDR and others) - limit is 200000000 (200 million, NOT inclusive) | 




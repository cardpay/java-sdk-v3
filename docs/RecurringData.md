
# RecurringData

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**contractNumber** | **String** | Contract number between customer and merchant. Required for Mexican merchants |  [optional]
**initialAmount** | [**BigDecimal**](BigDecimal.md) | The amount of subscription initiated transaction in selected currency with dot as a decimal separator, must be less than 100 millions |  [optional]
**plan** | [**Plan**](Plan.md) | Plan data |  [optional]
**subscriptionStart** | **String** | The time in &#39;yyyy-MM-dd&#39; format when subscription will actually become activated (grace period).Leave it empty to activate subscription at once without any grace period applied. |  [optional]
**type** | **String** | Scheduled payment type attribute. Supported values are: &#x60;SM&#x60; - value for scheduled by merchant case &#x60;SA&#x60; - value for scheduled by acquirer case The default value is SA |  [optional]




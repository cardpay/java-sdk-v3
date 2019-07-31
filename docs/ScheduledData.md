
# ScheduledData

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**dynamicDescriptor** | **String** | Short description of the service or product, must be enabled by CardPay manager to be used. |  [optional]
**generateToken** | **Boolean** | This attribute can be received only in first recurring request. In all requests with recurring_id card.token can&#39;t be generated. If set to &#39;true&#39;, Card token will be generated and returned in GET response. Will be generated only for successful transactions (not for declined). |  [optional]
**initialAmount** | [**BigDecimal**](BigDecimal.md) | The amount of subscription initiated transaction in selected currency with dot as a decimal separator, must be less than 100 millions |  [optional]
**initiator** | **String** | Use &#x60;cit&#x60; for initiator attribute (cardholder initiated transaction). | 
**note** | **String** | Note about the recurring that will not be displayed to customer. |  [optional]
**plan** | [**Plan**](Plan.md) | Plan data |  [optional]
**subscriptionStart** | [**OffsetDateTime**](OffsetDateTime.md) | The time in &#39;yyyy-MM-dd&#39; format when subscription will actually become activated (grace period).Leave it empty to activate subscription at once without any grace period applied. |  [optional]





# RefundResponseRefundData

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**amount** | [**BigDecimal**](BigDecimal.md) | Refund transaction amount | 
**arn** | **String** | ARN (Acquirer Reference Number), supplied by the acquiring financial institution, return only after receiving ARN from bank acquirer *(for BANKCARD payment method only)* |  [optional]
**authCode** | **String** | Authorization code, provided by bank *(for BANKCARD payment method only)* |  [optional]
**created** | **String** | Date and time when this refund was created, [ISO 8601](https://en.wikipedia.org/wiki/ISO_8601) format | 
**currency** | **String** | Currency of refunded amount, [ISO 4217](https://en.wikipedia.org/wiki/ISO_4217) currency code | 
**declineCode** | **String** | Refund decline code (only for &#x60;DECLINED&#x60; refund status) |  [optional]
**declineReason** | **String** | Refund decline reason (only for &#x60;DECLINED&#x60; refund status) |  [optional]
**id** | **String** | ID of the newly created refund in CardPay system | 
**is3d** | **Boolean** | Was 3-D Secure authentication made or not *(for BANKCARD payment method only)* |  [optional]
**rrn** | **String** | RRN (Retrieval Reference Number), supplied by the acquiring financial institution *(for BANKCARD payment method only)* |  [optional]
**status** | [**StatusEnum**](#StatusEnum) | Refund status in CardPay system | 


<a name="StatusEnum"></a>
## Enum: StatusEnum
Name | Value
---- | -----
NEW | &quot;NEW&quot;
IN_PROGRESS | &quot;IN_PROGRESS&quot;
DECLINED | &quot;DECLINED&quot;
AUTHORIZED | &quot;AUTHORIZED&quot;
COMPLETED | &quot;COMPLETED&quot;
CANCELLED | &quot;CANCELLED&quot;
REFUNDED | &quot;REFUNDED&quot;
PARTIALLY_REFUNDED | &quot;PARTIALLY_REFUNDED&quot;
VOIDED | &quot;VOIDED&quot;
CHARGED_BACK | &quot;CHARGED_BACK&quot;
CHARGEBACK_RESOLVED | &quot;CHARGEBACK_RESOLVED&quot;




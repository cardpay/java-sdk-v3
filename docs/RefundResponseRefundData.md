
# RefundResponseRefundData

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**amount** | [**BigDecimal**](BigDecimal.md) | Refund transaction amount |  [optional]
**arn** | **String** | ARN (Acquirer Reference Number), supplied by the acquiring financial institution, return only after receiving ARN from bank acquirer *(for BANKCARD payment method only)* |  [optional]
**authCode** | **String** | Authorization code, provided by bank *(for BANKCARD payment method only)* |  [optional]
**created** | **String** | Date and time when this refund was created, [ISO 8601](https://en.wikipedia.org/wiki/ISO_8601) format |  [optional]
**currency** | **String** | Currency of refunded amount, [ISO 4217](https://en.wikipedia.org/wiki/ISO_4217) currency code |  [optional]
**declineCode** | **String** | Refund decline code (only for &#x60;DECLINED&#x60; refund status) |  [optional]
**declineReason** | **String** | Refund decline reason (only for &#x60;DECLINED&#x60; refund status) |  [optional]
**extendedDeclineReason** | **String** | Original decline reason. Can be presented in responses if original network response code is presented and option is enabled for Merchant. Not presented by default, ask Unlimit manager to enable it if needed. |  [optional]
**id** | **String** | ID of the newly created refund in CardPay system |  [optional]
**is3d** | **Boolean** | Was 3-D Secure authentication made or not *(for BANKCARD payment method only)* |  [optional]
**rrn** | **String** | RRN (Retrieval Reference Number), supplied by the acquiring financial institution *(for BANKCARD payment method only)* |  [optional]
**status** | [**StatusEnum**](#StatusEnum) | Refund status in CardPay system |  [optional]


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
VOIDED | &quot;VOIDED&quot;
TERMINATED | &quot;TERMINATED&quot;
CHARGED_BACK | &quot;CHARGED_BACK&quot;
CHARGEBACK_RESOLVED | &quot;CHARGEBACK_RESOLVED&quot;
UNPAID | &quot;UNPAID&quot;
WAITING | &quot;WAITING&quot;




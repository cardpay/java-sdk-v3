
# BankCardPayoutData

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**amount** | [**BigDecimal**](BigDecimal.md) | Payout amount |  [optional]
**arn** | **String** | ARN (Acquirer Reference Number), supplied by the acquiring financial institution, return only after receiving ARN from bank acquirer *(for BANKCARD payment method only)* |  [optional]
**created** | **String** | Date and time when this payout was created, [ISO 8601](https://en.wikipedia.org/wiki/ISO_8601) format |  [optional]
**currency** | **String** | Payout currency ([ISO 4217](https://en.wikipedia.org/wiki/ISO_4217) format) |  [optional]
**declineCode** | **String** | Decline code (only in decline case) |  [optional]
**declineReason** | **String** | Bank&#39;s message about payout decline reason (only in decline case) |  [optional]
**id** | **String** | CardPay&#39;s payout id |  [optional]
**note** | **String** | Payout note |  [optional]
**rrn** | **String** | RRN (Retrieval Reference Number), supplied by the acquiring financial institution *(for BANKCARD method only)* |  [optional]
**status** | [**StatusEnum**](#StatusEnum) | Current payout status |  [optional]


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




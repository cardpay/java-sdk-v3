
# PaymentResponsePaymentData

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**amount** | [**BigDecimal**](BigDecimal.md) | Payment amount | 
**authCode** | **String** | Authorization code, provided by bank *(for BANKCARD payment method only)* |  [optional]
**created** | **String** | Time when this payment started in [ISO 8601](https://en.wikipedia.org/wiki/ISO_8601) format (yyyy-MM-dd&#39;T&#39;HH:mm:ss&#39;Z&#39;) | 
**currency** | **String** | Payment currency code ([ISO 4217](https://en.wikipedia.org/wiki/ISO_4217) code) | 
**declineCode** | **String** | Decline code (only in decline case) |  [optional]
**declineReason** | **String** | Bank&#39;s message about transaction decline reason (only in decline case) |  [optional]
**id** | **String** | CardPay&#39;s payment id | 
**is3d** | **Boolean** | Was 3-D Secure authentication made or not *(for BANKCARD payment method only)* |  [optional]
**note** | **String** | Payment note |  [optional]
**rrn** | **String** | RRN (Retrieval Reference Number), supplied by the acquiring financial institution *(for BANKCARD payment method only)* |  [optional]
**status** | [**StatusEnum**](#StatusEnum) | Current payment status | 


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




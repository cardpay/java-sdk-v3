
# PaymentResponsePaymentData

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**amount** | [**BigDecimal**](BigDecimal.md) | Payment amount |  [optional]
**arn** | **String** | ARN (Acquirer Reference Number), supplied by the acquiring financial institution, return only after receiving ARN from bank acquirer *(for BANKCARD payment method only)* |  [optional]
**authCode** | **String** | Authorization code, provided by bank *(for BANKCARD payment method only)* |  [optional]
**created** | **String** | Time when this payment started in [ISO 8601](https://en.wikipedia.org/wiki/ISO_8601) format (yyyy-MM-dd&#39;T&#39;HH:mm:ss&#39;Z&#39;) |  [optional]
**currency** | **String** | Payment currency code ([ISO 4217](https://en.wikipedia.org/wiki/ISO_4217) code) |  [optional]
**declineCode** | **String** | Decline code (only in decline case) |  [optional]
**declineReason** | **String** | Bank&#39;s message about transaction decline reason (only in decline case) |  [optional]
**extendedDeclineReason** | **String** | Original decline reason. Can be presented in responses if original network response code is presented and option is enabled for Merchant. Not presented by default, ask Unlimit manager to enable it if needed. |  [optional]
**holdPeriod** | **Integer** | The delay between the authorisation and scheduled auto-capture or auto-void, specified in hours. The minimum hold period is 1 hour, maximum hold period is 7 days (168 hours). |  [optional]
**id** | **String** | CardPay&#39;s payment id |  [optional]
**installmentType** | **String** | Selected installment type |  [optional]
**installments** | **String** | Number of total installment payments, to be charged |  [optional]
**invalidData** | **List&lt;String&gt;** | Invalid card or billing data |  [optional]
**is3d** | **Boolean** | Was 3-D Secure authentication made or not *(for BANKCARD payment method only)* |  [optional]
**networkTransId** | **String** | Network Reference Number of original transaction |  [optional]
**note** | **String** | Payment note |  [optional]
**postauthStatus** | **String** | The value contains payment status after hold period if payment has not been completed. Possible values: COMPLETE, REVERSE |  [optional]
**rrn** | **String** | RRN (Retrieval Reference Number), supplied by the acquiring financial institution *(for BANKCARD payment method only)* |  [optional]
**status** | [**StatusEnum**](#StatusEnum) | Current payment status, *(mandatory for WEBMONEY and BITCOIN payment method only)* |  [optional]
**transType** | [**TransTypeEnum**](#TransTypeEnum) |  |  [optional]
**type** | **String** | Payment type, can be PAYMENT, INSTALLMENT |  [optional]


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


<a name="TransTypeEnum"></a>
## Enum: TransTypeEnum
Name | Value
---- | -----
_01 | &quot;01&quot;
_03 | &quot;03&quot;
_10 | &quot;10&quot;
_11 | &quot;11&quot;
_28 | &quot;28&quot;




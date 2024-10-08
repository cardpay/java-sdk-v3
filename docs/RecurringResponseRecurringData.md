
# RecurringResponseRecurringData

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**amount** | [**BigDecimal**](BigDecimal.md) | Recurring amount |  [optional]
**arn** | **String** | ARN (Acquirer Reference Number), supplied by the acquiring financial institution, return only after receiving ARN from bank acquirer *(for BANKCARD payment method only)* |  [optional]
**authCode** | **String** | Authorization code, provided by bank |  [optional]
**begin** | **Boolean** | Callback: show first/next recurring |  [optional]
**created** | **String** | Date and time when this recurring payment was created, [ISO 8601](https://en.wikipedia.org/wiki/ISO_8601) format |  [optional]
**currency** | **String** | Recurring currency code ([ISO 4217](https://en.wikipedia.org/wiki/ISO_4217) code) |  [optional]
**declineCode** | **String** | Decline code (only in decline case) |  [optional]
**declineReason** | **String** | Bank&#39;s message about transaction decline reason (only in decline case) |  [optional]
**extendedDeclineReason** | **String** | Original decline reason. Can be presented in responses if original network response code is presented and option is enabled for Merchant. Not presented by default, ask Unlimit manager to enable it if needed. |  [optional]
**filing** | [**RecurringResponseFiling**](RecurringResponseFiling.md) | CardPay&#39;s filing data |  [optional]
**holdPeriod** | **Integer** | The delay between the authorisation and scheduled auto-capture or auto-void, specified in hours. The minimum hold period is 1 hour, maximum hold period is 7 days (168 hours). |  [optional]
**id** | **String** | CardPay&#39;s recurring id |  [optional]
**initiator** | **String** | Initiator of scheduled transaction (applicable only for scheduled by merchant payments) |  [optional]
**installmentAmount** | [**BigDecimal**](BigDecimal.md) | Amount of 1 installment payment, will be returned if presented in request (for payment page mode only) |  [optional]
**installmentType** | **String** | Selected installment type |  [optional]
**invalidData** | **List&lt;String&gt;** | Invalid card or billing data |  [optional]
**is3d** | **Boolean** | Was 3-D Secure authentication made or not |  [optional]
**networkTransId** | **String** | Network Reference Number of original transaction |  [optional]
**note** | **String** | Payment note |  [optional]
**payments** | **String** | Number of total payments, to be charged |  [optional]
**postauthStatus** | **String** | The value contains payment status after hold period if payment has not been completed. Possible values: COMPLETE, REVERSE |  [optional]
**rrn** | **String** | RRN (Retrieval Reference Number), supplied by the acquiring financial institution |  [optional]
**scheduledType** | [**ScheduledTypeEnum**](#ScheduledTypeEnum) | Scheduled payment type attribute. &#x60;SM&#x60; - value for scheduled by merchant case &#x60;SA&#x60; - value for scheduled by acquirer case |  [optional]
**status** | [**StatusEnum**](#StatusEnum) | Current recurring payment status |  [optional]
**subscription** | [**Subscription**](Subscription.md) | Subscription data. Mandatory if scheduled payment is requested. |  [optional]
**type** | [**TypeEnum**](#TypeEnum) | Recurring payment type name; can be ONECLICK, SCHEDULED, INSTALLMENT |  [optional]
**transType** | [**TransTypeEnum**](#TransTypeEnum) |  |  [optional]


<a name="ScheduledTypeEnum"></a>
## Enum: ScheduledTypeEnum
Name | Value
---- | -----
SA | &quot;SA&quot;
SM | &quot;SM&quot;


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


<a name="TypeEnum"></a>
## Enum: TypeEnum
Name | Value
---- | -----
ONECLICK | &quot;ONECLICK&quot;
SCHEDULED | &quot;SCHEDULED&quot;
INSTALLMENT | &quot;INSTALLMENT&quot;


<a name="TransTypeEnum"></a>
## Enum: TransTypeEnum
Name | Value
---- | -----
_01 | &quot;01&quot;
_03 | &quot;03&quot;
_10 | &quot;10&quot;
_11 | &quot;11&quot;
_28 | &quot;28&quot;




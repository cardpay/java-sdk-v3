
# AuthenticationData

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**amount** | [**BigDecimal**](BigDecimal.md) | Payment amount |  [optional]
**created** | **String** | Time when this payment started in [ISO 8601](https://en.wikipedia.org/wiki/ISO_8601) format (yyyy-MM-dd&#39;T&#39;HH:mm:ss&#39;Z&#39;) |  [optional]
**currency** | **String** | Payment currency code ([ISO 4217](https://en.wikipedia.org/wiki/ISO_4217) code) |  [optional]
**declineCode** | **String** | Decline code (only in decline case) |  [optional]
**declineReason** | **String** | Bank&#39;s message about transaction decline reason (only in decline case) |  [optional]
**id** | **String** | Unlimit&#39;s payment id |  [optional]
**installmentType** | **String** | Installment type, 2 possible values: &#x60;IF&#x60; - issuer financed &#x60;MF_HOLD&#39; - merchant financed. For installment subscription with hold rest amount. |  [optional]
**installments** | **String** | Number of total installment payments. |  [optional]
**invalidData** | **List&lt;String&gt;** | List incorrect fields for decline |  [optional]
**recurringData** | [**RecurringResponseRecurringData**](RecurringResponseRecurringData.md) | Recurring data |  [optional]
**status** | [**StatusEnum**](#StatusEnum) | Current payment status |  [optional]
**threeDSecure** | [**ThreeDSecureResponse**](ThreeDSecureResponse.md) | 3D Secure results data |  [optional]
**transType** | [**TransTypeEnum**](#TransTypeEnum) |  |  [optional]
**type** | **String** |  |  [optional]


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




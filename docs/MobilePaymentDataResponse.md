
# MobilePaymentDataResponse

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
**id** | **String** | CardPay&#39;s payment id |  [optional]
**invalidData** | **List&lt;String&gt;** | Invalid card or billing data |  [optional]
**is3d** | **Boolean** | Was 3-D Secure authentication made or not *(for BANKCARD payment method only)* |  [optional]
**note** | **String** | Payment note |  [optional]
**rrn** | **String** | RRN (Retrieval Reference Number), supplied by the acquiring financial institution *(for BANKCARD payment method only)* |  [optional]
**status** | **String** | Current payment status, *(mandatory for WEBMONEY and BITCOIN payment method only)* |  [optional]
**transType** | **String** |  |  [optional]




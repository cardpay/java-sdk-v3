
# PaymentRequestEWalletAccount

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**bankCode** | **String** | Card issuer&#39;s code. For DIRECTBANKINGNGA: Customer bank code (3 digits). Mandatory for DIRECTBANKINGNGA payment method only. |  [optional]
**creationDate** | **String** | Card creation date |  [optional]
**expirationDate** | **String** | Account expiration date |  [optional]
**id** | **String** | For QIWI: Customer phone number (from 1 to 15 digits). For NETELLER: email address of Customer. For &#39;Latin America&#39;: Customer personal identification number: CPF or CNPJ for Brazil, DNI for Argentina and ID for other countries. For AIRTEL, MPESA, MTN, UGANDAMOBILE, VODAFONE and TIGO: phone number linked to Customer&#39;s mobile money account. For DIRECTBANKINGNGA: bank account number Mandatory for QIWI, NETELLER, &#39;Latin America&#39;, AIRTEL, MPESA, MTN, UGANDAMOBILE, VODAFONE, TIGO and DIRECTBANKINGNGA payment methods only. |  [optional]
**verificationCode** | **String** | Provider security code. For NETELLER: member&#39;s 6 digits Secure Id or Google Authenticator OTP For VODAFONE: Customer voucher code (6 digits) For UBA bank in DIRECTBANKINGNGA: Customer BVN (bank verification number) number, 11 digits Mandatory for NETELLER, VODAFONE and DIRECTBANKINGNGA payment methods only. |  [optional]




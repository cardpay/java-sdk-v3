
# PaymentRequestCustomer

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**birthDate** | **String** | Customer birth date in format &#x60;YYYY-MM-DD&#x60;. For Zenith bank in DIRECTBANKINGNGA: Customer password in format date of birth. *(mandatory for DIRECTBANKINGNGA payment method only)* |  [optional]
**email** | **String** | Email address of Customer *(mandatory by default for BANKCARD, PAYPAL, &#39;Latin America&#39;, AIRTEL, MPESA, MTN, UGANDAMOBILE, VODAFONE, TIGO, DIRECTBANKINGNGA and AQRCODE payment methods only)*. Can be defined as optional by CardPay manager. |  [optional]
**fullName** | **String** | Customer full name *(mandatory for &#39;Latin America&#39; payment methods only)* |  [optional]
**id** | **String** | Customer ID in Merchant&#39;s system *(mandatory for WEBMONEY payment method only)* |  [optional]
**locale** | **String** | Preferred locale for the payment page ([ISO 639-1](https://en.wikipedia.org/wiki/ISO_639-1) language code). The default locale will be applied if the selected locale is not supported. Supported locales are: &#x60;ru&#x60;, &#x60;en&#x60;, &#x60;zh&#x60;, &#x60;ja&#x60; |  [optional]
**phone** | **String** | Customer phone number. Format: &#x60;+&#x60; sign and 10 or 11 digits, example: &#x60;+12345678901&#x60; Mandatory for DIRECTBANKINGNGA payment method. For other payment methods: optional by default, can be defined as mandatory by CardPay manager. |  [optional]




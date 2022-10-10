
# RecurringCustomer

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**contractNumber** | **String** | Contract number between customer and merchant. Required for Mexican merchants for scheduled payments. |  [optional]
**email** | **String** | Customer&#39;s e-mail address. Mandatory by default, can be defined as optional by CardPay manager. | 
**homePhone** | **String** | The work phone number provided by the Cardholder. Required (if available), unless market or regional mandate restricts sending this information. Characters Format: string (10-18 symbols) country code + Subscriber number. Refer to ITU-E.164 for additional information on format and length. |  [optional]
**id** | **String** | Customer&#39;s ID in Merchant&#39;s system | 
**identity** | **String** | Customer&#39;s identity in Merchant&#39;s system required for Brazil Installments |  [optional]
**ip** | **String** | Customer IPv4 |  [optional]
**ipCountry** | **String** | Customer country by IP |  [optional]
**locale** | [**LocaleEnum**](#LocaleEnum) | Preferred locale for the payment page ([ISO 639-1](https://en.wikipedia.org/wiki/ISO_639-1) language code). The default locale will be applied if the selected locale is not supported. Supported locales are: &#x60;ru&#x60;, &#x60;en&#x60;, &#x60;zh&#x60;, &#x60;ja&#x60; |  [optional]
**phone** | **String** | Customer phone number. Optional by default, can be defined as mandatory by CardPay manager. |  [optional]
**userAgent** | **String** | User agent |  [optional]
**workPhone** | **String** | The home phone number provided by the Cardholder. Required (if available) unless market or regional mandate restricts sending this information. Characters Format: string (10-18 symbols) country code + Subscriber number. Refer to ITU-E.164 for additional information on format and length. |  [optional]


<a name="LocaleEnum"></a>
## Enum: LocaleEnum
Name | Value
---- | -----
RU | &quot;ru&quot;
EN | &quot;en&quot;
ZH | &quot;zh&quot;
JA | &quot;ja&quot;




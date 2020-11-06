
# MobileCustomerResponse

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**email** | **String** | Email address of the customer (mandatory by default for &#39;Latin America&#39;, &#39;NETELLER&#39;, &#39;DIRECTBANKINGNGA&#39;, &#39;AQRCODE&#39;, &#39;AIRTEL&#39;, &#39;MPESA&#39;, &#39;MTN&#39;, &#39;UGANDAMOBILE&#39;, &#39;VODAFONE&#39;, &#39;TIGO&#39; payment methods only)). Can be defined as optional by CardPay manager. |  [optional]
**fullName** | **String** | Customer&#39;s full name |  [optional]
**homePhone** | **String** | The home phone number provided by the Cardholder. Required (if available), unless market or regional mandate restricts sending this information. Characters Format: string (10-18 symbols) country code + Subscriber number. Refer to ITU-E.164 for additional information on format and length. |  [optional]
**id** | **String** | Customer&#39;s ID in the merchant&#39;s system |  [optional]
**ip** | **String** | IP address of customer |  [optional]
**locale** | **String** | Preferred locale for the payment page ([ISO 639-1](https://en.wikipedia.org/wiki/ISO_639-1) language code). The default locale will be applied if the selected locale is not supported. Supported locales are: &#x60;ru&#x60;, &#x60;en&#x60;, &#x60;zh&#x60;, &#x60;ja&#x60; |  [optional]
**phone** | **String** | Customer&#39;s phone number. Mandatory for DIRECTBANKINGNGA payment method. For other payment methods: optional by default, can be defined as mandatory by CardPay manager. |  [optional]
**workPhone** | **String** | The work phone number provided by the Cardholder. Required (if available) unless market or regional mandate restricts sending this information. Characters Format: string (10-18 symbols) country code + Subscriber number. Refer to ITU-E.164 for additional information on format and length. |  [optional]





# PayoutRequestCustomer

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**birthDate** | **String** | Customer birth date |  [optional]
**device** | [**Device**](Device.md) | Customer&#39;s device information |  [optional]
**documentType** | **String** | Customer document type *(mandatory for &#39;Latin America&#39; methods only)* For &#39;Latin America&#39; is required for methods where country &#x3D; CO, PE |  [optional]
**email** | **String** | Customer e-mail address *(mandatory for &#39;Latin America&#39; methods only)* For &#39;Latin America&#39; is required for methods where country &#x3D; CO |  [optional]
**firstName** | **String** | Customer first name *(mandatory for &#39;Latin America&#39; methods only)* |  [optional]
**fullName** | **String** | Customer full name. Mandatory for DIRECTBANKINGNGA methods only: For DIRECTBANKINGNGA: only for non NGN currency |  [optional]
**id** | **String** | Customer id *(mandatory for WEBMONEY method only)* |  [optional]
**identity** | **String** | Customer identity  - Customer’s personal identification number: &#39;CPF&#39; or &#39;CNPJ&#39; for Brazil, &#39;DNI&#39; for Argentina and ID for other countries.  For SPEI - Customer CPF or CURP |  [optional]
**lastName** | **String** | Customer last name *(mandatory for &#39;Latin America&#39; methods only)* For &#39;Latin America&#39; is required for methods where country &#x3D; AR, BR, CO, MX, PE, UY |  [optional]
**livingAddress** | [**PayoutRequestLivingAddress**](PayoutRequestLivingAddress.md) | Customer address *(mandatory for &#39;Latin America&#39; methods only)* For &#39;Latin America&#39; is required for methods where country &#x3D; CO |  [optional]
**phone** | **String** | Customer&#39;s phone number |  [optional]
**taxReasonCode** | **String** | Customer&#39;s tax reason codeFor &#39;BANK131 back account mode&#39; is required for methods where country &#x3D; RU |  [optional]




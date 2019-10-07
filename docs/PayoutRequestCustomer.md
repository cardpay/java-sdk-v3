
# PayoutRequestCustomer

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**documentNumber** | **String** | Customer document number *(mandatory for &#39;Latin America&#39; methods only)* For &#39;Latin America&#39; is required for methods where country &#x3D; AR, BR, CL, CO, PE, UY |  [optional]
**documentType** | **String** | Customer document type *(mandatory for &#39;Latin America&#39; methods only)* For &#39;Latin America&#39; is required for methods where country &#x3D; CO, PE |  [optional]
**email** | **String** | Customer e-mail address *(mandatory for &#39;Latin America&#39; methods only)* For &#39;Latin America&#39; is required for methods where country &#x3D; CO |  [optional]
**firstName** | **String** | Customer first name *(mandatory for &#39;Latin America&#39; methods only)* |  [optional]
**fullName** | **String** | Customer full name. Mandatory for DIRECTBANKINGNGA methods only: For DIRECTBANKINGNGA: only for non NGN currency |  [optional]
**id** | **String** | Customer id *(mandatory for WEBMONEY method only)* |  [optional]
**lastName** | **String** | Customer last name *(mandatory for &#39;Latin America&#39; methods only)* For &#39;Latin America&#39; is required for methods where country &#x3D; AR, BR, CO, MX, PE, UY |  [optional]
**livingAddress** | [**PayoutRequestLivingAddress**](PayoutRequestLivingAddress.md) | Customer address *(mandatory for &#39;Latin America&#39; methods only)* For &#39;Latin America&#39; is required for methods where country &#x3D; CO |  [optional]
**phone** | **String** | Customer&#39;s phone number |  [optional]




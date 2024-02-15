
# PayoutRequestEWalletAccount

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**bankBranch** | **String** | Customer bank branch number (name). Mandatory for &#39;Latin America&#39; and DIRECTBANKINGNGA methods only. For &#39;Latin America&#39;: &lt;ul&gt;&lt;li&gt;required for methods where country &#x3D; BR, UY&lt;/li&gt;&lt;li&gt;for UY (Uruguay) is optional if &#39;payment_method&#39; is &#x60;UY113&#x60;&lt;/li&gt;&lt;/ul&gt; For DIRECTBANKINGNGA: Customer bank branch number (name), only for Ghana banks (GH******) |  [optional]
**bankCode** | **String** | Customer bank code For DIRECTBANKINGNGA: Customer bank code (3 digits) |  [optional]
**bankName** | **String** | Customer bank name Customer bank name (string) |  [optional]
**id** | **String** | For QIWI: Customer phone number (from 1 to 15 digits) For WEBMONEY: Customer account number For NETELLER: Customer email For &#39;Latin America&#39;: Customer personal identification number For AIRTEL, MPESA, MTN, UGANDAMOBILE, VODAFONE and TIGO: phone number linked to Customer&#39;s mobile money account. Phone prefix is **required**: AIRTEL - 233 (GHS), 256 (UGX); MTN - 233 (GHS), 256 (UGX); TIGO, VODAFONE - 233; UGANDAMOBILE - 256; MPESA - 254 For DIRECTBANKINGNGA: bank account number For PAYPAL: Customer email, phone or PayPal account number *(mandatory for QIWI, PAYPAL, WEBMONEY, NETELLER, &#39;Latin America&#39;, AIRTEL, MPESA, MTN, UGANDAMOBILE, VODAFONE, TIGO and DIRECTBANKINGNGA methods only)* |  [optional]
**name** | **String** | Customer bank account name. |  [optional]
**type** | **String** | Customer account type. Mandatory for &#39;Latin America&#39; methods only. For &#39;Latin America&#39;: &lt;ul&gt;&lt;li&gt;required for methods where country &#x3D; BR, CL, CO&lt;/li&gt;&lt;li&gt;for PE (PERU) only &#x60;M&#x60; value is allowed&lt;/li&gt;&lt;li&gt;for UY (Uruguay) is required only if &#39;payment_method&#39; is &#x60;UY001&#x60;&lt;/li&gt;&lt;/ul&gt; |  [optional]




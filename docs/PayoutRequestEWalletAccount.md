
# PayoutRequestEWalletAccount

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**bankBranch** | **String** | Customer bank branch number (name). Mandatory for &#39;Latin America&#39;, &#39;Asia&#39; and DIRECTBANKINGNGA methods only. For &#39;Latin America&#39;: &lt;ul&gt;&lt;li&gt;required for methods where country &#x3D; BR, UY&lt;/li&gt;&lt;li&gt;for UY (Uruguay) is optional if &#39;payment_method&#39; is &#x60;UY113&#x60;&lt;/li&gt;&lt;/ul&gt; For &#39;Asia&#39;: must be in Simplified Chinese For DIRECTBANKINGNGA: Customer bank branch number (name), only for Ghana banks (GH******) |  [optional]
**bankCode** | **String** | Customer bank code For DIRECTBANKINGNGA: Customer bank code (3 digits) |  [optional]
**id** | **String** | For QIWI: Customer phone number (from 1 to 15 digits) For WEBMONEY: Customer account number For NETELLER: Customer email For &#39;Latin America&#39;: Customer personal identification number For &#39;Asia&#39;: Customer bank account number For YANDEXMONEY: Customer wallet number, 11 to 16 digits, begins with &#x60;410&#x60; For AIRTEL, MPESA, MTN, UGANDAMOBILE, VODAFONE and TIGO: phone number linked to Customer&#39;s mobile money account. Phone prefix is **required**: AIRTEL - 233 (GHS), 256 (UGX); MTN - 233 (GHS), 256 (UGX); TIGO, VODAFONE - 233; UGANDAMOBILE - 256; MPESA - 254 For DIRECTBANKINGNGA: bank account number *(mandatory for QIWI, WEBMONEY, NETELLER, &#39;Latin America&#39;, &#39;Asia&#39;, YANDEXMONEY, AIRTEL, MPESA, MTN, UGANDAMOBILE, VODAFONE, TIGO and DIRECTBANKINGNGA methods only)* |  [optional]
**name** | **String** | Customer bank account name. For &#39;Asia&#39; methods: &lt;ul&gt;&lt;li&gt;mandatory&lt;/li&gt;&lt;li&gt;for &#x60;CNY&#x60; currency: must be in Simplified Chinese&lt;/li&gt;&lt;/ul&gt; |  [optional]
**type** | **String** | Customer account type. Mandatory for &#39;Latin America&#39; methods only. For &#39;Latin America&#39;: &lt;ul&gt;&lt;li&gt;required for methods where country &#x3D; BR, CL, CO&lt;/li&gt;&lt;li&gt;for PE (PERU) only &#x60;M&#x60; value is allowed&lt;/li&gt;&lt;li&gt;for UY (Uruguay) is required only if &#39;payment_method&#39; is &#x60;UY001&#x60;&lt;/li&gt;&lt;/ul&gt; |  [optional]




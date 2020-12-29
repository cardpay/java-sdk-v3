
# BillingAddress

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**addrLine1** | **String** | First line of the street address or equivalent local portion of the Cardholder billing address associated with the card used for this purchase. Should include street and house number. May include whitespaces, hyphens, apostrophes, commas, quotes, dots, slashes and semicolons. Required (if available) unless market or regional mandate restricts sending this information. For recurring: field will be ignored if &#39;filing.id&#39; is presented in request (continue one-click scenario) *Length: 0 - 50* | 
**addrLine2** | **String** | Second line of the street address or equivalent local portion of the Cardholder billing address associated with the card used for this purchase. Required (if available) unless market or regional mandate restricts sending this information. For recurring: field will be ignored if &#39;filing.id&#39; is presented in request (continue one-click scenario) *Length: 0 - 50* |  [optional]
**city** | **String** | Billing city. May include whitespaces, hyphens, apostrophes, commas and dots | 
**country** | **String** | [ISO 3166-1](https://en.wikipedia.org/wiki/ISO_3166-1) code of billing country: 2 or 3 latin letters or numeric code  | 
**state** | **String** | The state or province of the billing address associated with the card being used for this purchase. It&#39;s recommended to send in following format: the country subdivision code defined in [ISO 3166-2](https://en.wikipedia.org/wiki/ISO_3166-2). May include whitespaces, hyphens, apostrophes, commas and dots |  [optional]
**zip** | **String** | Billing postal code | 




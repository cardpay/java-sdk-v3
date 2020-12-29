
# ShippingAddress

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**addrLine1** | **String** | First line of the street address or equivalent local portion of the Cardholder shipping address associated with the card used for this purchase. Can include street and house number. *Length: 0 - 50* |  [optional]
**addrLine2** | **String** | Second line of the street address or equivalent local portion of the Cardholder shipping address associated with the card used for this purchase. *Length: 0 - 50* |  [optional]
**city** | **String** | Delivery city. May include whitespaces, hyphens, apostrophes, commas and dots |  [optional]
**country** | **String** | [ISO 3166-1](https://en.wikipedia.org/wiki/ISO_3166-1) code of delivery country: 2 or 3 latin letters or numeric code. Required for BANKCARD payment method if &#39;shipping_address&#39; is presented. |  [optional]
**phone** | **String** | Valid customer phone number |  [optional]
**state** | **String** | The state or province of the shipping address associated with the card being used for this purchase. It&#39;s recommended to send in following format: the country subdivision code defined in [ISO 3166-2](https://en.wikipedia.org/wiki/ISO_3166-2). May include whitespaces, hyphens, apostrophes, commas and dots. |  [optional]
**zip** | **String** | Delivery postal code. For BANKCARD payment method max length: 12 Mandatory for BOLETO and LOTERICA payment methods only. |  [optional]




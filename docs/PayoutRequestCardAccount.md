
# PayoutRequestCardAccount

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**billingAddress** | [**BillingAddress**](BillingAddress.md) | Address for billing |  [optional]
**card** | [**PayoutRequestCard**](PayoutRequestCard.md) | Represents a payout card data. Card section shouldn&#39;t be present if element &#x60;token&#x60; was presented. | 
**recipientInfo** | **String** | Property &#x60;recipient_info&#x60; may be required by Bank. In most cases it&#39;s Cardholder&#39;s name, contact CardPay manager for requirements. It must be omitted when property &#x60;token&#x60; is presented | 
**token** | **String** | Card token value, used instead of a card data |  [optional]





# DisputeResponseDisputeData

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**dueTime** | **String** | Due date and time in [ISO 8601](https://en.wikipedia.org/wiki/ISO_8601) format for making decision or action over chargeback/retrieval request, i.e accepting, disputing or providing evidence documents (format - yyyy-MM-dd&#39;T&#39;HH:mm:ss&#39;Z&#39;) |  [optional]
**groupId** | **String** | Dispute group ID in Disputes Resolution Center that includes returned dispute entity |  [optional]
**reasonCode** | **String** | Dispute&#39;s reason code |  [optional]
**reasonDescription** | **String** | Dispute&#39;s reason code description |  [optional]
**regTime** | **String** | Dispute registration date in [ISO 8601](https://en.wikipedia.org/wiki/ISO_8601) format (format - yyyy-MM-dd&#39;T&#39;HH:mm:ss&#39;Z&#39;) |  [optional]
**resultTime** | **String** | Dispute&#39;s terminal (final) status date and time in [ISO 8601](https://en.wikipedia.org/wiki/ISO_8601) format (format - yyyy-MM-dd&#39;T&#39;HH:mm:ss&#39;Z&#39;) |  [optional]
**stage** | **String** | Chargeback/retrieval request&#39;s current stage |  [optional]
**status** | **String** | Chargeback/retrieval request&#39;s current status |  [optional]
**type** | **String** | Indicates dispute entity type: &#x60;CB&#x60; - for chargebacks &#x60;RR&#x60; - for retrieval requests &#x60;FR&#x60; - for fraud reports |  [optional]




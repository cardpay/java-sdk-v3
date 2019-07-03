
# Request

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **String** | Request ID, should be unique for time period of 30 minutes | 
**time** | [**OffsetDateTime**](OffsetDateTime.md) | Request attempt date and time up to milliseconds in [ISO 8601](https://en.wikipedia.org/wiki/ISO_8601) format (example of format - yyyy-MM dd&#39;T&#39;HH:mm:ss&#39;Z&#39;) Should be current server time of request (UTC time) or shouldn&#39;t be more than +3 hours or less than -3 hours from current UTC time. | 





# Report

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**downloadUrl** | **String** | Link to archive downloading. Link is available for 24 hours |  [optional]
**fileId** | [**UUID**](UUID.md) | The identifier of report&#39;s file |  [optional]
**fileName** | **String** | The file name |  [optional]
**hashSum** | **String** | Hash sum of file (sha256) |  [optional]
**reportType** | **String** | Specific report type, one of: \&quot;regular_settlement\&quot;, \&quot;icpp_settlement\&quot; |  [optional]
**settlementDate** | **String** | Date of settlement. The format is yyyy-MM-dd |  [optional]
**settlementId** | **Long** | The identifier of settlement. Can be the same for several objects in sample |  [optional]
**size** | **Long** | Size of file in bytes |  [optional]
**status** | [**StatusEnum**](#StatusEnum) | One of statuses:  \&quot;IN_PROGRESS\&quot;  \&quot;COMPLETED\&quot;  \&quot;FAILED\&quot; |  [optional]
**websiteName** | **String** | Name of website |  [optional]


<a name="StatusEnum"></a>
## Enum: StatusEnum
Name | Value
---- | -----
IN_PROGRESS | &quot;IN_PROGRESS&quot;
COMPLETED | &quot;COMPLETED&quot;
FAILED | &quot;FAILED&quot;




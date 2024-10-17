
# PlanRetryResponse

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**duration** | **Integer** | Value of period time which is retry available for subscription in days. Mandatory, if mode &#x3D; DEFAULT Possible values: min: 1 max: 30 |  [optional]
**frequency** | **List&lt;Integer&gt;** | Intervals for initiating reties. Mandatory, if mode &#x3D; INTERVAL Possible element values in array: min: 1 max: 30 |  [optional]
**mode** | [**ModeEnum**](#ModeEnum) | Retry mode |  [optional]
**retryAdvice** | **Boolean** | If value is true MAC recommendation will be applied, if false retry will be strictly according setting for retry Can be only for mode &#x3D; INTERVAL (if not specified then default value is &#39;true&#39;) |  [optional]
**schedule** | **List&lt;Integer&gt;** | Intervals for initiating reties. Mandatory, if mode &#x3D; CALENDAR Possible element values in array: min: 1 max: 30 |  [optional]


<a name="ModeEnum"></a>
## Enum: ModeEnum
Name | Value
---- | -----
DEFAULT | &quot;DEFAULT&quot;
INTERVAL | &quot;INTERVAL&quot;
CALENDAR | &quot;CALENDAR&quot;
NO_RETRY | &quot;NO_RETRY&quot;




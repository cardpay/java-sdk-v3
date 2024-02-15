
# PlanUpdateRequest

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**request** | [**Request**](Request.md) | Request | 
**operation** | [**OperationEnum**](#OperationEnum) | &#x60;CHANGE_STATUS&#x60; value to initiate operation for status changing. &#x60;RENAME&#x60; value to initiate operation for plan renaming. | 
**planData** | [**PlanUpdateRequestPlanData**](PlanUpdateRequestPlanData.md) | Plan data | 


<a name="OperationEnum"></a>
## Enum: OperationEnum
Name | Value
---- | -----
CHANGE_STATUS | &quot;CHANGE_STATUS&quot;
RENAME | &quot;RENAME&quot;
CHANGE_QUANTITY | &quot;CHANGE_QUANTITY&quot;





# PlanUpdateRequestPlanData

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**nameTo** | **String** | New plan name - for RENAME operation only |  [optional]
**quantity** | [**List&lt;PlanQuantity&gt;**](PlanQuantity.md) | Array with units params |  [optional]
**statusTo** | [**StatusToEnum**](#StatusToEnum) | New state of plan (ACTIVE or INACTIVE) - for CHANGE_STATUS operation only |  [optional]


<a name="StatusToEnum"></a>
## Enum: StatusToEnum
Name | Value
---- | -----
ACTIVE | &quot;ACTIVE&quot;
INACTIVE | &quot;INACTIVE&quot;




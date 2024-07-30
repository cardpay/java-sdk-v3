
# AuthenticationConfirm3dsRequest

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**request** | [**Request**](Request.md) | Request | 
**cres** | **String** | Bank authentication result, for 3-D Secure 2 *(for BANKCARD payment method only)* |  [optional]
**paRes** | **String** | Bank authentication result, for 3-D Secure 1 *(for BANKCARD payment method only)* |  [optional]
**operation** | [**OperationEnum**](#OperationEnum) | &#x60;CONFIRM_3DS&#x60; value | 


<a name="OperationEnum"></a>
## Enum: OperationEnum
Name | Value
---- | -----
CHANGE_STATUS | &quot;CHANGE_STATUS&quot;
CONFIRM_3DS | &quot;CONFIRM_3DS&quot;
EXECUTE | &quot;EXECUTE&quot;
INCREMENT | &quot;INCREMENT&quot;




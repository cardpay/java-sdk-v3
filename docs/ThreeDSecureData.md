
# ThreeDSecureData

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**cardEnrollment** | **String** | Card enrollment in 3DS flow, possible values are: S - 3D Secure Skipped, N - 3D Secure not enrolled, Y - 3D Secure enrolled |  [optional]
**cavv** | **String** | Cardholder authentication verification value |  [optional]
**cavvAlgorithm** | **String** | CAVV algorithm |  [optional]
**paRes** | **String** | PaRes bank authentication result |  [optional]
**status** | **String** | 3DS status (from PaRes for 3Ds 1.0, ARes message for 3Ds 2.0) (possible values Y,A,U) |  [optional]
**threeDSecureFlow** | **String** | Possible values: 3DS1 - 3DS 1.0 flow, 3DS2C - 3DS 2.0 challenge flow, 3DS2F - 3DS 2.0 frictionless flow |  [optional]
**xid** | **String** | Transaction Id in PaRes |  [optional]




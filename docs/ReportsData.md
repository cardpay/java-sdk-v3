
# ReportsData

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**endDate** | [**LocalDate**](LocalDate.md) | End date of period on which the reports were generated. Period between dates is no more than 7 days.  The format is yyyy-MM-dd  If ‘end_date’ is skipped then default value is used: ‘start_date’ + 7 days |  [optional]
**reportType** | **List&lt;String&gt;** | Specific report type. Now are available: \&quot;regular_settlement\&quot;, \&quot;icpp_settlement\&quot; |  [optional]
**startDate** | [**LocalDate**](LocalDate.md) | Start date of period on which the reports were generated. The format is yyyy-MM-dd | 




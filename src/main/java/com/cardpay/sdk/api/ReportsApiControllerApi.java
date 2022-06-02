package com.cardpay.sdk.api;

import com.cardpay.sdk.client.CollectionFormats.*;
import com.cardpay.sdk.model.ReportsRequest;
import com.cardpay.sdk.model.ReportsResponse;
import retrofit2.Call;
import retrofit2.http.*;

public interface ReportsApiControllerApi {
  /**
   * Gets actual state of processing of requested settlement reports
   * 
   * @param id id (required)
   * @return Call&lt;ReportsResponse&gt;
   */
  @GET("api/reports/{id}")
  Call<ReportsResponse> gETReports(
    @retrofit2.http.Path("id") String id
  );

  /**
   * Download the report file
   * 
   * @param id id (required)
   * @return Call&lt;byte[]&gt;
   */
  @GET("api/reports/download/{id}")
  Call<byte[]> gETReportsContent(
    @retrofit2.http.Path("id") String id
  );

  /**
   * Initiate the reports&#39; preparation
   * 
   * @param request request (required)
   * @return Call&lt;ReportsResponse&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("api/reports")
  Call<ReportsResponse> pOSTReports(
    @retrofit2.http.Body ReportsRequest request
  );

}

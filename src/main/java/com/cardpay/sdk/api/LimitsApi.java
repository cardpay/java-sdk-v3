package com.cardpay.sdk.api;

import com.cardpay.sdk.client.CollectionFormats.*;
import com.cardpay.sdk.model.LimitInfoResponse;
import retrofit2.Call;
import retrofit2.http.*;

public interface LimitsApi {
  /**
   * Get limits information
   * 
   * @param requestId request_id (optional)
   * @return Call&lt;LimitInfoResponse&gt;
   */
  @GET("api/limits")
  Call<LimitInfoResponse> getLimitsInfo(
    @retrofit2.http.Query("request_id") String requestId
  );

}

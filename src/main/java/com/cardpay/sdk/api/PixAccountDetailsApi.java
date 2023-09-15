package com.cardpay.sdk.api;

import com.cardpay.sdk.client.CollectionFormats.*;
import com.cardpay.sdk.model.PixAccountDetailsRequest;
import com.cardpay.sdk.model.PixAccountDetailsResponse;
import retrofit2.Call;
import retrofit2.http.*;

public interface PixAccountDetailsApi {
  /**
   * Get pix account details
   * 
   * @param detailsRequest detailsRequest (required)
   * @return Call&lt;PixAccountDetailsResponse&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("api/account_details/pix")
  Call<PixAccountDetailsResponse> accountDetails(
    @retrofit2.http.Body PixAccountDetailsRequest detailsRequest
  );

  /**
   * Get adapter banks list
   * 
   * @param currency currency (required)
   * @param method method (required)
   * @return Call&lt;Object&gt;
   */
  @GET("api/banks/{method}/{currency}")
  Call<Object> banks(
    @retrofit2.http.Path("currency") String currency, @retrofit2.http.Path("method") String method
  );

}

package com.cardpay.sdk.api;

import com.cardpay.sdk.client.CollectionFormats.*;
import com.cardpay.sdk.model.CardBindingRequest;
import com.cardpay.sdk.model.CardBindingResponse;
import com.cardpay.sdk.model.MobileTokenRequest;
import com.cardpay.sdk.model.MobileTokenResponse;
import retrofit2.Call;
import retrofit2.http.*;

public interface MobileApi {
  /**
   * Execute card binding process
   * 
   * @param request request (required)
   * @return Call&lt;CardBindingResponse&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("api/mobile/cardbinding")
  Call<CardBindingResponse> executeCardBinding(
    @retrofit2.http.Body CardBindingRequest request
  );

  /**
   * Generate mobile token 
   * 
   * @param request request (required)
   * @return Call&lt;MobileTokenResponse&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("api/mobile/token")
  Call<MobileTokenResponse> generateMobileToken(
    @retrofit2.http.Body MobileTokenRequest request
  );

}

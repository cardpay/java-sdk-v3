package com.cardpay.sdk.api;

import com.cardpay.sdk.client.CollectionFormats.*;
import com.cardpay.sdk.model.MobileTokenRequest;
import com.cardpay.sdk.model.MobileTokenResponse;
import retrofit2.Call;
import retrofit2.http.*;

public interface MobileApi {
  /**
   * Generate mobile token
   * 
   * @param mobileTokenRequest mobileTokenRequest (required)
   * @return Call&lt;MobileTokenResponse&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("api/mobile/token")
  Call<MobileTokenResponse> getMobileToken(
    @retrofit2.http.Body MobileTokenRequest mobileTokenRequest
  );

}

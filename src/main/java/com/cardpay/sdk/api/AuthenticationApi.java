package com.cardpay.sdk.api;

import com.cardpay.sdk.client.CollectionFormats.*;
import com.cardpay.sdk.model.AuthenticationCreateResponse;
import com.cardpay.sdk.model.AuthenticationDataRequest;
import com.cardpay.sdk.model.AuthenticationDataResponse;
import com.cardpay.sdk.model.AuthenticationPatchRequest;
import com.cardpay.sdk.model.AuthenticationUpdateResponse;
import retrofit2.Call;
import retrofit2.http.*;

public interface AuthenticationApi {
  /**
   * Create authentication
   * 
   * @param authenticationDataRequest authenticationDataRequest (required)
   * @return Call&lt;AuthenticationCreateResponse&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("api/authentication")
  Call<AuthenticationCreateResponse> createAuthentication(
    @retrofit2.http.Body AuthenticationDataRequest authenticationDataRequest
  );

  /**
   * Get authentication information
   * 
   * @param authId Authentication ID (required)
   * @return Call&lt;AuthenticationDataResponse&gt;
   */
  @GET("api/authentication/{authId}")
  Call<AuthenticationDataResponse> getAuthentication(
    @retrofit2.http.Path("authId") String authId
  );

  /**
   * Update authentication
   * 
   * @param authenticationId Authentication ID (required)
   * @param authenticationPatchRequest authenticationPatchRequest (required)
   * @return Call&lt;AuthenticationUpdateResponse&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @PATCH("api/authentication/{authenticationId}")
  Call<AuthenticationUpdateResponse> updateAuthentication(
    @retrofit2.http.Path("authenticationId") String authenticationId, @retrofit2.http.Body AuthenticationPatchRequest authenticationPatchRequest
  );

}

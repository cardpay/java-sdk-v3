package com.cardpay.sdk.api;

import com.cardpay.sdk.client.CollectionFormats.*;
import com.cardpay.sdk.model.AuthenticationCreateResponse;
import com.cardpay.sdk.model.AuthenticationDataRequest;
import com.cardpay.sdk.model.AuthenticationDataResponse;
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

}

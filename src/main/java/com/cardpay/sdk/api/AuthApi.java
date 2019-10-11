package com.cardpay.sdk.api;

import com.cardpay.sdk.client.CollectionFormats.*;
import com.cardpay.sdk.model.ApiTokens;
import retrofit2.Call;
import retrofit2.http.*;

public interface AuthApi {
  /**
   * Get authorization token
   * 
   * @param grantType Token request credentials representation (required)
   * @param password Terminal password value (only for [password] grant type) (optional)
   * @param refreshToken Refresh token string (only for [refresh_token] grant type) (optional)
   * @param terminalCode Terminal code value (optional)
   * @return Call&lt;ApiTokens&gt;
   */
  @retrofit2.http.FormUrlEncoded
  @POST("api/auth/token")
  Call<ApiTokens> obtainTokens(
    @retrofit2.http.Field("grant_type") String grantType, @retrofit2.http.Field("password") String password, @retrofit2.http.Field("refresh_token") String refreshToken, @retrofit2.http.Field("terminal_code") String terminalCode
  );

}

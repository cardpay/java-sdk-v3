package com.cardpay.sdk.api;

import com.cardpay.sdk.client.CollectionFormats.*;

import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okhttp3.MultipartBody;

import com.cardpay.sdk.model.ApiTokens;
import com.cardpay.sdk.model.OAuthError;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

package com.cardpay.sdk.api;

import com.cardpay.sdk.client.CollectionFormats.*;
import com.cardpay.sdk.model.CardBindingRequest;
import com.cardpay.sdk.model.CardBindingResponse;
import com.cardpay.sdk.model.MobilePaymentRequest;
import com.cardpay.sdk.model.MobilePaymentResponse;
import com.cardpay.sdk.model.MobileTokenRequest;
import com.cardpay.sdk.model.MobileTokenResponse;
import com.cardpay.sdk.model.MobileVerificationRequest;
import com.cardpay.sdk.model.MobileVerificationResponse;
import retrofit2.Call;
import retrofit2.http.*;

public interface MobileApi {
  /**
   * Create mobile payment 
   * 
   * @param authorization Authorization (required)
   * @param request request (required)
   * @return Call&lt;MobilePaymentResponse&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("api/mobile/payment")
  Call<MobilePaymentResponse> createMobilePayment(
    @retrofit2.http.Header("Authorization") String authorization, @retrofit2.http.Body MobilePaymentRequest request
  );

  /**
   * Execute card binding process
   * 
   * @param authorization Authorization (required)
   * @param request request (required)
   * @return Call&lt;CardBindingResponse&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("api/mobile/cardbinding")
  Call<CardBindingResponse> executeCardBinding(
    @retrofit2.http.Header("Authorization") String authorization, @retrofit2.http.Body CardBindingRequest request
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

  /**
   * get mobile payment
   * 
   * @param authorization Authorization (required)
   * @param paymentId paymentId (required)
   * @return Call&lt;MobilePaymentResponse&gt;
   */
  @GET("api/mobile/payments/{paymentId}")
  Call<MobilePaymentResponse> getMobilePayment(
    @retrofit2.http.Header("Authorization") String authorization, @retrofit2.http.Path("paymentId") String paymentId
  );

  /**
   * get mobile payment methods
   * 
   * @param authorization Authorization (required)
   * @return Call&lt;MobilePaymentResponse&gt;
   */
  @GET("api/mobile/payment_methods")
  Call<MobilePaymentResponse> getMobilePaymentMethods(
    @retrofit2.http.Header("Authorization") String authorization
  );

  /**
   * Verify attestation statement
   * 
   * @param authorization Authorization (required)
   * @param request request (required)
   * @return Call&lt;MobileVerificationResponse&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("api/mobile/verify")
  Call<MobileVerificationResponse> verify(
    @retrofit2.http.Header("Authorization") String authorization, @retrofit2.http.Body MobileVerificationRequest request
  );

}

package com.cardpay.sdk.api;

import com.cardpay.sdk.client.CollectionFormats.*;
import com.cardpay.sdk.model.AuthenticationDataResponse;
import com.cardpay.sdk.model.PaymentGatewayCreationResponse;
import com.cardpay.sdk.model.PaymentMethodsList;
import com.cardpay.sdk.model.PaymentPatchRequest;
import com.cardpay.sdk.model.PaymentRequest;
import com.cardpay.sdk.model.PaymentResponse;
import com.cardpay.sdk.model.PaymentUpdateResponse;
import com.cardpay.sdk.model.PaymentsList;
import java.time.OffsetDateTime;
import retrofit2.Call;
import retrofit2.http.*;

public interface PaymentsApi {
  /**
   * Create payment
   * Endpoint for creation payments. Request example presented for Gateway mode.
   * @param paymentRequest paymentRequest (required)
   * @return Call&lt;PaymentGatewayCreationResponse&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("api/payments")
  Call<PaymentGatewayCreationResponse> createPayment(
    @retrofit2.http.Body PaymentRequest paymentRequest
  );

  /**
   * Get payment 3DS result information
   * 
   * @param paymentId Payment ID (required)
   * @return Call&lt;AuthenticationDataResponse&gt;
   */
  @GET("api/payments/{paymentId}/threedsecure")
  Call<AuthenticationDataResponse> getAuthenticationData1(
    @retrofit2.http.Path("paymentId") String paymentId
  );

  /**
   * Get payment information
   * 
   * @param paymentId Payment ID (required)
   * @return Call&lt;PaymentResponse&gt;
   */
  @GET("api/payments/{paymentId}")
  Call<PaymentResponse> getPayment(
    @retrofit2.http.Path("paymentId") String paymentId
  );

  /**
   * Get payment methods
   * Endpoint for get payment methods by current terminal code
   * @return Call&lt;PaymentMethodsList&gt;
   */
  @GET("api/payment_methods")
  Call<PaymentMethodsList> getPaymentMethods();
    

  /**
   * Get payments information
   * 
   * @param requestId Request ID (required)
   * @param currency [ISO 4217](https://en.wikipedia.org/wiki/ISO_4217) currency code of transactions currency (optional)
   * @param endTime Date and time up to milliseconds (in [ISO 8601](https://en.wikipedia.org/wiki/ISO_8601) format) when requested period ends (not inclusive), UTC time, must be less than 7 days after &#39;start_time&#39;, default is current time (format: yyyy-MM-dd&#39;T&#39;HH:mm:ss&#39;Z&#39;) (optional)
   * @param maxCount Limit number of returned transactions (must be less than 10000, default is 1000) (optional)
   * @param merchantOrderId Merchant order number from the merchant system (optional)
   * @param paymentMethod Used payment method type name from payment methods list (optional)
   * @param sortOrder Sort based on order of results. &#x60;asc&#x60; for ascending order or &#x60;desc&#x60; for descending order (default value) (optional)
   * @param startTime Date and time up to milliseconds (in [ISO 8601](https://en.wikipedia.org/wiki/ISO_8601) format) when requested period starts (inclusive), UTC time, default is 24 hours before &#39;end_time&#39; (format: yyyy-MM-dd&#39;T&#39;HH:mm:ss&#39;Z&#39;) (optional)
   * @return Call&lt;PaymentsList&gt;
   */
  @GET("api/payments")
  Call<PaymentsList> getPayments(
    @retrofit2.http.Query("request_id") String requestId, @retrofit2.http.Query("currency") String currency, @retrofit2.http.Query("end_time") OffsetDateTime endTime, @retrofit2.http.Query("max_count") Integer maxCount, @retrofit2.http.Query("merchant_order_id") String merchantOrderId, @retrofit2.http.Query("payment_method") String paymentMethod, @retrofit2.http.Query("sort_order") String sortOrder, @retrofit2.http.Query("start_time") OffsetDateTime startTime
  );

  /**
   * Update payment
   * 
   * @param paymentId Payment ID (required)
   * @param paymentPatchRequest paymentPatchRequest (required)
   * @return Call&lt;PaymentUpdateResponse&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @PATCH("api/payments/{paymentId}")
  Call<PaymentUpdateResponse> updatePayment(
    @retrofit2.http.Path("paymentId") String paymentId, @retrofit2.http.Body PaymentPatchRequest paymentPatchRequest
  );

}

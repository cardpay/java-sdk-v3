package com.cardpay.sdk.api;

import com.cardpay.sdk.client.CollectionFormats.*;
import com.cardpay.sdk.model.PayoutRequest;
import com.cardpay.sdk.model.PayoutResponse;
import com.cardpay.sdk.model.PayoutUpdateRequest;
import com.cardpay.sdk.model.PayoutUpdateResponse;
import com.cardpay.sdk.model.PayoutsList;
import java.time.OffsetDateTime;
import retrofit2.Call;
import retrofit2.http.*;

public interface PayoutsApi {
  /**
   * Create payout
   * 
   * @param payoutRequest payoutRequest (required)
   * @return Call&lt;PayoutResponse&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("api/payouts")
  Call<PayoutResponse> createPayout(
    @retrofit2.http.Body PayoutRequest payoutRequest
  );

  /**
   * Read payout information
   * 
   * @param payoutId Payout ID (required)
   * @return Call&lt;PayoutResponse&gt;
   */
  @GET("api/payouts/{payoutId}")
  Call<PayoutResponse> getPayout(
    @retrofit2.http.Path("payoutId") String payoutId
  );

  /**
   * Get payouts information
   * 
   * @param requestId Request ID (required)
   * @param currency [ISO 4217](https://en.wikipedia.org/wiki/ISO_4217) currency code of transactions currency (optional)
   * @param endTime Date and time up to milliseconds (in [ISO 8601](https://en.wikipedia.org/wiki/ISO_8601) format) when requested period ends (not inclusive), UTC time, must be less than 7 days after &#39;start_time&#39;, default is current time (format: yyyy-MM-dd&#39;T&#39;HH:mm:ss&#39;Z&#39;) (optional)
   * @param maxCount Limit number of returned transactions (must be less than 10000, default is 1000) (optional)
   * @param merchantOrderId Merchant order number from the merchant system (optional)
   * @param paymentMethod Used payment method type name from payment methods list (optional)
   * @param sortOrder Sort based on order of results. &#x60;asc&#x60; for ascending order or &#x60;desc&#x60; for descending order (default value) (optional)
   * @param startTime Date and time up to milliseconds (in [ISO 8601](https://en.wikipedia.org/wiki/ISO_8601) format) when requested period starts (inclusive), UTC time, default is 24 hours before &#39;end_time&#39; (format: yyyy-MM-dd&#39;T&#39;HH:mm:ss&#39;Z&#39;) (optional)
   * @return Call&lt;PayoutsList&gt;
   */
  @GET("api/payouts")
  Call<PayoutsList> getPayouts(
    @retrofit2.http.Query("request_id") String requestId, @retrofit2.http.Query("currency") String currency, @retrofit2.http.Query("end_time") OffsetDateTime endTime, @retrofit2.http.Query("max_count") Integer maxCount, @retrofit2.http.Query("merchant_order_id") String merchantOrderId, @retrofit2.http.Query("payment_method") String paymentMethod, @retrofit2.http.Query("sort_order") String sortOrder, @retrofit2.http.Query("start_time") OffsetDateTime startTime
  );

  /**
   * Update payout
   * 
   * @param payoutId Payout ID (required)
   * @param payoutUpdateRequest payoutUpdateRequest (required)
   * @return Call&lt;PayoutUpdateResponse&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @PATCH("api/payouts/{payoutId}")
  Call<PayoutUpdateResponse> updatePayout(
    @retrofit2.http.Path("payoutId") String payoutId, @retrofit2.http.Body PayoutUpdateRequest payoutUpdateRequest
  );

}

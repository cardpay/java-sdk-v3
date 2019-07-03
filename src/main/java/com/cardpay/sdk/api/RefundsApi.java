package com.cardpay.sdk.api;

import com.cardpay.sdk.client.CollectionFormats.*;

import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okhttp3.MultipartBody;

import com.cardpay.sdk.model.ApiError;
import com.cardpay.sdk.model.AuthenticationError;
import com.cardpay.sdk.model.BadRequestError;
import com.cardpay.sdk.model.NotFoundError;
import com.cardpay.sdk.model.OAuthError;
import java.time.OffsetDateTime;
import com.cardpay.sdk.model.RefundRequest;
import com.cardpay.sdk.model.RefundResponse;
import com.cardpay.sdk.model.RefundUpdateRequest;
import com.cardpay.sdk.model.RefundUpdateResponse;
import com.cardpay.sdk.model.RefundsList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface RefundsApi {
  /**
   * Create refund
   * 
   * @param refundRequest refundRequest (required)
   * @return Call&lt;RefundResponse&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("api/refunds")
  Call<RefundResponse> createRefund(
    @retrofit2.http.Body RefundRequest refundRequest
  );

  /**
   * Get refund information
   * 
   * @param refundId Refund ID (required)
   * @return Call&lt;RefundResponse&gt;
   */
  @GET("api/refunds/{refundId}")
  Call<RefundResponse> getRefund(
    @retrofit2.http.Path("refundId") String refundId
  );

  /**
   * Get list of refunds
   * 
   * @param requestId Request ID (required)
   * @param currency [ISO 4217](https://en.wikipedia.org/wiki/ISO_4217) currency code of transactions currency (optional)
   * @param endTime Date and time up to milliseconds (in [ISO 8601](https://en.wikipedia.org/wiki/ISO_8601) format) when requested period ends (not inclusive), UTC time, must be less than 7 days after &#39;start_time&#39;, default is current time (format: yyyy-MM-dd&#39;T&#39;HH:mm:ss&#39;Z&#39;) (optional)
   * @param maxCount Limit number of returned transactions (must be less than 10000, default is 1000) (optional)
   * @param merchantOrderId Merchant order number from the merchant system (optional)
   * @param paymentMethod Used payment method type name from payment methods list (optional)
   * @param sortOrder Sort based on order of results. &#x60;asc&#x60; for ascending order or &#x60;desc&#x60; for descending order (default value) (optional)
   * @param startTime Date and time up to milliseconds (in [ISO 8601](https://en.wikipedia.org/wiki/ISO_8601) format) when requested period starts (inclusive), UTC time, default is 24 hours before &#39;end_time&#39; (format: yyyy-MM-dd&#39;T&#39;HH:mm:ss&#39;Z&#39;) (optional)
   * @return Call&lt;RefundsList&gt;
   */
  @GET("api/refunds")
  Call<RefundsList> getRefunds(
    @retrofit2.http.Query("request_id") String requestId, @retrofit2.http.Query("currency") String currency, @retrofit2.http.Query("end_time") OffsetDateTime endTime, @retrofit2.http.Query("max_count") Integer maxCount, @retrofit2.http.Query("merchant_order_id") String merchantOrderId, @retrofit2.http.Query("payment_method") String paymentMethod, @retrofit2.http.Query("sort_order") String sortOrder, @retrofit2.http.Query("start_time") OffsetDateTime startTime
  );

  /**
   * Update refund
   * 
   * @param refundId Refund ID (required)
   * @param refundUpdateRequest refundUpdateRequest (required)
   * @return Call&lt;RefundUpdateResponse&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @PATCH("api/refunds/{refundId}")
  Call<RefundUpdateResponse> updateRefund(
    @retrofit2.http.Path("refundId") String refundId, @retrofit2.http.Body RefundUpdateRequest refundUpdateRequest
  );

}

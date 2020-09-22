package com.cardpay.sdk.api;

import com.cardpay.sdk.client.CollectionFormats.*;
import com.cardpay.sdk.model.InstallmentSubscriptionRequest;
import com.cardpay.sdk.model.RecurringGatewayCreationResponse;
import com.cardpay.sdk.model.RecurringPatchRequest;
import com.cardpay.sdk.model.RecurringResponse;
import com.cardpay.sdk.model.RecurringsList;
import com.cardpay.sdk.model.ScheduleOptionsResponse;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.*;

public interface RecurringsInstallmentsApi {
  /**
   * Get calculation of installment payment options
   * 
   * @param currency [ISO 4217](https://en.wikipedia.org/wiki/ISO_4217) currency code (required)
   * @param requestId Request ID (required)
   * @param totalAmount Total amount of subscription to be calculated to options; can have dot as a decimal separator. (optional)
   * @return Call&lt;ScheduleOptionsResponse&gt;
   */
  @GET("api/installments/options_calculator")
  Call<ScheduleOptionsResponse> calculateSchedule(
    @retrofit2.http.Query("currency") String currency, @retrofit2.http.Query("request_id") String requestId, @retrofit2.http.Query("totalAmount") BigDecimal totalAmount
  );

  /**
   * Create installment
   * 
   * @param subscriptionRequest subscriptionRequest (required)
   * @return Call&lt;RecurringGatewayCreationResponse&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("api/installments")
  Call<RecurringGatewayCreationResponse> createInstallment(
    @retrofit2.http.Body InstallmentSubscriptionRequest subscriptionRequest
  );

  /**
   * Get installment payment
   * 
   * @param recurringId Recurring ID (required)
   * @return Call&lt;RecurringResponse&gt;
   */
  @GET("api/installments/{recurringId}")
  Call<RecurringResponse> getInstallmentPayment(
    @retrofit2.http.Path("recurringId") String recurringId
  );

  /**
   * Get installment payments
   * 
   * @param requestId Request ID (required)
   * @param currency [ISO 4217](https://en.wikipedia.org/wiki/ISO_4217) currency code of transactions currency (optional)
   * @param endTime Date and time up to milliseconds (in [ISO 8601](https://en.wikipedia.org/wiki/ISO_8601) format) when requested period ends (not inclusive), UTC time, must be less than 7 days after &#39;start_time&#39;, default is current time (format: yyyy-MM-dd&#39;T&#39;HH:mm:ss&#39;Z&#39;) (optional)
   * @param maxCount Limit number of returned transactions (must be less than 10000, default is 1000) (optional)
   * @param merchantOrderId Merchant order number from the merchant system (optional)
   * @param paymentMethod Used payment method type name from payment methods list (optional)
   * @param recurringTypes  (optional)
   * @param sortOrder Sort based on order of results. &#x60;asc&#x60; for ascending order or &#x60;desc&#x60; for descending order (default value) (optional)
   * @param startTime Date and time up to milliseconds (in [ISO 8601](https://en.wikipedia.org/wiki/ISO_8601) format) when requested period starts (inclusive), UTC time, default is 24 hours before &#39;end_time&#39; (format: yyyy-MM-dd&#39;T&#39;HH:mm:ss&#39;Z&#39;) (optional)
   * @param type Filter recurring payments by certain type (applicable to /api/recurrings endpoint only): &#x60;SCHEDULED&#x60; for scheduled recurring payments &#x60;ONECLICK&#x60; for one-click payments &#x60;INSTALLMENT&#x60; for installment payments (optional)
   * @return Call&lt;RecurringsList&gt;
   */
  @GET("api/installments")
  Call<RecurringsList> getInstallmentPayments(
    @retrofit2.http.Query("request_id") String requestId, @retrofit2.http.Query("currency") String currency, @retrofit2.http.Query("end_time") OffsetDateTime endTime, @retrofit2.http.Query("max_count") Integer maxCount, @retrofit2.http.Query("merchant_order_id") String merchantOrderId, @retrofit2.http.Query("payment_method") String paymentMethod, @retrofit2.http.Query("recurring_types") List<String> recurringTypes, @retrofit2.http.Query("sort_order") String sortOrder, @retrofit2.http.Query("start_time") OffsetDateTime startTime, @retrofit2.http.Query("type") String type
  );

  /**
   * Update installment payment
   * 
   * @param recurringId Recurring ID (required)
   * @param recurringPatchRequest Recurring patch request (required)
   * @return Call&lt;RecurringResponse&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @PATCH("api/installments/{recurringId}")
  Call<RecurringResponse> updateInstallmentPayment(
    @retrofit2.http.Path("recurringId") String recurringId, @retrofit2.http.Body RecurringPatchRequest recurringPatchRequest
  );

}

package com.cardpay.sdk.api;

import com.cardpay.sdk.client.CollectionFormats.*;
import com.cardpay.sdk.model.AuthenticationDataResponse;
import com.cardpay.sdk.model.ChangeSubscriptionStatusClaimResponse;
import com.cardpay.sdk.model.FilingRequest;
import com.cardpay.sdk.model.PlanDataList;
import com.cardpay.sdk.model.PlanUpdateRequest;
import com.cardpay.sdk.model.PlanUpdateResponse;
import com.cardpay.sdk.model.RecurringCreationRequest;
import com.cardpay.sdk.model.RecurringGatewayCreationResponse;
import com.cardpay.sdk.model.RecurringPatchRequest;
import com.cardpay.sdk.model.RecurringPlanRequest;
import com.cardpay.sdk.model.RecurringPlanResponse;
import com.cardpay.sdk.model.RecurringResponse;
import com.cardpay.sdk.model.RecurringUpdateResponse;
import com.cardpay.sdk.model.RecurringsList;
import com.cardpay.sdk.model.SubscriptionGetResponse;
import com.cardpay.sdk.model.SubscriptionList;
import com.cardpay.sdk.model.SubscriptionUpdateRequest;
import com.cardpay.sdk.model.SubscriptionUpdateResponse;
import java.time.OffsetDateTime;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.*;

public interface RecurringsApi {
  /**
   * Create filing
   * 
   * @param filingRequest Filing request parameters (optional)
   * @return Call&lt;RecurringGatewayCreationResponse&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("api/recurring_filings")
  Call<RecurringGatewayCreationResponse> createFiling(
    @retrofit2.http.Body FilingRequest filingRequest
  );

  /**
   * Create recurring plan
   * 
   * @param recurringPlanRequest recurringPlanRequest (required)
   * @return Call&lt;RecurringPlanResponse&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("api/recurring_plans")
  Call<RecurringPlanResponse> createPlan(
    @retrofit2.http.Body RecurringPlanRequest recurringPlanRequest
  );

  /**
   * Create recurring
   * 
   * @param recurringRequest Recurring Request (required)
   * @return Call&lt;RecurringGatewayCreationResponse&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("api/recurrings")
  Call<RecurringGatewayCreationResponse> createRecurring(
    @retrofit2.http.Body RecurringCreationRequest recurringRequest
  );

  /**
   * Delete plan
   * 
   * @param planId Plan ID (required)
   * @return Call&lt;Void&gt;
   */
  @DELETE("api/recurring_plans/{plan_id}")
  Call<Void> deletePlan(
    @retrofit2.http.Path("plan_id") String planId
  );

  /**
   * Get recurring payment 3DS result information
   * 
   * @param recurringId Recurring ID (required)
   * @return Call&lt;AuthenticationDataResponse&gt;
   */
  @GET("api/recurrings/{recurringId}/threedsecure")
  Call<AuthenticationDataResponse> getAuthenticationData1(
    @retrofit2.http.Path("recurringId") String recurringId
  );

  /**
   * Get information about Change subscription status claim
   * 
   * @param claimId claimId (required)
   * @param subscriptionId subscription id (required)
   * @return Call&lt;ChangeSubscriptionStatusClaimResponse&gt;
   */
  @GET("api/recurring_subscriptions/{subscriptionId}/change_status_claims/{claimId}")
  Call<ChangeSubscriptionStatusClaimResponse> getChangeStatusClaim(
    @retrofit2.http.Path("claimId") String claimId, @retrofit2.http.Path("subscriptionId") String subscriptionId
  );

  /**
   * Get filing order information
   * 
   * @param filingId filing order id (required)
   * @return Call&lt;RecurringResponse&gt;
   */
  @GET("api/recurring_filings/{filingId}")
  Call<RecurringResponse> getFiling(
    @retrofit2.http.Path("filingId") String filingId
  );

  /**
   * Get plan information
   * 
   * @param planId Plan ID (required)
   * @return Call&lt;RecurringPlanResponse&gt;
   */
  @GET("api/recurring_plans/{plan_id}")
  Call<RecurringPlanResponse> getPlan(
    @retrofit2.http.Path("plan_id") String planId
  );

  /**
   * Get plans information
   * 
   * @param requestId Request ID (required)
   * @param maxCount Limit number of returned plans (must be less than 10000, default is 1000) (optional)
   * @param offset Offset (must be less than 10000) (optional)
   * @param sortOrder Sort based on order of results. &#39;asc&#39; for ascending order or &#39;desc&#39; for descending order (default value) (optional)
   * @return Call&lt;PlanDataList&gt;
   */
  @GET("api/recurring_plans")
  Call<PlanDataList> getPlans(
    @retrofit2.http.Query("request_id") String requestId, @retrofit2.http.Query("max_count") Integer maxCount, @retrofit2.http.Query("offset") Integer offset, @retrofit2.http.Query("sort_order") String sortOrder
  );

  /**
   * Get recurring information
   * 
   * @param recurringId Recurring ID (required)
   * @return Call&lt;RecurringResponse&gt;
   */
  @GET("api/recurrings/{recurringId}")
  Call<RecurringResponse> getRecurring(
    @retrofit2.http.Path("recurringId") String recurringId
  );

  /**
   * Get recurring list information
   * 
   * @param requestId Request ID (required)
   * @param currency [ISO 4217](https://en.wikipedia.org/wiki/ISO_4217) currency code of transactions currency (optional)
   * @param endTime Date and time up to milliseconds (in [ISO 8601](https://en.wikipedia.org/wiki/ISO_8601) format) when requested period ends (not inclusive), UTC time, must be less than 7 days after &#39;start_time&#39;, default is current time (format: yyyy-MM-dd&#39;T&#39;HH:mm:ss&#39;Z&#39;) (optional)
   * @param maxCount Limit number of returned transactions (must be less than 10000, default is 1000, minimal value is 1) (optional)
   * @param merchantOrderId Merchant order number from the merchant system (optional)
   * @param paymentMethod Used payment method type name from payment methods list (optional)
   * @param recurringTypes  (optional)
   * @param sortOrder Sort based on order of results. &#x60;asc&#x60; for ascending order or &#x60;desc&#x60; for descending order (default value) (optional)
   * @param startTime Date and time up to milliseconds (in [ISO 8601](https://en.wikipedia.org/wiki/ISO_8601) format) when requested period starts (inclusive), UTC time, default is 24 hours before &#39;end_time&#39; (format: yyyy-MM-dd&#39;T&#39;HH:mm:ss&#39;Z&#39;) (optional)
   * @param type Filter recurring payments by certain type (applicable to /api/recurrings endpoint only): &#x60;SCHEDULED&#x60; for scheduled recurring payments &#x60;ONECLICK&#x60; for one-click payments &#x60;INSTALLMENT&#x60; for installment payments (optional)
   * @return Call&lt;RecurringsList&gt;
   */
  @GET("api/recurrings")
  Call<RecurringsList> getRecurrings(
    @retrofit2.http.Query("request_id") String requestId, @retrofit2.http.Query("currency") String currency, @retrofit2.http.Query("end_time") OffsetDateTime endTime, @retrofit2.http.Query("max_count") Integer maxCount, @retrofit2.http.Query("merchant_order_id") String merchantOrderId, @retrofit2.http.Query("payment_method") String paymentMethod, @retrofit2.http.Query("recurring_types") List<String> recurringTypes, @retrofit2.http.Query("sort_order") String sortOrder, @retrofit2.http.Query("start_time") OffsetDateTime startTime, @retrofit2.http.Query("type") String type
  );

  /**
   * Get subscription information
   * 
   * @param subscriptionId subscription id (required)
   * @return Call&lt;SubscriptionGetResponse&gt;
   */
  @GET("api/recurring_subscriptions/{subscriptionId}")
  Call<SubscriptionGetResponse> getSubscription(
    @retrofit2.http.Path("subscriptionId") String subscriptionId
  );

  /**
   * Get subscription information
   * 
   * @param requestId Request ID (required)
   * @param accountId Merchant identifier of customer account (optional)
   * @param currency [ISO 4217](https://en.wikipedia.org/wiki/ISO_4217) currency code of transactions currency (optional)
   * @param endTime Date and time up to milliseconds (in [ISO 8601](https://en.wikipedia.org/wiki/ISO_8601) format) when requested period ends (not inclusive), UTC time, must be less than 7 days after &#39;start_time&#39;, default is current time (format: yyyy-MM-dd&#39;T&#39;HH:mm:ss&#39;Z&#39;) (optional)
   * @param maxCount Limit number of returned subscriptions (must be less than 10000, default is 1000) (optional)
   * @param offset Offset (must be less than 10000) (optional)
   * @param planId Id of plan. Use for searching scheduled subscriptions by plan (optional)
   * @param sortOrder Sort based on order of results. &#39;asc&#39; for ascending order or &#39;desc&#39; for descending order (default value) (optional)
   * @param startTime Date and time up to milliseconds (in [ISO 8601](https://en.wikipedia.org/wiki/ISO_8601) format) when requested period starts (inclusive), UTC time, default is 24 hours before &#39;end_time&#39; (format: yyyy-MM-dd&#39;T&#39;HH:mm:ss&#39;Z&#39;) (optional)
   * @param status Status of subscription (optional)
   * @param type Type of subscription. &#39;ONECLICK&#39; type will be ignored. (optional)
   * @return Call&lt;SubscriptionList&gt;
   */
  @GET("api/recurring_subscriptions")
  Call<SubscriptionList> getSubscriptions(
    @retrofit2.http.Query("request_id") String requestId, @retrofit2.http.Query("account_id") String accountId, @retrofit2.http.Query("currency") String currency, @retrofit2.http.Query("end_time") OffsetDateTime endTime, @retrofit2.http.Query("max_count") Integer maxCount, @retrofit2.http.Query("offset") Integer offset, @retrofit2.http.Query("plan_id") String planId, @retrofit2.http.Query("sort_order") String sortOrder, @retrofit2.http.Query("start_time") OffsetDateTime startTime, @retrofit2.http.Query("status") String status, @retrofit2.http.Query("type") String type
  );

  /**
   * Update plan
   * 
   * @param planId Plan ID (required)
   * @param planUpdateRequest planUpdateRequest (required)
   * @return Call&lt;PlanUpdateResponse&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @PATCH("api/recurring_plans/{plan_id}")
  Call<PlanUpdateResponse> updatePlan(
    @retrofit2.http.Path("plan_id") String planId, @retrofit2.http.Body PlanUpdateRequest planUpdateRequest
  );

  /**
   * Update recurring
   * 
   * @param recurringId Recurring ID (required)
   * @param recurringPatchRequest recurringPatchRequest (required)
   * @return Call&lt;RecurringUpdateResponse&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @PATCH("api/recurrings/{recurringId}")
  Call<RecurringUpdateResponse> updateRecurring(
    @retrofit2.http.Path("recurringId") String recurringId, @retrofit2.http.Body RecurringPatchRequest recurringPatchRequest
  );

  /**
   * Update subscription
   * 
   * @param subscriptionId Subscription ID (required)
   * @param subscriptionUpdateRequest subscriptionUpdateRequest (required)
   * @return Call&lt;SubscriptionUpdateResponse&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @PATCH("api/recurring_subscriptions/{subscriptionId}")
  Call<SubscriptionUpdateResponse> updateSubscription(
    @retrofit2.http.Path("subscriptionId") String subscriptionId, @retrofit2.http.Body SubscriptionUpdateRequest subscriptionUpdateRequest
  );

}

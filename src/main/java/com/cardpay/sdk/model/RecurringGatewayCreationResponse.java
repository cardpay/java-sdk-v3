/*
 * CardPay REST API
 * Welcome to the CardPay REST API. The CardPay API uses HTTP verbs and a [REST](https://en.wikipedia.org/wiki/Representational_state_transfer) resources endpoint structure (see more info about REST). Request and response payloads are formatted as JSON. Merchant uses API to create payments, refunds, payouts or recurrings, check or update transaction status and get information about created transactions. In API authentication process based on [OAuth 2.0](https://oauth.net/2/) standard. For recent changes see changelog section.
 *
 * OpenAPI spec version: 3.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package com.cardpay.sdk.model;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data

public class RecurringGatewayCreationResponse {
  @SerializedName("recurring_data")
  private RecurringGatewayResponseRecurringData recurringData = null;
  @SerializedName("subscription")
  private Subscription subscription = null;
  @SerializedName("redirect_url")
  private String redirectUrl = null;
  
  public void setRecurringData(RecurringGatewayResponseRecurringData recurringData) {
      this.recurringData = recurringData;
  }

  /**
   * @param recurringData Recurring data
   * @return bean instance
   **/
  public RecurringGatewayCreationResponse recurringData(RecurringGatewayResponseRecurringData recurringData) {
      this.recurringData = recurringData;
      return this;
  }

  
  public void setSubscription(Subscription subscription) {
      this.subscription = subscription;
  }

  /**
   * @param subscription Subscription (applicable to scheduled payments and installment payments)
   * @return bean instance
   **/
  public RecurringGatewayCreationResponse subscription(Subscription subscription) {
      this.subscription = subscription;
      return this;
  }

  
  public void setRedirectUrl(String redirectUrl) {
      this.redirectUrl = redirectUrl;
  }

  /**
   * @param redirectUrl URL Customer should be redirected to
   * @return bean instance
   **/
  public RecurringGatewayCreationResponse redirectUrl(String redirectUrl) {
      this.redirectUrl = redirectUrl;
      return this;
  }


  @Override
  public String toString() {
     StringBuilder sb = new StringBuilder();
     sb.append("RecurringGatewayCreationResponse( ");
     
     if (recurringData != null) sb.append("recurringData=").append(recurringData.toString()).append("; ");
     if (subscription != null) sb.append("subscription=").append(subscription.toString()).append("; ");
     if (redirectUrl != null) sb.append("redirectUrl=").append(redirectUrl.toString()).append("; ");
     sb.append(")");
     return sb.toString();
  }

}

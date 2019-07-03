/*
 * CardPay REST API
 * Welcome to the CardPay REST API. The CardPay API uses HTTP verbs and a REST resources endpoint structure (see more info about REST). Request and response payloads are formatted as JSON. Merchant uses API to create payments, refunds, payouts or recurrings, check or update transaction status and get information about created transactions. In API authentication process based on OAuth 2.0 standard. For recent changes see changelog section.
 *
 * OpenAPI spec version: 3.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package com.cardpay.sdk.model;

import java.util.Objects;
import java.util.Arrays;
import com.cardpay.sdk.model.UpdatedSubscriptionData;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import lombok.Data;

@Data

public class SubscriptionUpdateResponse {
  @SerializedName("subscription_data")
  private UpdatedSubscriptionData subscriptionData = null;
  
  public void setSubscriptionData(UpdatedSubscriptionData subscriptionData) {
      this.subscriptionData = subscriptionData;
  }

  /**
   * @param subscriptionData subscriptionData
   * @return bean instance
   **/
  public SubscriptionUpdateResponse subscriptionData(UpdatedSubscriptionData subscriptionData) {
      this.subscriptionData = subscriptionData;
      return this;
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SubscriptionUpdateResponse {\n");
    
    if (subscriptionData != null) sb.append("    subscriptionData: ").append(toIndentedString(subscriptionData)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }


}


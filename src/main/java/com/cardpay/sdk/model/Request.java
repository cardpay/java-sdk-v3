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
import java.time.OffsetDateTime;
import lombok.Data;

@Data

public class Request {
  @SerializedName("id")
  private String id = null;
  @SerializedName("time")
  private OffsetDateTime time = null;
  
  public void setId(String id) {
      this.id = id;
  }

  /**
   * @param id Request ID, should be unique for time period of 30 minutes
   * @return bean instance
   **/
  public Request id(String id) {
      this.id = id;
      return this;
  }

  
  public void setTime(OffsetDateTime time) {
      this.time = time;
  }

  /**
   * @param time Request attempt date and time up to milliseconds in [ISO 8601](https://en.wikipedia.org/wiki/ISO_8601) format (example of format - yyyy-MM dd&#39;T&#39;HH:mm:ss&#39;Z&#39;) Should be current server time of request (UTC time) or shouldn&#39;t be more than +3 hours or less than -3 hours from current UTC time.
   * @return bean instance
   **/
  public Request time(OffsetDateTime time) {
      this.time = time;
      return this;
  }


  @Override
  public String toString() {
     StringBuilder sb = new StringBuilder();
     sb.append("Request( ");
     
     if (id != null) sb.append("id=").append(id.toString()).append("; ");
     if (time != null) sb.append("time=").append(time.toString()).append("; ");
     sb.append(")");
     return sb.toString();
  }

}


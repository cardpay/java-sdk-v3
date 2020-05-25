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

public class RefundUpdateRequest {
  @SerializedName("request")
  private Request request = null;
  @SerializedName("refund_data")
  private RequestUpdatedTransactionData refundData = null;
  
  public void setRequest(Request request) {
      this.request = request;
  }

  /**
   * @param request Request
   * @return bean instance
   **/
  public RefundUpdateRequest request(Request request) {
      this.request = request;
      return this;
  }

  
  public void setRefundData(RequestUpdatedTransactionData refundData) {
      this.refundData = refundData;
  }

  /**
   * @param refundData Transaction data
   * @return bean instance
   **/
  public RefundUpdateRequest refundData(RequestUpdatedTransactionData refundData) {
      this.refundData = refundData;
      return this;
  }


  @Override
  public String toString() {
     StringBuilder sb = new StringBuilder();
     sb.append("RefundUpdateRequest( ");
     
     if (request != null) sb.append("request=").append(request.toString()).append("; ");
     if (refundData != null) sb.append("refundData=").append(refundData.toString()).append("; ");
     sb.append(")");
     return sb.toString();
  }

}


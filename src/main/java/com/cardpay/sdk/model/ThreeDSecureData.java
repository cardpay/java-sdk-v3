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

public class ThreeDSecureData {
  @SerializedName("card_enrollment")
  private String cardEnrollment = null;
  @SerializedName("cavv")
  private String cavv = null;
  @SerializedName("cavv_algorithm")
  private String cavvAlgorithm = null;
  @SerializedName("pa_res")
  private String paRes = null;
  @SerializedName("status")
  private String status = null;
  @SerializedName("three_d_secure_flow")
  private String threeDSecureFlow = null;
  @SerializedName("xid")
  private String xid = null;
  
  public void setCardEnrollment(String cardEnrollment) {
      this.cardEnrollment = cardEnrollment;
  }

  /**
   * @param cardEnrollment Card enrollment in 3DS flow, possible values are: S - 3D Secure Skipped, N - 3D Secure not enrolled, Y - 3D Secure enrolled
   * @return bean instance
   **/
  public ThreeDSecureData cardEnrollment(String cardEnrollment) {
      this.cardEnrollment = cardEnrollment;
      return this;
  }

  
  public void setCavv(String cavv) {
      this.cavv = cavv;
  }

  /**
   * @param cavv Cardholder authentication verification value
   * @return bean instance
   **/
  public ThreeDSecureData cavv(String cavv) {
      this.cavv = cavv;
      return this;
  }

  
  public void setCavvAlgorithm(String cavvAlgorithm) {
      this.cavvAlgorithm = cavvAlgorithm;
  }

  /**
   * @param cavvAlgorithm CAVV algorithm
   * @return bean instance
   **/
  public ThreeDSecureData cavvAlgorithm(String cavvAlgorithm) {
      this.cavvAlgorithm = cavvAlgorithm;
      return this;
  }

  
  public void setPaRes(String paRes) {
      this.paRes = paRes;
  }

  /**
   * @param paRes PaRes bank authentication result
   * @return bean instance
   **/
  public ThreeDSecureData paRes(String paRes) {
      this.paRes = paRes;
      return this;
  }

  
  public void setStatus(String status) {
      this.status = status;
  }

  /**
   * @param status 3DS status (from PaRes for 3Ds 1.0, ARes message for 3Ds 2.0) (possible values Y,A,U)
   * @return bean instance
   **/
  public ThreeDSecureData status(String status) {
      this.status = status;
      return this;
  }

  
  public void setThreeDSecureFlow(String threeDSecureFlow) {
      this.threeDSecureFlow = threeDSecureFlow;
  }

  /**
   * @param threeDSecureFlow Possible values: 3DS1 - 3DS 1.0 flow, 3DS2C - 3DS 2.0 challenge flow, 3DS2F - 3DS 2.0 frictionless flow
   * @return bean instance
   **/
  public ThreeDSecureData threeDSecureFlow(String threeDSecureFlow) {
      this.threeDSecureFlow = threeDSecureFlow;
      return this;
  }

  
  public void setXid(String xid) {
      this.xid = xid;
  }

  /**
   * @param xid Transaction Id in PaRes
   * @return bean instance
   **/
  public ThreeDSecureData xid(String xid) {
      this.xid = xid;
      return this;
  }


  @Override
  public String toString() {
     StringBuilder sb = new StringBuilder();
     sb.append("ThreeDSecureData( ");
     
     if (cardEnrollment != null) sb.append("cardEnrollment=").append(cardEnrollment.toString()).append("; ");
     if (cavv != null) sb.append("cavv=").append(cavv.toString()).append("; ");
     if (cavvAlgorithm != null) sb.append("cavvAlgorithm=").append(cavvAlgorithm.toString()).append("; ");
     if (paRes != null) sb.append("paRes=").append(paRes.toString()).append("; ");
     if (status != null) sb.append("status=").append(status.toString()).append("; ");
     if (threeDSecureFlow != null) sb.append("threeDSecureFlow=").append(threeDSecureFlow.toString()).append("; ");
     if (xid != null) sb.append("xid=").append(xid.toString()).append("; ");
     sb.append(")");
     return sb.toString();
  }

}


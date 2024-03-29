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

public class DisputeResponsePaymentData {
  @SerializedName("amount")
  private String amount = null;
  @SerializedName("arn")
  private String arn = null;
  @SerializedName("auth_code")
  private String authCode = null;
  @SerializedName("created")
  private String created = null;
  @SerializedName("currency")
  private String currency = null;
  @SerializedName("id")
  private String id = null;
  
  public void setAmount(String amount) {
      this.amount = amount;
  }

  /**
   * @param amount Payment amount
   * @return bean instance
   **/
  public DisputeResponsePaymentData amount(String amount) {
      this.amount = amount;
      return this;
  }

  
  public void setArn(String arn) {
      this.arn = arn;
  }

  /**
   * @param arn ARN (Acquirer Reference Number), supplied by the acquiring financial institution, return only after receiving ARN from bank acquirer
   * @return bean instance
   **/
  public DisputeResponsePaymentData arn(String arn) {
      this.arn = arn;
      return this;
  }

  
  public void setAuthCode(String authCode) {
      this.authCode = authCode;
  }

  /**
   * @param authCode Authorization code, provided by bank
   * @return bean instance
   **/
  public DisputeResponsePaymentData authCode(String authCode) {
      this.authCode = authCode;
      return this;
  }

  
  public void setCreated(String created) {
      this.created = created;
  }

  /**
   * @param created Payment creation date in [ISO 8601](https://en.wikipedia.org/wiki/ISO_8601) format (format - yyyy-MM-dd&#39;T&#39;HH:mm:ss&#39;Z&#39;)
   * @return bean instance
   **/
  public DisputeResponsePaymentData created(String created) {
      this.created = created;
      return this;
  }

  
  public void setCurrency(String currency) {
      this.currency = currency;
  }

  /**
   * @param currency Payment currency
   * @return bean instance
   **/
  public DisputeResponsePaymentData currency(String currency) {
      this.currency = currency;
      return this;
  }

  
  public void setId(String id) {
      this.id = id;
  }

  /**
   * @param id Unlimit&#39;s payment id
   * @return bean instance
   **/
  public DisputeResponsePaymentData id(String id) {
      this.id = id;
      return this;
  }


  @Override
  public String toString() {
     StringBuilder sb = new StringBuilder();
     sb.append("DisputeResponsePaymentData( ");
     
     if (amount != null) sb.append("amount=").append(amount.toString()).append("; ");
     if (arn != null) sb.append("arn=").append(arn.toString()).append("; ");
     if (authCode != null) sb.append("authCode=").append(authCode.toString()).append("; ");
     if (created != null) sb.append("created=").append(created.toString()).append("; ");
     if (currency != null) sb.append("currency=").append(currency.toString()).append("; ");
     if (id != null) sb.append("id=").append(id.toString()).append("; ");
     sb.append(")");
     return sb.toString();
  }

}


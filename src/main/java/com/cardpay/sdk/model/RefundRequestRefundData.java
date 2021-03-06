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
import java.math.BigDecimal;
import lombok.Data;

@Data

public class RefundRequestRefundData {
  @SerializedName("amount")
  private BigDecimal amount = null;
  @SerializedName("currency")
  private String currency = null;
  
  public void setAmount(BigDecimal amount) {
      this.amount = amount;
  }

  /**
   * minimum: 0
   * @param amount Amount to be refunded. If &#39;amount&#39; field is omitted then all remaining amount will be refunded
   * @return bean instance
   **/
  public RefundRequestRefundData amount(BigDecimal amount) {
      this.amount = amount;
      return this;
  }

  
  public void setCurrency(String currency) {
      this.currency = currency;
  }

  /**
   * @param currency [ISO 4217](https://en.wikipedia.org/wiki/ISO_4217) currency code. Not valid without &#39;amount&#39; field. Must be equal to initial payment currency
   * @return bean instance
   **/
  public RefundRequestRefundData currency(String currency) {
      this.currency = currency;
      return this;
  }


  @Override
  public String toString() {
     StringBuilder sb = new StringBuilder();
     sb.append("RefundRequestRefundData( ");
     
     if (amount != null) sb.append("amount=").append(amount.toString()).append("; ");
     if (currency != null) sb.append("currency=").append(currency.toString()).append("; ");
     sb.append(")");
     return sb.toString();
  }

}


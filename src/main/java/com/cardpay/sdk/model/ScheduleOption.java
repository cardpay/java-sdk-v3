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

public class ScheduleOption {
  @SerializedName("amount")
  private BigDecimal amount = null;
  @SerializedName("installments")
  private Integer installments = null;
  
  public void setAmount(BigDecimal amount) {
      this.amount = amount;
  }

  /**
   * @param amount Amount per one payment.
   * @return bean instance
   **/
  public ScheduleOption amount(BigDecimal amount) {
      this.amount = amount;
      return this;
  }

  
  public void setInstallments(Integer installments) {
      this.installments = installments;
  }

  /**
   * @param installments Number of payments, can be 3-12.
   * @return bean instance
   **/
  public ScheduleOption installments(Integer installments) {
      this.installments = installments;
      return this;
  }


  @Override
  public String toString() {
     StringBuilder sb = new StringBuilder();
     sb.append("ScheduleOption( ");
     
     if (amount != null) sb.append("amount=").append(amount.toString()).append("; ");
     if (installments != null) sb.append("installments=").append(installments.toString()).append("; ");
     sb.append(")");
     return sb.toString();
  }

}


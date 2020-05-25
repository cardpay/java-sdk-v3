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

public class PaymentRequestCryptocurrencyAccount {
  @SerializedName("rollback_address")
  private String rollbackAddress = null;
  
  public void setRollbackAddress(String rollbackAddress) {
      this.rollbackAddress = rollbackAddress;
  }

  /**
   * @param rollbackAddress Customer&#39;s bitcoin address to be used for rollback
   * @return bean instance
   **/
  public PaymentRequestCryptocurrencyAccount rollbackAddress(String rollbackAddress) {
      this.rollbackAddress = rollbackAddress;
      return this;
  }


  @Override
  public String toString() {
     StringBuilder sb = new StringBuilder();
     sb.append("PaymentRequestCryptocurrencyAccount( ");
     
     if (rollbackAddress != null) sb.append("rollbackAddress=").append(rollbackAddress.toString()).append("; ");
     sb.append(")");
     return sb.toString();
  }

}


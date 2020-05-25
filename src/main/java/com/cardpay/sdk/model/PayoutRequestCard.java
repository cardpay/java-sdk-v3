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

public class PayoutRequestCard {
  @SerializedName("expiration")
  private String expiration = null;
  @SerializedName("pan")
  private String pan = null;
  
  public void setExpiration(String expiration) {
      this.expiration = expiration;
  }

  /**
   * @param expiration Customer&#39;s card expiration date. Format: &#x60;mm/yyyy&#x60;
   * @return bean instance
   **/
  public PayoutRequestCard expiration(String expiration) {
      this.expiration = expiration;
      return this;
  }

  
  public void setPan(String pan) {
      this.pan = pan;
  }

  /**
   * @param pan Customer&#39;s card number (PAN). Any valid card number, may contain spaces. Required if &#x60;card_account.token&#x60; element isn&#39;t presented
   * @return bean instance
   **/
  public PayoutRequestCard pan(String pan) {
      this.pan = pan;
      return this;
  }


  @Override
  public String toString() {
     StringBuilder sb = new StringBuilder();
     sb.append("PayoutRequestCard( ");
     
     if (expiration != null) sb.append("expiration=").append(expiration.toString()).append("; ");
     if (pan != null) sb.append("pan=").append(pan.toString()).append("; ");
     sb.append(")");
     return sb.toString();
  }

}


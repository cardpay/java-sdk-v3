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

public class MobileVerificationRequest {
  @SerializedName("nonce")
  private String nonce = null;
  @SerializedName("jwsResult")
  private String jwsResult = null;
  
  public void setNonce(String nonce) {
      this.nonce = nonce;
  }

  /**
   * @param nonce Application&#39;s nonce
   * @return bean instance
   **/
  public MobileVerificationRequest nonce(String nonce) {
      this.nonce = nonce;
      return this;
  }

  
  public void setJwsResult(String jwsResult) {
      this.jwsResult = jwsResult;
  }

  /**
   * @param jwsResult Application&#39;s JWS result. Format of a JWS is: &lt;Base64url encoded header&gt;.&lt;Base64url encoded JSON data&gt;.&lt;Base64url encoded signature&gt;
   * @return bean instance
   **/
  public MobileVerificationRequest jwsResult(String jwsResult) {
      this.jwsResult = jwsResult;
      return this;
  }


  @Override
  public String toString() {
     StringBuilder sb = new StringBuilder();
     sb.append("MobileVerificationRequest( ");
     
     if (nonce != null) sb.append("nonce=").append(nonce.toString()).append("; ");
     if (jwsResult != null) sb.append("jwsResult=").append(jwsResult.toString()).append("; ");
     sb.append(")");
     return sb.toString();
  }

}


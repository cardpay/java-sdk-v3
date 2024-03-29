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

public class AuthenticationCreateResponse {
  @SerializedName("authentication_data")
  private AuthenticationData authenticationData = null;
  @SerializedName("redirect_url")
  private String redirectUrl = null;
  
  public void setAuthenticationData(AuthenticationData authenticationData) {
      this.authenticationData = authenticationData;
  }

  /**
   * @param authenticationData Authentication data
   * @return bean instance
   **/
  public AuthenticationCreateResponse authenticationData(AuthenticationData authenticationData) {
      this.authenticationData = authenticationData;
      return this;
  }

  
  public void setRedirectUrl(String redirectUrl) {
      this.redirectUrl = redirectUrl;
  }

  /**
   * @param redirectUrl URL Customer should be redirected to
   * @return bean instance
   **/
  public AuthenticationCreateResponse redirectUrl(String redirectUrl) {
      this.redirectUrl = redirectUrl;
      return this;
  }


  @Override
  public String toString() {
     StringBuilder sb = new StringBuilder();
     sb.append("AuthenticationCreateResponse( ");
     
     if (authenticationData != null) sb.append("authenticationData=").append(authenticationData.toString()).append("; ");
     if (redirectUrl != null) sb.append("redirectUrl=").append(redirectUrl.toString()).append("; ");
     sb.append(")");
     return sb.toString();
  }

}


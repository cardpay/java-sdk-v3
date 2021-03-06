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

public class PayoutRequestCryptocurrencyAccount {
  @SerializedName("crypto_address")
  private String cryptoAddress = null;
  
  public void setCryptoAddress(String cryptoAddress) {
      this.cryptoAddress = cryptoAddress;
  }

  /**
   * @param cryptoAddress Customer&#39;s bitcoin address can be used for payout *(for BITCOIN method only)*
   * @return bean instance
   **/
  public PayoutRequestCryptocurrencyAccount cryptoAddress(String cryptoAddress) {
      this.cryptoAddress = cryptoAddress;
      return this;
  }


  @Override
  public String toString() {
     StringBuilder sb = new StringBuilder();
     sb.append("PayoutRequestCryptocurrencyAccount( ");
     
     if (cryptoAddress != null) sb.append("cryptoAddress=").append(cryptoAddress.toString()).append("; ");
     sb.append(")");
     return sb.toString();
  }

}


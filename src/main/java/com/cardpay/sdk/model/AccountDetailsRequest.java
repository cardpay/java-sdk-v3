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
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data

public class AccountDetailsRequest {
  @SerializedName("account_info")
  private List<MapOfstringAndstring> accountInfo = null;
  @SerializedName("customer_identity")
  private String customerIdentity = null;
  
  public void setAccountInfo(List<MapOfstringAndstring> accountInfo) {
      this.accountInfo = accountInfo;
  }

  /**
   * @param accountInfo Customer account information
   * @return bean instance
   **/
  public AccountDetailsRequest accountInfo(List<MapOfstringAndstring> accountInfo) {
      this.accountInfo = accountInfo;
      return this;
  }

  public AccountDetailsRequest addAccountInfoItem(MapOfstringAndstring accountInfoItem) {
    if (this.accountInfo == null) {
      this.accountInfo = new ArrayList<>();
    }
    this.accountInfo.add(accountInfoItem);
    return this;
  }

  
  public void setCustomerIdentity(String customerIdentity) {
      this.customerIdentity = customerIdentity;
  }

  /**
   * @param customerIdentity Customer identity
   * @return bean instance
   **/
  public AccountDetailsRequest customerIdentity(String customerIdentity) {
      this.customerIdentity = customerIdentity;
      return this;
  }


  @Override
  public String toString() {
     StringBuilder sb = new StringBuilder();
     sb.append("AccountDetailsRequest( ");
     
     if (accountInfo != null) sb.append("accountInfo=").append(accountInfo.toString()).append("; ");
     if (customerIdentity != null) sb.append("customerIdentity=").append(customerIdentity.toString()).append("; ");
     sb.append(")");
     return sb.toString();
  }

}


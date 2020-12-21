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

public class MobileCardAccountResponse {
  @SerializedName("acct_type")
  private String acctType = null;
  @SerializedName("expiration")
  private String expiration = null;
  @SerializedName("holder")
  private String holder = null;
  @SerializedName("issuingCountryCode")
  private String issuingCountryCode = null;
  @SerializedName("maskedPan")
  private String maskedPan = null;
  @SerializedName("token")
  private String token = null;
  
  public void setAcctType(String acctType) {
      this.acctType = acctType;
  }

  /**
   * @param acctType acctType
   * @return bean instance
   **/
  public MobileCardAccountResponse acctType(String acctType) {
      this.acctType = acctType;
      return this;
  }

  
  public void setExpiration(String expiration) {
      this.expiration = expiration;
  }

  /**
   * @param expiration Customer’s card expiration date. Format: &#x60;mm/yyyy&#x60;
   * @return bean instance
   **/
  public MobileCardAccountResponse expiration(String expiration) {
      this.expiration = expiration;
      return this;
  }

  
  public void setHolder(String holder) {
      this.holder = holder;
  }

  /**
   * @param holder Customer&#39;s cardholder name. Any valid cardholder name. Not present by default, ask CardPay manager to enable it if needed.
   * @return bean instance
   **/
  public MobileCardAccountResponse holder(String holder) {
      this.holder = holder;
      return this;
  }

  
  public void setIssuingCountryCode(String issuingCountryCode) {
      this.issuingCountryCode = issuingCountryCode;
  }

  /**
   * @param issuingCountryCode Country code of issuing card country
   * @return bean instance
   **/
  public MobileCardAccountResponse issuingCountryCode(String issuingCountryCode) {
      this.issuingCountryCode = issuingCountryCode;
      return this;
  }

  
  public void setMaskedPan(String maskedPan) {
      this.maskedPan = maskedPan;
  }

  /**
   * @param maskedPan Masked PAN (shows first 6 digits and 4 last digits)
   * @return bean instance
   **/
  public MobileCardAccountResponse maskedPan(String maskedPan) {
      this.maskedPan = maskedPan;
      return this;
  }

  
  public void setToken(String token) {
      this.token = token;
  }

  /**
   * @param token Generated card token value. Token can be returned only for successful transactions (not for declined transactions). For payment: PaymentResponsePaymentData, for recurring: RecurringResponseRecurringData. 
   * @return bean instance
   **/
  public MobileCardAccountResponse token(String token) {
      this.token = token;
      return this;
  }


  @Override
  public String toString() {
     StringBuilder sb = new StringBuilder();
     sb.append("MobileCardAccountResponse( ");
     
     if (acctType != null) sb.append("acctType=").append(acctType.toString()).append("; ");
     if (expiration != null) sb.append("expiration=").append(expiration.toString()).append("; ");
     if (holder != null) sb.append("holder=").append(holder.toString()).append("; ");
     if (issuingCountryCode != null) sb.append("issuingCountryCode=").append(issuingCountryCode.toString()).append("; ");
     if (maskedPan != null) sb.append("maskedPan=").append(maskedPan.toString()).append("; ");
     if (token != null) sb.append("token=").append(token.toString()).append("; ");
     sb.append(")");
     return sb.toString();
  }

}

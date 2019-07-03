/*
 * CardPay REST API
 * Welcome to the CardPay REST API. The CardPay API uses HTTP verbs and a REST resources endpoint structure (see more info about REST). Request and response payloads are formatted as JSON. Merchant uses API to create payments, refunds, payouts or recurrings, check or update transaction status and get information about created transactions. In API authentication process based on OAuth 2.0 standard. For recent changes see changelog section.
 *
 * OpenAPI spec version: 3.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package com.cardpay.sdk.model;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import lombok.Data;

@Data

public class PaymentResponseCardAccount {
  @SerializedName("expiration")
  private String expiration = null;
  @SerializedName("holder")
  private String holder = null;
  @SerializedName("issuing_country_code")
  private String issuingCountryCode = null;
  @SerializedName("masked_pan")
  private String maskedPan = null;
  @SerializedName("token")
  private String token = null;
  
  public void setExpiration(String expiration) {
      this.expiration = expiration;
  }

  /**
   * @param expiration Customer’s card expiration date. Format: mm/yyyy. Returned only if setting &#39;Callback: card expiry&#39; in a wallet in PM system is ON
   * @return bean instance
   **/
  public PaymentResponseCardAccount expiration(String expiration) {
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
  public PaymentResponseCardAccount holder(String holder) {
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
  public PaymentResponseCardAccount issuingCountryCode(String issuingCountryCode) {
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
  public PaymentResponseCardAccount maskedPan(String maskedPan) {
      this.maskedPan = maskedPan;
      return this;
  }

  
  public void setToken(String token) {
      this.token = token;
  }

  /**
   * @param token Generated card token value. For payment: PaymentResponsePaymentData, for recurring: RecurringResponseRecurringData. Token can be returned only for successful transactions (not for declined transactions)
   * @return bean instance
   **/
  public PaymentResponseCardAccount token(String token) {
      this.token = token;
      return this;
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PaymentResponseCardAccount {\n");
    
    if (expiration != null) sb.append("    expiration: ").append(toIndentedString(expiration)).append("\n");
    if (holder != null) sb.append("    holder: ").append(toIndentedString(holder)).append("\n");
    if (issuingCountryCode != null) sb.append("    issuingCountryCode: ").append(toIndentedString(issuingCountryCode)).append("\n");
    if (maskedPan != null) sb.append("    maskedPan: ").append(toIndentedString(maskedPan)).append("\n");
    if (token != null) sb.append("    token: ").append(toIndentedString(token)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }


}


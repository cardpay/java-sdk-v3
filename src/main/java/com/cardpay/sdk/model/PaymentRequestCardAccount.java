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
import com.cardpay.sdk.model.BillingAddress;
import com.cardpay.sdk.model.PaymentRequestCard;
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

public class PaymentRequestCardAccount {
  @SerializedName("billing_address")
  private BillingAddress billingAddress = null;
  @SerializedName("card")
  private PaymentRequestCard card = null;
  @SerializedName("token")
  private String token = null;
  
  public void setBillingAddress(BillingAddress billingAddress) {
      this.billingAddress = billingAddress;
  }

  /**
   * @param billingAddress Billing Address
   * @return bean instance
   **/
  public PaymentRequestCardAccount billingAddress(BillingAddress billingAddress) {
      this.billingAddress = billingAddress;
      return this;
  }

  
  public void setCard(PaymentRequestCard card) {
      this.card = card;
  }

  /**
   * @param card Represents a payment card data. Card section shouldn&#39;t be present if element &#39;token&#39; was presented. Shouldn&#39;t be used in Payment Page mode. For recurring: all card elements should presented only for first recurring payment.
   * @return bean instance
   **/
  public PaymentRequestCardAccount card(PaymentRequestCard card) {
      this.card = card;
      return this;
  }

  
  public void setToken(String token) {
      this.token = token;
  }

  /**
   * @param token Card token value used instead of card information, except card.security_code (it&#39;s mandatory). For payment: see PaymentRequestPaymentData for token generation. For recurring: this attribute is valid only for first recurring payment. It isn&#39;t valid for continue recurring payments (with filing id), see RecurringRequestRecurringData for token generation.
   * @return bean instance
   **/
  public PaymentRequestCardAccount token(String token) {
      this.token = token;
      return this;
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PaymentRequestCardAccount {\n");
    
    if (billingAddress != null) sb.append("    billingAddress: ").append(toIndentedString(billingAddress)).append("\n");
    if (card != null) sb.append("    card: ").append(toIndentedString(card)).append("\n");
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


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

public class AuthenticationDataResponse {
  @SerializedName("merchant_order")
  private TransactionResponseMerchantOrder merchantOrder = null;
  @SerializedName("payment_method")
  private String paymentMethod = null;
  @SerializedName("authentication_data")
  private AuthenticationData authenticationData = null;
  @SerializedName("card_account")
  private PaymentResponseCardAccount cardAccount = null;
  @SerializedName("customer")
  private AuthenticationCustomer customer = null;
  
  public void setMerchantOrder(TransactionResponseMerchantOrder merchantOrder) {
      this.merchantOrder = merchantOrder;
  }

  /**
   * @param merchantOrder Merchant order data
   * @return bean instance
   **/
  public AuthenticationDataResponse merchantOrder(TransactionResponseMerchantOrder merchantOrder) {
      this.merchantOrder = merchantOrder;
      return this;
  }

  
  public void setPaymentMethod(String paymentMethod) {
      this.paymentMethod = paymentMethod;
  }

  /**
   * @param paymentMethod Used payment method type name from payment methods list
   * @return bean instance
   **/
  public AuthenticationDataResponse paymentMethod(String paymentMethod) {
      this.paymentMethod = paymentMethod;
      return this;
  }

  
  public void setAuthenticationData(AuthenticationData authenticationData) {
      this.authenticationData = authenticationData;
  }

  /**
   * @param authenticationData Payment authentication data
   * @return bean instance
   **/
  public AuthenticationDataResponse authenticationData(AuthenticationData authenticationData) {
      this.authenticationData = authenticationData;
      return this;
  }

  
  public void setCardAccount(PaymentResponseCardAccount cardAccount) {
      this.cardAccount = cardAccount;
  }

  /**
   * @param cardAccount Bank card data *(for BANKCARD payment method only)*
   * @return bean instance
   **/
  public AuthenticationDataResponse cardAccount(PaymentResponseCardAccount cardAccount) {
      this.cardAccount = cardAccount;
      return this;
  }

  
  public void setCustomer(AuthenticationCustomer customer) {
      this.customer = customer;
  }

  /**
   * @param customer Customer data
   * @return bean instance
   **/
  public AuthenticationDataResponse customer(AuthenticationCustomer customer) {
      this.customer = customer;
      return this;
  }


  @Override
  public String toString() {
     StringBuilder sb = new StringBuilder();
     sb.append("AuthenticationDataResponse( ");
     
     if (merchantOrder != null) sb.append("merchantOrder=").append(merchantOrder.toString()).append("; ");
     if (paymentMethod != null) sb.append("paymentMethod=").append(paymentMethod.toString()).append("; ");
     if (authenticationData != null) sb.append("authenticationData=").append(authenticationData.toString()).append("; ");
     if (cardAccount != null) sb.append("cardAccount=").append(cardAccount.toString()).append("; ");
     if (customer != null) sb.append("customer=").append(customer.toString()).append("; ");
     sb.append(")");
     return sb.toString();
  }

}


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

public class PaymentResponse {
  @SerializedName("customer")
  private PaymentRequestCustomer customer = null;
  @SerializedName("payment_method")
  private String paymentMethod = null;
  @SerializedName("merchant_order")
  private TransactionResponseMerchantOrder merchantOrder = null;
  @SerializedName("payment_data")
  private PaymentResponsePaymentData paymentData = null;
  @SerializedName("card_account")
  private PaymentResponseCardAccount cardAccount = null;
  
  public void setCustomer(PaymentRequestCustomer customer) {
      this.customer = customer;
  }

  /**
   * @param customer Customer data
   * @return bean instance
   **/
  public PaymentResponse customer(PaymentRequestCustomer customer) {
      this.customer = customer;
      return this;
  }

  
  public void setPaymentMethod(String paymentMethod) {
      this.paymentMethod = paymentMethod;
  }

  /**
   * @param paymentMethod Payment method
   * @return bean instance
   **/
  public PaymentResponse paymentMethod(String paymentMethod) {
      this.paymentMethod = paymentMethod;
      return this;
  }

  
  public void setMerchantOrder(TransactionResponseMerchantOrder merchantOrder) {
      this.merchantOrder = merchantOrder;
  }

  /**
   * @param merchantOrder Merchant order data
   * @return bean instance
   **/
  public PaymentResponse merchantOrder(TransactionResponseMerchantOrder merchantOrder) {
      this.merchantOrder = merchantOrder;
      return this;
  }

  
  public void setPaymentData(PaymentResponsePaymentData paymentData) {
      this.paymentData = paymentData;
  }

  /**
   * @param paymentData Payment data
   * @return bean instance
   **/
  public PaymentResponse paymentData(PaymentResponsePaymentData paymentData) {
      this.paymentData = paymentData;
      return this;
  }

  
  public void setCardAccount(PaymentResponseCardAccount cardAccount) {
      this.cardAccount = cardAccount;
  }

  /**
   * @param cardAccount Card account data *(for BANKCARD payment method only)*
   * @return bean instance
   **/
  public PaymentResponse cardAccount(PaymentResponseCardAccount cardAccount) {
      this.cardAccount = cardAccount;
      return this;
  }


  @Override
  public String toString() {
     StringBuilder sb = new StringBuilder();
     sb.append("PaymentResponse( ");
     
     if (customer != null) sb.append("customer=").append(customer.toString()).append("; ");
     if (paymentMethod != null) sb.append("paymentMethod=").append(paymentMethod.toString()).append("; ");
     if (merchantOrder != null) sb.append("merchantOrder=").append(merchantOrder.toString()).append("; ");
     if (paymentData != null) sb.append("paymentData=").append(paymentData.toString()).append("; ");
     if (cardAccount != null) sb.append("cardAccount=").append(cardAccount.toString()).append("; ");
     sb.append(")");
     return sb.toString();
  }

}


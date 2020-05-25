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

public class PayoutCallback {
  @SerializedName("callback_time")
  private String callbackTime = null;
  @SerializedName("card_account")
  private PayoutResponseCardAccount cardAccount = null;
  @SerializedName("cryptocurrency_account")
  private PayoutResponseCryptocurrencyAccount cryptocurrencyAccount = null;
  @SerializedName("customer")
  private PayoutResponseCustomer customer = null;
  @SerializedName("ewallet_account")
  private PayoutResponseEWalletAccount ewalletAccount = null;
  @SerializedName("merchant_order")
  private TransactionResponseMerchantOrder merchantOrder = null;
  @SerializedName("payment_data")
  private PayoutPaymentData paymentData = null;
  @SerializedName("payment_method")
  private String paymentMethod = null;
  @SerializedName("payout_data")
  private PayoutResponsePayoutData payoutData = null;
  
  public void setCallbackTime(String callbackTime) {
      this.callbackTime = callbackTime;
  }

  /**
   * @param callbackTime Date and time of created callback in [ISO 8601](https://en.wikipedia.org/wiki/ISO_8601) format
   * @return bean instance
   **/
  public PayoutCallback callbackTime(String callbackTime) {
      this.callbackTime = callbackTime;
      return this;
  }

  
  public void setCardAccount(PayoutResponseCardAccount cardAccount) {
      this.cardAccount = cardAccount;
  }

  /**
   * @param cardAccount Card account data *(for BANKCARD method only)*
   * @return bean instance
   **/
  public PayoutCallback cardAccount(PayoutResponseCardAccount cardAccount) {
      this.cardAccount = cardAccount;
      return this;
  }

  
  public void setCryptocurrencyAccount(PayoutResponseCryptocurrencyAccount cryptocurrencyAccount) {
      this.cryptocurrencyAccount = cryptocurrencyAccount;
  }

  /**
   * @param cryptocurrencyAccount Cryptocurrency account data *(for BITCOIN method only)*
   * @return bean instance
   **/
  public PayoutCallback cryptocurrencyAccount(PayoutResponseCryptocurrencyAccount cryptocurrencyAccount) {
      this.cryptocurrencyAccount = cryptocurrencyAccount;
      return this;
  }

  
  public void setCustomer(PayoutResponseCustomer customer) {
      this.customer = customer;
  }

  /**
   * @param customer Customer data
   * @return bean instance
   **/
  public PayoutCallback customer(PayoutResponseCustomer customer) {
      this.customer = customer;
      return this;
  }

  
  public void setEwalletAccount(PayoutResponseEWalletAccount ewalletAccount) {
      this.ewalletAccount = ewalletAccount;
  }

  /**
   * @param ewalletAccount eWallet account data *(for payout methods only)*
   * @return bean instance
   **/
  public PayoutCallback ewalletAccount(PayoutResponseEWalletAccount ewalletAccount) {
      this.ewalletAccount = ewalletAccount;
      return this;
  }

  
  public void setMerchantOrder(TransactionResponseMerchantOrder merchantOrder) {
      this.merchantOrder = merchantOrder;
  }

  /**
   * @param merchantOrder Merchant order data
   * @return bean instance
   **/
  public PayoutCallback merchantOrder(TransactionResponseMerchantOrder merchantOrder) {
      this.merchantOrder = merchantOrder;
      return this;
  }

  
  public void setPaymentData(PayoutPaymentData paymentData) {
      this.paymentData = paymentData;
  }

  /**
   * @param paymentData Payment data
   * @return bean instance
   **/
  public PayoutCallback paymentData(PayoutPaymentData paymentData) {
      this.paymentData = paymentData;
      return this;
  }

  
  public void setPaymentMethod(String paymentMethod) {
      this.paymentMethod = paymentMethod;
  }

  /**
   * @param paymentMethod Used payment method type name from payment methods list
   * @return bean instance
   **/
  public PayoutCallback paymentMethod(String paymentMethod) {
      this.paymentMethod = paymentMethod;
      return this;
  }

  
  public void setPayoutData(PayoutResponsePayoutData payoutData) {
      this.payoutData = payoutData;
  }

  /**
   * @param payoutData Payout data
   * @return bean instance
   **/
  public PayoutCallback payoutData(PayoutResponsePayoutData payoutData) {
      this.payoutData = payoutData;
      return this;
  }


  @Override
  public String toString() {
     StringBuilder sb = new StringBuilder();
     sb.append("PayoutCallback( ");
     
     if (callbackTime != null) sb.append("callbackTime=").append(callbackTime.toString()).append("; ");
     if (cardAccount != null) sb.append("cardAccount=").append(cardAccount.toString()).append("; ");
     if (cryptocurrencyAccount != null) sb.append("cryptocurrencyAccount=").append(cryptocurrencyAccount.toString()).append("; ");
     if (customer != null) sb.append("customer=").append(customer.toString()).append("; ");
     if (ewalletAccount != null) sb.append("ewalletAccount=").append(ewalletAccount.toString()).append("; ");
     if (merchantOrder != null) sb.append("merchantOrder=").append(merchantOrder.toString()).append("; ");
     if (paymentData != null) sb.append("paymentData=").append(paymentData.toString()).append("; ");
     if (paymentMethod != null) sb.append("paymentMethod=").append(paymentMethod.toString()).append("; ");
     if (payoutData != null) sb.append("payoutData=").append(payoutData.toString()).append("; ");
     sb.append(")");
     return sb.toString();
  }

}


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

public class PayoutRequest {
  @SerializedName("request")
  private Request request = null;
  @SerializedName("card_account")
  private PayoutRequestCardAccount cardAccount = null;
  @SerializedName("cryptocurrency_account")
  private PayoutRequestCryptocurrencyAccount cryptocurrencyAccount = null;
  @SerializedName("customer")
  private PayoutRequestCustomer customer = null;
  @SerializedName("ewallet_account")
  private PayoutRequestEWalletAccount ewalletAccount = null;
  @SerializedName("merchant_order")
  private PayoutRequestMerchantOrder merchantOrder = null;
  @SerializedName("payment_data")
  private PayoutPaymentData paymentData = null;
  @SerializedName("payment_method")
  private String paymentMethod = null;
  @SerializedName("payout_data")
  private PayoutRequestPayoutData payoutData = null;
  
  public void setRequest(Request request) {
      this.request = request;
  }

  /**
   * @param request Request
   * @return bean instance
   **/
  public PayoutRequest request(Request request) {
      this.request = request;
      return this;
  }

  
  public void setCardAccount(PayoutRequestCardAccount cardAccount) {
      this.cardAccount = cardAccount;
  }

  /**
   * @param cardAccount Bank card account data *(for BANKCARD method only)*
   * @return bean instance
   **/
  public PayoutRequest cardAccount(PayoutRequestCardAccount cardAccount) {
      this.cardAccount = cardAccount;
      return this;
  }

  
  public void setCryptocurrencyAccount(PayoutRequestCryptocurrencyAccount cryptocurrencyAccount) {
      this.cryptocurrencyAccount = cryptocurrencyAccount;
  }

  /**
   * @param cryptocurrencyAccount Cryptocurrency account data *(for BITCOIN method only)*
   * @return bean instance
   **/
  public PayoutRequest cryptocurrencyAccount(PayoutRequestCryptocurrencyAccount cryptocurrencyAccount) {
      this.cryptocurrencyAccount = cryptocurrencyAccount;
      return this;
  }

  
  public void setCustomer(PayoutRequestCustomer customer) {
      this.customer = customer;
  }

  /**
   * @param customer Customer data
   * @return bean instance
   **/
  public PayoutRequest customer(PayoutRequestCustomer customer) {
      this.customer = customer;
      return this;
  }

  
  public void setEwalletAccount(PayoutRequestEWalletAccount ewalletAccount) {
      this.ewalletAccount = ewalletAccount;
  }

  /**
   * @param ewalletAccount eWallet account data *(for payout methods only)*
   * @return bean instance
   **/
  public PayoutRequest ewalletAccount(PayoutRequestEWalletAccount ewalletAccount) {
      this.ewalletAccount = ewalletAccount;
      return this;
  }

  
  public void setMerchantOrder(PayoutRequestMerchantOrder merchantOrder) {
      this.merchantOrder = merchantOrder;
  }

  /**
   * @param merchantOrder Merchant order
   * @return bean instance
   **/
  public PayoutRequest merchantOrder(PayoutRequestMerchantOrder merchantOrder) {
      this.merchantOrder = merchantOrder;
      return this;
  }

  
  public void setPaymentData(PayoutPaymentData paymentData) {
      this.paymentData = paymentData;
  }

  /**
   * @param paymentData Payment data *(for BANKCARD method only)*
   * @return bean instance
   **/
  public PayoutRequest paymentData(PayoutPaymentData paymentData) {
      this.paymentData = paymentData;
      return this;
  }

  
  public void setPaymentMethod(String paymentMethod) {
      this.paymentMethod = paymentMethod;
  }

  /**
   * @param paymentMethod Used payment method type name from methods list
   * @return bean instance
   **/
  public PayoutRequest paymentMethod(String paymentMethod) {
      this.paymentMethod = paymentMethod;
      return this;
  }

  
  public void setPayoutData(PayoutRequestPayoutData payoutData) {
      this.payoutData = payoutData;
  }

  /**
   * @param payoutData Payout data
   * @return bean instance
   **/
  public PayoutRequest payoutData(PayoutRequestPayoutData payoutData) {
      this.payoutData = payoutData;
      return this;
  }


  @Override
  public String toString() {
     StringBuilder sb = new StringBuilder();
     sb.append("PayoutRequest( ");
     
     if (request != null) sb.append("request=").append(request.toString()).append("; ");
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


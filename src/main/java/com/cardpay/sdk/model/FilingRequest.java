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

public class FilingRequest {
  @SerializedName("request")
  private Request request = null;
  @SerializedName("card_account")
  private PaymentRequestCardAccount cardAccount = null;
  @SerializedName("customer")
  private RecurringCustomer customer = null;
  @SerializedName("merchant_order")
  private FilingRequestMerchantOrder merchantOrder = null;
  @SerializedName("payment_method")
  private String paymentMethod = null;
  @SerializedName("recurring_data")
  private FilingRecurringData recurringData = null;
  @SerializedName("return_urls")
  private ReturnUrls returnUrls = null;
  @SerializedName("subscription_data")
  private FilingRequestSubscriptionData subscriptionData = null;
  
  public void setRequest(Request request) {
      this.request = request;
  }

  /**
   * @param request Request
   * @return bean instance
   **/
  public FilingRequest request(Request request) {
      this.request = request;
      return this;
  }

  
  public void setCardAccount(PaymentRequestCardAccount cardAccount) {
      this.cardAccount = cardAccount;
  }

  /**
   * @param cardAccount Card account
   * @return bean instance
   **/
  public FilingRequest cardAccount(PaymentRequestCardAccount cardAccount) {
      this.cardAccount = cardAccount;
      return this;
  }

  
  public void setCustomer(RecurringCustomer customer) {
      this.customer = customer;
  }

  /**
   * @param customer Customer
   * @return bean instance
   **/
  public FilingRequest customer(RecurringCustomer customer) {
      this.customer = customer;
      return this;
  }

  
  public void setMerchantOrder(FilingRequestMerchantOrder merchantOrder) {
      this.merchantOrder = merchantOrder;
  }

  /**
   * @param merchantOrder Merchant order
   * @return bean instance
   **/
  public FilingRequest merchantOrder(FilingRequestMerchantOrder merchantOrder) {
      this.merchantOrder = merchantOrder;
      return this;
  }

  
  public void setPaymentMethod(String paymentMethod) {
      this.paymentMethod = paymentMethod;
  }

  /**
   * @param paymentMethod Used payment method type name from payment methods list\&quot;
   * @return bean instance
   **/
  public FilingRequest paymentMethod(String paymentMethod) {
      this.paymentMethod = paymentMethod;
      return this;
  }

  
  public void setRecurringData(FilingRecurringData recurringData) {
      this.recurringData = recurringData;
  }

  /**
   * @param recurringData Recurring data
   * @return bean instance
   **/
  public FilingRequest recurringData(FilingRecurringData recurringData) {
      this.recurringData = recurringData;
      return this;
  }

  
  public void setReturnUrls(ReturnUrls returnUrls) {
      this.returnUrls = returnUrls;
  }

  /**
   * @param returnUrls Return URLs
   * @return bean instance
   **/
  public FilingRequest returnUrls(ReturnUrls returnUrls) {
      this.returnUrls = returnUrls;
      return this;
  }

  
  public void setSubscriptionData(FilingRequestSubscriptionData subscriptionData) {
      this.subscriptionData = subscriptionData;
  }

  /**
   * @param subscriptionData Subscription data
   * @return bean instance
   **/
  public FilingRequest subscriptionData(FilingRequestSubscriptionData subscriptionData) {
      this.subscriptionData = subscriptionData;
      return this;
  }


  @Override
  public String toString() {
     StringBuilder sb = new StringBuilder();
     sb.append("FilingRequest( ");
     
     if (request != null) sb.append("request=").append(request.toString()).append("; ");
     if (cardAccount != null) sb.append("cardAccount=").append(cardAccount.toString()).append("; ");
     if (customer != null) sb.append("customer=").append(customer.toString()).append("; ");
     if (merchantOrder != null) sb.append("merchantOrder=").append(merchantOrder.toString()).append("; ");
     if (paymentMethod != null) sb.append("paymentMethod=").append(paymentMethod.toString()).append("; ");
     if (recurringData != null) sb.append("recurringData=").append(recurringData.toString()).append("; ");
     if (returnUrls != null) sb.append("returnUrls=").append(returnUrls.toString()).append("; ");
     if (subscriptionData != null) sb.append("subscriptionData=").append(subscriptionData.toString()).append("; ");
     sb.append(")");
     return sb.toString();
  }

}


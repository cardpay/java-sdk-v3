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

public class PaymentRequest {
  @SerializedName("request")
  private Request request = null;
  @SerializedName("authentication_data")
  private AuthenticationData authenticationData = null;
  @SerializedName("card_account")
  private PaymentRequestCardAccount cardAccount = null;
  @SerializedName("cryptocurrency_account")
  private PaymentRequestCryptocurrencyAccount cryptocurrencyAccount = null;
  @SerializedName("customer")
  private PaymentRequestCustomer customer = null;
  @SerializedName("ewallet_account")
  private PaymentRequestEWalletAccount ewalletAccount = null;
  @SerializedName("merchant_order")
  private PaymentRequestMerchantOrder merchantOrder = null;
  @SerializedName("payment_by_authentication")
  private Boolean paymentByAuthentication = null;
  @SerializedName("payment_data")
  private PaymentRequestPaymentData paymentData = null;
  @SerializedName("payment_method")
  private String paymentMethod = null;
  @SerializedName("payment_methods")
  private List<String> paymentMethods = null;
  @SerializedName("return_urls")
  private ReturnUrls returnUrls = null;
  
  public void setRequest(Request request) {
      this.request = request;
  }

  /**
   * @param request Request
   * @return bean instance
   **/
  public PaymentRequest request(Request request) {
      this.request = request;
      return this;
  }

  
  public void setAuthenticationData(AuthenticationData authenticationData) {
      this.authenticationData = authenticationData;
  }

  /**
   * @param authenticationData Authentication data
   * @return bean instance
   **/
  public PaymentRequest authenticationData(AuthenticationData authenticationData) {
      this.authenticationData = authenticationData;
      return this;
  }

  
  public void setCardAccount(PaymentRequestCardAccount cardAccount) {
      this.cardAccount = cardAccount;
  }

  /**
   * @param cardAccount Information about card *(for BANKCARD payment method only)*
   * @return bean instance
   **/
  public PaymentRequest cardAccount(PaymentRequestCardAccount cardAccount) {
      this.cardAccount = cardAccount;
      return this;
  }

  
  public void setCryptocurrencyAccount(PaymentRequestCryptocurrencyAccount cryptocurrencyAccount) {
      this.cryptocurrencyAccount = cryptocurrencyAccount;
  }

  /**
   * @param cryptocurrencyAccount Cryptocurrency data *(for BITCOIN payment method only)*
   * @return bean instance
   **/
  public PaymentRequest cryptocurrencyAccount(PaymentRequestCryptocurrencyAccount cryptocurrencyAccount) {
      this.cryptocurrencyAccount = cryptocurrencyAccount;
      return this;
  }

  
  public void setCustomer(PaymentRequestCustomer customer) {
      this.customer = customer;
  }

  /**
   * @param customer Customer data
   * @return bean instance
   **/
  public PaymentRequest customer(PaymentRequestCustomer customer) {
      this.customer = customer;
      return this;
  }

  
  public void setEwalletAccount(PaymentRequestEWalletAccount ewalletAccount) {
      this.ewalletAccount = ewalletAccount;
  }

  /**
   * @param ewalletAccount eWallet account data *(for all payment method, excluding BANKCARD, BITCOIN, DIRECTBANKINGEU)
   * @return bean instance
   **/
  public PaymentRequest ewalletAccount(PaymentRequestEWalletAccount ewalletAccount) {
      this.ewalletAccount = ewalletAccount;
      return this;
  }

  
  public void setMerchantOrder(PaymentRequestMerchantOrder merchantOrder) {
      this.merchantOrder = merchantOrder;
  }

  /**
   * @param merchantOrder Merchant order data
   * @return bean instance
   **/
  public PaymentRequest merchantOrder(PaymentRequestMerchantOrder merchantOrder) {
      this.merchantOrder = merchantOrder;
      return this;
  }

  
  public void setPaymentByAuthentication(Boolean paymentByAuthentication) {
      this.paymentByAuthentication = paymentByAuthentication;
  }

  /**
   * @param paymentByAuthentication paymentByAuthentication
   * @return bean instance
   **/
  public PaymentRequest paymentByAuthentication(Boolean paymentByAuthentication) {
      this.paymentByAuthentication = paymentByAuthentication;
      return this;
  }

  
  public void setPaymentData(PaymentRequestPaymentData paymentData) {
      this.paymentData = paymentData;
  }

  /**
   * @param paymentData Payment data
   * @return bean instance
   **/
  public PaymentRequest paymentData(PaymentRequestPaymentData paymentData) {
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
  public PaymentRequest paymentMethod(String paymentMethod) {
      this.paymentMethod = paymentMethod;
      return this;
  }

  
  public void setPaymentMethods(List<String> paymentMethods) {
      this.paymentMethods = paymentMethods;
  }

  /**
   * @param paymentMethods Array of payment methods to display on Checkout Page. If it is not set then all available methods will be displayed
   * @return bean instance
   **/
  public PaymentRequest paymentMethods(List<String> paymentMethods) {
      this.paymentMethods = paymentMethods;
      return this;
  }

  public PaymentRequest addPaymentMethodsItem(String paymentMethodsItem) {
    if (this.paymentMethods == null) {
      this.paymentMethods = new ArrayList<>();
    }
    this.paymentMethods.add(paymentMethodsItem);
    return this;
  }

  
  public void setReturnUrls(ReturnUrls returnUrls) {
      this.returnUrls = returnUrls;
  }

  /**
   * @param returnUrls Return URLs are the URLs where Customer returns by pressing &#39;Back to the shop&#39; or &#39;Cancel&#39; button in Payment page mode and redirected automatically in Gateway mode
   * @return bean instance
   **/
  public PaymentRequest returnUrls(ReturnUrls returnUrls) {
      this.returnUrls = returnUrls;
      return this;
  }


  @Override
  public String toString() {
     StringBuilder sb = new StringBuilder();
     sb.append("PaymentRequest( ");
     
     if (request != null) sb.append("request=").append(request.toString()).append("; ");
     if (authenticationData != null) sb.append("authenticationData=").append(authenticationData.toString()).append("; ");
     if (cardAccount != null) sb.append("cardAccount=").append(cardAccount.toString()).append("; ");
     if (cryptocurrencyAccount != null) sb.append("cryptocurrencyAccount=").append(cryptocurrencyAccount.toString()).append("; ");
     if (customer != null) sb.append("customer=").append(customer.toString()).append("; ");
     if (ewalletAccount != null) sb.append("ewalletAccount=").append(ewalletAccount.toString()).append("; ");
     if (merchantOrder != null) sb.append("merchantOrder=").append(merchantOrder.toString()).append("; ");
     if (paymentByAuthentication != null) sb.append("paymentByAuthentication=").append(paymentByAuthentication.toString()).append("; ");
     if (paymentData != null) sb.append("paymentData=").append(paymentData.toString()).append("; ");
     if (paymentMethod != null) sb.append("paymentMethod=").append(paymentMethod.toString()).append("; ");
     if (paymentMethods != null) sb.append("paymentMethods=").append(paymentMethods.toString()).append("; ");
     if (returnUrls != null) sb.append("returnUrls=").append(returnUrls.toString()).append("; ");
     sb.append(")");
     return sb.toString();
  }

}


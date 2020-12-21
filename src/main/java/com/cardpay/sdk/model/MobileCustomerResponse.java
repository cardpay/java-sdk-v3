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

public class MobileCustomerResponse {
  @SerializedName("email")
  private String email = null;
  @SerializedName("fullName")
  private String fullName = null;
  @SerializedName("homePhone")
  private String homePhone = null;
  @SerializedName("id")
  private String id = null;
  @SerializedName("ip")
  private String ip = null;
  @SerializedName("locale")
  private String locale = null;
  @SerializedName("phone")
  private String phone = null;
  @SerializedName("workPhone")
  private String workPhone = null;
  
  public void setEmail(String email) {
      this.email = email;
  }

  /**
   * @param email Email address of the customer (mandatory by default for &#39;Latin America&#39;, &#39;NETELLER&#39;, &#39;DIRECTBANKINGNGA&#39;, &#39;AQRCODE&#39;, &#39;AIRTEL&#39;, &#39;MPESA&#39;, &#39;MTN&#39;, &#39;UGANDAMOBILE&#39;, &#39;VODAFONE&#39;, &#39;TIGO&#39; payment methods only)). Can be defined as optional by CardPay manager.
   * @return bean instance
   **/
  public MobileCustomerResponse email(String email) {
      this.email = email;
      return this;
  }

  
  public void setFullName(String fullName) {
      this.fullName = fullName;
  }

  /**
   * @param fullName Customer&#39;s full name
   * @return bean instance
   **/
  public MobileCustomerResponse fullName(String fullName) {
      this.fullName = fullName;
      return this;
  }

  
  public void setHomePhone(String homePhone) {
      this.homePhone = homePhone;
  }

  /**
   * @param homePhone The home phone number provided by the Cardholder. Required (if available), unless market or regional mandate restricts sending this information. Characters Format: string (10-18 symbols) country code + Subscriber number. Refer to ITU-E.164 for additional information on format and length.
   * @return bean instance
   **/
  public MobileCustomerResponse homePhone(String homePhone) {
      this.homePhone = homePhone;
      return this;
  }

  
  public void setId(String id) {
      this.id = id;
  }

  /**
   * @param id Customer&#39;s ID in the merchant&#39;s system
   * @return bean instance
   **/
  public MobileCustomerResponse id(String id) {
      this.id = id;
      return this;
  }

  
  public void setIp(String ip) {
      this.ip = ip;
  }

  /**
   * @param ip IP address of customer
   * @return bean instance
   **/
  public MobileCustomerResponse ip(String ip) {
      this.ip = ip;
      return this;
  }

  
  public void setLocale(String locale) {
      this.locale = locale;
  }

  /**
   * @param locale Preferred locale for the payment page ([ISO 639-1](https://en.wikipedia.org/wiki/ISO_639-1) language code). The default locale will be applied if the selected locale is not supported. Supported locales are: &#x60;ru&#x60;, &#x60;en&#x60;, &#x60;zh&#x60;, &#x60;ja&#x60;
   * @return bean instance
   **/
  public MobileCustomerResponse locale(String locale) {
      this.locale = locale;
      return this;
  }

  
  public void setPhone(String phone) {
      this.phone = phone;
  }

  /**
   * @param phone Customer&#39;s phone number. Mandatory for DIRECTBANKINGNGA payment method. For other payment methods: optional by default, can be defined as mandatory by CardPay manager.
   * @return bean instance
   **/
  public MobileCustomerResponse phone(String phone) {
      this.phone = phone;
      return this;
  }

  
  public void setWorkPhone(String workPhone) {
      this.workPhone = workPhone;
  }

  /**
   * @param workPhone The work phone number provided by the Cardholder. Required (if available) unless market or regional mandate restricts sending this information. Characters Format: string (10-18 symbols) country code + Subscriber number. Refer to ITU-E.164 for additional information on format and length.
   * @return bean instance
   **/
  public MobileCustomerResponse workPhone(String workPhone) {
      this.workPhone = workPhone;
      return this;
  }


  @Override
  public String toString() {
     StringBuilder sb = new StringBuilder();
     sb.append("MobileCustomerResponse( ");
     
     if (email != null) sb.append("email=").append(email.toString()).append("; ");
     if (fullName != null) sb.append("fullName=").append(fullName.toString()).append("; ");
     if (homePhone != null) sb.append("homePhone=").append(homePhone.toString()).append("; ");
     if (id != null) sb.append("id=").append(id.toString()).append("; ");
     if (ip != null) sb.append("ip=").append(ip.toString()).append("; ");
     if (locale != null) sb.append("locale=").append(locale.toString()).append("; ");
     if (phone != null) sb.append("phone=").append(phone.toString()).append("; ");
     if (workPhone != null) sb.append("workPhone=").append(workPhone.toString()).append("; ");
     sb.append(")");
     return sb.toString();
  }

}

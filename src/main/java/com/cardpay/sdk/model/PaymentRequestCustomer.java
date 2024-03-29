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

public class PaymentRequestCustomer {
  @SerializedName("birth_date")
  private String birthDate = null;
  @SerializedName("browser_info")
  private BrowserInfo browserInfo = null;
  @SerializedName("device")
  private Device device = null;
  @SerializedName("document_type")
  private String documentType = null;
  @SerializedName("email")
  private String email = null;
  @SerializedName("first_name")
  private String firstName = null;
  @SerializedName("full_name")
  private String fullName = null;
  @SerializedName("home_phone")
  private String homePhone = null;
  @SerializedName("id")
  private String id = null;
  @SerializedName("identity")
  private String identity = null;
  @SerializedName("last_name")
  private String lastName = null;
  @SerializedName("living_address")
  private PaymentRequestLivingAddress livingAddress = null;
  @SerializedName("locale")
  private String locale = null;
  @SerializedName("phone")
  private String phone = null;
  @SerializedName("user_agent")
  private String userAgent = null;
  @SerializedName("work_phone")
  private String workPhone = null;
  @SerializedName("ip")
  private String ip = null;
  
  public void setBirthDate(String birthDate) {
      this.birthDate = birthDate;
  }

  /**
   * @param birthDate Customer birth date in format &#x60;YYYY-MM-DD&#x60;. For Zenith bank in DIRECTBANKINGNGA: Customer password in format date of birth. *(mandatory for DIRECTBANKINGNGA payment method only)*
   * @return bean instance
   **/
  public PaymentRequestCustomer birthDate(String birthDate) {
      this.birthDate = birthDate;
      return this;
  }

  
  public void setBrowserInfo(BrowserInfo browserInfo) {
      this.browserInfo = browserInfo;
  }

  /**
   * @param browserInfo Browser info
   * @return bean instance
   **/
  public PaymentRequestCustomer browserInfo(BrowserInfo browserInfo) {
      this.browserInfo = browserInfo;
      return this;
  }

  
  public void setDevice(Device device) {
      this.device = device;
  }

  /**
   * @param device Customer&#39;s device information
   * @return bean instance
   **/
  public PaymentRequestCustomer device(Device device) {
      this.device = device;
      return this;
  }

  
  public void setDocumentType(String documentType) {
      this.documentType = documentType;
  }

  /**
   * @param documentType Customer document type *(mandatory for &#39;PAGOEFECTIVO&#39; methods only)*
   * @return bean instance
   **/
  public PaymentRequestCustomer documentType(String documentType) {
      this.documentType = documentType;
      return this;
  }

  
  public void setEmail(String email) {
      this.email = email;
  }

  /**
   * @param email Email address of Customer *(mandatory by default for BANKCARD, PAYPAL, &#39;Latin America&#39;, AIRTEL, MPESA, MTN, UGANDAMOBILE, VODAFONE, TIGO, DIRECTBANKINGNGA and AQRCODE payment methods only)*. Can be defined as optional by CardPay manager.
   * @return bean instance
   **/
  public PaymentRequestCustomer email(String email) {
      this.email = email;
      return this;
  }

  
  public void setFirstName(String firstName) {
      this.firstName = firstName;
  }

  /**
   * @param firstName Customer first name *(mandatory for &#39;PAGOEFECTIVO&#39; payment methods only)*
   * @return bean instance
   **/
  public PaymentRequestCustomer firstName(String firstName) {
      this.firstName = firstName;
      return this;
  }

  
  public void setFullName(String fullName) {
      this.fullName = fullName;
  }

  /**
   * @param fullName Customer full name *(mandatory for &#39;Latin America&#39; payment methods only)*
   * @return bean instance
   **/
  public PaymentRequestCustomer fullName(String fullName) {
      this.fullName = fullName;
      return this;
  }

  
  public void setHomePhone(String homePhone) {
      this.homePhone = homePhone;
  }

  /**
   * @param homePhone The work phone number provided by the Cardholder. Required (if available), unless market or regional mandate restricts sending this information. Characters Format: string (10-18 symbols) country code + Subscriber number. Refer to ITU-E.164 for additional information on format and length.
   * @return bean instance
   **/
  public PaymentRequestCustomer homePhone(String homePhone) {
      this.homePhone = homePhone;
      return this;
  }

  
  public void setId(String id) {
      this.id = id;
  }

  /**
   * @param id Customer ID in Merchant&#39;s system *(mandatory for WEBMONEY payment method only)*
   * @return bean instance
   **/
  public PaymentRequestCustomer id(String id) {
      this.id = id;
      return this;
  }

  
  public void setIdentity(String identity) {
      this.identity = identity;
  }

  /**
   * @param identity Customer identity string value
   * @return bean instance
   **/
  public PaymentRequestCustomer identity(String identity) {
      this.identity = identity;
      return this;
  }

  
  public void setLastName(String lastName) {
      this.lastName = lastName;
  }

  /**
   * @param lastName Customer last name *(mandatory for &#39;PAGOEFECTIVO&#39; payment methods only)*
   * @return bean instance
   **/
  public PaymentRequestCustomer lastName(String lastName) {
      this.lastName = lastName;
      return this;
  }

  
  public void setLivingAddress(PaymentRequestLivingAddress livingAddress) {
      this.livingAddress = livingAddress;
  }

  /**
   * @param livingAddress Customer address *(mandatory for &#39;Latin America&#39; methods only)* For &#39;Latin America&#39; is required for methods where country &#x3D; CO
   * @return bean instance
   **/
  public PaymentRequestCustomer livingAddress(PaymentRequestLivingAddress livingAddress) {
      this.livingAddress = livingAddress;
      return this;
  }

  
  public void setLocale(String locale) {
      this.locale = locale;
  }

  /**
   * @param locale Preferred locale for the payment page ([ISO 639-1](https://en.wikipedia.org/wiki/ISO_639-1) language code). The default locale will be applied if the selected locale is not supported. Supported locales are: &#x60;ru&#x60;, &#x60;en&#x60;, &#x60;zh&#x60;, &#x60;ja&#x60;
   * @return bean instance
   **/
  public PaymentRequestCustomer locale(String locale) {
      this.locale = locale;
      return this;
  }

  
  public void setPhone(String phone) {
      this.phone = phone;
  }

  /**
   * @param phone Customer phone number. Format: &#x60;+&#x60; sign and 10 or 11 digits, example: &#x60;+12345678901&#x60; Mandatory for DIRECTBANKINGNGA payment method. For other payment methods: optional by default, can be defined as mandatory by CardPay manager.
   * @return bean instance
   **/
  public PaymentRequestCustomer phone(String phone) {
      this.phone = phone;
      return this;
  }

  
  public void setUserAgent(String userAgent) {
      this.userAgent = userAgent;
  }

  /**
   * @param userAgent User agent
   * @return bean instance
   **/
  public PaymentRequestCustomer userAgent(String userAgent) {
      this.userAgent = userAgent;
      return this;
  }

  
  public void setWorkPhone(String workPhone) {
      this.workPhone = workPhone;
  }

  /**
   * @param workPhone The home phone number provided by the Cardholder. Required (if available) unless market or regional mandate restricts sending this information. Characters Format: string (10-18 symbols) country code + Subscriber number. Refer to ITU-E.164 for additional information on format and length.
   * @return bean instance
   **/
  public PaymentRequestCustomer workPhone(String workPhone) {
      this.workPhone = workPhone;
      return this;
  }

  
  public void setIp(String ip) {
      this.ip = ip;
  }

  /**
   * @param ip IP address of Customer
   * @return bean instance
   **/
  public PaymentRequestCustomer ip(String ip) {
      this.ip = ip;
      return this;
  }


  @Override
  public String toString() {
     StringBuilder sb = new StringBuilder();
     sb.append("PaymentRequestCustomer( ");
     
     if (birthDate != null) sb.append("birthDate=").append(birthDate.toString()).append("; ");
     if (browserInfo != null) sb.append("browserInfo=").append(browserInfo.toString()).append("; ");
     if (device != null) sb.append("device=").append(device.toString()).append("; ");
     if (documentType != null) sb.append("documentType=").append(documentType.toString()).append("; ");
     if (email != null) sb.append("email=").append(email.toString()).append("; ");
     if (firstName != null) sb.append("firstName=").append(firstName.toString()).append("; ");
     if (fullName != null) sb.append("fullName=").append(fullName.toString()).append("; ");
     if (homePhone != null) sb.append("homePhone=").append(homePhone.toString()).append("; ");
     if (id != null) sb.append("id=").append(id.toString()).append("; ");
     if (identity != null) sb.append("identity=").append(identity.toString()).append("; ");
     if (lastName != null) sb.append("lastName=").append(lastName.toString()).append("; ");
     if (livingAddress != null) sb.append("livingAddress=").append(livingAddress.toString()).append("; ");
     if (locale != null) sb.append("locale=").append(locale.toString()).append("; ");
     if (phone != null) sb.append("phone=").append(phone.toString()).append("; ");
     if (userAgent != null) sb.append("userAgent=").append(userAgent.toString()).append("; ");
     if (workPhone != null) sb.append("workPhone=").append(workPhone.toString()).append("; ");
     if (ip != null) sb.append("ip=").append(ip.toString()).append("; ");
     sb.append(")");
     return sb.toString();
  }

}


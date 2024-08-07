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

public class PayoutRequestCustomer {
  @SerializedName("birth_date")
  private String birthDate = null;
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
  @SerializedName("id")
  private String id = null;
  @SerializedName("identity")
  private String identity = null;
  @SerializedName("last_name")
  private String lastName = null;
  @SerializedName("living_address")
  private PayoutRequestLivingAddress livingAddress = null;
  @SerializedName("phone")
  private String phone = null;
  @SerializedName("tax_reason_code")
  private String taxReasonCode = null;
  
  public void setBirthDate(String birthDate) {
      this.birthDate = birthDate;
  }

  /**
   * @param birthDate Customer birth date
   * @return bean instance
   **/
  public PayoutRequestCustomer birthDate(String birthDate) {
      this.birthDate = birthDate;
      return this;
  }

  
  public void setDevice(Device device) {
      this.device = device;
  }

  /**
   * @param device Customer&#39;s device information
   * @return bean instance
   **/
  public PayoutRequestCustomer device(Device device) {
      this.device = device;
      return this;
  }

  
  public void setDocumentType(String documentType) {
      this.documentType = documentType;
  }

  /**
   * @param documentType Customer document type *(mandatory for &#39;Latin America&#39; methods only)* For &#39;Latin America&#39; is required for methods where country &#x3D; CO, PE
   * @return bean instance
   **/
  public PayoutRequestCustomer documentType(String documentType) {
      this.documentType = documentType;
      return this;
  }

  
  public void setEmail(String email) {
      this.email = email;
  }

  /**
   * @param email Customer e-mail address *(mandatory for &#39;Latin America&#39; methods only)* For &#39;Latin America&#39; is required for methods where country &#x3D; CO
   * @return bean instance
   **/
  public PayoutRequestCustomer email(String email) {
      this.email = email;
      return this;
  }

  
  public void setFirstName(String firstName) {
      this.firstName = firstName;
  }

  /**
   * @param firstName Customer first name *(mandatory for &#39;Latin America&#39; methods only)*
   * @return bean instance
   **/
  public PayoutRequestCustomer firstName(String firstName) {
      this.firstName = firstName;
      return this;
  }

  
  public void setFullName(String fullName) {
      this.fullName = fullName;
  }

  /**
   * @param fullName Customer full name. Mandatory for DIRECTBANKINGNGA methods only: For DIRECTBANKINGNGA: only for non NGN currency
   * @return bean instance
   **/
  public PayoutRequestCustomer fullName(String fullName) {
      this.fullName = fullName;
      return this;
  }

  
  public void setId(String id) {
      this.id = id;
  }

  /**
   * @param id Customer id *(mandatory for WEBMONEY method only)*
   * @return bean instance
   **/
  public PayoutRequestCustomer id(String id) {
      this.id = id;
      return this;
  }

  
  public void setIdentity(String identity) {
      this.identity = identity;
  }

  /**
   * @param identity Customer identity  - Customer’s personal identification number: &#39;CPF&#39; or &#39;CNPJ&#39; for Brazil, &#39;DNI&#39; for Argentina and ID for other countries.  For SPEI - Customer CPF or CURP
   * @return bean instance
   **/
  public PayoutRequestCustomer identity(String identity) {
      this.identity = identity;
      return this;
  }

  
  public void setLastName(String lastName) {
      this.lastName = lastName;
  }

  /**
   * @param lastName Customer last name *(mandatory for &#39;Latin America&#39; methods only)* For &#39;Latin America&#39; is required for methods where country &#x3D; AR, BR, CO, MX, PE, UY
   * @return bean instance
   **/
  public PayoutRequestCustomer lastName(String lastName) {
      this.lastName = lastName;
      return this;
  }

  
  public void setLivingAddress(PayoutRequestLivingAddress livingAddress) {
      this.livingAddress = livingAddress;
  }

  /**
   * @param livingAddress Customer address *(mandatory for &#39;Latin America&#39; methods only)* For &#39;Latin America&#39; is required for methods where country &#x3D; CO
   * @return bean instance
   **/
  public PayoutRequestCustomer livingAddress(PayoutRequestLivingAddress livingAddress) {
      this.livingAddress = livingAddress;
      return this;
  }

  
  public void setPhone(String phone) {
      this.phone = phone;
  }

  /**
   * @param phone Customer&#39;s phone number
   * @return bean instance
   **/
  public PayoutRequestCustomer phone(String phone) {
      this.phone = phone;
      return this;
  }

  
  public void setTaxReasonCode(String taxReasonCode) {
      this.taxReasonCode = taxReasonCode;
  }

  /**
   * @param taxReasonCode Customer&#39;s tax reason codeFor &#39;BANK131 back account mode&#39; is required for methods where country &#x3D; RU
   * @return bean instance
   **/
  public PayoutRequestCustomer taxReasonCode(String taxReasonCode) {
      this.taxReasonCode = taxReasonCode;
      return this;
  }


  @Override
  public String toString() {
     StringBuilder sb = new StringBuilder();
     sb.append("PayoutRequestCustomer( ");
     
     if (birthDate != null) sb.append("birthDate=").append(birthDate.toString()).append("; ");
     if (device != null) sb.append("device=").append(device.toString()).append("; ");
     if (documentType != null) sb.append("documentType=").append(documentType.toString()).append("; ");
     if (email != null) sb.append("email=").append(email.toString()).append("; ");
     if (firstName != null) sb.append("firstName=").append(firstName.toString()).append("; ");
     if (fullName != null) sb.append("fullName=").append(fullName.toString()).append("; ");
     if (id != null) sb.append("id=").append(id.toString()).append("; ");
     if (identity != null) sb.append("identity=").append(identity.toString()).append("; ");
     if (lastName != null) sb.append("lastName=").append(lastName.toString()).append("; ");
     if (livingAddress != null) sb.append("livingAddress=").append(livingAddress.toString()).append("; ");
     if (phone != null) sb.append("phone=").append(phone.toString()).append("; ");
     if (taxReasonCode != null) sb.append("taxReasonCode=").append(taxReasonCode.toString()).append("; ");
     sb.append(")");
     return sb.toString();
  }

}


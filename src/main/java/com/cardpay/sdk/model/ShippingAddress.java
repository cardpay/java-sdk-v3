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

public class ShippingAddress {
  @SerializedName("addr_line_1")
  private String addrLine1 = null;
  @SerializedName("addr_line_2")
  private String addrLine2 = null;
  @SerializedName("city")
  private String city = null;
  @SerializedName("country")
  private String country = null;
  @SerializedName("phone")
  private String phone = null;
  @SerializedName("state")
  private String state = null;
  @SerializedName("zip")
  private String zip = null;
  
  public void setAddrLine1(String addrLine1) {
      this.addrLine1 = addrLine1;
  }

  /**
   * @param addrLine1 First line of the street address or equivalent local portion of the Cardholder shipping address associated with the card used for this purchase. Can include street and house number. *Length: 0 - 50*
   * @return bean instance
   **/
  public ShippingAddress addrLine1(String addrLine1) {
      this.addrLine1 = addrLine1;
      return this;
  }

  
  public void setAddrLine2(String addrLine2) {
      this.addrLine2 = addrLine2;
  }

  /**
   * @param addrLine2 Second line of the street address or equivalent local portion of the Cardholder shipping address associated with the card used for this purchase. *Length: 0 - 50*
   * @return bean instance
   **/
  public ShippingAddress addrLine2(String addrLine2) {
      this.addrLine2 = addrLine2;
      return this;
  }

  
  public void setCity(String city) {
      this.city = city;
  }

  /**
   * @param city Delivery city. May include whitespaces, hyphens, apostrophes, commas and dots
   * @return bean instance
   **/
  public ShippingAddress city(String city) {
      this.city = city;
      return this;
  }

  
  public void setCountry(String country) {
      this.country = country;
  }

  /**
   * @param country [ISO 3166-1](https://en.wikipedia.org/wiki/ISO_3166-1) code of delivery country: 2 or 3 latin letters or numeric code. Required for BANKCARD payment method if &#39;shipping_address&#39; is presented.
   * @return bean instance
   **/
  public ShippingAddress country(String country) {
      this.country = country;
      return this;
  }

  
  public void setPhone(String phone) {
      this.phone = phone;
  }

  /**
   * @param phone Valid customer phone number
   * @return bean instance
   **/
  public ShippingAddress phone(String phone) {
      this.phone = phone;
      return this;
  }

  
  public void setState(String state) {
      this.state = state;
  }

  /**
   * @param state The state or province of the shipping address associated with the card being used for this purchase. It&#39;s recommended to send in following format: the country subdivision code defined in [ISO 3166-2](https://en.wikipedia.org/wiki/ISO_3166-2). May include whitespaces, hyphens, apostrophes, commas and dots.
   * @return bean instance
   **/
  public ShippingAddress state(String state) {
      this.state = state;
      return this;
  }

  
  public void setZip(String zip) {
      this.zip = zip;
  }

  /**
   * @param zip Delivery postal code. For BANKCARD payment method max length: 12 Mandatory for BOLETO and LOTERICA payment methods only.
   * @return bean instance
   **/
  public ShippingAddress zip(String zip) {
      this.zip = zip;
      return this;
  }


  @Override
  public String toString() {
     StringBuilder sb = new StringBuilder();
     sb.append("ShippingAddress( ");
     
     if (addrLine1 != null) sb.append("addrLine1=").append(addrLine1.toString()).append("; ");
     if (addrLine2 != null) sb.append("addrLine2=").append(addrLine2.toString()).append("; ");
     if (city != null) sb.append("city=").append(city.toString()).append("; ");
     if (country != null) sb.append("country=").append(country.toString()).append("; ");
     if (phone != null) sb.append("phone=").append(phone.toString()).append("; ");
     if (state != null) sb.append("state=").append(state.toString()).append("; ");
     if (zip != null) sb.append("zip=").append(zip.toString()).append("; ");
     sb.append(")");
     return sb.toString();
  }

}


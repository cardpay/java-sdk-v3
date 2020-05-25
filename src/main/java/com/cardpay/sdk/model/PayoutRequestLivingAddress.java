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

public class PayoutRequestLivingAddress {
  @SerializedName("address")
  private String address = null;
  @SerializedName("city")
  private String city = null;
  @SerializedName("country")
  private String country = null;
  @SerializedName("state")
  private String state = null;
  @SerializedName("zip")
  private String zip = null;
  
  public void setAddress(String address) {
      this.address = address;
  }

  /**
   * @param address Customer address *(mandatory for &#39;Latin America&#39; methods only)* For &#39;Latin America&#39; is required for methods where country &#x3D; CO
   * @return bean instance
   **/
  public PayoutRequestLivingAddress address(String address) {
      this.address = address;
      return this;
  }

  
  public void setCity(String city) {
      this.city = city;
  }

  /**
   * @param city Customer city.
   * @return bean instance
   **/
  public PayoutRequestLivingAddress city(String city) {
      this.city = city;
      return this;
  }

  
  public void setCountry(String country) {
      this.country = country;
  }

  /**
   * @param country ISO 3166-1 code of country: 2 or 3 latin letters or numeric code.
   * @return bean instance
   **/
  public PayoutRequestLivingAddress country(String country) {
      this.country = country;
      return this;
  }

  
  public void setState(String state) {
      this.state = state;
  }

  /**
   * @param state Living state or province.
   * @return bean instance
   **/
  public PayoutRequestLivingAddress state(String state) {
      this.state = state;
      return this;
  }

  
  public void setZip(String zip) {
      this.zip = zip;
  }

  /**
   * @param zip Customer postal code
   * @return bean instance
   **/
  public PayoutRequestLivingAddress zip(String zip) {
      this.zip = zip;
      return this;
  }


  @Override
  public String toString() {
     StringBuilder sb = new StringBuilder();
     sb.append("PayoutRequestLivingAddress( ");
     
     if (address != null) sb.append("address=").append(address.toString()).append("; ");
     if (city != null) sb.append("city=").append(city.toString()).append("; ");
     if (country != null) sb.append("country=").append(country.toString()).append("; ");
     if (state != null) sb.append("state=").append(state.toString()).append("; ");
     if (zip != null) sb.append("zip=").append(zip.toString()).append("; ");
     sb.append(")");
     return sb.toString();
  }

}


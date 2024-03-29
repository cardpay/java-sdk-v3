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

public class PaymentMethodsResponse {
  @SerializedName("brands")
  private List<String> brands = null;
  @SerializedName("category")
  private String category = null;
  @SerializedName("name")
  private String name = null;
  @SerializedName("supported_payment_methods")
  private List<SupportedPaymentMethod> supportedPaymentMethods = null;
  
  public void setBrands(List<String> brands) {
      this.brands = brands;
  }

  /**
   * @param brands Available Card Brands, is presented only for &#39;BANKCARD&#39; payment method
   * @return bean instance
   **/
  public PaymentMethodsResponse brands(List<String> brands) {
      this.brands = brands;
      return this;
  }

  public PaymentMethodsResponse addBrandsItem(String brandsItem) {
    if (this.brands == null) {
      this.brands = new ArrayList<>();
    }
    this.brands.add(brandsItem);
    return this;
  }

  
  public void setCategory(String category) {
      this.category = category;
  }

  /**
   * @param category Payment method category
   * @return bean instance
   **/
  public PaymentMethodsResponse category(String category) {
      this.category = category;
      return this;
  }

  
  public void setName(String name) {
      this.name = name;
  }

  /**
   * @param name Payment method name
   * @return bean instance
   **/
  public PaymentMethodsResponse name(String name) {
      this.name = name;
      return this;
  }

  
  public void setSupportedPaymentMethods(List<SupportedPaymentMethod> supportedPaymentMethods) {
      this.supportedPaymentMethods = supportedPaymentMethods;
  }

  /**
   * @param supportedPaymentMethods Supported payment methods
   * @return bean instance
   **/
  public PaymentMethodsResponse supportedPaymentMethods(List<SupportedPaymentMethod> supportedPaymentMethods) {
      this.supportedPaymentMethods = supportedPaymentMethods;
      return this;
  }

  public PaymentMethodsResponse addSupportedPaymentMethodsItem(SupportedPaymentMethod supportedPaymentMethodsItem) {
    if (this.supportedPaymentMethods == null) {
      this.supportedPaymentMethods = new ArrayList<>();
    }
    this.supportedPaymentMethods.add(supportedPaymentMethodsItem);
    return this;
  }


  @Override
  public String toString() {
     StringBuilder sb = new StringBuilder();
     sb.append("PaymentMethodsResponse( ");
     
     if (brands != null) sb.append("brands=").append(brands.toString()).append("; ");
     if (category != null) sb.append("category=").append(category.toString()).append("; ");
     if (name != null) sb.append("name=").append(name.toString()).append("; ");
     if (supportedPaymentMethods != null) sb.append("supportedPaymentMethods=").append(supportedPaymentMethods.toString()).append("; ");
     sb.append(")");
     return sb.toString();
  }

}


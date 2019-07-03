/*
 * CardPay REST API
 * Welcome to the CardPay REST API. The CardPay API uses HTTP verbs and a REST resources endpoint structure (see more info about REST). Request and response payloads are formatted as JSON. Merchant uses API to create payments, refunds, payouts or recurrings, check or update transaction status and get information about created transactions. In API authentication process based on OAuth 2.0 standard. For recent changes see changelog section.
 *
 * OpenAPI spec version: 3.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package com.cardpay.sdk.model;

import java.util.Objects;
import java.util.Arrays;
import com.cardpay.sdk.model.ShippingAddress;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import lombok.Data;

@Data

public class FilingRequestMerchantOrder {
  @SerializedName("description")
  private String description = null;
  @SerializedName("id")
  private String id = null;
  @SerializedName("shipping_address")
  private ShippingAddress shippingAddress = null;
  
  public void setDescription(String description) {
      this.description = description;
  }

  /**
   * @param description Description of product/service being sold
   * @return bean instance
   **/
  public FilingRequestMerchantOrder description(String description) {
      this.description = description;
      return this;
  }

  
  public void setId(String id) {
      this.id = id;
  }

  /**
   * @param id Merchant&#39;s ID of the order
   * @return bean instance
   **/
  public FilingRequestMerchantOrder id(String id) {
      this.id = id;
      return this;
  }

  
  public void setShippingAddress(ShippingAddress shippingAddress) {
      this.shippingAddress = shippingAddress;
  }

  /**
   * @param shippingAddress Shipping address is the address where the order will be delivered.  It is used in Anti-fraud System and also can be seen in Merchant Account (Transactions).  But this address field may be omitted and all the subfields inside it may be omitted too except Country.
   * @return bean instance
   **/
  public FilingRequestMerchantOrder shippingAddress(ShippingAddress shippingAddress) {
      this.shippingAddress = shippingAddress;
      return this;
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FilingRequestMerchantOrder {\n");
    
    if (description != null) sb.append("    description: ").append(toIndentedString(description)).append("\n");
    if (id != null) sb.append("    id: ").append(toIndentedString(id)).append("\n");
    if (shippingAddress != null) sb.append("    shippingAddress: ").append(toIndentedString(shippingAddress)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }


}


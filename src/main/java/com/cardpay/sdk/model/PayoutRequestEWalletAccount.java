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

public class PayoutRequestEWalletAccount {
  @SerializedName("bank_branch")
  private String bankBranch = null;
  @SerializedName("bank_code")
  private String bankCode = null;
  @SerializedName("id")
  private String id = null;
  @SerializedName("name")
  private String name = null;
  @SerializedName("type")
  private String type = null;
  
  public void setBankBranch(String bankBranch) {
      this.bankBranch = bankBranch;
  }

  /**
   * @param bankBranch Customer bank branch number (name). Mandatory for &#39;Latin America&#39;, &#39;Asia&#39; and DIRECTBANKINGNGA methods only. For &#39;Latin America&#39;: &lt;ul&gt;&lt;li&gt;required for methods where country &#x3D; BR, UY&lt;/li&gt;&lt;li&gt;for UY (Uruguay) is optional if &#39;payment_method&#39; is &#x60;UY113&#x60;&lt;/li&gt;&lt;/ul&gt; For &#39;Asia&#39;: must be in Simplified Chinese For DIRECTBANKINGNGA: Customer bank branch number (name), only for Ghana banks (GH******)
   * @return bean instance
   **/
  public PayoutRequestEWalletAccount bankBranch(String bankBranch) {
      this.bankBranch = bankBranch;
      return this;
  }

  
  public void setBankCode(String bankCode) {
      this.bankCode = bankCode;
  }

  /**
   * @param bankCode Customer bank code For DIRECTBANKINGNGA: Customer bank code (3 digits)
   * @return bean instance
   **/
  public PayoutRequestEWalletAccount bankCode(String bankCode) {
      this.bankCode = bankCode;
      return this;
  }

  
  public void setId(String id) {
      this.id = id;
  }

  /**
   * @param id For QIWI: Customer phone number (from 1 to 15 digits) For WEBMONEY: Customer account number For NETELLER: Customer email For &#39;Latin America&#39;: Customer personal identification number For &#39;Asia&#39;: Customer bank account number For YANDEXMONEY: Customer wallet number, 11 to 16 digits, begins with &#x60;410&#x60; For AIRTEL, MPESA, MTN, UGANDAMOBILE, VODAFONE and TIGO: phone number linked to Customer&#39;s mobile money account. Phone prefix is **required**: AIRTEL - 233 (GHS), 256 (UGX); MTN - 233 (GHS), 256 (UGX); TIGO, VODAFONE - 233; UGANDAMOBILE - 256; MPESA - 254 For DIRECTBANKINGNGA: bank account number *(mandatory for QIWI, WEBMONEY, NETELLER, &#39;Latin America&#39;, &#39;Asia&#39;, YANDEXMONEY, AIRTEL, MPESA, MTN, UGANDAMOBILE, VODAFONE, TIGO and DIRECTBANKINGNGA methods only)*
   * @return bean instance
   **/
  public PayoutRequestEWalletAccount id(String id) {
      this.id = id;
      return this;
  }

  
  public void setName(String name) {
      this.name = name;
  }

  /**
   * @param name Customer bank account name. For &#39;Asia&#39; methods: &lt;ul&gt;&lt;li&gt;mandatory&lt;/li&gt;&lt;li&gt;for &#x60;CNY&#x60; currency: must be in Simplified Chinese&lt;/li&gt;&lt;/ul&gt;
   * @return bean instance
   **/
  public PayoutRequestEWalletAccount name(String name) {
      this.name = name;
      return this;
  }

  
  public void setType(String type) {
      this.type = type;
  }

  /**
   * @param type Customer account type. Mandatory for &#39;Latin America&#39; methods only. For &#39;Latin America&#39;: &lt;ul&gt;&lt;li&gt;required for methods where country &#x3D; BR, CL, CO&lt;/li&gt;&lt;li&gt;for PE (PERU) only &#x60;M&#x60; value is allowed&lt;/li&gt;&lt;li&gt;for UY (Uruguay) is required only if &#39;payment_method&#39; is &#x60;UY001&#x60;&lt;/li&gt;&lt;/ul&gt;
   * @return bean instance
   **/
  public PayoutRequestEWalletAccount type(String type) {
      this.type = type;
      return this;
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PayoutRequestEWalletAccount {\n");
    
    if (bankBranch != null) sb.append("    bankBranch: ").append(toIndentedString(bankBranch)).append("\n");
    if (bankCode != null) sb.append("    bankCode: ").append(toIndentedString(bankCode)).append("\n");
    if (id != null) sb.append("    id: ").append(toIndentedString(id)).append("\n");
    if (name != null) sb.append("    name: ").append(toIndentedString(name)).append("\n");
    if (type != null) sb.append("    type: ").append(toIndentedString(type)).append("\n");
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


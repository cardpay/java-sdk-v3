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

public class PayoutRequestEWalletAccount {
  @SerializedName("bank_branch")
  private String bankBranch = null;
  @SerializedName("bank_code")
  private String bankCode = null;
  @SerializedName("bank_name")
  private String bankName = null;
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
   * @param bankBranch Customer bank branch number (name). Mandatory for &#39;Latin America&#39; and DIRECTBANKINGNGA methods only. For &#39;Latin America&#39;: &lt;ul&gt;&lt;li&gt;required for methods where country &#x3D; BR, UY&lt;/li&gt;&lt;li&gt;for UY (Uruguay) is optional if &#39;payment_method&#39; is &#x60;UY113&#x60;&lt;/li&gt;&lt;/ul&gt; For DIRECTBANKINGNGA: Customer bank branch number (name), only for Ghana banks (GH******)
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

  
  public void setBankName(String bankName) {
      this.bankName = bankName;
  }

  /**
   * @param bankName Customer bank name Customer bank name (string)
   * @return bean instance
   **/
  public PayoutRequestEWalletAccount bankName(String bankName) {
      this.bankName = bankName;
      return this;
  }

  
  public void setId(String id) {
      this.id = id;
  }

  /**
   * @param id For QIWI: Customer phone number (from 1 to 15 digits) For WEBMONEY: Customer account number For NETELLER: Customer email For &#39;Latin America&#39;: Customer personal identification number For AIRTEL, MPESA, MTN, UGANDAMOBILE, VODAFONE and TIGO: phone number linked to Customer&#39;s mobile money account. Phone prefix is **required**: AIRTEL - 233 (GHS), 256 (UGX); MTN - 233 (GHS), 256 (UGX); TIGO, VODAFONE - 233; UGANDAMOBILE - 256; MPESA - 254 For DIRECTBANKINGNGA: bank account number For PAYPAL: Customer email, phone or PayPal account number *(mandatory for QIWI, PAYPAL, WEBMONEY, NETELLER, &#39;Latin America&#39;, AIRTEL, MPESA, MTN, UGANDAMOBILE, VODAFONE, TIGO and DIRECTBANKINGNGA methods only)*
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
   * @param name Customer bank account name.
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
     sb.append("PayoutRequestEWalletAccount( ");
     
     if (bankBranch != null) sb.append("bankBranch=").append(bankBranch.toString()).append("; ");
     if (bankCode != null) sb.append("bankCode=").append(bankCode.toString()).append("; ");
     if (bankName != null) sb.append("bankName=").append(bankName.toString()).append("; ");
     if (id != null) sb.append("id=").append(id.toString()).append("; ");
     if (name != null) sb.append("name=").append(name.toString()).append("; ");
     if (type != null) sb.append("type=").append(type.toString()).append("; ");
     sb.append(")");
     return sb.toString();
  }

}


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

public class InvoiceGetResponse {
  @SerializedName("customer")
  private InvoiceCustomer customer = null;
  @SerializedName("invoice_data")
  private InvoiceGetDataResponse invoiceData = null;
  @SerializedName("invoice_url")
  private String invoiceUrl = null;
  @SerializedName("merchant_order")
  private InvoiceMerchantOrder merchantOrder = null;
  
  public void setCustomer(InvoiceCustomer customer) {
      this.customer = customer;
  }

  /**
   * @param customer Customer data
   * @return bean instance
   **/
  public InvoiceGetResponse customer(InvoiceCustomer customer) {
      this.customer = customer;
      return this;
  }

  
  public void setInvoiceData(InvoiceGetDataResponse invoiceData) {
      this.invoiceData = invoiceData;
  }

  /**
   * @param invoiceData Invoice data
   * @return bean instance
   **/
  public InvoiceGetResponse invoiceData(InvoiceGetDataResponse invoiceData) {
      this.invoiceData = invoiceData;
      return this;
  }

  
  public void setInvoiceUrl(String invoiceUrl) {
      this.invoiceUrl = invoiceUrl;
  }

  /**
   * @param invoiceUrl Invoice URL
   * @return bean instance
   **/
  public InvoiceGetResponse invoiceUrl(String invoiceUrl) {
      this.invoiceUrl = invoiceUrl;
      return this;
  }

  
  public void setMerchantOrder(InvoiceMerchantOrder merchantOrder) {
      this.merchantOrder = merchantOrder;
  }

  /**
   * @param merchantOrder Merchant order data
   * @return bean instance
   **/
  public InvoiceGetResponse merchantOrder(InvoiceMerchantOrder merchantOrder) {
      this.merchantOrder = merchantOrder;
      return this;
  }


  @Override
  public String toString() {
     StringBuilder sb = new StringBuilder();
     sb.append("InvoiceGetResponse( ");
     
     if (customer != null) sb.append("customer=").append(customer.toString()).append("; ");
     if (invoiceData != null) sb.append("invoiceData=").append(invoiceData.toString()).append("; ");
     if (invoiceUrl != null) sb.append("invoiceUrl=").append(invoiceUrl.toString()).append("; ");
     if (merchantOrder != null) sb.append("merchantOrder=").append(merchantOrder.toString()).append("; ");
     sb.append(")");
     return sb.toString();
  }

}


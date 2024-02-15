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
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import lombok.Data;

@Data

public class InvoiceGetDataResponse {
  @SerializedName("amount")
  private BigDecimal amount = null;
  @SerializedName("currency")
  private String currency = null;
  @SerializedName("expire_at")
  private OffsetDateTime expireAt = null;
  @SerializedName("id")
  private String id = null;
  @SerializedName("initial_amount")
  private BigDecimal initialAmount = null;
  @SerializedName("status")
  private String status = null;
  
  public void setAmount(BigDecimal amount) {
      this.amount = amount;
  }

  /**
   * @param amount The total invoice amount in selected currency with dot as a decimal separator
   * @return bean instance
   **/
  public InvoiceGetDataResponse amount(BigDecimal amount) {
      this.amount = amount;
      return this;
  }

  
  public void setCurrency(String currency) {
      this.currency = currency;
  }

  /**
   * @param currency ISO 4217 currency code
   * @return bean instance
   **/
  public InvoiceGetDataResponse currency(String currency) {
      this.currency = currency;
      return this;
  }

  
  public void setExpireAt(OffsetDateTime expireAt) {
      this.expireAt = expireAt;
  }

  /**
   * @param expireAt Date of invoice expiring. Invoice cannot be used after this date.
   * @return bean instance
   **/
  public InvoiceGetDataResponse expireAt(OffsetDateTime expireAt) {
      this.expireAt = expireAt;
      return this;
  }

  
  public void setId(String id) {
      this.id = id;
  }

  /**
   * @param id Identifier of created invoice.
   * @return bean instance
   **/
  public InvoiceGetDataResponse id(String id) {
      this.id = id;
      return this;
  }

  
  public void setInitialAmount(BigDecimal initialAmount) {
      this.initialAmount = initialAmount;
  }

  /**
   * @param initialAmount The amount charged for the initial period from the creation of the transaction to the start date of the subscription
   * @return bean instance
   **/
  public InvoiceGetDataResponse initialAmount(BigDecimal initialAmount) {
      this.initialAmount = initialAmount;
      return this;
  }

  
  public void setStatus(String status) {
      this.status = status;
  }

  /**
   * @param status Status of invoice.
   * @return bean instance
   **/
  public InvoiceGetDataResponse status(String status) {
      this.status = status;
      return this;
  }


  @Override
  public String toString() {
     StringBuilder sb = new StringBuilder();
     sb.append("InvoiceGetDataResponse( ");
     
     if (amount != null) sb.append("amount=").append(amount.toString()).append("; ");
     if (currency != null) sb.append("currency=").append(currency.toString()).append("; ");
     if (expireAt != null) sb.append("expireAt=").append(expireAt.toString()).append("; ");
     if (id != null) sb.append("id=").append(id.toString()).append("; ");
     if (initialAmount != null) sb.append("initialAmount=").append(initialAmount.toString()).append("; ");
     if (status != null) sb.append("status=").append(status.toString()).append("; ");
     sb.append(")");
     return sb.toString();
  }

}


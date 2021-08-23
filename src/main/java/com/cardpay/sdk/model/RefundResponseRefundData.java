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

import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.math.BigDecimal;
import lombok.Data;

@Data

public class RefundResponseRefundData {
  @SerializedName("amount")
  private BigDecimal amount = null;
  @SerializedName("arn")
  private String arn = null;
  @SerializedName("auth_code")
  private String authCode = null;
  @SerializedName("created")
  private String created = null;
  @SerializedName("currency")
  private String currency = null;
  @SerializedName("decline_code")
  private String declineCode = null;
  @SerializedName("decline_reason")
  private String declineReason = null;
  @SerializedName("id")
  private String id = null;
  @SerializedName("is_3d")
  private Boolean is3d = null;
  @SerializedName("rrn")
  private String rrn = null;
  /**
   * Refund status in CardPay system
   */
  @JsonAdapter(StatusEnum.Adapter.class)
  public enum StatusEnum {
    NEW("NEW"),
    
    IN_PROGRESS("IN_PROGRESS"),
    
    DECLINED("DECLINED"),
    
    AUTHORIZED("AUTHORIZED"),
    
    COMPLETED("COMPLETED"),
    
    CANCELLED("CANCELLED"),
    
    REFUNDED("REFUNDED"),
    
    VOIDED("VOIDED"),
    
    TERMINATED("TERMINATED"),
    
    CHARGED_BACK("CHARGED_BACK"),
    
    CHARGEBACK_RESOLVED("CHARGEBACK_RESOLVED");

    private String value;

    StatusEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static StatusEnum fromValue(String text) {
      for (StatusEnum b : StatusEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<StatusEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final StatusEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public StatusEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return StatusEnum.fromValue(String.valueOf(value));
      }
    }
  }

  @SerializedName("status")
  private StatusEnum status = null;
  
  public void setAmount(BigDecimal amount) {
      this.amount = amount;
  }

  /**
   * @param amount Refund transaction amount
   * @return bean instance
   **/
  public RefundResponseRefundData amount(BigDecimal amount) {
      this.amount = amount;
      return this;
  }

  
  public void setArn(String arn) {
      this.arn = arn;
  }

  /**
   * @param arn ARN (Acquirer Reference Number), supplied by the acquiring financial institution, return only after receiving ARN from bank acquirer *(for BANKCARD payment method only)*
   * @return bean instance
   **/
  public RefundResponseRefundData arn(String arn) {
      this.arn = arn;
      return this;
  }

  
  public void setAuthCode(String authCode) {
      this.authCode = authCode;
  }

  /**
   * @param authCode Authorization code, provided by bank *(for BANKCARD payment method only)*
   * @return bean instance
   **/
  public RefundResponseRefundData authCode(String authCode) {
      this.authCode = authCode;
      return this;
  }

  
  public void setCreated(String created) {
      this.created = created;
  }

  /**
   * @param created Date and time when this refund was created, [ISO 8601](https://en.wikipedia.org/wiki/ISO_8601) format
   * @return bean instance
   **/
  public RefundResponseRefundData created(String created) {
      this.created = created;
      return this;
  }

  
  public void setCurrency(String currency) {
      this.currency = currency;
  }

  /**
   * @param currency Currency of refunded amount, [ISO 4217](https://en.wikipedia.org/wiki/ISO_4217) currency code
   * @return bean instance
   **/
  public RefundResponseRefundData currency(String currency) {
      this.currency = currency;
      return this;
  }

  
  public void setDeclineCode(String declineCode) {
      this.declineCode = declineCode;
  }

  /**
   * @param declineCode Refund decline code (only for &#x60;DECLINED&#x60; refund status)
   * @return bean instance
   **/
  public RefundResponseRefundData declineCode(String declineCode) {
      this.declineCode = declineCode;
      return this;
  }

  
  public void setDeclineReason(String declineReason) {
      this.declineReason = declineReason;
  }

  /**
   * @param declineReason Refund decline reason (only for &#x60;DECLINED&#x60; refund status)
   * @return bean instance
   **/
  public RefundResponseRefundData declineReason(String declineReason) {
      this.declineReason = declineReason;
      return this;
  }

  
  public void setId(String id) {
      this.id = id;
  }

  /**
   * @param id ID of the newly created refund in CardPay system
   * @return bean instance
   **/
  public RefundResponseRefundData id(String id) {
      this.id = id;
      return this;
  }

  
  public void setIs3d(Boolean is3d) {
      this.is3d = is3d;
  }

  /**
   * @param is3d Was 3-D Secure authentication made or not *(for BANKCARD payment method only)*
   * @return bean instance
   **/
  public RefundResponseRefundData is3d(Boolean is3d) {
      this.is3d = is3d;
      return this;
  }

  
  public void setRrn(String rrn) {
      this.rrn = rrn;
  }

  /**
   * @param rrn RRN (Retrieval Reference Number), supplied by the acquiring financial institution *(for BANKCARD payment method only)*
   * @return bean instance
   **/
  public RefundResponseRefundData rrn(String rrn) {
      this.rrn = rrn;
      return this;
  }

  
  public void setStatus(StatusEnum status) {
      this.status = status;
  }

  /**
   * @param status Refund status in CardPay system
   * @return bean instance
   **/
  public RefundResponseRefundData status(StatusEnum status) {
      this.status = status;
      return this;
  }


  @Override
  public String toString() {
     StringBuilder sb = new StringBuilder();
     sb.append("RefundResponseRefundData( ");
     
     if (amount != null) sb.append("amount=").append(amount.toString()).append("; ");
     if (arn != null) sb.append("arn=").append(arn.toString()).append("; ");
     if (authCode != null) sb.append("authCode=").append(authCode.toString()).append("; ");
     if (created != null) sb.append("created=").append(created.toString()).append("; ");
     if (currency != null) sb.append("currency=").append(currency.toString()).append("; ");
     if (declineCode != null) sb.append("declineCode=").append(declineCode.toString()).append("; ");
     if (declineReason != null) sb.append("declineReason=").append(declineReason.toString()).append("; ");
     if (id != null) sb.append("id=").append(id.toString()).append("; ");
     if (is3d != null) sb.append("is3d=").append(is3d.toString()).append("; ");
     if (rrn != null) sb.append("rrn=").append(rrn.toString()).append("; ");
     if (status != null) sb.append("status=").append(status.toString()).append("; ");
     sb.append(")");
     return sb.toString();
  }

}


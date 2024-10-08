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

public class BankCardPayoutData {
  @SerializedName("amount")
  private BigDecimal amount = null;
  @SerializedName("arn")
  private String arn = null;
  @SerializedName("created")
  private String created = null;
  @SerializedName("currency")
  private String currency = null;
  @SerializedName("decline_code")
  private String declineCode = null;
  @SerializedName("decline_reason")
  private String declineReason = null;
  @SerializedName("extended_decline_reason")
  private String extendedDeclineReason = null;
  @SerializedName("id")
  private String id = null;
  @SerializedName("note")
  private String note = null;
  @SerializedName("rrn")
  private String rrn = null;
  /**
   * Current payout status
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
    
    CHARGEBACK_RESOLVED("CHARGEBACK_RESOLVED"),
    
    UNPAID("UNPAID"),
    
    WAITING("WAITING");

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
   * @param amount Payout amount
   * @return bean instance
   **/
  public BankCardPayoutData amount(BigDecimal amount) {
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
  public BankCardPayoutData arn(String arn) {
      this.arn = arn;
      return this;
  }

  
  public void setCreated(String created) {
      this.created = created;
  }

  /**
   * @param created Date and time when this payout was created, [ISO 8601](https://en.wikipedia.org/wiki/ISO_8601) format
   * @return bean instance
   **/
  public BankCardPayoutData created(String created) {
      this.created = created;
      return this;
  }

  
  public void setCurrency(String currency) {
      this.currency = currency;
  }

  /**
   * @param currency Payout currency ([ISO 4217](https://en.wikipedia.org/wiki/ISO_4217) format)
   * @return bean instance
   **/
  public BankCardPayoutData currency(String currency) {
      this.currency = currency;
      return this;
  }

  
  public void setDeclineCode(String declineCode) {
      this.declineCode = declineCode;
  }

  /**
   * @param declineCode Decline code (only in decline case)
   * @return bean instance
   **/
  public BankCardPayoutData declineCode(String declineCode) {
      this.declineCode = declineCode;
      return this;
  }

  
  public void setDeclineReason(String declineReason) {
      this.declineReason = declineReason;
  }

  /**
   * @param declineReason Bank&#39;s message about payout decline reason (only in decline case)
   * @return bean instance
   **/
  public BankCardPayoutData declineReason(String declineReason) {
      this.declineReason = declineReason;
      return this;
  }

  
  public void setExtendedDeclineReason(String extendedDeclineReason) {
      this.extendedDeclineReason = extendedDeclineReason;
  }

  /**
   * @param extendedDeclineReason Original decline reason. Can be presented in responses if original network response code is presented and option is enabled for Merchant. Not presented by default, ask Unlimit manager to enable it if needed.
   * @return bean instance
   **/
  public BankCardPayoutData extendedDeclineReason(String extendedDeclineReason) {
      this.extendedDeclineReason = extendedDeclineReason;
      return this;
  }

  
  public void setId(String id) {
      this.id = id;
  }

  /**
   * @param id CardPay&#39;s payout id
   * @return bean instance
   **/
  public BankCardPayoutData id(String id) {
      this.id = id;
      return this;
  }

  
  public void setNote(String note) {
      this.note = note;
  }

  /**
   * @param note Payout note
   * @return bean instance
   **/
  public BankCardPayoutData note(String note) {
      this.note = note;
      return this;
  }

  
  public void setRrn(String rrn) {
      this.rrn = rrn;
  }

  /**
   * @param rrn RRN (Retrieval Reference Number), supplied by the acquiring financial institution *(for BANKCARD method only)*
   * @return bean instance
   **/
  public BankCardPayoutData rrn(String rrn) {
      this.rrn = rrn;
      return this;
  }

  
  public void setStatus(StatusEnum status) {
      this.status = status;
  }

  /**
   * @param status Current payout status
   * @return bean instance
   **/
  public BankCardPayoutData status(StatusEnum status) {
      this.status = status;
      return this;
  }


  @Override
  public String toString() {
     StringBuilder sb = new StringBuilder();
     sb.append("BankCardPayoutData( ");
     
     if (amount != null) sb.append("amount=").append(amount.toString()).append("; ");
     if (arn != null) sb.append("arn=").append(arn.toString()).append("; ");
     if (created != null) sb.append("created=").append(created.toString()).append("; ");
     if (currency != null) sb.append("currency=").append(currency.toString()).append("; ");
     if (declineCode != null) sb.append("declineCode=").append(declineCode.toString()).append("; ");
     if (declineReason != null) sb.append("declineReason=").append(declineReason.toString()).append("; ");
     if (extendedDeclineReason != null) sb.append("extendedDeclineReason=").append(extendedDeclineReason.toString()).append("; ");
     if (id != null) sb.append("id=").append(id.toString()).append("; ");
     if (note != null) sb.append("note=").append(note.toString()).append("; ");
     if (rrn != null) sb.append("rrn=").append(rrn.toString()).append("; ");
     if (status != null) sb.append("status=").append(status.toString()).append("; ");
     sb.append(")");
     return sb.toString();
  }

}


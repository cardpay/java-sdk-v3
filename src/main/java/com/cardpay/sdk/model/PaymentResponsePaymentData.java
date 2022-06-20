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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lombok.Data;

@Data

public class PaymentResponsePaymentData {
  @SerializedName("action_code")
  private String actionCode = null;
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
  @SerializedName("extended_data")
  private Map<String, String> extendedData = null;
  @SerializedName("id")
  private String id = null;
  @SerializedName("installment_type")
  private String installmentType = null;
  @SerializedName("installments")
  private String installments = null;
  @SerializedName("invalid_data")
  private List<String> invalidData = null;
  @SerializedName("is_3d")
  private Boolean is3d = null;
  @SerializedName("note")
  private String note = null;
  @SerializedName("rrn")
  private String rrn = null;
  /**
   * Current payment status, *(mandatory for WEBMONEY and BITCOIN payment method only)*
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
  /**
   * Gets or Sets transType
   */
  @JsonAdapter(TransTypeEnum.Adapter.class)
  public enum TransTypeEnum {
    _01("01"),
    
    _03("03"),
    
    _10("10"),
    
    _11("11"),
    
    _28("28");

    private String value;

    TransTypeEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static TransTypeEnum fromValue(String text) {
      for (TransTypeEnum b : TransTypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<TransTypeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final TransTypeEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public TransTypeEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return TransTypeEnum.fromValue(String.valueOf(value));
      }
    }
  }

  @SerializedName("trans_type")
  private TransTypeEnum transType = null;
  
  public void setActionCode(String actionCode) {
      this.actionCode = actionCode;
  }

  /**
   * @param actionCode Action code (only in decline case)
   * @return bean instance
   **/
  public PaymentResponsePaymentData actionCode(String actionCode) {
      this.actionCode = actionCode;
      return this;
  }

  
  public void setAmount(BigDecimal amount) {
      this.amount = amount;
  }

  /**
   * @param amount Payment amount
   * @return bean instance
   **/
  public PaymentResponsePaymentData amount(BigDecimal amount) {
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
  public PaymentResponsePaymentData arn(String arn) {
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
  public PaymentResponsePaymentData authCode(String authCode) {
      this.authCode = authCode;
      return this;
  }

  
  public void setCreated(String created) {
      this.created = created;
  }

  /**
   * @param created Time when this payment started in [ISO 8601](https://en.wikipedia.org/wiki/ISO_8601) format (yyyy-MM-dd&#39;T&#39;HH:mm:ss&#39;Z&#39;)
   * @return bean instance
   **/
  public PaymentResponsePaymentData created(String created) {
      this.created = created;
      return this;
  }

  
  public void setCurrency(String currency) {
      this.currency = currency;
  }

  /**
   * @param currency Payment currency code ([ISO 4217](https://en.wikipedia.org/wiki/ISO_4217) code)
   * @return bean instance
   **/
  public PaymentResponsePaymentData currency(String currency) {
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
  public PaymentResponsePaymentData declineCode(String declineCode) {
      this.declineCode = declineCode;
      return this;
  }

  
  public void setDeclineReason(String declineReason) {
      this.declineReason = declineReason;
  }

  /**
   * @param declineReason Bank&#39;s message about transaction decline reason (only in decline case)
   * @return bean instance
   **/
  public PaymentResponsePaymentData declineReason(String declineReason) {
      this.declineReason = declineReason;
      return this;
  }

  
  public void setExtendedData(Map<String, String> extendedData) {
      this.extendedData = extendedData;
  }

  /**
   * @param extendedData Extended structure with information for processing a payment in gateway mode. Contact your account manager to enable it
   * @return bean instance
   **/
  public PaymentResponsePaymentData extendedData(Map<String, String> extendedData) {
      this.extendedData = extendedData;
      return this;
  }

  
  public void setId(String id) {
      this.id = id;
  }

  /**
   * @param id CardPay&#39;s payment id
   * @return bean instance
   **/
  public PaymentResponsePaymentData id(String id) {
      this.id = id;
      return this;
  }

  
  public void setInstallmentType(String installmentType) {
      this.installmentType = installmentType;
  }

  /**
   * @param installmentType Selected installment type
   * @return bean instance
   **/
  public PaymentResponsePaymentData installmentType(String installmentType) {
      this.installmentType = installmentType;
      return this;
  }

  
  public void setInstallments(String installments) {
      this.installments = installments;
  }

  /**
   * @param installments Number of total installment payments, to be charged
   * @return bean instance
   **/
  public PaymentResponsePaymentData installments(String installments) {
      this.installments = installments;
      return this;
  }

  
  public void setInvalidData(List<String> invalidData) {
      this.invalidData = invalidData;
  }

  /**
   * @param invalidData Invalid card or billing data
   * @return bean instance
   **/
  public PaymentResponsePaymentData invalidData(List<String> invalidData) {
      this.invalidData = invalidData;
      return this;
  }

  public PaymentResponsePaymentData addInvalidDataItem(String invalidDataItem) {
    if (this.invalidData == null) {
      this.invalidData = new ArrayList<>();
    }
    this.invalidData.add(invalidDataItem);
    return this;
  }

  
  public void setIs3d(Boolean is3d) {
      this.is3d = is3d;
  }

  /**
   * @param is3d Was 3-D Secure authentication made or not *(for BANKCARD payment method only)*
   * @return bean instance
   **/
  public PaymentResponsePaymentData is3d(Boolean is3d) {
      this.is3d = is3d;
      return this;
  }

  
  public void setNote(String note) {
      this.note = note;
  }

  /**
   * @param note Payment note
   * @return bean instance
   **/
  public PaymentResponsePaymentData note(String note) {
      this.note = note;
      return this;
  }

  
  public void setRrn(String rrn) {
      this.rrn = rrn;
  }

  /**
   * @param rrn RRN (Retrieval Reference Number), supplied by the acquiring financial institution *(for BANKCARD payment method only)*
   * @return bean instance
   **/
  public PaymentResponsePaymentData rrn(String rrn) {
      this.rrn = rrn;
      return this;
  }

  
  public void setStatus(StatusEnum status) {
      this.status = status;
  }

  /**
   * @param status Current payment status, *(mandatory for WEBMONEY and BITCOIN payment method only)*
   * @return bean instance
   **/
  public PaymentResponsePaymentData status(StatusEnum status) {
      this.status = status;
      return this;
  }

  
  public void setTransType(TransTypeEnum transType) {
      this.transType = transType;
  }

  /**
   * @param transType transType
   * @return bean instance
   **/
  public PaymentResponsePaymentData transType(TransTypeEnum transType) {
      this.transType = transType;
      return this;
  }


  @Override
  public String toString() {
     StringBuilder sb = new StringBuilder();
     sb.append("PaymentResponsePaymentData( ");
     
     if (actionCode != null) sb.append("actionCode=").append(actionCode.toString()).append("; ");
     if (amount != null) sb.append("amount=").append(amount.toString()).append("; ");
     if (arn != null) sb.append("arn=").append(arn.toString()).append("; ");
     if (authCode != null) sb.append("authCode=").append(authCode.toString()).append("; ");
     if (created != null) sb.append("created=").append(created.toString()).append("; ");
     if (currency != null) sb.append("currency=").append(currency.toString()).append("; ");
     if (declineCode != null) sb.append("declineCode=").append(declineCode.toString()).append("; ");
     if (declineReason != null) sb.append("declineReason=").append(declineReason.toString()).append("; ");
     if (extendedData != null) sb.append("extendedData=").append(extendedData.toString()).append("; ");
     if (id != null) sb.append("id=").append(id.toString()).append("; ");
     if (installmentType != null) sb.append("installmentType=").append(installmentType.toString()).append("; ");
     if (installments != null) sb.append("installments=").append(installments.toString()).append("; ");
     if (invalidData != null) sb.append("invalidData=").append(invalidData.toString()).append("; ");
     if (is3d != null) sb.append("is3d=").append(is3d.toString()).append("; ");
     if (note != null) sb.append("note=").append(note.toString()).append("; ");
     if (rrn != null) sb.append("rrn=").append(rrn.toString()).append("; ");
     if (status != null) sb.append("status=").append(status.toString()).append("; ");
     if (transType != null) sb.append("transType=").append(transType.toString()).append("; ");
     sb.append(")");
     return sb.toString();
  }

}


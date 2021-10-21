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
import lombok.Data;

@Data

public class RecurringResponseRecurringData {
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
  @SerializedName("filing")
  private RecurringResponseFiling filing = null;
  @SerializedName("id")
  private String id = null;
  @SerializedName("initiator")
  private String initiator = null;
  @SerializedName("installment_amount")
  private BigDecimal installmentAmount = null;
  @SerializedName("installment_type")
  private String installmentType = null;
  @SerializedName("invalid_data")
  private List<String> invalidData = null;
  @SerializedName("is_3d")
  private Boolean is3d = null;
  @SerializedName("note")
  private String note = null;
  @SerializedName("payments")
  private String payments = null;
  @SerializedName("rrn")
  private String rrn = null;
  /**
   * Scheduled payment type attribute. &#x60;SM&#x60; - value for scheduled by merchant case &#x60;SA&#x60; - value for scheduled by acquirer case
   */
  @JsonAdapter(ScheduledTypeEnum.Adapter.class)
  public enum ScheduledTypeEnum {
    SA("SA"),
    
    SM("SM");

    private String value;

    ScheduledTypeEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static ScheduledTypeEnum fromValue(String text) {
      for (ScheduledTypeEnum b : ScheduledTypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<ScheduledTypeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final ScheduledTypeEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public ScheduledTypeEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return ScheduledTypeEnum.fromValue(String.valueOf(value));
      }
    }
  }

  @SerializedName("scheduled_type")
  private ScheduledTypeEnum scheduledType = null;
  /**
   * Current recurring payment status
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
  @SerializedName("subscription")
  private Subscription subscription = null;
  /**
   * Recurring payment type name; can be ONECLICK, SCHEDULED, INSTALLMENT
   */
  @JsonAdapter(TypeEnum.Adapter.class)
  public enum TypeEnum {
    ONECLICK("ONECLICK"),
    
    SCHEDULED("SCHEDULED"),
    
    INSTALLMENT("INSTALLMENT");

    private String value;

    TypeEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static TypeEnum fromValue(String text) {
      for (TypeEnum b : TypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<TypeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final TypeEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public TypeEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return TypeEnum.fromValue(String.valueOf(value));
      }
    }
  }

  @SerializedName("type")
  private TypeEnum type = null;
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
  public RecurringResponseRecurringData actionCode(String actionCode) {
      this.actionCode = actionCode;
      return this;
  }

  
  public void setAmount(BigDecimal amount) {
      this.amount = amount;
  }

  /**
   * @param amount Recurring amount
   * @return bean instance
   **/
  public RecurringResponseRecurringData amount(BigDecimal amount) {
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
  public RecurringResponseRecurringData arn(String arn) {
      this.arn = arn;
      return this;
  }

  
  public void setAuthCode(String authCode) {
      this.authCode = authCode;
  }

  /**
   * @param authCode Authorization code, provided by bank
   * @return bean instance
   **/
  public RecurringResponseRecurringData authCode(String authCode) {
      this.authCode = authCode;
      return this;
  }

  
  public void setCreated(String created) {
      this.created = created;
  }

  /**
   * @param created Date and time when this recurring payment was created, [ISO 8601](https://en.wikipedia.org/wiki/ISO_8601) format
   * @return bean instance
   **/
  public RecurringResponseRecurringData created(String created) {
      this.created = created;
      return this;
  }

  
  public void setCurrency(String currency) {
      this.currency = currency;
  }

  /**
   * @param currency Recurring currency code ([ISO 4217](https://en.wikipedia.org/wiki/ISO_4217) code)
   * @return bean instance
   **/
  public RecurringResponseRecurringData currency(String currency) {
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
  public RecurringResponseRecurringData declineCode(String declineCode) {
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
  public RecurringResponseRecurringData declineReason(String declineReason) {
      this.declineReason = declineReason;
      return this;
  }

  
  public void setFiling(RecurringResponseFiling filing) {
      this.filing = filing;
  }

  /**
   * @param filing CardPay&#39;s filing data
   * @return bean instance
   **/
  public RecurringResponseRecurringData filing(RecurringResponseFiling filing) {
      this.filing = filing;
      return this;
  }

  
  public void setId(String id) {
      this.id = id;
  }

  /**
   * @param id CardPay&#39;s recurring id
   * @return bean instance
   **/
  public RecurringResponseRecurringData id(String id) {
      this.id = id;
      return this;
  }

  
  public void setInitiator(String initiator) {
      this.initiator = initiator;
  }

  /**
   * @param initiator Initiator of scheduled transaction (applicable only for scheduled by merchant payments)
   * @return bean instance
   **/
  public RecurringResponseRecurringData initiator(String initiator) {
      this.initiator = initiator;
      return this;
  }

  
  public void setInstallmentAmount(BigDecimal installmentAmount) {
      this.installmentAmount = installmentAmount;
  }

  /**
   * @param installmentAmount Amount of 1 installment payment, will be returned if presented in request (for payment page mode only)
   * @return bean instance
   **/
  public RecurringResponseRecurringData installmentAmount(BigDecimal installmentAmount) {
      this.installmentAmount = installmentAmount;
      return this;
  }

  
  public void setInstallmentType(String installmentType) {
      this.installmentType = installmentType;
  }

  /**
   * @param installmentType Selected installment type
   * @return bean instance
   **/
  public RecurringResponseRecurringData installmentType(String installmentType) {
      this.installmentType = installmentType;
      return this;
  }

  
  public void setInvalidData(List<String> invalidData) {
      this.invalidData = invalidData;
  }

  /**
   * @param invalidData Invalid card or billing data
   * @return bean instance
   **/
  public RecurringResponseRecurringData invalidData(List<String> invalidData) {
      this.invalidData = invalidData;
      return this;
  }

  public RecurringResponseRecurringData addInvalidDataItem(String invalidDataItem) {
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
   * @param is3d Was 3-D Secure authentication made or not
   * @return bean instance
   **/
  public RecurringResponseRecurringData is3d(Boolean is3d) {
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
  public RecurringResponseRecurringData note(String note) {
      this.note = note;
      return this;
  }

  
  public void setPayments(String payments) {
      this.payments = payments;
  }

  /**
   * @param payments Number of total payments, to be charged
   * @return bean instance
   **/
  public RecurringResponseRecurringData payments(String payments) {
      this.payments = payments;
      return this;
  }

  
  public void setRrn(String rrn) {
      this.rrn = rrn;
  }

  /**
   * @param rrn RRN (Retrieval Reference Number), supplied by the acquiring financial institution
   * @return bean instance
   **/
  public RecurringResponseRecurringData rrn(String rrn) {
      this.rrn = rrn;
      return this;
  }

  
  public void setScheduledType(ScheduledTypeEnum scheduledType) {
      this.scheduledType = scheduledType;
  }

  /**
   * @param scheduledType Scheduled payment type attribute. &#x60;SM&#x60; - value for scheduled by merchant case &#x60;SA&#x60; - value for scheduled by acquirer case
   * @return bean instance
   **/
  public RecurringResponseRecurringData scheduledType(ScheduledTypeEnum scheduledType) {
      this.scheduledType = scheduledType;
      return this;
  }

  
  public void setStatus(StatusEnum status) {
      this.status = status;
  }

  /**
   * @param status Current recurring payment status
   * @return bean instance
   **/
  public RecurringResponseRecurringData status(StatusEnum status) {
      this.status = status;
      return this;
  }

  
  public void setSubscription(Subscription subscription) {
      this.subscription = subscription;
  }

  /**
   * @param subscription Subscription data. Mandatory if scheduled payment is requested.
   * @return bean instance
   **/
  public RecurringResponseRecurringData subscription(Subscription subscription) {
      this.subscription = subscription;
      return this;
  }

  
  public void setType(TypeEnum type) {
      this.type = type;
  }

  /**
   * @param type Recurring payment type name; can be ONECLICK, SCHEDULED, INSTALLMENT
   * @return bean instance
   **/
  public RecurringResponseRecurringData type(TypeEnum type) {
      this.type = type;
      return this;
  }

  
  public void setTransType(TransTypeEnum transType) {
      this.transType = transType;
  }

  /**
   * @param transType transType
   * @return bean instance
   **/
  public RecurringResponseRecurringData transType(TransTypeEnum transType) {
      this.transType = transType;
      return this;
  }


  @Override
  public String toString() {
     StringBuilder sb = new StringBuilder();
     sb.append("RecurringResponseRecurringData( ");
     
     if (actionCode != null) sb.append("actionCode=").append(actionCode.toString()).append("; ");
     if (amount != null) sb.append("amount=").append(amount.toString()).append("; ");
     if (arn != null) sb.append("arn=").append(arn.toString()).append("; ");
     if (authCode != null) sb.append("authCode=").append(authCode.toString()).append("; ");
     if (created != null) sb.append("created=").append(created.toString()).append("; ");
     if (currency != null) sb.append("currency=").append(currency.toString()).append("; ");
     if (declineCode != null) sb.append("declineCode=").append(declineCode.toString()).append("; ");
     if (declineReason != null) sb.append("declineReason=").append(declineReason.toString()).append("; ");
     if (filing != null) sb.append("filing=").append(filing.toString()).append("; ");
     if (id != null) sb.append("id=").append(id.toString()).append("; ");
     if (initiator != null) sb.append("initiator=").append(initiator.toString()).append("; ");
     if (installmentAmount != null) sb.append("installmentAmount=").append(installmentAmount.toString()).append("; ");
     if (installmentType != null) sb.append("installmentType=").append(installmentType.toString()).append("; ");
     if (invalidData != null) sb.append("invalidData=").append(invalidData.toString()).append("; ");
     if (is3d != null) sb.append("is3d=").append(is3d.toString()).append("; ");
     if (note != null) sb.append("note=").append(note.toString()).append("; ");
     if (payments != null) sb.append("payments=").append(payments.toString()).append("; ");
     if (rrn != null) sb.append("rrn=").append(rrn.toString()).append("; ");
     if (scheduledType != null) sb.append("scheduledType=").append(scheduledType.toString()).append("; ");
     if (status != null) sb.append("status=").append(status.toString()).append("; ");
     if (subscription != null) sb.append("subscription=").append(subscription.toString()).append("; ");
     if (type != null) sb.append("type=").append(type.toString()).append("; ");
     if (transType != null) sb.append("transType=").append(transType.toString()).append("; ");
     sb.append(")");
     return sb.toString();
  }

}


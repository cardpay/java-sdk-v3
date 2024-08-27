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
import java.time.OffsetDateTime;
import lombok.Data;

@Data

public class ResponseUpdatedTransactionData {
  @SerializedName("details")
  private String details = null;
  @SerializedName("id")
  private String id = null;
  @SerializedName("is_executed")
  private Boolean isExecuted = null;
  /**
   * Status of modified or created transaction
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
  /**
   * Requested action (status to be set).  Payment: &#x60;COMPLETE&#x60; or &#x60;REVERSE&#x60;.  Refund, payout: &#x60;REVERSE&#x60;.
   */
  @JsonAdapter(StatusToEnum.Adapter.class)
  public enum StatusToEnum {
    REVERSE("REVERSE"),
    
    COMPLETE("COMPLETE"),
    
    TERMINATE("TERMINATE");

    private String value;

    StatusToEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static StatusToEnum fromValue(String text) {
      for (StatusToEnum b : StatusToEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<StatusToEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final StatusToEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public StatusToEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return StatusToEnum.fromValue(String.valueOf(value));
      }
    }
  }

  @SerializedName("status_to")
  private StatusToEnum statusTo = null;
  @SerializedName("updated")
  private OffsetDateTime updated = null;
  
  public void setDetails(String details) {
      this.details = details;
  }

  /**
   * @param details The reason why request was unsuccessful
   * @return bean instance
   **/
  public ResponseUpdatedTransactionData details(String details) {
      this.details = details;
      return this;
  }

  
  public void setId(String id) {
      this.id = id;
  }

  /**
   * @param id Represents the ID of the modified transaction
   * @return bean instance
   **/
  public ResponseUpdatedTransactionData id(String id) {
      this.id = id;
      return this;
  }

  
  public void setIsExecuted(Boolean isExecuted) {
      this.isExecuted = isExecuted;
  }

  /**
   * @param isExecuted Indicates was the request successful or not
   * @return bean instance
   **/
  public ResponseUpdatedTransactionData isExecuted(Boolean isExecuted) {
      this.isExecuted = isExecuted;
      return this;
  }

  
  public void setStatus(StatusEnum status) {
      this.status = status;
  }

  /**
   * @param status Status of modified or created transaction
   * @return bean instance
   **/
  public ResponseUpdatedTransactionData status(StatusEnum status) {
      this.status = status;
      return this;
  }

  
  public void setStatusTo(StatusToEnum statusTo) {
      this.statusTo = statusTo;
  }

  /**
   * @param statusTo Requested action (status to be set).  Payment: &#x60;COMPLETE&#x60; or &#x60;REVERSE&#x60;.  Refund, payout: &#x60;REVERSE&#x60;.
   * @return bean instance
   **/
  public ResponseUpdatedTransactionData statusTo(StatusToEnum statusTo) {
      this.statusTo = statusTo;
      return this;
  }

  
  public void setUpdated(OffsetDateTime updated) {
      this.updated = updated;
  }

  /**
   * @param updated Transaction update date and time in [ISO 8601](https://en.wikipedia.org/wiki/ISO_8601) format. Returned only for successful update operations.
   * @return bean instance
   **/
  public ResponseUpdatedTransactionData updated(OffsetDateTime updated) {
      this.updated = updated;
      return this;
  }


  @Override
  public String toString() {
     StringBuilder sb = new StringBuilder();
     sb.append("ResponseUpdatedTransactionData( ");
     
     if (details != null) sb.append("details=").append(details.toString()).append("; ");
     if (id != null) sb.append("id=").append(id.toString()).append("; ");
     if (isExecuted != null) sb.append("isExecuted=").append(isExecuted.toString()).append("; ");
     if (status != null) sb.append("status=").append(status.toString()).append("; ");
     if (statusTo != null) sb.append("statusTo=").append(statusTo.toString()).append("; ");
     if (updated != null) sb.append("updated=").append(updated.toString()).append("; ");
     sb.append(")");
     return sb.toString();
  }

}


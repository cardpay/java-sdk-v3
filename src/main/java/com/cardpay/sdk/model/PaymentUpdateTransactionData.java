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

public class PaymentUpdateTransactionData {
  @SerializedName("amount")
  private BigDecimal amount = null;
  /**
   * Payment, one-click recurring: &#x60;COMPLETE&#x60; or &#x60;REVERSE&#x60; status to be set. Refund, payout: &#x60;REVERSE&#x60; status to be set.
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
  
  public void setAmount(BigDecimal amount) {
      this.amount = amount;
  }

  /**
   * @param amount The total transaction amount in selected currency with dot as a decimal separator, must be less than 10 billion
   * @return bean instance
   **/
  public PaymentUpdateTransactionData amount(BigDecimal amount) {
      this.amount = amount;
      return this;
  }

  
  public void setStatusTo(StatusToEnum statusTo) {
      this.statusTo = statusTo;
  }

  /**
   * @param statusTo Payment, one-click recurring: &#x60;COMPLETE&#x60; or &#x60;REVERSE&#x60; status to be set. Refund, payout: &#x60;REVERSE&#x60; status to be set.
   * @return bean instance
   **/
  public PaymentUpdateTransactionData statusTo(StatusToEnum statusTo) {
      this.statusTo = statusTo;
      return this;
  }


  @Override
  public String toString() {
     StringBuilder sb = new StringBuilder();
     sb.append("PaymentUpdateTransactionData( ");
     
     if (amount != null) sb.append("amount=").append(amount.toString()).append("; ");
     if (statusTo != null) sb.append("statusTo=").append(statusTo.toString()).append("; ");
     sb.append(")");
     return sb.toString();
  }

}


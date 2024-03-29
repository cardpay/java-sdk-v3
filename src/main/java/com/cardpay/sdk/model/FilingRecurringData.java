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
import lombok.Data;

@Data

public class FilingRecurringData {
  @SerializedName("currency")
  private String currency = null;
  @SerializedName("dynamic_descriptor")
  private String dynamicDescriptor = null;
  @SerializedName("initiator")
  private String initiator = null;
  @SerializedName("note")
  private String note = null;
  @SerializedName("three_ds_challenge_indicator")
  private String threeDsChallengeIndicator = null;
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
  
  public void setCurrency(String currency) {
      this.currency = currency;
  }

  /**
   * @param currency [ISO 4217](https://en.wikipedia.org/wiki/ISO_4217) currency code
   * @return bean instance
   **/
  public FilingRecurringData currency(String currency) {
      this.currency = currency;
      return this;
  }

  
  public void setDynamicDescriptor(String dynamicDescriptor) {
      this.dynamicDescriptor = dynamicDescriptor;
  }

  /**
   * @param dynamicDescriptor Short description of the service or product, must be enabled by CardPay manager to be used
   * @return bean instance
   **/
  public FilingRecurringData dynamicDescriptor(String dynamicDescriptor) {
      this.dynamicDescriptor = dynamicDescriptor;
      return this;
  }

  
  public void setInitiator(String initiator) {
      this.initiator = initiator;
  }

  /**
   * @param initiator Can be only &#x60;cit&#x60; (cardholder initiated transaction)
   * @return bean instance
   **/
  public FilingRecurringData initiator(String initiator) {
      this.initiator = initiator;
      return this;
  }

  
  public void setNote(String note) {
      this.note = note;
  }

  /**
   * @param note Note about the transaction that will not be displayed to Customer
   * @return bean instance
   **/
  public FilingRecurringData note(String note) {
      this.note = note;
      return this;
  }

  
  public void setThreeDsChallengeIndicator(String threeDsChallengeIndicator) {
      this.threeDsChallengeIndicator = threeDsChallengeIndicator;
  }

  /**
   * @param threeDsChallengeIndicator threeDsChallengeIndicator
   * @return bean instance
   **/
  public FilingRecurringData threeDsChallengeIndicator(String threeDsChallengeIndicator) {
      this.threeDsChallengeIndicator = threeDsChallengeIndicator;
      return this;
  }

  
  public void setTransType(TransTypeEnum transType) {
      this.transType = transType;
  }

  /**
   * @param transType transType
   * @return bean instance
   **/
  public FilingRecurringData transType(TransTypeEnum transType) {
      this.transType = transType;
      return this;
  }


  @Override
  public String toString() {
     StringBuilder sb = new StringBuilder();
     sb.append("FilingRecurringData( ");
     
     if (currency != null) sb.append("currency=").append(currency.toString()).append("; ");
     if (dynamicDescriptor != null) sb.append("dynamicDescriptor=").append(dynamicDescriptor.toString()).append("; ");
     if (initiator != null) sb.append("initiator=").append(initiator.toString()).append("; ");
     if (note != null) sb.append("note=").append(note.toString()).append("; ");
     if (threeDsChallengeIndicator != null) sb.append("threeDsChallengeIndicator=").append(threeDsChallengeIndicator.toString()).append("; ");
     if (transType != null) sb.append("transType=").append(transType.toString()).append("; ");
     sb.append(")");
     return sb.toString();
  }

}


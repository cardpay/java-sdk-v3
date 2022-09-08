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

public class OneclickData {
  @SerializedName("amount")
  private BigDecimal amount = null;
  @SerializedName("currency")
  private String currency = null;
  @SerializedName("dynamic_descriptor")
  private String dynamicDescriptor = null;
  @SerializedName("filing")
  private RecurringRequestFiling filing = null;
  @SerializedName("generate_token")
  private Boolean generateToken = null;
  @SerializedName("initiator")
  private String initiator = null;
  @SerializedName("note")
  private String note = null;
  @SerializedName("preauth")
  private Boolean preauth = null;
  @SerializedName("sca_exemption")
  private String scaExemption = null;
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
  
  public void setAmount(BigDecimal amount) {
      this.amount = amount;
  }

  /**
   * @param amount The total transaction amount in selected currency with dot as a decimal separator, must be less than 10 billion
   * @return bean instance
   **/
  public OneclickData amount(BigDecimal amount) {
      this.amount = amount;
      return this;
  }

  
  public void setCurrency(String currency) {
      this.currency = currency;
  }

  /**
   * @param currency [ISO 4217](https://en.wikipedia.org/wiki/ISO_4217) currency code
   * @return bean instance
   **/
  public OneclickData currency(String currency) {
      this.currency = currency;
      return this;
  }

  
  public void setDynamicDescriptor(String dynamicDescriptor) {
      this.dynamicDescriptor = dynamicDescriptor;
  }

  /**
   * @param dynamicDescriptor Short description of the service or product, must be enabled by CardPay manager to be used.
   * @return bean instance
   **/
  public OneclickData dynamicDescriptor(String dynamicDescriptor) {
      this.dynamicDescriptor = dynamicDescriptor;
      return this;
  }

  
  public void setFiling(RecurringRequestFiling filing) {
      this.filing = filing;
  }

  /**
   * @param filing Filing data, should be send in all recurring requests besides first recurring request First recurring request should be send without filing attribute
   * @return bean instance
   **/
  public OneclickData filing(RecurringRequestFiling filing) {
      this.filing = filing;
      return this;
  }

  
  public void setGenerateToken(Boolean generateToken) {
      this.generateToken = generateToken;
  }

  /**
   * @param generateToken This attribute can be received only in first recurring request. If set to &#39;true&#39;, Card token will be generated and returned in GET response for all successful transactions (can&#39;t be generated for declined transactions). In all requests with filing_id card.token can&#39;t be generated.
   * @return bean instance
   **/
  public OneclickData generateToken(Boolean generateToken) {
      this.generateToken = generateToken;
      return this;
  }

  
  public void setInitiator(String initiator) {
      this.initiator = initiator;
  }

  /**
   * @param initiator Can be only 2 values - &#39;mit&#39; (merchant initiated transaction), &#39;cit&#39; (cardholder initiated transaction).
   * @return bean instance
   **/
  public OneclickData initiator(String initiator) {
      this.initiator = initiator;
      return this;
  }

  
  public void setNote(String note) {
      this.note = note;
  }

  /**
   * @param note Note about the recurring that will not be displayed to customer.
   * @return bean instance
   **/
  public OneclickData note(String note) {
      this.note = note;
      return this;
  }

  
  public void setPreauth(Boolean preauth) {
      this.preauth = preauth;
  }

  /**
   * @param preauth This parameter allowed to be used only for first recurring payment. If set to &#39;true&#39;, the amount will not be captured but only blocked. One-click payments with &#39;preauth&#39; attribute will be captured automatically in 7 days from the time of creating the preauth transaction. In continue recurring request (with &#39;filing_id&#39;) this parameter shouldn&#39;t be used.
   * @return bean instance
   **/
  public OneclickData preauth(Boolean preauth) {
      this.preauth = preauth;
      return this;
  }

  
  public void setScaExemption(String scaExemption) {
      this.scaExemption = scaExemption;
  }

  /**
   * @param scaExemption Indicates the exemption type that you want to request for the transaction. Possible value: LOW_VALUE
   * @return bean instance
   **/
  public OneclickData scaExemption(String scaExemption) {
      this.scaExemption = scaExemption;
      return this;
  }

  
  public void setThreeDsChallengeIndicator(String threeDsChallengeIndicator) {
      this.threeDsChallengeIndicator = threeDsChallengeIndicator;
  }

  /**
   * @param threeDsChallengeIndicator threeDsChallengeIndicator
   * @return bean instance
   **/
  public OneclickData threeDsChallengeIndicator(String threeDsChallengeIndicator) {
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
  public OneclickData transType(TransTypeEnum transType) {
      this.transType = transType;
      return this;
  }


  @Override
  public String toString() {
     StringBuilder sb = new StringBuilder();
     sb.append("OneclickData( ");
     
     if (amount != null) sb.append("amount=").append(amount.toString()).append("; ");
     if (currency != null) sb.append("currency=").append(currency.toString()).append("; ");
     if (dynamicDescriptor != null) sb.append("dynamicDescriptor=").append(dynamicDescriptor.toString()).append("; ");
     if (filing != null) sb.append("filing=").append(filing.toString()).append("; ");
     if (generateToken != null) sb.append("generateToken=").append(generateToken.toString()).append("; ");
     if (initiator != null) sb.append("initiator=").append(initiator.toString()).append("; ");
     if (note != null) sb.append("note=").append(note.toString()).append("; ");
     if (preauth != null) sb.append("preauth=").append(preauth.toString()).append("; ");
     if (scaExemption != null) sb.append("scaExemption=").append(scaExemption.toString()).append("; ");
     if (threeDsChallengeIndicator != null) sb.append("threeDsChallengeIndicator=").append(threeDsChallengeIndicator.toString()).append("; ");
     if (transType != null) sb.append("transType=").append(transType.toString()).append("; ");
     sb.append(")");
     return sb.toString();
  }

}


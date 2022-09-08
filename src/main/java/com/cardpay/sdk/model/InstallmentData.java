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

public class InstallmentData {
  @SerializedName("amount")
  private BigDecimal amount = null;
  @SerializedName("currency")
  private String currency = null;
  @SerializedName("dynamic_descriptor")
  private String dynamicDescriptor = null;
  @SerializedName("generate_token")
  private Boolean generateToken = null;
  @SerializedName("initiator")
  private String initiator = null;
  @SerializedName("installment_amount")
  private BigDecimal installmentAmount = null;
  @SerializedName("installment_type")
  private String installmentType = null;
  @SerializedName("note")
  private String note = null;
  @SerializedName("payments")
  private Integer payments = null;
  @SerializedName("preauth")
  private Boolean preauth = null;
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
  public InstallmentData amount(BigDecimal amount) {
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
  public InstallmentData currency(String currency) {
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
  public InstallmentData dynamicDescriptor(String dynamicDescriptor) {
      this.dynamicDescriptor = dynamicDescriptor;
      return this;
  }

  
  public void setGenerateToken(Boolean generateToken) {
      this.generateToken = generateToken;
  }

  /**
   * @param generateToken This attribute can be received only in first recurring request. In all requests with recurring_id card.token can&#39;t be generated. If set to &#39;true&#39;, Card token will be generated and returned in GET response. Will be generated only for successful transactions (not for declined).
   * @return bean instance
   **/
  public InstallmentData generateToken(Boolean generateToken) {
      this.generateToken = generateToken;
      return this;
  }

  
  public void setInitiator(String initiator) {
      this.initiator = initiator;
  }

  /**
   * @param initiator Use &#x60;cit&#x60; for initiator attribute (cardholder initiated transaction).
   * @return bean instance
   **/
  public InstallmentData initiator(String initiator) {
      this.initiator = initiator;
      return this;
  }

  
  public void setInstallmentAmount(BigDecimal installmentAmount) {
      this.installmentAmount = installmentAmount;
  }

  /**
   * @param installmentAmount Amount of 1 installment payment, should be less or equal to total amount of subscription, can have dot as a decimal separator. Mandatory for Payment Page Mode only.
   * @return bean instance
   **/
  public InstallmentData installmentAmount(BigDecimal installmentAmount) {
      this.installmentAmount = installmentAmount;
      return this;
  }

  
  public void setInstallmentType(String installmentType) {
      this.installmentType = installmentType;
  }

  /**
   * @param installmentType Installment type, 2 possible values: &#x60;IF&#x60; - issuer financed &#x60;MF_HOLD&#39; - merchant financed hold
   * @return bean instance
   **/
  public InstallmentData installmentType(String installmentType) {
      this.installmentType = installmentType;
      return this;
  }

  
  public void setNote(String note) {
      this.note = note;
  }

  /**
   * @param note Note about the recurring that will not be displayed to customer.
   * @return bean instance
   **/
  public InstallmentData note(String note) {
      this.note = note;
      return this;
  }

  
  public void setPayments(Integer payments) {
      this.payments = payments;
  }

  /**
   * @param payments Number of total payments, to be charged per defined interval. For installment subscription with installment_type &#x3D; &#x60;MF_HOLD&#x60; can be 2-12. For Mexican installment subscription (installment_type &#x3D; &#x60;IF&#x60;) should be 1-99.
   * @return bean instance
   **/
  public InstallmentData payments(Integer payments) {
      this.payments = payments;
      return this;
  }

  
  public void setPreauth(Boolean preauth) {
      this.preauth = preauth;
  }

  /**
   * @param preauth If set to &#x60;true&#x60;, the amount will not be captured but only blocked. Installment with &#x60;preauth&#x60; attribute will be voided automatically in 7 days from the time of creating the preauth transaction.
   * @return bean instance
   **/
  public InstallmentData preauth(Boolean preauth) {
      this.preauth = preauth;
      return this;
  }

  
  public void setThreeDsChallengeIndicator(String threeDsChallengeIndicator) {
      this.threeDsChallengeIndicator = threeDsChallengeIndicator;
  }

  /**
   * @param threeDsChallengeIndicator threeDsChallengeIndicator
   * @return bean instance
   **/
  public InstallmentData threeDsChallengeIndicator(String threeDsChallengeIndicator) {
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
  public InstallmentData transType(TransTypeEnum transType) {
      this.transType = transType;
      return this;
  }


  @Override
  public String toString() {
     StringBuilder sb = new StringBuilder();
     sb.append("InstallmentData( ");
     
     if (amount != null) sb.append("amount=").append(amount.toString()).append("; ");
     if (currency != null) sb.append("currency=").append(currency.toString()).append("; ");
     if (dynamicDescriptor != null) sb.append("dynamicDescriptor=").append(dynamicDescriptor.toString()).append("; ");
     if (generateToken != null) sb.append("generateToken=").append(generateToken.toString()).append("; ");
     if (initiator != null) sb.append("initiator=").append(initiator.toString()).append("; ");
     if (installmentAmount != null) sb.append("installmentAmount=").append(installmentAmount.toString()).append("; ");
     if (installmentType != null) sb.append("installmentType=").append(installmentType.toString()).append("; ");
     if (note != null) sb.append("note=").append(note.toString()).append("; ");
     if (payments != null) sb.append("payments=").append(payments.toString()).append("; ");
     if (preauth != null) sb.append("preauth=").append(preauth.toString()).append("; ");
     if (threeDsChallengeIndicator != null) sb.append("threeDsChallengeIndicator=").append(threeDsChallengeIndicator.toString()).append("; ");
     if (transType != null) sb.append("transType=").append(transType.toString()).append("; ");
     sb.append(")");
     return sb.toString();
  }

}


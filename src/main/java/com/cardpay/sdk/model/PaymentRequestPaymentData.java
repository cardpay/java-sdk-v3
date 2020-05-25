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

public class PaymentRequestPaymentData {
  @SerializedName("amount")
  private BigDecimal amount = null;
  @SerializedName("authentication_request")
  private Boolean authenticationRequest = null;
  @SerializedName("currency")
  private String currency = null;
  @SerializedName("dynamic_descriptor")
  private String dynamicDescriptor = null;
  @SerializedName("encrypted_data")
  private String encryptedData = null;
  @SerializedName("generate_token")
  private Boolean generateToken = null;
  @SerializedName("note")
  private String note = null;
  @SerializedName("preauth")
  private Boolean preauth = null;
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
   * @param amount The total transaction amount in selected currency with dot as a decimal separator, must be less than 100 millions If &#39;payment_method&#39; &#x3D; &#x60;BITCOIN&#x60; then minimum order amount is approximately 0.003 bitcoins or its equivalent. The exact value should be provided by the account manager.
   * @return bean instance
   **/
  public PaymentRequestPaymentData amount(BigDecimal amount) {
      this.amount = amount;
      return this;
  }

  
  public void setAuthenticationRequest(Boolean authenticationRequest) {
      this.authenticationRequest = authenticationRequest;
  }

  /**
   * @param authenticationRequest If set to &#x60;true&#x60;, amount must not be presented in request, no payment will be made, only cardholder authentication will be performed. Also can be used to generate token. *(for BANKCARD payment method only)*
   * @return bean instance
   **/
  public PaymentRequestPaymentData authenticationRequest(Boolean authenticationRequest) {
      this.authenticationRequest = authenticationRequest;
      return this;
  }

  
  public void setCurrency(String currency) {
      this.currency = currency;
  }

  /**
   * @param currency [ISO 4217](https://en.wikipedia.org/wiki/ISO_4217) currency code
   * @return bean instance
   **/
  public PaymentRequestPaymentData currency(String currency) {
      this.currency = currency;
      return this;
  }

  
  public void setDynamicDescriptor(String dynamicDescriptor) {
      this.dynamicDescriptor = dynamicDescriptor;
  }

  /**
   * @param dynamicDescriptor Short description of the service or product, must be enabled by CardPay manager to be used *(for BANKCARD payment method only)*
   * @return bean instance
   **/
  public PaymentRequestPaymentData dynamicDescriptor(String dynamicDescriptor) {
      this.dynamicDescriptor = dynamicDescriptor;
      return this;
  }

  
  public void setEncryptedData(String encryptedData) {
      this.encryptedData = encryptedData;
  }

  /**
   * @param encryptedData The encrypted payment credentials encoded in base64. *(for APPLEPAY payment method only)*
   * @return bean instance
   **/
  public PaymentRequestPaymentData encryptedData(String encryptedData) {
      this.encryptedData = encryptedData;
      return this;
  }

  
  public void setGenerateToken(Boolean generateToken) {
      this.generateToken = generateToken;
  }

  /**
   * @param generateToken If set to &#x60;true&#x60;, token will be generated and returned in the response. Token can be generated only for successful transactions (not for declined transactions) *(for BANKCARD payment method only)*
   * @return bean instance
   **/
  public PaymentRequestPaymentData generateToken(Boolean generateToken) {
      this.generateToken = generateToken;
      return this;
  }

  
  public void setNote(String note) {
      this.note = note;
  }

  /**
   * @param note Note about the transaction that will not be displayed to Customer
   * @return bean instance
   **/
  public PaymentRequestPaymentData note(String note) {
      this.note = note;
      return this;
  }

  
  public void setPreauth(Boolean preauth) {
      this.preauth = preauth;
  }

  /**
   * @param preauth If set to &#x60;true&#x60;, the amount will not be captured but only blocked. Payments with &#39;preauth&#39; attribute will be captured automatically in 7 days from the time of creating the preauth transaction. *(for BANKCARD payment method only)*.
   * @return bean instance
   **/
  public PaymentRequestPaymentData preauth(Boolean preauth) {
      this.preauth = preauth;
      return this;
  }

  
  public void setTransType(TransTypeEnum transType) {
      this.transType = transType;
  }

  /**
   * @param transType transType
   * @return bean instance
   **/
  public PaymentRequestPaymentData transType(TransTypeEnum transType) {
      this.transType = transType;
      return this;
  }


  @Override
  public String toString() {
     StringBuilder sb = new StringBuilder();
     sb.append("PaymentRequestPaymentData( ");
     
     if (amount != null) sb.append("amount=").append(amount.toString()).append("; ");
     if (authenticationRequest != null) sb.append("authenticationRequest=").append(authenticationRequest.toString()).append("; ");
     if (currency != null) sb.append("currency=").append(currency.toString()).append("; ");
     if (dynamicDescriptor != null) sb.append("dynamicDescriptor=").append(dynamicDescriptor.toString()).append("; ");
     if (encryptedData != null) sb.append("encryptedData=").append(encryptedData.toString()).append("; ");
     if (generateToken != null) sb.append("generateToken=").append(generateToken.toString()).append("; ");
     if (note != null) sb.append("note=").append(note.toString()).append("; ");
     if (preauth != null) sb.append("preauth=").append(preauth.toString()).append("; ");
     if (transType != null) sb.append("transType=").append(transType.toString()).append("; ");
     sb.append(")");
     return sb.toString();
  }

}


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
import java.time.OffsetDateTime;
import lombok.Data;

@Data

public class RecurringRequestRecurringData {
  @SerializedName("amount")
  private BigDecimal amount = null;
  @SerializedName("contract_number")
  private String contractNumber = null;
  @SerializedName("currency")
  private String currency = null;
  @SerializedName("dynamic_descriptor")
  private String dynamicDescriptor = null;
  @SerializedName("encrypted_data")
  private String encryptedData = null;
  @SerializedName("filing")
  private RecurringRequestFiling filing = null;
  @SerializedName("generate_token")
  private Boolean generateToken = null;
  @SerializedName("initial_amount")
  private BigDecimal initialAmount = null;
  @SerializedName("initiator")
  private String initiator = null;
  @SerializedName("interval")
  private Integer interval = null;
  @SerializedName("note")
  private String note = null;
  @SerializedName("payments")
  private Integer payments = null;
  /**
   * Initial period of recurring, can be &#x60;day&#x60;, &#x60;week&#x60;, &#x60;month&#x60;, &#x60;year&#x60;.  &#x60;minute&#x60; - for **sandbox environment** and testing purpose only.
   */
  @JsonAdapter(PeriodEnum.Adapter.class)
  public enum PeriodEnum {
    MINUTE("minute"),
    
    DAY("day"),
    
    WEEK("week"),
    
    MONTH("month"),
    
    YEAR("year");

    private String value;

    PeriodEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static PeriodEnum fromValue(String text) {
      for (PeriodEnum b : PeriodEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<PeriodEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final PeriodEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public PeriodEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return PeriodEnum.fromValue(String.valueOf(value));
      }
    }
  }

  @SerializedName("period")
  private PeriodEnum period = null;
  @SerializedName("plan")
  private Plan plan = null;
  @SerializedName("preauth")
  private Boolean preauth = null;
  @SerializedName("retries")
  private Integer retries = null;
  @SerializedName("scheduled_type")
  private String scheduledType = null;
  @SerializedName("subscription_start")
  private OffsetDateTime subscriptionStart = null;
  @SerializedName("trans_type")
  private String transType = null;
  
  public void setAmount(BigDecimal amount) {
      this.amount = amount;
  }

  /**
   * @param amount The total transaction amount in selected currency with dot as a decimal separator, must be less than 100 millions
   * @return bean instance
   **/
  public RecurringRequestRecurringData amount(BigDecimal amount) {
      this.amount = amount;
      return this;
  }

  
  public void setContractNumber(String contractNumber) {
      this.contractNumber = contractNumber;
  }

  /**
   * @param contractNumber Contract number between customer and merchant. Required for Mexican merchants for scheduled payments.
   * @return bean instance
   **/
  public RecurringRequestRecurringData contractNumber(String contractNumber) {
      this.contractNumber = contractNumber;
      return this;
  }

  
  public void setCurrency(String currency) {
      this.currency = currency;
  }

  /**
   * @param currency [ISO 4217](https://en.wikipedia.org/wiki/ISO_4217) currency code
   * @return bean instance
   **/
  public RecurringRequestRecurringData currency(String currency) {
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
  public RecurringRequestRecurringData dynamicDescriptor(String dynamicDescriptor) {
      this.dynamicDescriptor = dynamicDescriptor;
      return this;
  }

  
  public void setEncryptedData(String encryptedData) {
      this.encryptedData = encryptedData;
  }

  /**
   * @param encryptedData The encrypted payment credentials encoded in Base64
   * @return bean instance
   **/
  public RecurringRequestRecurringData encryptedData(String encryptedData) {
      this.encryptedData = encryptedData;
      return this;
  }

  
  public void setFiling(RecurringRequestFiling filing) {
      this.filing = filing;
  }

  /**
   * @param filing Filing data, should be send in all recurring requests besides first recurring request First recurring request should be send without filing attribute
   * @return bean instance
   **/
  public RecurringRequestRecurringData filing(RecurringRequestFiling filing) {
      this.filing = filing;
      return this;
  }

  
  public void setGenerateToken(Boolean generateToken) {
      this.generateToken = generateToken;
  }

  /**
   * @param generateToken This attribute can be received only in first recurring request. In all requests with recurring_id card.token can&#39;t be generated. If set to &#39;true&#39;, card token will be generated and returned in GET response. Will be generated only for successful transactions (not for declined).
   * @return bean instance
   **/
  public RecurringRequestRecurringData generateToken(Boolean generateToken) {
      this.generateToken = generateToken;
      return this;
  }

  
  public void setInitialAmount(BigDecimal initialAmount) {
      this.initialAmount = initialAmount;
  }

  /**
   * @param initialAmount The amount charged for the initial period from the creation of the transaction to the start date of the subscription (&#39;subscription_start&#39;). It is indicated by the merchant in case of a discount or extra charge. It pays once during subscription.
   * @return bean instance
   **/
  public RecurringRequestRecurringData initialAmount(BigDecimal initialAmount) {
      this.initialAmount = initialAmount;
      return this;
  }

  
  public void setInitiator(String initiator) {
      this.initiator = initiator;
  }

  /**
   * @param initiator Can be only 2 values: &#x60;mit&#x60; (merchant initiated transaction), &#x60;cit&#x60; (cardholder initiated transaction)
   * @return bean instance
   **/
  public RecurringRequestRecurringData initiator(String initiator) {
      this.initiator = initiator;
      return this;
  }

  
  public void setInterval(Integer interval) {
      this.interval = interval;
  }

  /**
   * minimum: 1
   * @param interval Frequency interval of period, can be 1-365 depending on selected period value. Minimum value of period + interval can be 7 days / 1 week. Maximum value of period + interval plan can be 365 days / 52 weeks / 12 months / 1 year. 1-60 minutes - for **sandbox environment** and testing purpose only.
   * @return bean instance
   **/
  public RecurringRequestRecurringData interval(Integer interval) {
      this.interval = interval;
      return this;
  }

  
  public void setNote(String note) {
      this.note = note;
  }

  /**
   * @param note Note about the recurring that will not be displayed to customer.
   * @return bean instance
   **/
  public RecurringRequestRecurringData note(String note) {
      this.note = note;
      return this;
  }

  
  public void setPayments(Integer payments) {
      this.payments = payments;
  }

  /**
   * minimum: 2
   * maximum: 200
   * @param payments Number of total payments to be charged per defined interval, can be 2-200.
   * @return bean instance
   **/
  public RecurringRequestRecurringData payments(Integer payments) {
      this.payments = payments;
      return this;
  }

  
  public void setPeriod(PeriodEnum period) {
      this.period = period;
  }

  /**
   * @param period Initial period of recurring, can be &#x60;day&#x60;, &#x60;week&#x60;, &#x60;month&#x60;, &#x60;year&#x60;.  &#x60;minute&#x60; - for **sandbox environment** and testing purpose only.
   * @return bean instance
   **/
  public RecurringRequestRecurringData period(PeriodEnum period) {
      this.period = period;
      return this;
  }

  
  public void setPlan(Plan plan) {
      this.plan = plan;
  }

  /**
   * @param plan Plan data
   * @return bean instance
   **/
  public RecurringRequestRecurringData plan(Plan plan) {
      this.plan = plan;
      return this;
  }

  
  public void setPreauth(Boolean preauth) {
      this.preauth = preauth;
  }

  /**
   * @param preauth This parameter is allowed to be used only for first recurring payment. If set to &#x60;true&#x60;, the amount will not be captured but only blocked *(for BANKCARD payment method only)*.
   * @return bean instance
   **/
  public RecurringRequestRecurringData preauth(Boolean preauth) {
      this.preauth = preauth;
      return this;
  }

  
  public void setRetries(Integer retries) {
      this.retries = retries;
  }

  /**
   * minimum: 1
   * maximum: 15
   * @param retries Number of daily basis retry attempts in case of payment has not been captured successfully, from 1 to 15 attempts can be specified.
   * @return bean instance
   **/
  public RecurringRequestRecurringData retries(Integer retries) {
      this.retries = retries;
      return this;
  }

  
  public void setScheduledType(String scheduledType) {
      this.scheduledType = scheduledType;
  }

  /**
   * @param scheduledType Scheduled payment type attribute. For scheduled payments by merchant value should be &#x60;SM&#x60; - scheduled by merchant
   * @return bean instance
   **/
  public RecurringRequestRecurringData scheduledType(String scheduledType) {
      this.scheduledType = scheduledType;
      return this;
  }

  
  public void setSubscriptionStart(OffsetDateTime subscriptionStart) {
      this.subscriptionStart = subscriptionStart;
  }

  /**
   * @param subscriptionStart The date in yyyy-MM-dd format when subscription will actually become activated (grace period). Auth request will be created but Customer will be charged only when subscription start date comes. Leave it empty or specify the current date to activate subscription at once without any grace period applied.
   * @return bean instance
   **/
  public RecurringRequestRecurringData subscriptionStart(OffsetDateTime subscriptionStart) {
      this.subscriptionStart = subscriptionStart;
      return this;
  }

  
  public void setTransType(String transType) {
      this.transType = transType;
  }

  /**
   * @param transType Identifies the type of transaction being authenticated
   * @return bean instance
   **/
  public RecurringRequestRecurringData transType(String transType) {
      this.transType = transType;
      return this;
  }


  @Override
  public String toString() {
     StringBuilder sb = new StringBuilder();
     sb.append("RecurringRequestRecurringData( ");
     
     if (amount != null) sb.append("amount=").append(amount.toString()).append("; ");
     if (contractNumber != null) sb.append("contractNumber=").append(contractNumber.toString()).append("; ");
     if (currency != null) sb.append("currency=").append(currency.toString()).append("; ");
     if (dynamicDescriptor != null) sb.append("dynamicDescriptor=").append(dynamicDescriptor.toString()).append("; ");
     if (encryptedData != null) sb.append("encryptedData=").append(encryptedData.toString()).append("; ");
     if (filing != null) sb.append("filing=").append(filing.toString()).append("; ");
     if (generateToken != null) sb.append("generateToken=").append(generateToken.toString()).append("; ");
     if (initialAmount != null) sb.append("initialAmount=").append(initialAmount.toString()).append("; ");
     if (initiator != null) sb.append("initiator=").append(initiator.toString()).append("; ");
     if (interval != null) sb.append("interval=").append(interval.toString()).append("; ");
     if (note != null) sb.append("note=").append(note.toString()).append("; ");
     if (payments != null) sb.append("payments=").append(payments.toString()).append("; ");
     if (period != null) sb.append("period=").append(period.toString()).append("; ");
     if (plan != null) sb.append("plan=").append(plan.toString()).append("; ");
     if (preauth != null) sb.append("preauth=").append(preauth.toString()).append("; ");
     if (retries != null) sb.append("retries=").append(retries.toString()).append("; ");
     if (scheduledType != null) sb.append("scheduledType=").append(scheduledType.toString()).append("; ");
     if (subscriptionStart != null) sb.append("subscriptionStart=").append(subscriptionStart.toString()).append("; ");
     if (transType != null) sb.append("transType=").append(transType.toString()).append("; ");
     sb.append(")");
     return sb.toString();
  }

}


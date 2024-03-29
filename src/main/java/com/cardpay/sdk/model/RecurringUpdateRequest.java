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

public class RecurringUpdateRequest {
  @SerializedName("request")
  private Request request = null;
  /**
   * &#x60;CHANGE_STATUS&#x60; value
   */
  @JsonAdapter(OperationEnum.Adapter.class)
  public enum OperationEnum {
    CHANGE_STATUS("CHANGE_STATUS"),
    
    CONFIRM_3DS("CONFIRM_3DS"),
    
    EXECUTE("EXECUTE"),
    
    INCREMENT("INCREMENT");

    private String value;

    OperationEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static OperationEnum fromValue(String text) {
      for (OperationEnum b : OperationEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<OperationEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final OperationEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public OperationEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return OperationEnum.fromValue(String.valueOf(value));
      }
    }
  }

  @SerializedName("operation")
  private OperationEnum operation = null;
  @SerializedName("recurring_data")
  private PaymentUpdateTransactionData recurringData = null;
  @SerializedName("transaction_data")
  private PaymentUpdateTransactionData transactionData = null;
  
  public void setRequest(Request request) {
      this.request = request;
  }

  /**
   * @param request Request
   * @return bean instance
   **/
  public RecurringUpdateRequest request(Request request) {
      this.request = request;
      return this;
  }

  
  public void setOperation(OperationEnum operation) {
      this.operation = operation;
  }

  /**
   * @param operation &#x60;CHANGE_STATUS&#x60; value
   * @return bean instance
   **/
  public RecurringUpdateRequest operation(OperationEnum operation) {
      this.operation = operation;
      return this;
  }

  
  public void setRecurringData(PaymentUpdateTransactionData recurringData) {
      this.recurringData = recurringData;
  }

  /**
   * @param recurringData Recurring data
   * @return bean instance
   **/
  public RecurringUpdateRequest recurringData(PaymentUpdateTransactionData recurringData) {
      this.recurringData = recurringData;
      return this;
  }

  
  public void setTransactionData(PaymentUpdateTransactionData transactionData) {
      this.transactionData = transactionData;
  }

  /**
   * @param transactionData transactionData
   * @return bean instance
   **/
  public RecurringUpdateRequest transactionData(PaymentUpdateTransactionData transactionData) {
      this.transactionData = transactionData;
      return this;
  }


  @Override
  public String toString() {
     StringBuilder sb = new StringBuilder();
     sb.append("RecurringUpdateRequest( ");
     
     if (request != null) sb.append("request=").append(request.toString()).append("; ");
     if (operation != null) sb.append("operation=").append(operation.toString()).append("; ");
     if (recurringData != null) sb.append("recurringData=").append(recurringData.toString()).append("; ");
     if (transactionData != null) sb.append("transactionData=").append(transactionData.toString()).append("; ");
     sb.append(")");
     return sb.toString();
  }

}


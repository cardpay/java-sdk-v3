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

public class PlanUpdateRequest {
  @SerializedName("request")
  private Request request = null;
  /**
   * &#x60;CHANGE_STATUS&#x60; value to initiate operation for status changing. &#x60;RENAME&#x60; value to initiate operation for plan renaming.
   */
  @JsonAdapter(OperationEnum.Adapter.class)
  public enum OperationEnum {
    CHANGE_STATUS("CHANGE_STATUS"),
    
    RENAME("RENAME"),
    
    CHANGE_QUANTITY("CHANGE_QUANTITY");

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
  @SerializedName("plan_data")
  private PlanUpdateRequestPlanData planData = null;
  
  public void setRequest(Request request) {
      this.request = request;
  }

  /**
   * @param request Request
   * @return bean instance
   **/
  public PlanUpdateRequest request(Request request) {
      this.request = request;
      return this;
  }

  
  public void setOperation(OperationEnum operation) {
      this.operation = operation;
  }

  /**
   * @param operation &#x60;CHANGE_STATUS&#x60; value to initiate operation for status changing. &#x60;RENAME&#x60; value to initiate operation for plan renaming.
   * @return bean instance
   **/
  public PlanUpdateRequest operation(OperationEnum operation) {
      this.operation = operation;
      return this;
  }

  
  public void setPlanData(PlanUpdateRequestPlanData planData) {
      this.planData = planData;
  }

  /**
   * @param planData Plan data
   * @return bean instance
   **/
  public PlanUpdateRequest planData(PlanUpdateRequestPlanData planData) {
      this.planData = planData;
      return this;
  }


  @Override
  public String toString() {
     StringBuilder sb = new StringBuilder();
     sb.append("PlanUpdateRequest( ");
     
     if (request != null) sb.append("request=").append(request.toString()).append("; ");
     if (operation != null) sb.append("operation=").append(operation.toString()).append("; ");
     if (planData != null) sb.append("planData=").append(planData.toString()).append("; ");
     sb.append(")");
     return sb.toString();
  }

}


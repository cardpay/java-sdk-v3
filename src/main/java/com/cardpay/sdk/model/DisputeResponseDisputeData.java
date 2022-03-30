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

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data

public class DisputeResponseDisputeData {
  @SerializedName("due_time")
  private String dueTime = null;
  @SerializedName("group_id")
  private String groupId = null;
  @SerializedName("reason_code")
  private String reasonCode = null;
  @SerializedName("reason_description")
  private String reasonDescription = null;
  @SerializedName("reg_time")
  private String regTime = null;
  @SerializedName("result_time")
  private String resultTime = null;
  @SerializedName("stage")
  private String stage = null;
  @SerializedName("status")
  private String status = null;
  @SerializedName("type")
  private String type = null;
  
  public void setDueTime(String dueTime) {
      this.dueTime = dueTime;
  }

  /**
   * @param dueTime Due date and time in [ISO 8601](https://en.wikipedia.org/wiki/ISO_8601) format for making decision or action over chargeback/retrieval request, i.e accepting, disputing or providing evidence documents (format - yyyy-MM-dd&#39;T&#39;HH:mm:ss&#39;Z&#39;)
   * @return bean instance
   **/
  public DisputeResponseDisputeData dueTime(String dueTime) {
      this.dueTime = dueTime;
      return this;
  }

  
  public void setGroupId(String groupId) {
      this.groupId = groupId;
  }

  /**
   * @param groupId Dispute group ID in Disputes Resolution Center that includes returned dispute entity
   * @return bean instance
   **/
  public DisputeResponseDisputeData groupId(String groupId) {
      this.groupId = groupId;
      return this;
  }

  
  public void setReasonCode(String reasonCode) {
      this.reasonCode = reasonCode;
  }

  /**
   * @param reasonCode Dispute&#39;s reason code
   * @return bean instance
   **/
  public DisputeResponseDisputeData reasonCode(String reasonCode) {
      this.reasonCode = reasonCode;
      return this;
  }

  
  public void setReasonDescription(String reasonDescription) {
      this.reasonDescription = reasonDescription;
  }

  /**
   * @param reasonDescription Dispute&#39;s reason code description
   * @return bean instance
   **/
  public DisputeResponseDisputeData reasonDescription(String reasonDescription) {
      this.reasonDescription = reasonDescription;
      return this;
  }

  
  public void setRegTime(String regTime) {
      this.regTime = regTime;
  }

  /**
   * @param regTime Dispute registration date in [ISO 8601](https://en.wikipedia.org/wiki/ISO_8601) format (format - yyyy-MM-dd&#39;T&#39;HH:mm:ss&#39;Z&#39;)
   * @return bean instance
   **/
  public DisputeResponseDisputeData regTime(String regTime) {
      this.regTime = regTime;
      return this;
  }

  
  public void setResultTime(String resultTime) {
      this.resultTime = resultTime;
  }

  /**
   * @param resultTime Dispute&#39;s terminal (final) status date and time in [ISO 8601](https://en.wikipedia.org/wiki/ISO_8601) format (format - yyyy-MM-dd&#39;T&#39;HH:mm:ss&#39;Z&#39;)
   * @return bean instance
   **/
  public DisputeResponseDisputeData resultTime(String resultTime) {
      this.resultTime = resultTime;
      return this;
  }

  
  public void setStage(String stage) {
      this.stage = stage;
  }

  /**
   * @param stage Chargeback/retrieval request&#39;s current stage
   * @return bean instance
   **/
  public DisputeResponseDisputeData stage(String stage) {
      this.stage = stage;
      return this;
  }

  
  public void setStatus(String status) {
      this.status = status;
  }

  /**
   * @param status Chargeback/retrieval request&#39;s current status
   * @return bean instance
   **/
  public DisputeResponseDisputeData status(String status) {
      this.status = status;
      return this;
  }

  
  public void setType(String type) {
      this.type = type;
  }

  /**
   * @param type Indicates dispute entity type: &#x60;CB&#x60; - for chargebacks &#x60;RR&#x60; - for retrieval requests &#x60;FR&#x60; - for fraud reports
   * @return bean instance
   **/
  public DisputeResponseDisputeData type(String type) {
      this.type = type;
      return this;
  }


  @Override
  public String toString() {
     StringBuilder sb = new StringBuilder();
     sb.append("DisputeResponseDisputeData( ");
     
     if (dueTime != null) sb.append("dueTime=").append(dueTime.toString()).append("; ");
     if (groupId != null) sb.append("groupId=").append(groupId.toString()).append("; ");
     if (reasonCode != null) sb.append("reasonCode=").append(reasonCode.toString()).append("; ");
     if (reasonDescription != null) sb.append("reasonDescription=").append(reasonDescription.toString()).append("; ");
     if (regTime != null) sb.append("regTime=").append(regTime.toString()).append("; ");
     if (resultTime != null) sb.append("resultTime=").append(resultTime.toString()).append("; ");
     if (stage != null) sb.append("stage=").append(stage.toString()).append("; ");
     if (status != null) sb.append("status=").append(status.toString()).append("; ");
     if (type != null) sb.append("type=").append(type.toString()).append("; ");
     sb.append(")");
     return sb.toString();
  }

}

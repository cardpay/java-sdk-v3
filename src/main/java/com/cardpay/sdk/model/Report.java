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
import java.util.UUID;
import lombok.Data;

@Data

public class Report {
  @SerializedName("currency")
  private String currency = null;
  @SerializedName("downloadUrl")
  private String downloadUrl = null;
  @SerializedName("fileId")
  private UUID fileId = null;
  @SerializedName("fileName")
  private String fileName = null;
  @SerializedName("hashSum")
  private String hashSum = null;
  @SerializedName("reportType")
  private String reportType = null;
  @SerializedName("settlementDate")
  private String settlementDate = null;
  @SerializedName("settlementId")
  private Long settlementId = null;
  @SerializedName("size")
  private Long size = null;
  /**
   * Gets or Sets status
   */
  @JsonAdapter(StatusEnum.Adapter.class)
  public enum StatusEnum {
    IN_PROGRESS("IN_PROGRESS"),
    
    COMPLETED("COMPLETED"),
    
    FAILED("FAILED");

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
  @SerializedName("websiteName")
  private String websiteName = null;
  
  public void setCurrency(String currency) {
      this.currency = currency;
  }

  /**
   * @param currency currency
   * @return bean instance
   **/
  public Report currency(String currency) {
      this.currency = currency;
      return this;
  }

  
  public void setDownloadUrl(String downloadUrl) {
      this.downloadUrl = downloadUrl;
  }

  /**
   * @param downloadUrl downloadUrl
   * @return bean instance
   **/
  public Report downloadUrl(String downloadUrl) {
      this.downloadUrl = downloadUrl;
      return this;
  }

  
  public void setFileId(UUID fileId) {
      this.fileId = fileId;
  }

  /**
   * @param fileId fileId
   * @return bean instance
   **/
  public Report fileId(UUID fileId) {
      this.fileId = fileId;
      return this;
  }

  
  public void setFileName(String fileName) {
      this.fileName = fileName;
  }

  /**
   * @param fileName fileName
   * @return bean instance
   **/
  public Report fileName(String fileName) {
      this.fileName = fileName;
      return this;
  }

  
  public void setHashSum(String hashSum) {
      this.hashSum = hashSum;
  }

  /**
   * @param hashSum hashSum
   * @return bean instance
   **/
  public Report hashSum(String hashSum) {
      this.hashSum = hashSum;
      return this;
  }

  
  public void setReportType(String reportType) {
      this.reportType = reportType;
  }

  /**
   * @param reportType reportType
   * @return bean instance
   **/
  public Report reportType(String reportType) {
      this.reportType = reportType;
      return this;
  }

  
  public void setSettlementDate(String settlementDate) {
      this.settlementDate = settlementDate;
  }

  /**
   * @param settlementDate settlementDate
   * @return bean instance
   **/
  public Report settlementDate(String settlementDate) {
      this.settlementDate = settlementDate;
      return this;
  }

  
  public void setSettlementId(Long settlementId) {
      this.settlementId = settlementId;
  }

  /**
   * @param settlementId settlementId
   * @return bean instance
   **/
  public Report settlementId(Long settlementId) {
      this.settlementId = settlementId;
      return this;
  }

  
  public void setSize(Long size) {
      this.size = size;
  }

  /**
   * @param size size
   * @return bean instance
   **/
  public Report size(Long size) {
      this.size = size;
      return this;
  }

  
  public void setStatus(StatusEnum status) {
      this.status = status;
  }

  /**
   * @param status status
   * @return bean instance
   **/
  public Report status(StatusEnum status) {
      this.status = status;
      return this;
  }

  
  public void setWebsiteName(String websiteName) {
      this.websiteName = websiteName;
  }

  /**
   * @param websiteName websiteName
   * @return bean instance
   **/
  public Report websiteName(String websiteName) {
      this.websiteName = websiteName;
      return this;
  }


  @Override
  public String toString() {
     StringBuilder sb = new StringBuilder();
     sb.append("Report( ");
     
     if (currency != null) sb.append("currency=").append(currency.toString()).append("; ");
     if (downloadUrl != null) sb.append("downloadUrl=").append(downloadUrl.toString()).append("; ");
     if (fileId != null) sb.append("fileId=").append(fileId.toString()).append("; ");
     if (fileName != null) sb.append("fileName=").append(fileName.toString()).append("; ");
     if (hashSum != null) sb.append("hashSum=").append(hashSum.toString()).append("; ");
     if (reportType != null) sb.append("reportType=").append(reportType.toString()).append("; ");
     if (settlementDate != null) sb.append("settlementDate=").append(settlementDate.toString()).append("; ");
     if (settlementId != null) sb.append("settlementId=").append(settlementId.toString()).append("; ");
     if (size != null) sb.append("size=").append(size.toString()).append("; ");
     if (status != null) sb.append("status=").append(status.toString()).append("; ");
     if (websiteName != null) sb.append("websiteName=").append(websiteName.toString()).append("; ");
     sb.append(")");
     return sb.toString();
  }

}


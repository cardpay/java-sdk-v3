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

public class BrowserInfo {
  @SerializedName("accept_header")
  private String acceptHeader = null;
  @SerializedName("color_depth")
  private Integer colorDepth = null;
  @SerializedName("java_enabled")
  private Boolean javaEnabled = null;
  @SerializedName("java_script_enabled")
  private Boolean javaScriptEnabled = null;
  @SerializedName("language")
  private String language = null;
  @SerializedName("screen_height")
  private Integer screenHeight = null;
  @SerializedName("screen_width")
  private Integer screenWidth = null;
  @SerializedName("time_zone_offset")
  private Integer timeZoneOffset = null;
  
  public void setAcceptHeader(String acceptHeader) {
      this.acceptHeader = acceptHeader;
  }

  /**
   * @param acceptHeader Exact content of the HTTP accept headers as sent to the 3-D Secure 2 Requestor from the Cardholder&#39;s browser
   * @return bean instance
   **/
  public BrowserInfo acceptHeader(String acceptHeader) {
      this.acceptHeader = acceptHeader;
      return this;
  }

  
  public void setColorDepth(Integer colorDepth) {
      this.colorDepth = colorDepth;
  }

  /**
   * minimum: 1
   * maximum: 99
   * @param colorDepth Value representing the bit depth of the colour palette for displaying images, in bits per pixel
   * @return bean instance
   **/
  public BrowserInfo colorDepth(Integer colorDepth) {
      this.colorDepth = colorDepth;
      return this;
  }

  
  public void setJavaEnabled(Boolean javaEnabled) {
      this.javaEnabled = javaEnabled;
  }

  /**
   * @param javaEnabled Boolean that represents the ability of the cardholder browser to execute Java
   * @return bean instance
   **/
  public BrowserInfo javaEnabled(Boolean javaEnabled) {
      this.javaEnabled = javaEnabled;
      return this;
  }

  
  public void setJavaScriptEnabled(Boolean javaScriptEnabled) {
      this.javaScriptEnabled = javaScriptEnabled;
  }

  /**
   * @param javaScriptEnabled Boolean that represents the ability of the cardholder browser to execute JavaScript
   * @return bean instance
   **/
  public BrowserInfo javaScriptEnabled(Boolean javaScriptEnabled) {
      this.javaScriptEnabled = javaScriptEnabled;
      return this;
  }

  
  public void setLanguage(String language) {
      this.language = language;
  }

  /**
   * @param language Value representing the browser language as defined in IETF BCP47
   * @return bean instance
   **/
  public BrowserInfo language(String language) {
      this.language = language;
      return this;
  }

  
  public void setScreenHeight(Integer screenHeight) {
      this.screenHeight = screenHeight;
  }

  /**
   * minimum: 1
   * maximum: 999999
   * @param screenHeight Total height of the Cardholder’s screen in pixels
   * @return bean instance
   **/
  public BrowserInfo screenHeight(Integer screenHeight) {
      this.screenHeight = screenHeight;
      return this;
  }

  
  public void setScreenWidth(Integer screenWidth) {
      this.screenWidth = screenWidth;
  }

  /**
   * minimum: 1
   * maximum: 999999
   * @param screenWidth Total width of the Cardholder&#39;s screen in pixels
   * @return bean instance
   **/
  public BrowserInfo screenWidth(Integer screenWidth) {
      this.screenWidth = screenWidth;
      return this;
  }

  
  public void setTimeZoneOffset(Integer timeZoneOffset) {
      this.timeZoneOffset = timeZoneOffset;
  }

  /**
   * @param timeZoneOffset Time-zone offset in minutes between UTC and the Cardholder browser local time
   * @return bean instance
   **/
  public BrowserInfo timeZoneOffset(Integer timeZoneOffset) {
      this.timeZoneOffset = timeZoneOffset;
      return this;
  }


  @Override
  public String toString() {
     StringBuilder sb = new StringBuilder();
     sb.append("BrowserInfo( ");
     
     if (acceptHeader != null) sb.append("acceptHeader=").append(acceptHeader.toString()).append("; ");
     if (colorDepth != null) sb.append("colorDepth=").append(colorDepth.toString()).append("; ");
     if (javaEnabled != null) sb.append("javaEnabled=").append(javaEnabled.toString()).append("; ");
     if (javaScriptEnabled != null) sb.append("javaScriptEnabled=").append(javaScriptEnabled.toString()).append("; ");
     if (language != null) sb.append("language=").append(language.toString()).append("; ");
     if (screenHeight != null) sb.append("screenHeight=").append(screenHeight.toString()).append("; ");
     if (screenWidth != null) sb.append("screenWidth=").append(screenWidth.toString()).append("; ");
     if (timeZoneOffset != null) sb.append("timeZoneOffset=").append(timeZoneOffset.toString()).append("; ");
     sb.append(")");
     return sb.toString();
  }

}


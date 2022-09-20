package com.cardpay.sdk.api;

import com.cardpay.sdk.client.CollectionFormats.*;
import com.cardpay.sdk.model.CardInfoRequest;
import com.cardpay.sdk.model.CardInfoResponse;
import retrofit2.Call;
import retrofit2.http.*;

public interface CardInfoApi {
  /**
   * Get card information
   * 
   * @param cardInfoRequest cardInfoRequest (required)
   * @return Call&lt;CardInfoResponse&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("api/card_info")
  Call<CardInfoResponse> cardInfo(
    @retrofit2.http.Body CardInfoRequest cardInfoRequest
  );

}

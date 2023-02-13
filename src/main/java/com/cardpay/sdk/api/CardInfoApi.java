package com.cardpay.sdk.api;

import com.cardpay.sdk.client.CollectionFormats.*;
import com.cardpay.sdk.model.CardInfoRequest;
import com.cardpay.sdk.model.CardInfoResponse;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.*;

public interface CardInfoApi {
  /**
   * Get card information
   * 
   * @param cardInfoRequest cardInfoRequest (required)
   * @return Call&lt;List&lt;CardInfoResponse&gt;&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("api/card_info")
  Call<List<CardInfoResponse>> cardInfo(
    @retrofit2.http.Body CardInfoRequest cardInfoRequest
  );

}

package com.cardpay.sdk.api;

import com.cardpay.sdk.client.CollectionFormats.*;
import com.cardpay.sdk.model.InvoiceCreationResponse;
import com.cardpay.sdk.model.InvoiceGetResponse;
import com.cardpay.sdk.model.InvoiceRequest;
import retrofit2.Call;
import retrofit2.http.*;

public interface InvoicesApi {
  /**
   * Create invoice
   * Endpoint for invoice creation
   * @param invoiceRequest invoiceRequest (required)
   * @return Call&lt;InvoiceCreationResponse&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @POST("api/invoices")
  Call<InvoiceCreationResponse> createInvoice(
    @retrofit2.http.Body InvoiceRequest invoiceRequest
  );

  /**
   * Get invoice information
   * Method allows to get information about single invoice.
   * @param invoiceId Invoice ID (required)
   * @return Call&lt;InvoiceGetResponse&gt;
   */
  @GET("api/invoices/{invoiceId}")
  Call<InvoiceGetResponse> getInvoice(
    @retrofit2.http.Path("invoiceId") String invoiceId
  );

}

/*
 * Copyright (c) 2021 R2D2 - Arturo Astorga
 */
package com.aplazo.r2d2.payment.quote.service;

import com.aplazo.r2d2.payment.quote.model.ProjectionPaymentsRequest;
import org.springframework.http.ResponseEntity;

/**
 * Description: Interfaz de la logica de negocio.
 * 
 * @author arturoastorga file: MsAplazoPaymentQuoteService.java
 * @since Oct 23, 2021
 */
public interface MsAplazoPaymentQuoteService {
  ResponseEntity<Object> getProjection(ProjectionPaymentsRequest projectionPaymentsRequest);
}

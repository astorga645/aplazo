/*
 * Copyright (c) 2021 R2D2 - Arturo Astorga
 */
package com.aplazo.r2d2.payment.quote.api;

import com.aplazo.r2d2.payment.quote.constant.ApiConstant;
import com.aplazo.r2d2.payment.quote.constant.Constant;
import com.aplazo.r2d2.payment.quote.model.ProjectionPaymentsRequest;
import com.aplazo.r2d2.payment.quote.service.MsAplazoPaymentQuoteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description: Clase conrtolador del servicio
 * 
 * @author arturoastorga file: MsAplazoPaymentQuoteController.java
 * @since Oct 23, 2021
 */
@Slf4j
@RestController
@Validated
@RequestMapping(ApiConstant.BASE_PATH)
public class MsAplazoPaymentQuoteController {

  /**
   * Servicio MsAplazoPaymentQuoteService para de Obtener la proyeccion.
   */
  @Autowired
  private MsAplazoPaymentQuoteService msAplazoPaymentQuoteService;

  /**
   * Api que realizara la proyeccion de pagos
   * 
   * @param host
   * @param userAgent
   * @param projectionPaymentsRequest
   * @return
   */
  @PostMapping(ApiConstant.PATH_PAYMENT_QUOTE)
  public ResponseEntity<Object> paymentsProjection(
      @RequestHeader(name = Constant.HOST, required = true) String host,
      @RequestHeader(name = Constant.USER_AGENT, required = true) String userAgent,
      @RequestBody ProjectionPaymentsRequest projectionPaymentsRequest) {
    log.info(Constant.RESPONSE, projectionPaymentsRequest);
    return this.msAplazoPaymentQuoteService.getProjection(projectionPaymentsRequest);
  }
}

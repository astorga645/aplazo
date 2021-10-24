/*
 * Copyright (c) 2021 R2D2 - Arturo Astorga
 */
package com.aplazo.r2d2.payment.quote.business;

import com.aplazo.r2d2.payment.quote.constant.Constant;
import com.aplazo.r2d2.payment.quote.model.ErrorRequest;
import com.aplazo.r2d2.payment.quote.model.ProjectionPayments;
import com.aplazo.r2d2.payment.quote.model.ProjectionPaymentsRequest;
import com.aplazo.r2d2.payment.quote.service.MsAplazoPaymentQuoteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Description:Implementacion de la logica de negocio.
 * 
 * @author arturoastorga file: MsAplazoPaymentQuoteBusiness.java
 * @since Oct 23, 2021
 */
@Slf4j
@Service
public class MsAplazoPaymentQuoteBusiness implements MsAplazoPaymentQuoteService {

  @Override
  public ResponseEntity<Object> getProjection(ProjectionPaymentsRequest projectionPaymentsRequest) {

    log.info(Constant.RESPONSE, projectionPaymentsRequest);
    if (evaluateRequest(projectionPaymentsRequest)) {
      int nAbono = Constant.ONE_INT;
      double abono = (projectionPaymentsRequest.getAmount()
          * (Constant.ONE_INT + (projectionPaymentsRequest.getRate() / Constant.ONE_HUNDRED_INT)))
          / projectionPaymentsRequest.getTerms();
      abono = Math.round(abono * Constant.ONE_HUNDRED_POINT_ZERO) / Constant.ONE_HUNDRED_POINT_ZERO;
      List<ProjectionPayments> listProjectionPayments = new ArrayList<>();
      LocalDate localDate = obtenerSabado();
      while (nAbono <= projectionPaymentsRequest.getTerms()) {
        listProjectionPayments.add(new ProjectionPayments(nAbono, abono, localDate));
        localDate = localDate.plusDays(Constant.SEVEN_INT);
        nAbono += Constant.ONE_INT;
      }

      return new ResponseEntity<>(listProjectionPayments, HttpStatus.OK);
    } else
      return new ResponseEntity<>(
          new ErrorRequest(projectionPaymentsRequest.toString(), Constant.MESSAGE_ERROR),
          HttpStatus.BAD_REQUEST);
  }

  /**
   * 
   * @param projectionPaymentsRequest
   * @return
   */
  private Boolean evaluateRequest(ProjectionPaymentsRequest projectionPaymentsRequest) {
    return (projectionPaymentsRequest.getAmount() < Constant.ONE_INT
        || projectionPaymentsRequest.getAmount() > Constant.NINE_INT
        || projectionPaymentsRequest.getRate() < Constant.ONE_INT
        || projectionPaymentsRequest.getRate() > Constant.ONE_HUNDRED_INT
        || projectionPaymentsRequest.getTerms() < Constant.FOUR_INT
        || projectionPaymentsRequest.getTerms() > Constant.FIFTY_TWO_INT) ? false : true;
    /*
     * if (projectionPaymentsRequest.getAmount() < Constant.ONE_INT ||
     * projectionPaymentsRequest.getAmount() > Constant.NINE_INT) return false; if
     * (projectionPaymentsRequest.getRate() < Constant.ONE_INT ||
     * projectionPaymentsRequest.getRate() > Constant.CIEN_ENTERO) return false; if
     * (projectionPaymentsRequest.getTerms() < Constant.FOUR_INT ||
     * projectionPaymentsRequest.getTerms() > Constant.CINCODOS_ENTERO) return false; return true;
     * 
     */
  }

  private LocalDate obtenerSabado() {

    return (LocalDate.now().getDayOfWeek().getValue() == Constant.SEVEN_INT)
        ? LocalDate.now().plusDays(Constant.SIX_INT)
        : LocalDate.now().plusDays(Constant.SIX_INT - LocalDate.now().getDayOfWeek().getValue());
    /*
     * LocalDate date = LocalDate.now(); int value = date.getDayOfWeek().getValue(); if (value ==
     * Constant.SEVEN_INT) return date.plusDays(Constant.SIX_INT); else { return
     * date.plusDays(Constant.SIX_INT - value); }
     */
  }

}

/*
 * Copyright (c) 2021 R2D2 - Arturo Astorga
 */
package com.aplazo.r2d2.payment.quote.business;

import com.aplazo.r2d2.payment.quote.constant.Constant;
import com.aplazo.r2d2.payment.quote.model.ErrorRequest;
import com.aplazo.r2d2.payment.quote.model.ProjectionPayments;
import com.aplazo.r2d2.payment.quote.model.ProjectionPaymentsRequest;
import com.aplazo.r2d2.payment.quote.model.ProjectionPaymentsResponse;
import com.aplazo.r2d2.payment.quote.service.MsAplazoPaymentQuoteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
      Calendar calendar = Calendar.getInstance();
      int numberWeekOfYear = calendar.get(Calendar.WEEK_OF_YEAR);
      int nAbono = Constant.UNO_ENTERO;
      double abono = (projectionPaymentsRequest.getAmount()
          * (Constant.UNO_ENTERO + (projectionPaymentsRequest.getRate() / Constant.CIEN_ENTERO)))
          / projectionPaymentsRequest.getTerms();

      List<ProjectionPayments> listProjectionPayments = new ArrayList<>();
      while (nAbono <= projectionPaymentsRequest.getTerms()) {
        listProjectionPayments.add(new ProjectionPayments(nAbono, abono, new Date()));
        nAbono += Constant.UNO_ENTERO;
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
    if (projectionPaymentsRequest.getAmount() < Constant.UNO_ENTERO
        || projectionPaymentsRequest.getAmount() > Constant.NUEVES_ENTERO)
      return false;
    if (projectionPaymentsRequest.getRate() < Constant.UNO_ENTERO
        || projectionPaymentsRequest.getRate() > Constant.CIEN_ENTERO)
      return false;
    if (projectionPaymentsRequest.getTerms() < Constant.CUATRO_ENTERO
        || projectionPaymentsRequest.getTerms() > Constant.CINCODOS_ENTERO)
      return false;
    return true;
  }

}

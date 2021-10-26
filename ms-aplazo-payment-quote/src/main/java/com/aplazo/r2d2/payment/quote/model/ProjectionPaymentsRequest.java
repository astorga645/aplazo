/*
 * Copyright (c) 2021 R2D2 - Arturo Astorga
 */
package com.aplazo.r2d2.payment.quote.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Description: Cuerpo de la peticion
 * 
 * @author arturoastorga file: ProjectionPaymentsRequest.java
 * @since Oct 23, 2021
 */
@Data
@AllArgsConstructor
public class ProjectionPaymentsRequest {
  /**
   * credito.
   */
  private double amount;

  /**
   * plazo.
   */
  private int terms;

  /**
   * tasa.
   */
  private double rate;


}

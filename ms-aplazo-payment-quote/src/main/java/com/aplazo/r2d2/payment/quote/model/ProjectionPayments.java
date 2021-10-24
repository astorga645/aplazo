/*
 * Copyright (c) 2021 R2D2 - Arturo Astorga
 */
package com.aplazo.r2d2.payment.quote.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.time.LocalDate;

/**
 * Description: Cuerpo de la lista.
 * 
 * @author arturoastorga file: ProjectionPayments.java
 * @since Oct 23, 2021
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ProjectionPayments {
  /**
   * numero abono.
   */
  private int paymentNumber;

  /**
   * abono.
   */
  private double amount;

  /**
   * fecha de pago.
   */
  private LocalDate paymentDate;

}

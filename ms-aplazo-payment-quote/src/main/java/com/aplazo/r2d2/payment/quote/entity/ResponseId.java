/*
 * Copyright (c) 2021 R2D2 - Arturo Astorga
 */
package com.aplazo.r2d2.payment.quote.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

/**
 * Description:
 * 
 * @author arturoastorga file: ResponseId.java
 * @since Oct 25, 2021
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ResponseId implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = -299633570420774079L;

  private int idRequest;

  private int paymentNumber;

}

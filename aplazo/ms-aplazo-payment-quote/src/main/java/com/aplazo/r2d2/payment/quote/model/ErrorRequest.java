/*
 * Copyright (c) 2021 R2D2 - Arturo Astorga
 */
package com.aplazo.r2d2.payment.quote.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Description: Error Response
 * @author arturoastorga file: ErrorRequest.java
 * @since Oct 23, 2021
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ErrorRequest {
  /**
   * Response el cuerpo de la peticion.
   */
  private String peticion;
  
  /**
   * Response un mensaje.
   */
  private String mensaje;

}

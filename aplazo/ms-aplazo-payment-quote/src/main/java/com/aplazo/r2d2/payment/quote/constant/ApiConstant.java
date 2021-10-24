/*
 * Copyright (c) 2021 R2D2 - Arturo Astorga
 */
package com.aplazo.r2d2.payment.quote.constant;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * Description: Constantes estaticas lecturas del properties.
 * @author arturoastorga file: ApiConstant.java
 * @since Oct 23, 2021
 */
@Component
@Data
public class ApiConstant {
  
  /**
   * Pathdel uri get del microservicio.
   */
  public static final String BASE_PATH = "${api.basePath}";
  
  /**
   * Placeholder de la llave del '.properites' para el valor del path del uri que recupera
   * informacion.
   */
  public static final String PATH_PAYMENT_QUOTE = "${api.aplazo.payment.quote.mapping}";
  

}

/*
 * Copyright (c) 2021 R2D2 - Arturo Astorga
 */
package com.aplazo.r2d2.payment.quote.constant;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Description: Constantes estaticas lecturas del properties.
 * 
 * @author arturoastorga file: ApiConstant.java
 * @since Oct 23, 2021
 */
@Component
@Data
@PropertySource("classpath:application.properties")
public class ApiConstant {

  /**
   * Pathdel uri get del microservicio.
   */
  @Value("${api.basePath}")
  public static String BASE_PATH;

  /**
   * Placeholder de la llave del '.properites' para el valor del path del uri que recupera
   * informacion.
   */
  @Value("${api.aplazo.payment.quote.mapping}")
  public static String PATH_PAYMENT_QUOTE;

}

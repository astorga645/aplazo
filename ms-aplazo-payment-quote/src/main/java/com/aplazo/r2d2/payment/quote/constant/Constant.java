/*
 * Copyright (c) 2021 R2D2 - Arturo Astorga
 */
package com.aplazo.r2d2.payment.quote.constant;

import org.springframework.stereotype.Component;

/**
 * Description: Constantes de codigo duro.
 * 
 * @author arturoastorga file: Constant.java
 * @since Oct 23, 2021
 */
@Component
public class Constant {

  /**
   * Placeholder de la llave del '.properites' para el valor del paquete.
   */
  public static final String BASE_PACKAGE_ASTERICK = "com.aplazo.r2d2.*";

  /**
   * Cadena para pintar la respuesta.
   */
  public static final String RESPONSE = "Response: {}";

  /**
   * Constante utilizada para representar el nombre del header Host.
   */
  public static final String HOST = "Host";
  /**
   * Constante utilizada para representar el nombre del header User-Agent.
   */
  public static final String USER_AGENT = "User-Agent";

  /**
   * Constante String vacio.
   */
  public static final String REQUEST_TABLE = "Request";
  
  /**
   * Constante String tabla.
   */
  public static final String RESPONSE_TABLE = "Response";
  
  /**
   * Constante String vacio.
   */
  public static final String EMPTY_STRING = "";

  /**
   * Constante String vacio.
   */
  public static final String MESSAGE_ERROR =
      "Se recibio un parametro fuera de los valores permitidos.";


  /**
   * Constante entera 1.
   */
  public static final int ONE_INT = 1;

  /**
   * Constante entera 4.
   */
  public static final int FOUR_INT = 4;
  /**
   * Constante entera 6.
   */
  public static final int SIX_INT = 6;

  /**
   * Constante entera 7.
   */
  public static final int SEVEN_INT = 7;

  /**
   * Constante entera 52.
   */
  public static final int FIFTY_TWO_INT = 52;

  /**
   * Constante entera 100.
   */
  public static final int ONE_HUNDRED_INT = 100;
  
  /**
   * Constante entera 100.
   */
  public static final double ONE_HUNDRED_POINT_ZERO = 100.0;

  /**
   * Constante entera 999999.
   */
  public static final int NINE_INT = 999999;

  /**
   * Constante base de la ruta.
   */
  public static final String BASE_PATH = "/api";

  /**
   * Constante base de la ruta completa.
   */
  public static final String PATH_PAYMENT_QUOTE = "/private/v1/aplazo/payment/quote/projection";


}

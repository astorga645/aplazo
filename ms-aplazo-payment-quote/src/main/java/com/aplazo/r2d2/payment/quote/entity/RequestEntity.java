/*
 * Copyright (c) 2021 R2D2 - Arturo Astorga
 */
package com.aplazo.r2d2.payment.quote.entity;

import com.aplazo.r2d2.payment.quote.constant.Constant;
import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Description: 
 * @author arturoastorga file: RequestEntity.java
 * @since Oct 25, 2021
 */
@Data
@Entity
@Table(name =Constant.REQUEST_TABLE)
public class RequestEntity {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  
  /**
   * plazo.
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

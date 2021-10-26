/*
 * Copyright (c) 2021 R2D2 - Arturo Astorga
 */
package com.aplazo.r2d2.payment.quote.entity;

import com.aplazo.r2d2.payment.quote.constant.Constant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 * Description:
 * 
 * @author arturoastorga file: ResponseEntity.java
 * @since Oct 25, 2021
 */
@Data
@Entity
@IdClass(ResponseId.class)
@Table(name = Constant.RESPONSE_TABLE)
@NoArgsConstructor
@AllArgsConstructor
public class ResponseEntity {
  @Id
  private int idRequest;
  @Id
  private int paymentNumber;

  private double amount;

  private LocalDate paymentDate;

}

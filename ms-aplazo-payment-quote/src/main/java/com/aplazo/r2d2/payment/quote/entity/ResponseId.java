/*
 * Copyright (c) 2021 R2D2 - Arturo Astorga
 */
package com.aplazo.r2d2.payment.quote.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
public class ResponseId {

  private int idRequest;

  private int paymentNumber;

}

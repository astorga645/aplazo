/*
 * Copyright (c) 2021 R2D2 - Arturo Astorga
 */
package com.aplazo.r2d2.payment.quote.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.util.List;

/**
 * Description: Cuerpo de la respuesta
 * 
 * @author arturoastorga file: ProjectionPaymentsResponse.java
 * @since Oct 23, 2021
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ProjectionPaymentsResponse {

  List<ProjectionPayments> projectionPayments;

}

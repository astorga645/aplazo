/*
 * Copyright (c) 2021 R2D2 - Arturo Astorga
 */
package com.aplazo.r2d2.payment.quote.repository;

import com.aplazo.r2d2.payment.quote.entity.ResponseEntity;
import com.aplazo.r2d2.payment.quote.entity.ResponseId;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Description: 
 * @author arturoastorga file: ResponseRepository.java
 * @since Oct 25, 2021
 */
public interface ResponseRepository extends JpaRepository<ResponseEntity, ResponseId> {

}

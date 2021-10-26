/*
 * Copyright (c) 2021 R2D2 - Arturo Astorga
 */
package com.aplazo.r2d2.payment.quote.business;

import static org.junit.Assert.*;
import com.aplazo.r2d2.payment.quote.model.ProjectionPaymentsRequest;
import com.aplazo.r2d2.payment.quote.test.constant.TestConstants;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;

/**
 * Description:
 * 
 * @author arturoastorga file: MsAplazoPaymentQuoteBusinessTest.java
 * @since Oct 25, 2021
 */
public class MsAplazoPaymentQuoteBusinessTest {


  /**
   * Mock inyectado del controlador que se va a probar.
   */
  @InjectMocks
  private MsAplazoPaymentQuoteBusiness msAplazoPaymentQuoteBusiness;

  /**
   * @throws java.lang.Exception
   */
  @Before
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);
  }

  /**
   * Test method for
   * {@link com.aplazo.r2d2.payment.quote.business.MsAplazoPaymentQuoteBusiness#getProjection(com.aplazo.r2d2.payment.quote.model.ProjectionPaymentsRequest)}.
   */
  @Test
  public final void testGetProjection() {
    ProjectionPaymentsRequest projectionPaymentsRequest = new ProjectionPaymentsRequest(
        TestConstants.ONE_HUNDRED_DOUBLE, TestConstants.FIFTEN_INT, TestConstants.TEEN_INT);

    assertEquals(
        msAplazoPaymentQuoteBusiness.getProjection(projectionPaymentsRequest).getStatusCode(),
        HttpStatus.OK);
  }

  /**
   * Test method for
   * {@link com.aplazo.r2d2.payment.quote.business.MsAplazoPaymentQuoteBusiness#getProjection(com.aplazo.r2d2.payment.quote.model.ProjectionPaymentsRequest)}.
   */
  @Test
  public final void testGetProjectionFailMinimumAmount() {
    ProjectionPaymentsRequest projectionPaymentsRequest = new ProjectionPaymentsRequest(
        TestConstants.ZERO_DOUBLE, TestConstants.FIFTEN_INT, TestConstants.TEEN_INT);

    assertEquals(
        msAplazoPaymentQuoteBusiness.getProjection(projectionPaymentsRequest).getStatusCode(),
        HttpStatus.BAD_REQUEST);

  }

  /**
   * Test method for
   * {@link com.aplazo.r2d2.payment.quote.business.MsAplazoPaymentQuoteBusiness#getProjection(com.aplazo.r2d2.payment.quote.model.ProjectionPaymentsRequest)}.
   */
  @Test
  public final void testGetProjectionFailMaximumAmount() {
    ProjectionPaymentsRequest projectionPaymentsRequest = new ProjectionPaymentsRequest(
        TestConstants.TWO_MILLION_DOUBLE, TestConstants.FIFTEN_INT, TestConstants.TEEN_INT);
    assertEquals(
        msAplazoPaymentQuoteBusiness.getProjection(projectionPaymentsRequest).getStatusCode(),
        HttpStatus.BAD_REQUEST);
  }
  
  /**
   * Test method for
   * {@link com.aplazo.r2d2.payment.quote.business.MsAplazoPaymentQuoteBusiness#getProjection(com.aplazo.r2d2.payment.quote.model.ProjectionPaymentsRequest)}.
   */
  @Test
  public final void testGetProjectionFailMinimumTerms() {
    ProjectionPaymentsRequest projectionPaymentsRequest = new ProjectionPaymentsRequest(
        TestConstants.ONE_HUNDRED_DOUBLE, TestConstants.ONE_INT, TestConstants.TEEN_INT);

    assertEquals(
        msAplazoPaymentQuoteBusiness.getProjection(projectionPaymentsRequest).getStatusCode(),
        HttpStatus.BAD_REQUEST);

  }

  /**
   * Test method for
   * {@link com.aplazo.r2d2.payment.quote.business.MsAplazoPaymentQuoteBusiness#getProjection(com.aplazo.r2d2.payment.quote.model.ProjectionPaymentsRequest)}.
   */
  @Test
  public final void testGetProjectionFailMaximumTerms() {
    ProjectionPaymentsRequest projectionPaymentsRequest = new ProjectionPaymentsRequest(
        TestConstants.ONE_HUNDRED_DOUBLE, TestConstants.OK_INT, TestConstants.TEEN_INT);
    assertEquals(
        msAplazoPaymentQuoteBusiness.getProjection(projectionPaymentsRequest).getStatusCode(),
        HttpStatus.BAD_REQUEST);
  }
  
  /**
   * Test method for
   * {@link com.aplazo.r2d2.payment.quote.business.MsAplazoPaymentQuoteBusiness#getProjection(com.aplazo.r2d2.payment.quote.model.ProjectionPaymentsRequest)}.
   */
  @Test
  public final void testGetProjectionFailMinimumRate() {
    
    ProjectionPaymentsRequest projectionPaymentsRequest = new ProjectionPaymentsRequest(
        TestConstants.ONE_HUNDRED_DOUBLE, TestConstants.FIFTEN_INT, TestConstants.ZERO_INT);
    
    
    projectionPaymentsRequest.setAmount(projectionPaymentsRequest.getAmount());
    projectionPaymentsRequest.setTerms(projectionPaymentsRequest.getTerms());
    projectionPaymentsRequest.setRate(projectionPaymentsRequest.getRate());

    assertEquals(
        msAplazoPaymentQuoteBusiness.getProjection(projectionPaymentsRequest).getStatusCode(),
        HttpStatus.BAD_REQUEST);

  }

  /**
   * Test method for
   * {@link com.aplazo.r2d2.payment.quote.business.MsAplazoPaymentQuoteBusiness#getProjection(com.aplazo.r2d2.payment.quote.model.ProjectionPaymentsRequest)}.
   */
  @Test
  public final void testGetProjectionFailMaximumRate() {
    ProjectionPaymentsRequest projectionPaymentsRequest = new ProjectionPaymentsRequest(
        TestConstants.ONE_HUNDRED_DOUBLE, TestConstants.FIFTEN_INT, TestConstants.OK_INT);
    assertEquals(
        msAplazoPaymentQuoteBusiness.getProjection(projectionPaymentsRequest).getStatusCode(),
        HttpStatus.BAD_REQUEST);
  }

}

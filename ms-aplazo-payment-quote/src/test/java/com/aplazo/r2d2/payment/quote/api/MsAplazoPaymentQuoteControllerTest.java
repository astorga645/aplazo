/*
 * Copyright (c) 2021 R2D2 - Arturo Astorga
 */
package com.aplazo.r2d2.payment.quote.api;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import com.aplazo.r2d2.payment.quote.model.ProjectionPaymentsRequest;
import com.aplazo.r2d2.payment.quote.service.MsAplazoPaymentQuoteService;
import com.aplazo.r2d2.payment.quote.test.constant.TestConstants;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.ArrayList;

/**
 * Description: Mock inyectado del controlador que se va a probar.
 * 
 * @author arturoastorga file: MsAplazoPaymentQuoteControllerTest.java
 * @since Oct 25, 2021
 */
public class MsAplazoPaymentQuoteControllerTest {

  /**
   * Mock inyectado del controlador que se va a probar.
   */
  @InjectMocks
  private MsAplazoPaymentQuoteController msAplazoPaymentQuoteController;

  @Mock
  private MsAplazoPaymentQuoteService msAplazoPaymentQuoteService;

  /**
   * @throws java.lang.Exception
   */
  @Before
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);
  }

  /**
   * Test method for
   * {@link com.aplazo.r2d2.payment.quote.api.MsAplazoPaymentQuoteController#paymentsProjection(java.lang.String, java.lang.String, com.aplazo.r2d2.payment.quote.model.ProjectionPaymentsRequest)}.
   */
  @Test
  public final void testPaymentsProjection() {
    ProjectionPaymentsRequest projectionPaymentsRequest = new ProjectionPaymentsRequest(
        TestConstants.ONE_HUNDRED_DOUBLE, TestConstants.FIFTEN_INT, TestConstants.TEEN_INT);

    when(msAplazoPaymentQuoteService.getProjection(projectionPaymentsRequest))
        .thenReturn(new ResponseEntity<>(new ArrayList<>(), HttpStatus.OK));
    assertNotNull(msAplazoPaymentQuoteController.paymentsProjection(TestConstants.HOST,
        TestConstants.USER_AGENT, projectionPaymentsRequest));
  }

}

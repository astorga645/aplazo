/*
 * Copyright (c) 2021 R2D2 - Arturo Astorga
 */
package com.aplazo.r2d2.payment.quote.test.api;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import com.aplazo.r2d2.payment.quote.api.MsAplazoPaymentQuoteController;
import com.aplazo.r2d2.payment.quote.model.ProjectionPaymentsRequest;
import com.aplazo.r2d2.payment.quote.service.MsAplazoPaymentQuoteService;
import com.aplazo.r2d2.payment.quote.test.constant.TestConstants;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * Description: Clase test de controlador
 * 
 * @author arturoastorga file: MsAplazoPaymentQuoteControllerTest.java
 * @since Oct 24, 2021
 */
@SpringBootTest
public class MsAplazoPaymentQuoteControllerTest {
  /**
   * Mock inyectado del controlador que se va a probar.
   */
  @InjectMocks
  private MsAplazoPaymentQuoteController msAplazoPaymentQuoteController;

  /**
   * Mock de la lógica que genera el codigo otp.
   */
  @Mock
  private MsAplazoPaymentQuoteService msAplazoPaymentQuoteService;

  

  /**
   * Prueba que verifica que el controlador regrese un Http 200.
   * 
   * @throws Exception excepcion controlada.
   */
  @Test
  public void generateOtp() throws Exception {
    
    MsAplazoPaymentQuoteService msAplazoPaymentQuoteService = new MsAplazoPaymentQuoteService();
    HttpHeaders requestHeaders = new HttpHeaders();
    requestHeaders.add(TestConstants.HOST_TXT, TestConstants.HOST);
    requestHeaders.add(TestConstants.USER_AGENT_TXT, TestConstants.USER_AGENT);
    ProjectionPaymentsRequest projectionPaymentsRequest = new ProjectionPaymentsRequest();

    when(msAplazoPaymentQuoteService.getProjection(projectionPaymentsRequest))
        .thenReturn(new ResponseEntity<>(HttpStatus.OK));

    assertEquals(new ResponseEntity<>(HttpStatus.OK),
        msAplazoPaymentQuoteController.paymentsProjection(TestConstants.HOST,
            TestConstants.USER_AGENT, projectionPaymentsRequest));
  }
}

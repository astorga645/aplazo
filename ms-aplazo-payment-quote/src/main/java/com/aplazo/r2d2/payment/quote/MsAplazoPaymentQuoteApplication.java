package com.aplazo.r2d2.payment.quote;

import com.aplazo.r2d2.payment.quote.constant.Constant;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(Constant.BASE_PACKAGE_ASTERICK)
public class MsAplazoPaymentQuoteApplication {

  public static void main(String[] args) {
    SpringApplication.run(MsAplazoPaymentQuoteApplication.class, args);
  }

}

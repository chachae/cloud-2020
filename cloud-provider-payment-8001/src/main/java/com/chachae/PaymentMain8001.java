package com.chachae;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author chachae
 * @since 2020/3/27 14:51
 */

@MapperScan("com.chachae.dao")
@SpringBootApplication
public class PaymentMain8001 {

  public static void main(String[] args) {
    SpringApplication.run(PaymentMain8001.class, args);
  }
}

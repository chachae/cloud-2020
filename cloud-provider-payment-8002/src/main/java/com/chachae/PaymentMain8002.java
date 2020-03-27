package com.chachae;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author chachae
 * @since 2020/3/27 14:51
 */
@EnableEurekaClient
@SpringBootApplication
@MapperScan("com.chachae.dao")
public class PaymentMain8002 {

  public static void main(String[] args) {
    SpringApplication.run(PaymentMain8002.class, args);
  }
}

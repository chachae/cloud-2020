package com.chachae;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author chachae
 * @since 2020/3/31 23:24
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentMain9002 {

  public static void main(String[] args) {
    SpringApplication.run(PaymentMain9002.class, args);
  }
}

package com.chachae;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author chachae
 * @since 2020/3/27 14:51
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentConsulMain8006 {

  public static void main(String[] args) {
    SpringApplication.run(PaymentConsulMain8006.class, args);
  }
}

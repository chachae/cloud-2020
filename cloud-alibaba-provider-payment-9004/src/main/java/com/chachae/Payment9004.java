package com.chachae;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author chachae
 * @since 2020/4/5 20:42
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Payment9004 {

  public static void main(String[] args) {
    SpringApplication.run(Payment9004.class, args);
  }
}

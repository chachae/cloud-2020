package com.chachae;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author chachae
 * @since 2020/3/31 23:34
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderMain83 {

  public static void main(String[] args) {
    SpringApplication.run(OrderMain83.class, args);
  }
}

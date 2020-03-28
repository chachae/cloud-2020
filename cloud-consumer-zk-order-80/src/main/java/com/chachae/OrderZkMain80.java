package com.chachae;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author chachae
 * @since 2020/3/28 11:57
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderZkMain80 {

  public static void main(String[] args) {
    SpringApplication.run(OrderZkMain80.class, args);
  }
}

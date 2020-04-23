package com.chachae.security.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

/**
 * @author chachae
 * @since 2020/4/22 21:51
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class OrderMain {

  public static void main(String[] args) {
    SpringApplication.run(OrderMain.class, args);
  }
}

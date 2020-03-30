package com.chachae;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author chachae
 * @since 2020/3/30 11:24
 */
@EnableEurekaClient
@SpringBootApplication
public class GatewayMain9527 {

  public static void main(String[] args) {
    SpringApplication.run(GatewayMain9527.class, args);
  }
}

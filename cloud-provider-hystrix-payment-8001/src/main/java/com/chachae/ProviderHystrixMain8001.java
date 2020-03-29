package com.chachae;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author chachae
 * @since 2020/3/29 20:08
 */
// 服务降级
@EnableCircuitBreaker
@SpringBootApplication
@EnableEurekaClient
public class ProviderHystrixMain8001 {

  public static void main(String[] args) {
    SpringApplication.run(ProviderHystrixMain8001.class, args);
  }
}

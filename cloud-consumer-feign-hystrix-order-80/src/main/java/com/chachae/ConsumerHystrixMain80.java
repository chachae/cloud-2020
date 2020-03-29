package com.chachae;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author chachae
 * @since 2020/3/29 21:14
 */
@SpringBootApplication
@EnableFeignClients
@EnableHystrix
public class ConsumerHystrixMain80 {

  public static void main(String[] args) {
    SpringApplication.run(ConsumerHystrixMain80.class, args);
  }
}

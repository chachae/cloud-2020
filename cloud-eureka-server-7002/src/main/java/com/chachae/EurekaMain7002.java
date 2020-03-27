package com.chachae;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author chachae
 * @since 2020/3/27 21:30
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaMain7002 {

  public static void main(String[] args) {
    SpringApplication.run(EurekaMain7002.class, args);
  }
}

package com.chachae;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 启动类必须记得打上@EnableFeignClients
 *
 * @author chachae
 * @since 2020/3/27 14:51
 */
@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication
public class ConsumerFeignMain80 {

  public static void main(String[] args) {
    SpringApplication.run(ConsumerFeignMain80.class, args);
  }
}

package com.chachae;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author chachae
 * @since 2020/3/27 14:51
 */
@SpringBootApplication
/** 该注解向 consul 或者 Zookeeper 作为注册中心时注册服务*/
@EnableDiscoveryClient
public class PaymentZkMain8004 {

  public static void main(String[] args) {
    SpringApplication.run(PaymentZkMain8004.class, args);
  }
}

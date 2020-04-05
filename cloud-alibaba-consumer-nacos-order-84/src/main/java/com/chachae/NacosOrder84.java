package com.chachae;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author chachae
 * @since 2020/4/5 20:42
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class NacosOrder84 {

  public static void main(String[] args) {
    SpringApplication.run(NacosOrder84.class, args);
  }
}

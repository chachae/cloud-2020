package com.chachae;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author chachae
 * @since 2020/4/1 18:23
 */

@SpringBootApplication
@EnableDiscoveryClient
public class SentinelServiceMain8401 {

  public static void main(String[] args) {
    SpringApplication.run(SentinelServiceMain8401.class, args);
  }
}

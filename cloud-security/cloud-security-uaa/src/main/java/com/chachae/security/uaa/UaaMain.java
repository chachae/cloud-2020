package com.chachae.security.uaa;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

/**
 * @author chachae
 * @since 2020/4/22 21:44
 */

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.chachae.security.uaa.dao")
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class UaaMain {

  public static void main(String[] args) {
    SpringApplication.run(UaaMain.class, args);
  }

}

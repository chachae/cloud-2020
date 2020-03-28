package com.chachae.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author chachae
 * @since 2020/3/27 18:01
 */
@Configuration
public class ApplicationContextConfig {

  @Bean
  @LoadBalanced // 开启RestTemplate 负载均衡
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }
}

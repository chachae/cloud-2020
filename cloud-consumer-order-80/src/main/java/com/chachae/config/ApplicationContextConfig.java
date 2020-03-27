package com.chachae.config;

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
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }
}

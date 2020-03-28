package com.chachae.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Feign 配置
 *
 * @author chachae
 * @since 2020/3/28 22:59
 */
@Configuration
public class FeignConfig {

  /**
   * FeignClient 配置日志级别
   *
   * @return 日志级别
   */
  @Bean
  public Logger.Level feignLoggerLevel() {
    // 请求和响应的头信息，请求和响应的正文及元数据
    return Logger.Level.FULL;
  }
}

package com.chachae.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chachae
 * @since 2020/4/1 10:40
 */
@RestController
@RequestMapping("/nacos")
@RefreshScope // Nacos 支持动态配置刷新
public class ConfigClientController {

  @Value("${config.info}")
  public String configInfo;

  @GetMapping("/config/info")
  public String getConfigInfo() {
    return configInfo;
  }
}

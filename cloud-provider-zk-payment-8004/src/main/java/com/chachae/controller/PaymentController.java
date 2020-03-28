package com.chachae.controller;

import cn.hutool.core.util.IdUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chachae
 * @since 2020/3/28 11:47
 */
@RestController
@RequestMapping("/payment")
public class PaymentController {

  @Value("${server.port}")
  private String serverPort;

  /**
   * http://localhost:8004/payment/zk
   *
   * @return String
   */
  @GetMapping(value = "/zk")
  public String paymentZk() {
    return "SpringCloud with Zookeeper:" + serverPort + "\t" + IdUtil.randomUUID();
  }
}

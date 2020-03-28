package com.chachae.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author chachae
 * @since 2020/3/28 11:56
 */
@RestController
@RequestMapping("/consumer")
public class OrderController {

  private final RestTemplate restTemplate;

  public OrderController(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  /** 支付服务的 Zk 地址 */
  public static final String INVOKE_URL = "http://cloud-provider-payment";

  /**
   * http://localhost/consumer/payment/zk
   *
   * @return String
   */
  @GetMapping("/payment/zk")
  public String paymentInfo() {
    return restTemplate.getForObject(INVOKE_URL + "/payment/zk", String.class);
  }
}

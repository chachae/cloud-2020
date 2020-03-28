package com.chachae.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author chachae
 * @since 2020/3/27 17:11
 */
@RestController
@RequestMapping("/consumer")
public class ConsumerController {

  private final RestTemplate restTemplate;

  public ConsumerController(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  /** 支付服务的 consul 地址 */
  public static final String INVOKE_URL = "http://cloud-provider-payment";

  /**
   * http://localhost/consumer/payment/consul
   *
   * @return String
   */
  @GetMapping("/payment/consul")
  public String paymentInfo() {
    return restTemplate.getForObject(INVOKE_URL + "/payment/consul", String.class);
  }
}

package com.chachae.controller;

import com.chachae.entity.Payment;
import com.chachae.entity.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

  private static final String PAYMENT_URL = "http://localhost:8001/payment";

  @GetMapping("/create")
  public Result<Boolean> creat(Payment payment) {
    return this.restTemplate.postForObject(PAYMENT_URL + "/create", payment, Result.class);
  }

  @GetMapping("/get/{id}")
  public Result<Payment> get(@PathVariable Long id) {
    return this.restTemplate.getForObject(PAYMENT_URL + "/get/" + id, Result.class);
  }
}

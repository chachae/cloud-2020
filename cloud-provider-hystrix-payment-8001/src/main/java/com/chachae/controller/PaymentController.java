package com.chachae.controller;

import com.chachae.entity.Result;
import com.chachae.service.PaymentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author chachae
 * @since 2020/3/29 20:41
 */
@RestController
@RequestMapping("/payment/hystrix")
public class PaymentController {

  private final PaymentService paymentService;

  public PaymentController(PaymentService paymentService) {
    this.paymentService = paymentService;
  }

  @GetMapping("/ok/{id}")
  public Result<Map<String, Object>> paymentOk(@PathVariable("id") Integer id) {
    return new Result<>(200, "success", this.paymentService.paymentOk(id));
  }

  @GetMapping("/timeout/{id}")
  public Result<Map<String, Object>> paymentTimeout(@PathVariable Integer id) {
    return new Result<>(200, "success", this.paymentService.paymentTimeout(id));
  }

  @GetMapping("/circuit/{id}")
  public Result<String> circuit(@PathVariable Integer id) {
    return new Result<>(200, "success", this.paymentService.circuitBreaker(id));
  }
}

package com.chachae.controller;

import com.chachae.entity.Payment;
import com.chachae.entity.Result;
import com.chachae.service.PaymentFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chachae
 * @since 2020/3/27 17:11
 */
@RestController
@RequestMapping("/consumer")
public class OrderFeignClientController {

  private final PaymentFeignService paymentFeignService;

  public OrderFeignClientController(PaymentFeignService paymentFeignService) {
    this.paymentFeignService = paymentFeignService;
  }

  @GetMapping(value = "/payment/get/{id}")
  public Result<Payment> getPaymentById(@PathVariable Long id) {
    return this.paymentFeignService.getPaymentById(id);
  }

  @GetMapping("/payment/feign/timeout")
  public Integer timeout() {
    // Open-Feign 默认等待一秒，超过视作超时（application.yml 配置ribbon 超時时间）
    return this.paymentFeignService.timeout();
  }
}

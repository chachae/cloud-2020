package com.chachae.service;

import com.chachae.entity.Payment;
import com.chachae.entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Feign 接口
 *
 * @author chachae
 * @since 2020/3/28 22:06
 */
@Component
@FeignClient("CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {
  /**
   * 根据id查询
   *
   * @param id 订单ID
   * @return Result<Payment>
   */
  @GetMapping(value = "/payment/get/{id}")
  Result<Payment> getPaymentById(@PathVariable("id") Long id);

  /**
   * 模拟耗时业务
   *
   * @return 服务端口
   */
  @GetMapping("/payment/timeout")
  Integer timeout();
}

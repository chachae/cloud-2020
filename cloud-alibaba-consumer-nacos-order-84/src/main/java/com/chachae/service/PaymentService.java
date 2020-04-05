package com.chachae.service;

import com.chachae.entity.Payment;
import com.chachae.entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author chachae
 * @since 2020/4/5 20:50
 */
@FeignClient(value = "nacos-payment-provider", fallback = PaymentFallbackService.class)
public interface PaymentService {

  @GetMapping("/paymentSQL/{id}")
  Result<Payment> paymentSql(@PathVariable("id") Long id);
}

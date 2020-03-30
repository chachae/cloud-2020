package com.chachae.service;

import com.chachae.entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Map;

/**
 * @author chachae
 * @since 2020/3/29 21:16
 */
@FeignClient(
    value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT",
    fallbackFactory = ConsumerServiceFallbackImpl.class)
public interface ConsumerService {

  @GetMapping("/payment/hystrix/ok/{id}")
  Result<Map<String, Object>> paymentOk(@PathVariable("id") Integer id);

  @GetMapping("/payment/hystrix/timeout/{id}")
  Result<Map<String, Object>> paymentTimeout(@PathVariable("id") Integer id);
}

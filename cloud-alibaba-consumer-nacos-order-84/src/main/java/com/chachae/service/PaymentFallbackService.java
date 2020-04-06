package com.chachae.service;

import com.chachae.entity.Result;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @author chachae
 * @since 2020/4/5 20:50
 */
@Component
public class PaymentFallbackService implements FallbackFactory<PaymentService> {

  @Override
  public PaymentService create(Throwable throwable) {
    return id -> new Result<>(400, "fallback");
  }
}

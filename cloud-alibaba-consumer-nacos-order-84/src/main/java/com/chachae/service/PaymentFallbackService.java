package com.chachae.service;

import com.chachae.entity.Payment;
import com.chachae.entity.Result;
import org.springframework.stereotype.Component;

/**
 * @author chachae
 * @since 2020/4/5 20:50
 */
@Component
public class PaymentFallbackService implements PaymentService {

  @Override
  public Result<Payment> paymentSql(Long id) {
    return new Result<>(400, "fallback");
  }
}

package com.chachae.controller;

import cn.hutool.core.util.IdUtil;
import com.chachae.entity.Payment;
import com.chachae.entity.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chachae
 * @since 2020/4/5 20:47
 */
@RestController
public class PaymentController {

  @Value("${server.port}")
  private String serverPort;

  public static Map<Long, Payment> hashMap = new HashMap<>();

  static {
    hashMap.put(1L, new Payment(1L, IdUtil.simpleUUID()));
    hashMap.put(2L, new Payment(2L, IdUtil.simpleUUID()));
    hashMap.put(3L, new Payment(3L, IdUtil.simpleUUID()));
  }

  @GetMapping("/paymentSQL/{id}")
  public Result<Payment> paymentSql(@PathVariable("id") Long id) {
    Payment payment = hashMap.get(id);
    return new Result<>(200, "from mysql,serverPort:" + serverPort, payment);
  }
}

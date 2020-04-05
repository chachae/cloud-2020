package com.chachae.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.chachae.entity.Payment;
import com.chachae.entity.Result;
import com.chachae.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author chachae
 * @since 2020/4/5 20:51
 */
@RestController
@Slf4j
public class CircleBreakerController {
  private static final String SERVICE_URL = "http://nacos-payment-provider";

  @Resource private RestTemplate restTemplate;

  @RequestMapping("/consumer/fallback/{id}")
  //    @SentinelResource(value = "fallback") //没有配置
  //    @SentinelResource(value = "fallback",fallback = "handlerFallback")
  // //配置了fallback的，fallback只负责业务异常
  //    @SentinelResource(value = "fallback",blockHandler = "blockHandler") //
  // 配置了blockHandler，只负责sentinel控制台配置违规
  @SentinelResource(
      value = "fallback",
      fallback = "handlerFallback",
      blockHandler = "blockHandler",
      exceptionsToIgnore = {IllegalArgumentException.class}) // 配置了blockHandler和fallback
  public Result<Payment> fallback(@PathVariable("id") Long id) {
    Result<Payment> commonResult =
        restTemplate.getForObject(SERVICE_URL + "/paymentSQL/" + id, Result.class);
    if (id == 4) {
      throw new IllegalArgumentException("IllegalArgumentException,非法参数异常");
    } else {
      assert commonResult != null;
      if (commonResult.getData() == null) {
        throw new NullPointerException("NullPointerException,该ID没有记录，空指针异常");
      }
    }
    return commonResult;
  }
  // 本例是fallback
  public Result<Payment> handlerFallback(Long id, Throwable e) {
    Payment payment = new Payment(id, null);
    return new Result<>(400, "兜底异常handler，exception内容" + e.getMessage(), payment);
  }

  public Result<Payment> blockHandler(Long id, BlockException exception) {
    Payment payment = new Payment(id, null);
    return new Result<>(
        445, "blockHandler-sentinel 限流，无此流水号：blockException" + exception.getMessage(), payment);
  }

  // --------------- open feign---------

  @Resource private PaymentService paymentService;

  @GetMapping("/consumer/paymentSQL/{id}")
  public Result<Payment> paymentSql(@PathVariable("id") Long id) {
    return paymentService.paymentSql(id);
  }
}

package com.chachae.controller;

import com.chachae.entity.Result;
import com.chachae.service.ConsumerService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author chachae
 * @since 2020/3/29 21:16
 */
@RestController
@RequestMapping("/consumer/hystrix")
// @DefaultProperties(defaultFallback = "globalFallback")
public class ConsumerController {

  private final ConsumerService consumerService;

  public ConsumerController(ConsumerService consumerService) {
    this.consumerService = consumerService;
  }

  // @HystrixCommand
  @GetMapping("/ok/{id}")
  public Result<Map<String, Object>> ok(@PathVariable("id") Integer id) {
    return this.consumerService.paymentOk(id);
  }

  @GetMapping("/timeout/{id}")
  // @HystrixCommand
  //    @HystrixCommand(
  //        fallbackMethod = "paymentTimeOutFallbackMethod",
  //        commandProperties = {
  //          @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value =
  //   "1500")
  //        })
  public Result<Map<String, Object>> timeout(@PathVariable Integer id) {
    return this.consumerService.paymentTimeout(id);
  }

  /**
   * 降级方法
   *
   * @param id ID
   * @return Map<String,Object>
   */
  private Result<Map<String, Object>> paymentTimeOutFallbackMethod(@PathVariable Integer id) {
    return new Result<>(400, "服务超时，请稍候再试", null);
  }

  public Result<Map<String, Object>> globalFallback() {
    return new Result<>(400, "服务超时，请稍候再试", null);
  }
}

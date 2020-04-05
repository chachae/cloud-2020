package com.chachae.controller;

import cn.hutool.core.util.IdUtil;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.chachae.entity.Payment;
import com.chachae.entity.Result;
import com.chachae.handler.CustomerBlockHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chachae
 * @since 2020/4/5 18:32
 */
@Slf4j
@RestController
@RequestMapping("/rateLimit")
public class RateLimitController {

  @GetMapping("/byResource")
  @SentinelResource(value = "byResource", blockHandler = "handleException")
  public Result<Payment> byResource() {
    return new Result<>(200, "按资源名称限流测试OK", new Payment(2020L, IdUtil.simpleUUID()));
  }

  public Result<String> handleException(BlockException blockException) {
    return new Result<>(400, blockException.getClass().getCanonicalName() + " 服务不可用");
  }

  @GetMapping("/byUrl")
  @SentinelResource(value = "byUrl")
  public Result<Payment> byUrl() {
    return new Result<>(200, "by url限流测试OK", new Payment(2020L, IdUtil.simpleUUID()));
  }

  // CustomerBlockHandler
  @GetMapping("/customerBlockHandler")
  @SentinelResource(
      value = "customerBlockHandler",
      blockHandlerClass = CustomerBlockHandler.class,
      blockHandler = "handlerException2")
  public Result<Payment> customerBlockHandler() {
    return new Result<>(200, "客户自定义 限流测试OK", new Payment(2020L, IdUtil.simpleUUID()));
  }
}

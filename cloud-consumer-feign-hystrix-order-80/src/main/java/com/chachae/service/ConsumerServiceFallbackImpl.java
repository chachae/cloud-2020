package com.chachae.service;

import com.chachae.entity.Result;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 服务降级方案（实现 FallbackFactory<T> 接口）
 *
 * @author chachae
 * @since 2020/3/30 8:48
 */
@Component
public class ConsumerServiceFallbackImpl implements FallbackFactory<ConsumerService> {

  @Override
  public ConsumerService create(Throwable cause) {
    return new ConsumerService() {

      @Override
      public Result<Map<String, Object>> paymentOk(Integer id) {
        return new Result<>(400, "服务降级，请稍后重试", null);
      }

      @Override
      public Result<Map<String, Object>> paymentTimeout(Integer id) {
        return new Result<>(400, "服务降级，请稍后重试", null);
      }
    };
  }
}

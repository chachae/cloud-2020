package com.chachae.service;

import cn.hutool.core.lang.Dict;
import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author chachae
 * @since 2020/3/29 20:09
 */
@Slf4j
@Service
public class PaymentService {

  /**
   * 正常访问
   *
   * @param id ID
   * @return String
   */
  public Map<String, Object> paymentOk(Integer id) {
    return this.toMap(id, null, "paymentOk");
  }

  /**
   * 超时
   *
   * <p>HystrixCommand:一旦调用服务方法失败并抛出了错误信息后,会自动调用
   *
   * <p>@HystrixCommand标注好的fallbackMethod调用类中的指定方法
   *
   * <p>execution.isolation.thread.timeoutInMilliseconds:线程超时时间3秒钟
   *
   * @param id ID
   * @return String
   */
  @HystrixCommand(
      fallbackMethod = "timeOutHandler",
      commandProperties = {
        @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
      })
  public Map<String, Object> paymentTimeout(Integer id) {
    long start = System.currentTimeMillis();
    try {
      // 模拟 3 秒
      TimeUnit.SECONDS.sleep(5);
    } catch (InterruptedException e) {
      log.info("运行异常");
    }
    long end = System.currentTimeMillis();
    return this.toMap(id, end - start, "paymentTimeout");
  }

  /**
   * 服务熔断
   *
   * @param id ID
   * @return Map<String,Object>
   */
  @HystrixCommand(
      fallbackMethod = "circuitBreakerFallback",
      commandProperties = {
        @HystrixProperty(name = "circuitBreaker.enabled", value = "true"), // 是否开启断路器
        @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"), // 请求次数
        @HystrixProperty(
            name = "circuitBreaker.sleepWindowInMilliseconds",
            value = "10000"), // 时间窗口期/时间范文
        @HystrixProperty(
            name = "circuitBreaker.errorThresholdPercentage",
            value = "60") // 失败率达到多少后跳闸
      })
  public String circuitBreaker(Integer id) {
    if (id >= 0) {
      return IdUtil.fastSimpleUUID();
    } else {
      throw new RuntimeException("ID 不能为0");
    }
  }

  private String circuitBreakerFallback(Integer id) {
    return id + ":error";
  }

  /**
   * 兜底方案
   *
   * @param id ID
   * @return Map
   */
  private Map<String, Object> timeOutHandler(Integer id) {
    return this.toMap(id, null, "timeOutHandler");
  }

  private Map<String, Object> toMap(Integer id, Long time, String methodName) {
    return Dict.create()
        .set("线程", Thread.currentThread().getName())
        .set("方法", methodName)
        .set("ID", id)
        .set("耗时", time);
  }
}

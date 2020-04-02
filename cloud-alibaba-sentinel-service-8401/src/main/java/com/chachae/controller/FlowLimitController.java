package com.chachae.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author chachae
 * @since 2020/4/1 18:29
 */
@Slf4j
@RestController
public class FlowLimitController {

  /**
   * 限流 QPS、线程、关联、预热测试
   *
   * @return String
   */
  @GetMapping("/testA")
  public String getA() {
    return "A";
  }

  /**
   * 限流 QPS、线程、关联、预热测试
   *
   * @return String
   */
  @GetMapping("/testB")
  public String getB() {
    log.info(Thread.currentThread().getName() + "\t" + "[ getB() ]");
    return "B";
  }

  /**
   * 限流 - 排队等待测试
   *
   * @return String
   */
  @GetMapping("/testC")
  public String getC() {
    try {
      // 模拟业务处理 800 毫秒
      TimeUnit.MILLISECONDS.sleep(800);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    return "C";
  }

  /**
   * 熔断降级 - RT测试
   *
   * <p>RT:RT时间内如果无法完成请求并且并发数大于5，系统触发降级
   *
   * @return String
   */
  @GetMapping("/testD")
  public String getD() {
    try {
      // 模拟业务处理 1000 毫秒
      TimeUnit.SECONDS.sleep(1);
      log.info("[ RT 熔断降级测试 ]");
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    return "[ RT 熔断降级测试 ]";
  }

  /**
   * 熔断降级 - 异常比例测试
   *
   * <pre>
   * <p>时间窗口：当异常比例触发之后并且并发数大于5，如：时间窗口设置3秒，
   * <p>系统触发降级，未来3秒内服务就无法使用，3秒后恢复使用
   * </pre>
   *
   * @return String
   */
  @GetMapping("/testE")
  public String getE() {
    log.info("[ 异常比例 熔断降级测试 ]");
    // 模拟异常发生
    int age = 10 / 0;
    return "[ 异常比例 熔断降级测试 ]";
  }

  /**
   * 熔断降级 - 异常数测试
   *
   * <pre>
   * <p>系统一分钟内发生的异常数大于目标异常阈值，会发生熔断，若时间小于一分钟，
   * <p>则熔断结束后仍可能再次静茹熔断状态
   * </pre>
   *
   * @return String
   */
  @GetMapping("/testF")
  public String getF() {
    log.info("[ 异常数 熔断降级测试 ]");
    // 模拟异常发生
    int age = 10 / 0;
    return "[ 异常数 熔断降级测试 ]";
  }

  /**
   * Sentinel - 热点key
   *
   * <pre>
   *     <p>1. 没有blockHandler 触发热点限流，直接返回error page，不友好
   *     <p>2. 热点参数索引限流、热点参数可额外配置，根据不同的参数使用不同的限流阈值
   * </pre>
   *
   * @return String
   */
  @GetMapping("/testHotKey")
  @SentinelResource(value = "testHotKey", blockHandler = "dealTestHotKey")
  public String testHotKey(
      @RequestParam(value = "p1", required = false) String p1,
      @RequestParam(value = "p2", required = false) String p2) {

    /*
    系统出现的异常，不会进入热点异常处理方法，而是出现error page，因为@SentinelResource
    只处理 Sentinel 控制台的配置异常
    */

    // int age = 10/0;

    return "[ HotKey...Test... ]";
  }

  /**
   * 热点异常处理方法
   *
   * @param p1 value 1
   * @param p2 value 2
   * @param blockException blockException;
   * @return String
   */
  public String dealTestHotKey(String p1, String p2, BlockException blockException) {
    // 默认异常提示：Block by Sentinel (flow limiting)
    return "dealTestHotKey";
  }
}

package com.chachae.controller;

import com.chachae.entity.Payment;
import com.chachae.entity.Result;
import com.chachae.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author chachae
 * @since 2020/3/27 17:11
 */
@Slf4j
@RestController
@RequestMapping("/payment")
public class PaymentController {

  private final PaymentService paymentService;

  private final DiscoveryClient discoveryClient;

  public PaymentController(PaymentService paymentService, DiscoveryClient discoveryClient) {
    this.paymentService = paymentService;
    this.discoveryClient = discoveryClient;
  }

  @Value("${server.port}")
  private Integer port;

  @PostMapping("/create")
  public Result<Boolean> creat(@RequestBody Payment payment) {
    boolean res = this.paymentService.save(payment);
    return new Result<>(200, "插入成功，服务提供方接口：" + port, res);
  }

  @GetMapping("/get/{id}")
  public Result<Payment> get(@PathVariable Long id) {
    Payment res = this.paymentService.getById(id);
    return new Result<>(200, "查询成功，服务提供方接口：" + port, res);
  }

  /**
   * 模拟 Open-Feign 超时
   *
   * @return Integer
   */
  @GetMapping("/timeout")
  public Integer timeout() {
    try {
      // 模拟耗时业务，3秒钟
      TimeUnit.SECONDS.sleep(3);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    return port;
  }

  @GetMapping("/discovery")
  public List<String> discovery() {
    List<String> services = this.discoveryClient.getServices();

    List<ServiceInstance> instances = this.discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
    instances.forEach(
        instance -> log.info("服务ID：{}，服务地址：{}", instance.getServiceId(), instance.getUri()));

    return services;
  }
}

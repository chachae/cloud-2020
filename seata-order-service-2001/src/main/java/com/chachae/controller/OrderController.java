package com.chachae.controller;

import com.chachae.domain.Order;
import com.chachae.domain.Result;
import com.chachae.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 订单表(Order)表控制层
 *
 * @author chachae
 * @since 2020-04-06 16:39:16
 */
@RestController
public class OrderController {
  @Resource private OrderService orderService;

  /**
   * 创建订单
   *
   * @param order 订单信息
   * @return Result<String>
   */
  @GetMapping("/order/create")
  public Result<String> create(Order order) {
    orderService.create(order);
    return new Result<>(200, "订单创建成功");
  }
}

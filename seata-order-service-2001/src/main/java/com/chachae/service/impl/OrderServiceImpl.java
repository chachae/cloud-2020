package com.chachae.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chachae.dao.OrderDAO;
import com.chachae.domain.Order;
import com.chachae.service.AccountService;
import com.chachae.service.OrderService;
import com.chachae.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 订单表(Order)表服务实现类
 *
 * @author chachae
 * @since 2020-04-06 16:39:16
 */
@Slf4j
@Service
public class OrderServiceImpl extends ServiceImpl<OrderDAO, Order> implements OrderService {

  @Resource private OrderDAO orderDAO;
  @Resource private AccountService accountService;
  @Resource private StorageService storageService;

  @Override
  // name：随意，具有唯一性即可
  @GlobalTransactional(name = "fsp-order-service",rollbackFor = Exception.class)
  public void create(Order order) {

    // 1 新建订单
    log.info("开始新建订单");
    order.setStatus(0);
    System.out.println(order);
    this.orderDAO.insert(order);

    // 2 扣减库存
    log.info("订单微服务开始调用 [库存服务] 进行库存扣减");
    storageService.decrease(order.getProductId(), order.getCount());
    log.info("订单微服务开始调用 [库存服务] 完成库存扣减");

    // 3 扣减账户
    log.info("订单微服务开始调用 [账户服务] 进行扣钱");
    accountService.decrease(order.getUserId(), order.getMoney());
    log.info("订单微服务开始调用 [账户服务] 完成扣钱");

    // 4 修改订单状态,从0到1,1代表已完成
    log.info("开始修改订单状态");
    orderDAO.updateById(Order.builder().id(order.getId()).status(1).build());
    log.info("下单结束，:)");
  }
}

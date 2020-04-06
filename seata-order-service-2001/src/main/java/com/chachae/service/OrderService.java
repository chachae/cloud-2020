package com.chachae.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chachae.domain.Order;
/**
 * 订单表(Order)表服务接口
 *
 * @author chachae
 * @since 2020-04-06 16:39:15
 */
public interface OrderService extends IService<Order> {

  /**
   * 创建订单->调用库存服务扣减库存->调用账户服务扣减账户余额->修改订单状态
   *
   * <pre>简单说:
   * 下订单->减库存->减余额->改状态
   * GlobalTransactional Seata 开启分布式事务,异常时回滚,name保证唯一即可
   * </pre>
   *
   * @param order 订单对象
   */
  void create(Order order);
}

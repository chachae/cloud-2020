package com.chachae.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 订单表(Order)表实体类
 *
 * @author chachae
 * @since 2020-04-06 16:39:13
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order {

  @TableId(type = IdType.AUTO)
  private Long id;
  // 用户id
  private Long userId;
  // 产品id
  private Long productId;
  // 数量
  private Integer count;
  // 金额
  private Double money;
  // 订单状态:  0:创建中 1:已完结
  private Integer status;
}

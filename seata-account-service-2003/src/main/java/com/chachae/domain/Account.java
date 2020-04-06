package com.chachae.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 账户表(TAccount)表实体类
 *
 * @author chachae
 * @since 2020-04-06 17:43:41
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class Account {

  private Long id;
  // 用户id
  @TableId(type = IdType.AUTO)
  private Long userId;
  // 总额度
  private Double total;
  // 已用余额
  private Double used;
  // 剩余可用额度
  private Double residue;
}

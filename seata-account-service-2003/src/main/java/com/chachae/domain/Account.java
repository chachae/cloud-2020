package com.chachae.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("t_account")
public class Account {

  @TableId(type = IdType.AUTO)
  private Long id;
  // 用户id
  private Long userId;
  // 总额度
  private Double total;
  // 已用余额
  private Double used;
  // 剩余可用额度
  private Double residue;
}

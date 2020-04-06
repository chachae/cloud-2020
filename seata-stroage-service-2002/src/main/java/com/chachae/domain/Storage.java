package com.chachae.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 库存(TStorage)表实体类
 *
 * @author chachae
 * @since 2020-04-06 17:29:39
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class Storage {

  private Long id;
  // 产品id
  @TableId(type = IdType.AUTO)
  private Long productId;
  // 总库存
  private Integer total;
  // 已用库存
  private Integer used;
  // 剩余库存
  private Integer residue;
}

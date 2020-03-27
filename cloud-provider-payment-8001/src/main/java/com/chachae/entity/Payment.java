package com.chachae.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author chachae
 * @since 2020/3/27 15:05
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment implements Serializable {

  @TableId(type = IdType.AUTO)
  private Long id;

  private String serial;
}

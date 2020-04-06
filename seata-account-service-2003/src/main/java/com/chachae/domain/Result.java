package com.chachae.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author chachae
 * @since 2020/3/27 15:07
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> {

  private Integer code;

  private String message;

  private T data;

  public Result(int code, String message) {
    this(code, message, null);
  }
}

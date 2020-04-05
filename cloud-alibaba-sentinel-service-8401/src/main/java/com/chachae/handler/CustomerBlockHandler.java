package com.chachae.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.chachae.entity.Result;

/**
 * 方法必须静态
 *
 * @author chachae
 * @since 2020/4/5 19:03
 */
public class CustomerBlockHandler {

  public static Result<String> handlerException(BlockException exception) {
    return new Result<>(400, "Global Exception handler [1]");
  }

  public static Result<String> handlerException2(BlockException exception) {
    return new Result<>(400, "Global Exception handler [2]");
  }
}

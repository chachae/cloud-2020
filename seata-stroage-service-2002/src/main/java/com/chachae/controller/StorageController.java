package com.chachae.controller;

import com.chachae.domain.Result;
import com.chachae.service.StorageService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 库存(TStorage)表控制层
 *
 * @author chachae
 * @since 2020-04-06 17:29:40
 */
@RestController
public class StorageController {

  @Resource private StorageService storageService;

  /**
   * 减库存
   *
   * @param productId 产品ID
   * @param count 数量
   * @return Result<String>
   */
  @PostMapping(value = "/storage/decrease")
  public Result<String> decrease(
      @RequestParam("productId") Long productId, @RequestParam("count") Integer count) {
    storageService.decrease(productId, count);
    return new Result<>(200, "扣减库存成功");
  }
}

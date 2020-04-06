package com.chachae.service;

import com.chachae.domain.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author chachae
 * @since 2020/4/6 16:53
 */
@FeignClient(value = "seata-storage-service")
public interface StorageService {
  /**
   * 减库存
   *
   * @param productId 产品ID
   * @param count 数量
   * @return Result<T>
   */
  @PostMapping(value = "storage/decrease")
  Result<String> decrease(
      @RequestParam("productId") Long productId, @RequestParam("count") Integer count);
}

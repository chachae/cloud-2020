package com.chachae.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chachae.domain.Storage;

/**
 * 库存(TStorage)表服务接口
 *
 * @author chachae
 * @since 2020-04-06 17:29:40
 */
public interface StorageService extends IService<Storage> {

  /**
   * 减库存
   *
   * @param productId 产品ID
   * @param count 数量
   */
  void decrease(Long productId, Integer count);

  Storage selectByProductId(Long id);
}

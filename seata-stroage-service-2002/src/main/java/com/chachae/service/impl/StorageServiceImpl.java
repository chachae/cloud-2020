package com.chachae.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chachae.dao.StorageDAO;
import com.chachae.domain.Storage;
import com.chachae.service.StorageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 库存(TStorage)表服务实现类
 *
 * @author chachae
 * @since 2020-04-06 17:29:40
 */
@Service
public class StorageServiceImpl extends ServiceImpl<StorageDAO, Storage> implements StorageService {

  @Resource private StorageDAO storageDAO;

  @Override
  public void decrease(Long productId, Integer count) {

    Storage result = this.selectByProductId(productId);

    Storage storage = new Storage();
    storage
        .setId(productId)
        .setResidue(result.getResidue() - count)
        .setUsed(result.getUsed() + count);
    this.storageDAO.updateById(storage);
  }

  @Override
  public Storage selectByProductId(Long id) {
    QueryWrapper<Storage> qw = new QueryWrapper<>();
    qw.lambda().eq(Storage::getProductId, id);
    return this.storageDAO.selectOne(qw);
  }
}

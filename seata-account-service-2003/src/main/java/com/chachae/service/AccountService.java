package com.chachae.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chachae.domain.Account;

/**
 * 账户表(TAccount)表服务接口
 *
 * @author chachae
 * @since 2020-04-06 17:43:42
 */
public interface AccountService extends IService<Account> {

  /**
   * 减库存
   *
   * @param userId 用户id
   * @param money 金额
   */
  void decrease(Long userId, double money);

  Account selectByUserId(Long userId);
}

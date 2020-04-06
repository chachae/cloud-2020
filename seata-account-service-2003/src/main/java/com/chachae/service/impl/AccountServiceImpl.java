package com.chachae.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chachae.domain.Account;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import com.chachae.dao.AccountDAO;
import com.chachae.service.AccountService;

/**
 * 账户表(TAccount)表服务实现类
 *
 * @author chachae
 * @since 2020-04-06 17:43:42
 */
@Service
public class AccountServiceImpl extends ServiceImpl<AccountDAO, Account> implements AccountService {

  @Resource private AccountDAO accountDAO;

  @Override
  public void decrease(Long userId, double money) {
    Account result = this.accountDAO.selectById(userId);

    Account account = new Account();
    account
        .setUserId(userId)
        .setResidue(result.getResidue() - money)
        .setUsed(result.getUsed() - money);

    this.accountDAO.updateById(account);
  }
}

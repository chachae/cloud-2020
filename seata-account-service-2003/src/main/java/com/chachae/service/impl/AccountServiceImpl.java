package com.chachae.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chachae.dao.AccountDAO;
import com.chachae.domain.Account;
import com.chachae.service.AccountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

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
    Account result = this.selectByUserId(userId);

    Account account = new Account();
    account
        .setId(result.getId())
        .setResidue(result.getResidue() - money)
        .setUsed(result.getUsed() + money);

    // 模拟超时异常，20s，Open-Feign 默认请求时间为1s
    try {
      TimeUnit.SECONDS.sleep(20);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    this.accountDAO.updateById(account);
  }

  @Override
  public Account selectByUserId(Long userId) {
    QueryWrapper<Account> qw = new QueryWrapper<>();
    qw.lambda().eq(Account::getUserId, userId);
    return this.accountDAO.selectOne(qw);
  }
}

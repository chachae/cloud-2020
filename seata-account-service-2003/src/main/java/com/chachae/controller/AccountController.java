package com.chachae.controller;

import com.chachae.domain.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import com.chachae.service.AccountService;

/**
 * 账户表(TAccount)表控制层
 *
 * @author chachae
 * @since 2020-04-06 17:43:42
 */
@RestController
public class AccountController {
  @Resource private AccountService accountService;

  @PostMapping(value = "/account/decrease")
  public Result<String> decrease(
      @RequestParam("userId") Long userId, @RequestParam("money") double money) {
    accountService.decrease(userId, money);
    return new Result<>(200, "扣减账户余额成功");
  }
}

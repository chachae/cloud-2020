package com.chachae.service;

import com.chachae.domain.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author chachae
 * @since 2020/4/6 16:52
 */
@FeignClient(value = "seata-account-service")
public interface AccountService {
  /**
   * 减余额
   *
   * @param userId 用户ID
   * @param money 金额
   * @return Result<T>
   */
  @PostMapping(value = "account/decrease")
  Result decrease(@RequestParam("userId") Long userId, @RequestParam("money") Double money);
}

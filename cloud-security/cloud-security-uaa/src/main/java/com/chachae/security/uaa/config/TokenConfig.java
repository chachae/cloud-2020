package com.chachae.security.uaa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.code.AuthorizationCodeServices;
import org.springframework.security.oauth2.provider.code.InMemoryAuthorizationCodeServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

/**
 * @author chachae
 * @since 2020/4/23 16:46
 */

@Configuration
public class TokenConfig {

  /**
   * 设置授权码模式的授权码如何存取，暂时采用内存方式
   *
   * @return /
   */
  @Bean
  public AuthorizationCodeServices authorizationCodeServices() {
    return new InMemoryAuthorizationCodeServices();
  }

}

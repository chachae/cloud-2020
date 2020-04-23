package com.chachae.security.uaa.config;

import java.util.HashMap;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.code.AuthorizationCodeServices;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

/**
 * @author chachae
 * @since 2020/4/22 22:23
 */
@Configuration
@EnableAuthorizationServer
@RequiredArgsConstructor
public class AuthorizationServer extends AuthorizationServerConfigurerAdapter {

  private final ClientDetailsService clientDetailsService;
  private final AuthorizationCodeServices authorizationCodeServices;
  private final AuthenticationManager authenticationManager;


  /**
   * 客戶端詳細信息
   *
   * @param clients /
   * @throws Exception /
   */
  @Override
  public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
    // 使用in‐memory存储
    clients.inMemory()
        // client_id
        .withClient("c1")
        //客户端秘钥
        .secret(new BCryptPasswordEncoder().encode("secret"))
        // 资源id
        .resourceIds("res1")
        // 该client允许的授权类型
        .authorizedGrantTypes("authorization_code",
            "password", "client_credentials", "implicit", "refresh_token")
        // 允许的授权范围（相当于客户端的权限）
        .scopes("all")
        // false 跳转到授权页面
        .autoApprove(false)
        //加上验证回调地址
        .redirectUris("http://www.baidu.com");
  }

  /**
   * token 存储在内存中（普通令牌）
   *
   * @return /
   */
  @Bean
  public TokenStore tokenStore() {
    return new InMemoryTokenStore();
  }

  /**
   * 令牌管理
   *
   * @return /
   */
  @Bean
  @Primary
  public AuthorizationServerTokenServices tokenService() {
    DefaultTokenServices service = new DefaultTokenServices();
    // 客户端详细信息
    service.setClientDetailsService(clientDetailsService);
    // 支持刷新令牌
    service.setSupportRefreshToken(true);
    // token 存储策略
    service.setTokenStore(tokenStore());
    // 令牌默认有效期2小时
    service.setAccessTokenValiditySeconds(7200);
    // 刷新令牌默认有效期3天
    service.setRefreshTokenValiditySeconds(259200);
    return service;
  }

  /**
   * 令牌访问端点
   *
   * @param endpoints /
   */
  @Override
  public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
    endpoints
        .authenticationManager(authenticationManager)
        .authorizationCodeServices(authorizationCodeServices)
        .tokenServices(tokenService())
        .allowedTokenEndpointRequestMethods(HttpMethod.POST);
  }

  /**
   * 令牌端点安全约束
   *
   * @param security /
   */
  @Override
  public void configure(AuthorizationServerSecurityConfigurer security) {
    security
        .tokenKeyAccess("permitAll()")
        .checkTokenAccess("permitAll()")
        .allowFormAuthenticationForClients();
  }
}

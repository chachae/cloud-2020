package com.chachae.security.order.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
import org.springframework.web.client.RestTemplate;

/**
 * @author chachae
 * @since 2020/4/23 18:14
 */
@Configuration
@RequiredArgsConstructor
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

  private final RestTemplate restTemplate;

  public static final String RESOURCE_ID = "res1";

  @Override
  public void configure(ResourceServerSecurityConfigurer resources) {
    resources.resourceId(RESOURCE_ID)
        .tokenServices(tokenService())
        .stateless(true);
  }

  @Override
  public void configure(HttpSecurity http) throws Exception {
    http
        .authorizeRequests()
        .antMatchers("/**").access("#oauth2.hasScope('all')")
        .and().csrf().disable()
        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
  }

  //资源服务令牌解析服务
  @Bean
  public ResourceServerTokenServices tokenService() {
    //使用远程服务请求授权服务器校验token,必须指定校验token 的url、client_id，client_secret
    RemoteTokenServices service = new RemoteTokenServices();
    service.setCheckTokenEndpointUrl("http://cloud-security-uaa/uaa/oauth/check_token");
    service.setRestTemplate(restTemplate);
    service.setClientId("c1");
    service.setClientSecret("secret");
    return service;
  }

}
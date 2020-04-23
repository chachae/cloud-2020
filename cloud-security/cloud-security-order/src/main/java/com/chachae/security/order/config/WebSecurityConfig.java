package com.chachae.security.order.config;

import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author chachae
 * @since 2020/4/23 17:44
 */

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  //安全拦截机制（最重要）
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.csrf().disable()
        .authorizeRequests()
        //所有/r/**的请求必须认证通过
        .antMatchers("/r/**").authenticated()
        //除了/r/**，其它的请求可以访问
        .anyRequest().permitAll()
    ;
  }
}

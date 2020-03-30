package com.chachae.filter;

import cn.hutool.core.util.StrUtil;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * Gateway 全局过滤器
 *
 * @author chachae
 * @since 2020/3/30 17:17
 */
@Component
@Order(0)
public class GlobalGatewayFilter implements GlobalFilter {

  @Override
  public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
    String username = exchange.getRequest().getQueryParams().getFirst("username");
    if (StrUtil.isBlank(username)) {
      exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
      return exchange.getResponse().setComplete();
    } else {
      return chain.filter(exchange);
    }
  }
}

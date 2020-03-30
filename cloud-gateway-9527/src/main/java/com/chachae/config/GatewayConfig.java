package com.chachae.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author chachae
 * @since 2020/3/30 11:50
 */
@Configuration
public class GatewayConfig {

  @Bean
  public RouteLocator customRouteLocate(RouteLocatorBuilder builder) {

    RouteLocatorBuilder.Builder routes = builder.routes();
    routes
        .route("route_locate_news", r -> r.path("/guonei").uri("http://news.baidu.com/guonei"))
            .build();

    return routes.build();
  }
}

package com.ribbon.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 自定义 Ribbon 负载均衡算法（默认轮询，注意不能放在能被@CompentScan 扫描到的包下）
 *
 * @author chachae
 * @since 2020/3/28 17:05
 */
@Configuration
public class RibbonRuleConfig {

  @Bean
  public IRule randomRule() {

    // return new RoundRobinRule();
    // 替换默认的负载均衡算法：轮询算法 -> 随机负载算法
    return new RandomRule();
  }
}

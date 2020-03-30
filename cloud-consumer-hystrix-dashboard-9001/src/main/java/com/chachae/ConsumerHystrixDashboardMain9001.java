package com.chachae;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * 监控地址：http://localhost:8001/actuator/hystrix.stream
 *
 * <p>需要在8001的yml 中配置 actuator 的 hystrix 监控配置
 *
 * @author chachae
 * @since 2020/3/30 10:07
 */
@SpringBootApplication
@EnableHystrixDashboard
public class ConsumerHystrixDashboardMain9001 {

  public static void main(String[] args) {
    SpringApplication.run(ConsumerHystrixDashboardMain9001.class, args);
  }
}

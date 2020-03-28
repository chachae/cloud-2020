package com.chachae;

import com.ribbon.config.RibbonRuleConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author chachae
 * @since 2020/3/27 14:51
 */
@EnableEurekaClient
@SpringBootApplication
// 自定义 Ribbon 算法（注意 name 要大写）
@RibbonClient(name = "CLOUD-PAYMENT-SERVICE", configuration = RibbonRuleConfig.class)
public class ConsumerMain80 {

  public static void main(String[] args) {
    SpringApplication.run(ConsumerMain80.class, args);
  }
}

package com.chachae.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.baomidou.mybatisplus.autoconfigure.MybatisPlusProperties;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import io.seata.rm.datasource.DataSourceProxy;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.util.StringUtils;

import javax.sql.DataSource;

/**
 * @author chachae
 * @since 2020/4/6 17:14
 */
@Configuration
@EnableConfigurationProperties({MybatisPlusProperties.class})
public class DataSourceProxyConfig {

  @Bean
  @ConfigurationProperties(prefix = "spring.datasource")
  public DataSource dataSource() {
    return new DruidDataSource();
  }

  @Bean
  @Primary
  public DataSourceProxy dataSourceProxy(DataSource dataSource) {
    return new DataSourceProxy(dataSource);
  }

  @Bean
  public SqlSessionFactory sqlSessionFactoryBean(
      DataSourceProxy dataSourceProxy, MybatisPlusProperties mybatisProperties) {
    MybatisSqlSessionFactoryBean bean = new MybatisSqlSessionFactoryBean();
    bean.setDataSource(dataSourceProxy);

    ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
    try {

      Resource[] mapperLocations = resolver.getResources(mybatisProperties.getMapperLocations()[0]);
      bean.setMapperLocations(mapperLocations);

      if (StringUtils.hasText(mybatisProperties.getConfigLocation())) {
        Resource[] resources = resolver.getResources(mybatisProperties.getConfigLocation());
        bean.setConfigLocation(resources[0]);
      }
      return bean.getObject();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }
}

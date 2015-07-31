package com.memory.base.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
@EnableTransactionManagement
@MapperScan("com.memory.*.persistence")
public class MySQLConfig {

  @Bean
  @Primary
  @ConfigurationProperties(prefix = "spring.mysql")
  public DataSource getDataSource() {
    return new DruidDataSource();
  }

  @Bean
  public PlatformTransactionManager txManager() {
    return new DataSourceTransactionManager(getDataSource());
  }

  @Bean
  public SqlSessionFactory sqlSessionFactoryBean() throws Exception {

    SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
    sqlSessionFactoryBean.setDataSource(getDataSource());

    return sqlSessionFactoryBean.getObject();
  }
}

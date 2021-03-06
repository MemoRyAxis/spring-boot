package com.memory.base.config;

import javax.servlet.Filter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.HttpPutFormContentFilter;

import com.memory.base.filter.CorsFilter;

@Configuration
public class WebConfig {

  @Bean
  public Filter getCorsFilter() {
    // return new CorsFilter();
    return new CorsFilter();
  }

  @Bean
  public Filter getHttpPutFormFilter() {
    return new HttpPutFormContentFilter();
  }
/*
  @Bean
  public HttpMessageConverters getHttpMessageConverter() {
    HttpMessageConverter<?> shmc = new StringHttpMessageConverter();
    HttpMessageConverter<?> fhmc = new FormHttpMessageConverter();
    HttpMessageConverter<?> mjhmc = new MappingJackson2HttpMessageConverter();
    return new HttpMessageConverters(shmc, fhmc, mjhmc);
  }
  */
}

package com.memory;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
@EnableAutoConfiguration
public class Application {
  public static void main(String[] args) throws IOException {

    System.out.println("\t-> test url1");
    URL url1 = Application.class.getClassLoader().getResource("/application.properties");
    System.out.println(url1); // null

    System.out.println("\t-> test is1");
    InputStream is1 = Application.class.getResourceAsStream("/application.properties");
    System.out.println(is1); // jar:file:/E:/workspace0319/spring-boot/ta................
    Properties prop = new Properties();
    prop.load(is1);
    System.out.println(prop.get("spring.redis.host"));

    System.out.println("\t-> test url2");
    URL url2 = Application.class.getResource("/application.properties");
    System.out.println(url2); // file:E:.................
    prop = new Properties();
    prop.load(url2.openStream());
    System.out.println(prop.get("spring.redis.host"));

    SpringApplication.run(Application.class, args);
  }
}

package com.memory.demo;

import redis.clients.jedis.Jedis;

public class RedisDemoTest {

  public static void main(String[] args) {
    Jedis jedis = new Jedis("120.24.57.174", 6379);
    jedis.auth("MemoRyAxis");
    
    System.out.println(jedis.get("helloworld"));
    jedis.del("helloworld");
    System.out.println(jedis.get("helloworld"));
  }
}

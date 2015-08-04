package com.memory.user.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.memory.Application;
import com.memory.user.domain.User;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebIntegrationTest(value = "server.port:0")
public class UserControllerTest {

  protected static ObjectMapper mapper = new ObjectMapper();

  RestTemplate template = new TestRestTemplate();

  @Value("${local.server.port}")
  int port;

  String userPath = "/user/";

  private String getBaseUrl() {
    return "http://localhost:" + port + userPath;
  }

  @Test
  public void getUserById() {
    String result = template.getForObject(getBaseUrl() + userPath, String.class);
    System.out.println(result);
  }

  @Test
  public void testUpdateUser() {

  }

  @Test
  public void testDeleteUser() throws Exception {
    System.out.println(getBaseUrl());

    User user = new User();
    user.setUsername("0");
    user.setPassword("0");

    String userJson = mapper.writeValueAsString(user);

    HttpHeaders headers = new HttpHeaders();
    headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);

//    @SuppressWarnings("unchecked")
//    Map<String, String> paramsMap = mapper.readValue(userJson, Map.class);
    
    HttpEntity<String> requestEntity = new HttpEntity<String>(userJson.toString(), headers);
    
    System.out.println(requestEntity.getBody());

    ResponseEntity<String> insertResult =
        template.exchange(getBaseUrl(), HttpMethod.POST, requestEntity, String.class);
    
    System.out.println(insertResult.getBody());

    ResponseEntity<String> deleteResult =
        template.exchange(getBaseUrl() + user.getId(), HttpMethod.DELETE, null, String.class);

    System.out.println(deleteResult.getBody());
  }
}

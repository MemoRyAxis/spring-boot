package com.memory.user.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.memory.Application;
import com.memory.user.domain.User;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@Transactional
public class UserServiceImplTest {

  @Autowired
  UserService userService;

  @Test
  @Rollback
  public void testAddUser() {
    User user = new User();
    user.setUsername("testUser");
    user.setPassword("123456");
    long id = userService.add(user);
    assert id != 0;
    assert userService.getById(id) != null;
  }
  
  @Test
  @Rollback
  public void testDeleteUser() {
    User user = new User();
    long id = userService.add(user);
    assert id != 0;
    assert userService.delById(id);
  }
}

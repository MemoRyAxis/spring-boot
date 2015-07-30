package com.memory.user.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.memory.user.domain.User;
import com.memory.user.persistence.UserMapper;

@Service
public class UserService {

  @Autowired
  UserMapper userMapper;

  List<User> getAll(Map<String, Object> params) {
    return userMapper.getAll(params);
  }

  int getCount(Map<String, Object> params) {
    return userMapper.getCount(params);
  }

  User getById(long id) {
    return userMapper.getById(id);
  }

  int add(User user) {
    return userMapper.add(user);
  }

  int delById(long id) {
    return userMapper.delById(id);
  }

  int update(User user) {
    return userMapper.update(user);
  }
}

package com.memory.user.service;

import java.util.List;
import java.util.Map;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.memory.user.domain.User;
import com.memory.user.persistence.UserDao;

@Service
public class UserService {
//
//  @Autowired
//  UserMapper userMapper;
//  
  @Autowired
  UserDao userDao;

  public List<User> getAll(Map<String, Object> params) {
    return userDao.getAll(params);
  }

  public int getCount(Map<String, Object> params) {
    return userDao.getCount(params);
  }

  public User getById(long id) {
    return userDao.getById(id);
  }

  public long add(User user) {
    user.setPassword(DigestUtils.md5Hex(user.getPassword()));
    return userDao.add(user) > 0 ? user.getId() : 0L;
  }

  public boolean delById(long id) {
    return userDao.delById(id) > 0 ? true : false;
  }

  public boolean update(User user) {
    return userDao.update(user) > 0 ? true : false;
  }
}

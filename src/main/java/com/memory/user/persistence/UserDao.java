package com.memory.user.persistence;

import org.springframework.stereotype.Repository;

import com.memory.base.persistence.BaseDao;
import com.memory.user.domain.User;

@Repository
public class UserDao extends BaseDao<User> {

  @Override
  protected Class<User> getEntityClass() {
    return User.class;  
  }
}

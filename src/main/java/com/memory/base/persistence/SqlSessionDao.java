package com.memory.base.persistence;

import org.apache.ibatis.session.SqlSessionFactory;

public interface SqlSessionDao {

  void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory);
}

package com.memory.base.persistence;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.memory.base.model.BaseModel;

/**
 * base dao
 * 
 * TODO finer grit transaction, R/W splitting
 * 
 * @date 2015年8月16日上午12:18:43
 * @author memoryaxis
 *
 */
public abstract class BaseDao<E extends BaseModel> extends MyBatisDao<E> {

  @Override
  @Autowired
  @Qualifier("sqlSessionFactoryBean")
  public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
    super.setSqlSessionFactory(sqlSessionFactory);
  }
}

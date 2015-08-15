package com.memory.base.persistence;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.memory.base.model.BaseModel;

/**
 * mybatis base dao
 *
 * @date 2015年8月16日上午12:05:18
 * @author memoryaxis
 *
 */
public abstract class MyBatisDao<T extends BaseModel> extends SqlSessionDaoSupport implements
    GenericDao<T, Long>, SqlSessionDao {

  protected final Logger logger = LoggerFactory.getLogger(getClass());

  // TODO get generic type
  protected abstract Class<T> getEntityClass();

  protected final AtomicBoolean verbose;

  public MyBatisDao() {
    verbose = new AtomicBoolean(false);
  }

  public String getStatement(String mapperId) {
    return getEntityClass().getCanonicalName() + '.' + mapperId;
  }

  @Override
  public int add(T entity) {

    Date now = new Date();
    entity.setCreateTime(now);
    entity.setUpdateTime(now);

    return getSqlSession().insert(getStatement("add"), entity);
  }

  @Override
  public int delById(Long id) {
    return getSqlSession().delete(getStatement("delete"), id);
  }

  @Override
  public int update(T entity) {

    entity.setUpdateTime(new Date());

    return getSqlSession().update(getStatement("update"), entity);
  }

  @Override
  public T getById(Long id) {
    return getSqlSession().selectOne(getStatement("getById"), id);
  }

  @Override
  public List<T> getAll(Map<String, Object> params) {
    return getSqlSession().selectList(getStatement("getAll"), params);
  }

  @Override
  public int getCount(Map<String, Object> params) {
    return getSqlSession().selectOne("getCount", params);
  }
}

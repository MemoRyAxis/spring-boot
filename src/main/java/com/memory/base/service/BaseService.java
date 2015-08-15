package com.memory.base.service;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.memory.base.model.BaseModel;
import com.memory.base.persistence.BaseDao;

/**
 * base service
 *
 * @date 2015年8月15日上午2:52:07
 * @author memoryaxis
 *
 */
public abstract class BaseService<E extends BaseModel> implements GenericService<E, Long> {

  protected final Logger logger = LoggerFactory.getLogger(getClass());

  protected abstract BaseDao<E> getBaseDao();

  @Override
  public List<E> getAll(Map<String, Object> params) {
    return getBaseDao().getAll(params);
  }

  @Override
  public int getCount(Map<String, Object> params) {
    return getBaseDao().getCount(params);
  }

  @Override
  public E getById(Long id) {
    return getBaseDao().getById(id);
  }

  @Override
  public int add(E entity) {
    return getBaseDao().add(entity);
  }

  @Override
  public int delById(Long id) {
    return getBaseDao().delById(id);
  }

  @Override
  public int update(E entity) {
    return getBaseDao().update(entity);
  }
}

package com.memory.base.persistence;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * base dao interfaces
 *
 * @date 2015年8月15日上午2:23:00
 * @author memoryaxis
 *
 */
public interface GenericDao<E, PK extends Serializable> {

  // TODO return primary key
  int add(E entity);

  int delById(PK id);

  int update(E entity);

  E getById(PK id);

  List<E> getAll(Map<String, Object> params);

  int getCount(Map<String, Object> params);

}

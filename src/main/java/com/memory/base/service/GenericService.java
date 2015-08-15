package com.memory.base.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * base service interface
 *
 * @date 2015年8月15日上午2:38:40
 * @author memoryaxis
 *
 */
public interface GenericService<E, PK extends Serializable> {

  List<E> getAll(Map<String, Object> params);

  int getCount(Map<String, Object> params);

  E getById(PK id);

  int add(E entity);

  int delById(PK id);

  int update(E entity);
}

package com.memory.deposit.service;

import java.util.List;
import java.util.Map;

import com.memory.deposit.domain.CostType;

public interface CostTypeService {

  List<CostType> getAll(Map<String, Object> params);

  int getCount(Map<String, Object> params);

  CostType getById(long id);

  long add(CostType costType);

  boolean delById(long id);

  boolean update(CostType costType);
}

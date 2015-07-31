package com.memory.deposit.persistence;

import java.util.List;
import java.util.Map;

import com.memory.deposit.domain.CostType;

public interface CostTypeMapper {

  List<CostType> getAll(Map<String, Object> params);

  int getCount(Map<String, Object> params);

  CostType getById(long id);

  long add(CostType costType);

  int delById(long id);

  int update(CostType costType);
}

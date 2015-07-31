package com.memory.deposit.persistence;

import java.util.List;
import java.util.Map;

import com.memory.deposit.domain.CostDetail;

public interface CostDetailMapper {

  List<CostDetail> getAll(Map<String, Object> params);

  int getCount(Map<String, Object> params);

  CostDetail getById(long id);

  long add(CostDetail costDetail);

  int delById(long id);

  int update(CostDetail costDetail);
}

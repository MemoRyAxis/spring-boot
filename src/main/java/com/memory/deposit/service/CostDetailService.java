package com.memory.deposit.service;

import java.util.List;
import java.util.Map;

import com.memory.deposit.domain.CostDetail;

public interface CostDetailService {

  List<CostDetail> getAll(Map<String, Object> params);

  int getCount(Map<String, Object> params);

  CostDetail getById(long id);

  long add(CostDetail costDetail);

  boolean delById(long id);

  boolean update(CostDetail costDetail);
}

package com.memory.deposit.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.memory.deposit.domain.CostType;
import com.memory.deposit.persistence.CostTypeMapper;
import com.memory.deposit.service.CostTypeService;

@Service
public class CostTypeServiceImpl implements CostTypeService {

  @Autowired
  CostTypeMapper costTypeMapper;

  @Override
  public List<CostType> getAll(Map<String, Object> params) {
    return costTypeMapper.getAll(params);
  }

  @Override
  public int getCount(Map<String, Object> params) {
    return costTypeMapper.getCount(params);
  }

  @Override
  public CostType getById(long id) {
    return costTypeMapper.getById(id);
  }

  @Override
  public long add(CostType costType) {
    return costTypeMapper.add(costType) > 0 ? costType.getId() : 0;
  }

  @Override
  public boolean delById(long id) {
    return costTypeMapper.delById(id) > 0;
  }

  @Override
  public boolean update(CostType costType) {
    return costTypeMapper.update(costType) > 0;
  }
}

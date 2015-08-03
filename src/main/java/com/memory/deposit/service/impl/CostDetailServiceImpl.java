package com.memory.deposit.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.memory.deposit.domain.CostDetail;
import com.memory.deposit.persistence.CostDetailMapper;
import com.memory.deposit.service.CostDetailService;

@Service
public class CostDetailServiceImpl implements CostDetailService {

  @Autowired
  CostDetailMapper costDetailMapper;

  @Override
  public List<CostDetail> getAll(Map<String, Object> params) {
    return costDetailMapper.getAll(params);
  }

  @Override
  public int getCount(Map<String, Object> params) {
    return costDetailMapper.getCount(params);
  }

  @Override
  public CostDetail getById(long id) {
    return costDetailMapper.getById(id);
  }

  @Override
  public long add(CostDetail costDetail) {
    return costDetailMapper.add(costDetail) > 0 ? costDetail.getId() : 0;
  }

  @Override
  public boolean delById(long id) {
    return costDetailMapper.delById(id) > 0;
  }

  @Override
  public boolean update(CostDetail costDetail) {
    return costDetailMapper.update(costDetail) > 0;
  }
}

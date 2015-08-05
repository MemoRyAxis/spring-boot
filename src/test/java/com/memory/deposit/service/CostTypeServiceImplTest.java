package com.memory.deposit.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.memory.Application;
import com.memory.deposit.domain.CostType;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@Transactional
public class CostTypeServiceImplTest {

  @Autowired
  CostTypeService costTypeService;
  
  @Test
  @Rollback(false)
  public void testAddCostType() {
    CostType costType = new CostType();
    costType.setAlias("breakfast");
    costType.setRemark("the first meal of the day, usually eaten in the morning");
    long id = costTypeService.add(costType);
    
    assert id != 0;
    assert costTypeService.getById(id) != null;
  }
}

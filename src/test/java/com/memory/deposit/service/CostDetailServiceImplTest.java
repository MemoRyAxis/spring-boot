package com.memory.deposit.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.memory.Application;
import com.memory.deposit.domain.CostDetail;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@Transactional
public class CostDetailServiceImplTest {

  @Autowired
  CostDetailService costDetailService;

  @Test
  @Rollback(false)
  public void testUpdateCostDetail() throws InterruptedException {
    CostDetail costDetail = new CostDetail();
    costDetail.setCost(200);
    costDetail.setCostType(0L);
    long id = costDetailService.add(costDetail);
    
    assert id != 0;
    
    Thread.sleep(1000);
    
    costDetail = costDetailService.getById(id);
    costDetail.setCost(150);
    boolean result = costDetailService.update(costDetail);
    
    assert result;
    assert costDetailService.getById(id).getCost() == 150;
  }
}

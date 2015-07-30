package com.memory.deposit.domain;

import java.util.Date;

import com.memory.base.model.BaseModel;

public class CostDetail extends BaseModel {

  private static final long serialVersionUID = 1L;

  private long id;

  private long costType;

  private double cost;

  private Date costData;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public long getCostType() {
    return costType;
  }

  public void setCostType(long costType) {
    this.costType = costType;
  }

  public double getCost() {
    return cost;
  }

  public void setCost(double cost) {
    this.cost = cost;
  }

  public Date getCostData() {
    return costData;
  }

  public void setCostData(Date costData) {
    this.costData = costData;
  }
}

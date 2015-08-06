package com.memory.deposit.domain;

import java.util.Date;

import com.memory.base.model.BaseModel;

public class CostDetail extends BaseModel {

  private static final long serialVersionUID = 1L;

  private long id;

  private long costType;

  private int cost;

  private String remark;

  private Date costDate;

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

  public int getCost() {
    return cost;
  }

  public void setCost(int cost) {
    this.cost = cost;
  }

  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }

  public Date getCostDate() {
    return costDate;
  }

  public void setCostDate(Date costDate) {
    this.costDate = costDate;
  }
}

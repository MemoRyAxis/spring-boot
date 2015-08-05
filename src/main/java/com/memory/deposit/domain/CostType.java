package com.memory.deposit.domain;

import com.memory.base.model.BaseModel;

public class CostType extends BaseModel {

  private static final long serialVersionUID = 1L;

  private long id;
  
  private long superId;
  
  private String alias;
  
  private String remark;

  public String getAlias() {
    return alias;
  }

  public void setAlias(String alias) {
    this.alias = alias;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public long getSuperId() {
    return superId;
  }

  public void setSuperId(long superId) {
    this.superId = superId;
  }

  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }
}

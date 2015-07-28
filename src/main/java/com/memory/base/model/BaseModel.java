package com.memory.base.model;

import java.io.Serializable;
import java.util.Date;

public class BaseModel implements Serializable {

  private static final long serialVersionUID = 1L;


  protected Long createBy;

  protected Long updateBy;

  protected Date createTime;

  protected Date updateTime;

  public Long getCreateBy() {
    return createBy;
  }

  public void setCreateBy(Long createBy) {
    this.createBy = createBy;
  }

  public Long getUpdateBy() {
    return updateBy;
  }

  public void setUpdateBy(Long updateBy) {
    this.updateBy = updateBy;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public Date getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }
 
}

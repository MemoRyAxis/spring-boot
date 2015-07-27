package com.memory.base.web;

import java.io.Serializable;
import java.util.List;

import com.memory.base.model.BaseModel;

public class ResponseList implements Serializable {

    private static final long serialVersionUID = -723202403327555602L;

    private int count;

    private int currentPage;

    private List<? extends BaseModel> list;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public List<? extends BaseModel> getList() {
        return list;
    }

    public void setList(List<? extends BaseModel> list) {
        this.list = list;
    }
}

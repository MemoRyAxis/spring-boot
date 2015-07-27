package com.memory.base.web;

public enum ResponseCode {

    SUBMIT_SUCCESS(600, "提交成功"), SUBMIT_FAIL(601, "提交失败"),

    QUERY_SUCCESS(602, "查询成功"), QUERY_FAIL(603, "查询失败"),

    GET_SUCCESS(701, "查询成功"), GET_FAIL(702, "查询失败"),

    POST_SUCCESS(701, "插入成功"), POST_FAIL(702, "插入失败"),

    PUT_SUCCESS(701, "更新成功"), PUT_FAIL(702, "更新失败"),

    DELETE_SUCCESS(701, "删除成功"), DELETE_FAIL(702, "删除失败"),

    X(999, "我是可爱的小酱油");

    private final int code;
    private final String msg;

    private ResponseCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}

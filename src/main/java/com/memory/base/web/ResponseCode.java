package com.memory.base.web;

public enum ResponseCode {

	SUBMIT_SUCCESS(600, "提交成功"),
	SUBMIT_FAIL(601, "提交失败"),
	
	QUERY_SUCCESS(700, "查询成功"),
	QUERY_FAIL(701, "查询失败"),

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

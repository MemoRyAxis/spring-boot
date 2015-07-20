package com.memory.base.web;

import java.io.Serializable;
import java.util.List;

public class ResponseModel implements Serializable {

	private static final long serialVersionUID = -8603951768171144375L;

	private int code;

	private String message;

	private Object data;

	class ResponseList implements Serializable {

		private static final long serialVersionUID = 3226478575123155281L;

		private int count;

		private int currentPage;

		private List<Object> list;

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

		public List<Object> getList() {
			return list;
		}

		public void setList(List<Object> list) {
			this.list = list;
		}

	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}

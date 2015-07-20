package com.memory.base.web;

import com.memory.base.web.ResponseModel.ResponseList;

public abstract class BaseController {

	protected ResponseModel genResponseModel(ResponseCode code) {
		return genResponseModel(code, code.getMsg());
	}

	protected ResponseModel genResponseModel(ResponseCode code, String message) {
		return genResponseModel(code, message, null);
	}

	protected ResponseModel genResponseModel(ResponseCode code, Object data) {
		return genResponseModel(code, code.getMsg(), data);
	}
	
	protected ResponseModel genResponseModel(ResponseCode code, ResponseList list) {
		return genResponseModel(code, code.getMsg(), list);
	}

	protected ResponseModel genResponseModel(ResponseCode code, String message, Object data) {
		ResponseModel responseModel = new ResponseModel();
		responseModel.setCode(code.getCode());
		responseModel.setMessage(message);
		responseModel.setData(data);
		return responseModel;
	}
}

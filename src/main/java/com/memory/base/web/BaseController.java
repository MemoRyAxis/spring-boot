package com.memory.base.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class BaseController {

  private Map<String, Object> decodeRequest() {
    // TODO
    return null;
  }

  private final static String PATH = "/";
  private final static String ID_PATH_VARIABLE = "{id}";
  protected final static String FIND_BY_ID_REQUEST = PATH + ID_PATH_VARIABLE;
  protected final static String FIND_REQUEST = PATH;
  protected final static String INSERT_REQUEST = PATH;
  protected final static String UPDATE_REQUEST = PATH;
  protected final static String DELETE_REQUEST = PATH + ID_PATH_VARIABLE;

  private static Map<String, Object> dataMap = new HashMap<String, Object>(1);

  protected ResponseModel genResponseModel(ResponseCode code) {
    return genResponseModel(code, code.getMsg(), null);
  }

  protected ResponseModel genResponseModel(ResponseCode code, ResponseList list) {
    return genResponseModel(code, code.getMsg(), list);
  }

  protected ResponseModel genResponseModel(ResponseCode code, Object obj) {
    return genResponseModel(code, code.getMsg(), obj);
  }

  private ResponseModel genResponseModel(ResponseCode code, String msg, Object data) {
    ResponseModel responseModel = new ResponseModel();
    responseModel.setCode(code.getCode());
    responseModel.setMessage(msg);
    if (data == null) {
      dataMap = null;
    } else if (data instanceof ResponseList) {
      responseModel.setData(data);
    } else if (data instanceof Map) {
      responseModel.setData(data);
    } else if (data instanceof List) {
      dataMap.put("list", data);
      responseModel.setData(dataMap);
    } else {
      dataMap.put("obj", data);
      responseModel.setData(dataMap);
    }
    return responseModel;
  }
}

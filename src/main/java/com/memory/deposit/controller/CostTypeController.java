package com.memory.deposit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.memory.base.web.BaseController;
import com.memory.base.web.ResponseCode;
import com.memory.base.web.ResponseList;
import com.memory.base.web.ResponseModel;
import com.memory.deposit.domain.CostType;
import com.memory.deposit.service.CostTypeService;

@RestController
@RequestMapping(value = "/costType")
public class CostTypeController extends BaseController {

  @Autowired
  CostTypeService costTypeService;
  

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public ResponseModel getAll(CostType costType) {
    ResponseModel rm = new ResponseModel();

    // TODO parameters
    List<CostType> costTypeList = costTypeService.getAll(null);

    ResponseList rl = new ResponseList();
    rl.setCount(costTypeList.size());
    rl.setCurrentPage(1);
    rl.setList(costTypeList);
    rm = genResponseModel(ResponseCode.GET_SUCCESS, rl);

    return rm;
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public ResponseModel get(@PathVariable("id") long id) {
    ResponseModel rm = new ResponseModel();

    CostType costType = costTypeService.getById(id);
    rm =
        costType != null
            ? genResponseModel(ResponseCode.GET_SUCCESS, costType)
            : genResponseModel(ResponseCode.GET_FAIL);

    return rm;
  }

  @RequestMapping(value = "/", method = RequestMethod.POST)
  public ResponseModel insert(CostType costType) {
    ResponseModel rm = new ResponseModel();

    long id = costTypeService.add(costType);

    rm =
        id > 0
            ? genResponseModel(ResponseCode.POST_SUCCESS, id)
            : genResponseModel(ResponseCode.POST_FAIL);

    return rm;
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
  public ResponseModel update(@PathVariable("id") long id, CostType costType) {
    ResponseModel rm = new ResponseModel();

    if (costTypeService.getById(id) != null) {
      costType.setId(id);
      rm =
          costTypeService.add(costType) != 0L
              ? genResponseModel(ResponseCode.POST_SUCCESS)
              : genResponseModel(ResponseCode.POST_FAIL);
    } else {
      costType.setId(id);
      rm =
          costTypeService.update(costType)
              ? genResponseModel(ResponseCode.PUT_SUCCESS)
              : genResponseModel(ResponseCode.PUT_FAIL);
    }

    return rm;
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public ResponseModel delete(@PathVariable("id") long id) {

    return costTypeService.delById(id)
        ? genResponseModel(ResponseCode.DELETE_SUCCESS)
        : genResponseModel(ResponseCode.DELETE_FAIL);
  }
}

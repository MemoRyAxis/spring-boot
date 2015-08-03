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
import com.memory.deposit.domain.CostDetail;
import com.memory.deposit.service.CostDetailService;

@RestController
@RequestMapping(value = "/costDetail")
public class CostDetailController extends BaseController {

  @Autowired
  CostDetailService costDetailService;
  

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public ResponseModel getAll(CostDetail costDetail) {
    ResponseModel rm = new ResponseModel();

    // TODO parameters
    List<CostDetail> costDetailList = costDetailService.getAll(null);

    ResponseList rl = new ResponseList();
    rl.setCount(costDetailList.size());
    rl.setCurrentPage(1);
    rl.setList(costDetailList);
    rm = genResponseModel(ResponseCode.GET_SUCCESS, rl);

    return rm;
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public ResponseModel get(@PathVariable("id") long id) {
    ResponseModel rm = new ResponseModel();

    CostDetail costDetail = costDetailService.getById(id);
    rm =
        costDetail != null
            ? genResponseModel(ResponseCode.GET_SUCCESS, costDetail)
            : genResponseModel(ResponseCode.GET_FAIL);

    return rm;
  }

  @RequestMapping(value = "/", method = RequestMethod.POST)
  public ResponseModel insert(CostDetail costDetail) {
    ResponseModel rm = new ResponseModel();

    long id = costDetailService.add(costDetail);

    rm =
        id > 0
            ? genResponseModel(ResponseCode.POST_SUCCESS, id)
            : genResponseModel(ResponseCode.POST_FAIL);

    return rm;
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
  public ResponseModel update(@PathVariable("id") long id, CostDetail costDetail) {
    ResponseModel rm = new ResponseModel();

    if (costDetailService.getById(id) != null) {
      costDetail.setId(id);
      rm =
          costDetailService.add(costDetail) != 0L
              ? genResponseModel(ResponseCode.POST_SUCCESS)
              : genResponseModel(ResponseCode.POST_FAIL);
    } else {
      costDetail.setId(id);
      rm =
          costDetailService.update(costDetail)
              ? genResponseModel(ResponseCode.PUT_SUCCESS)
              : genResponseModel(ResponseCode.PUT_FAIL);
    }

    return rm;
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public ResponseModel delete(@PathVariable("id") long id) {

    return costDetailService.delById(id)
        ? genResponseModel(ResponseCode.DELETE_SUCCESS)
        : genResponseModel(ResponseCode.DELETE_FAIL);
  }
}

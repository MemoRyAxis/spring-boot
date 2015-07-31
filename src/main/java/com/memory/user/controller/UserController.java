package com.memory.user.controller;

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
import com.memory.user.domain.User;
import com.memory.user.service.UserService;

@RestController
@RequestMapping(value = "/user")
public class UserController extends BaseController {

  @Autowired
  UserService userService;

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public ResponseModel getAll(User user) {
    ResponseModel rm = new ResponseModel();

    // TODO parameters
    List<User> userList = userService.getAll(null);

    ResponseList rl = new ResponseList();
    rl.setCount(userList.size());
    rl.setCurrentPage(1);
    rl.setList(userList);
    rm = genResponseModel(ResponseCode.GET_SUCCESS, rl);

    return rm;
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public ResponseModel get(@PathVariable("id") long id) {
    ResponseModel rm = new ResponseModel();

    User user = userService.getById(id);
    rm =
        user != null
            ? genResponseModel(ResponseCode.GET_SUCCESS, user)
            : genResponseModel(ResponseCode.GET_FAIL);

    return rm;
  }

  @RequestMapping(value = "/", method = RequestMethod.POST)
  public ResponseModel insert(User user) {
    ResponseModel rm = new ResponseModel();

    long id = userService.add(user);

    rm =
        id > 0
            ? genResponseModel(ResponseCode.POST_SUCCESS, id)
            : genResponseModel(ResponseCode.POST_FAIL);

    return rm;
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
  public ResponseModel update(@PathVariable("id") long id, User user) {
    ResponseModel rm = new ResponseModel();

    if (userService.getById(id) != null) {
      user.setId(id);
      rm =
          userService.add(user) != 0L
              ? genResponseModel(ResponseCode.POST_SUCCESS)
              : genResponseModel(ResponseCode.POST_FAIL);
    } else {
      user.setId(id);
      rm =
          userService.update(user)
              ? genResponseModel(ResponseCode.PUT_SUCCESS)
              : genResponseModel(ResponseCode.PUT_FAIL);
    }

    return rm;
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public ResponseModel delete(@PathVariable("id") long id) {

    return userService.delById(id)
        ? genResponseModel(ResponseCode.DELETE_SUCCESS)
        : genResponseModel(ResponseCode.DELETE_FAIL);
  }
}

package com.memory.user.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import net.sf.ehcache.Element;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.memory.base.util.EhcacheUtil;
import com.memory.base.util.NiceUtil;
import com.memory.base.web.BaseController;
import com.memory.base.web.ResponseCode;
import com.memory.base.web.ResponseList;
import com.memory.base.web.ResponseModel;
import com.memory.user.po.User;

@RestController
@RequestMapping(value = "/user2")
public class User2Controller extends BaseController {

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public ResponseModel getAll() {
    ResponseModel rm = new ResponseModel();

    try {
      List<User> userList = new ArrayList<User>();

      Set<Entry<Object, Element>> cacheSet =
          EhcacheUtil.getCurrentCache().getAll(EhcacheUtil.getCurrentCache().getKeys()).entrySet();
      Iterator<Entry<Object, Element>> iterator = cacheSet.iterator();
      while (iterator.hasNext()) {
        User user = (User) iterator.next().getValue().getObjectValue();
        userList.add(user);
      }

      ResponseList rl = new ResponseList();
      rl.setCount(userList.size());
      rl.setCurrentPage(1);
      rl.setList(userList);

      rm = genResponseModel(ResponseCode.GET_SUCCESS, rl);
    } catch (Exception e) {
      rm = genResponseModel(ResponseCode.GET_FAIL);
    }

    return rm;
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public ResponseModel get(@PathVariable("id") long id) {
    ResponseModel rm = new ResponseModel();

    try {
      User user = (User) EhcacheUtil.get(id).getObjectValue();
      genResponseModel(ResponseCode.GET_SUCCESS, user);
    } catch (Exception e) {
      rm = genResponseModel(ResponseCode.GET_FAIL);
    }

    return rm;
  }

  @RequestMapping(value = "/", method = RequestMethod.POST)
  public ResponseModel insert(User user) {

    user.setId(NiceUtil.getIncreaseLong());
    EhcacheUtil.put(new Element(user.getId(), user));

    return genResponseModel(ResponseCode.GET_SUCCESS);
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
  public ResponseModel update(@PathVariable("id") long id, User user) {

    EhcacheUtil.put(new Element(id, user));

    return genResponseModel(ResponseCode.PUT_SUCCESS);
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public ResponseModel delete(@PathVariable("id") long id) {

    EhcacheUtil.remove(id);

    return genResponseModel(ResponseCode.DELETE_SUCCESS);
  }
}

package com.memory.user.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import net.sf.ehcache.Cache;
import net.sf.ehcache.Element;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.memory.base.util.EhcacheUtil;
import com.memory.base.util.NiceUtil;
import com.memory.base.web.BaseController;
import com.memory.base.web.ResponseCode;
import com.memory.base.web.ResponseModel;
import com.memory.user.po.User;

@RestController
@RequestMapping(value = "/user")
public class UserController extends BaseController {

	// private static final Logger logger =
	// Logger.getLogger(UserController.class);

	private static final String USER_CACHE = "userCaches";
	private static Cache userCache;

	static {
		userCache = new Cache(USER_CACHE, 0, true, false, 60, 10);
		EhcacheUtil.addCache(userCache);
		EhcacheUtil.setCurrentCache(USER_CACHE);
	}

	@ResponseBody
	@RequestMapping(value = "/insert/{username}/{password}")
	public User insertUser(@PathVariable("username") String username,
			@PathVariable("password") String password) {

		User user = new User();
		user.setId(NiceUtil.getIncreaseLong());
		user.setUsername(username);
		user.setPassword(password);

		EhcacheUtil.put(new Element(String.valueOf(user.getId()), user));

		return user;
	}

	@ResponseBody
	@RequestMapping(value = "/get/{id}")
	public User getUser(@PathVariable("id") long id) {

		User user = new User();

		if (EhcacheUtil.haveElement(String.valueOf(id))) {
			user = (User) EhcacheUtil.get(String.valueOf(id)).getObjectValue();
		}
		return user;
	}

	@ResponseBody
	@RequestMapping(value = "/getAll")
	public ResponseModel getAll() {
		ResponseModel responseModel = new ResponseModel();
		
		List<User> userList = new ArrayList<User>();

		Set<Entry<Object, Element>> cacheSet = EhcacheUtil.getCurrentCache()
				.getAll(EhcacheUtil.getCurrentCache().getKeys()).entrySet();
		Iterator<Entry<Object, Element>> iterator = cacheSet.iterator();
		while (iterator.hasNext()) {
			User user = (User) iterator.next().getValue().getObjectValue();
			userList.add(user);
		}
		responseModel = genResponseModel(ResponseCode.QUERY_SUCCESS, userList);

		return responseModel;
	}

	@ResponseBody
	@RequestMapping(value = "/delete/{id}")
	public ResponseModel delete(@PathVariable("id") long id) {
		ResponseModel responseModel = new ResponseModel();

		if (EhcacheUtil.haveElement(String.valueOf(id))) {
			EhcacheUtil.remove(String.valueOf(id));
			responseModel = genResponseModel(ResponseCode.SUBMIT_SUCCESS);
		} else {
			responseModel = genResponseModel(ResponseCode.SUBMIT_FAIL);
		}

		return responseModel;
	}
}

package com.memory.metlife.controller;

import net.sf.ehcache.Cache;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.memory.base.util.EhcacheUtil;
import com.memory.base.web.BaseController;
import com.memory.base.web.ResponseModel;

@RestController
@RequestMapping(value = "metlife")
public class GiftController extends BaseController {

	private static final String IP_PHONE_CACHE = "ipPhoneCache";
	private static Cache ipPhoneCache;

	static {
		ipPhoneCache = new Cache(IP_PHONE_CACHE, 0, true, false, 60, 60);
		EhcacheUtil.addCache(ipPhoneCache);
		EhcacheUtil.setCurrentCache(IP_PHONE_CACHE);
	}

	@ResponseBody
	@RequestMapping(value = "/getCaptcha")
	public ResponseModel getCaptcha() {
		ResponseModel responseModel = new ResponseModel();

		return responseModel;
	}
}

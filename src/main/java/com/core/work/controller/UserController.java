package com.core.work.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.core.work.model.User;
import com.core.work.service.UserService;
import com.efun.mainland.util.redis.RedisUtil;

@RestController
public class UserController extends BaseController {
	
	@Autowired
	UserService userServ;
	

	@RequestMapping("/register")
	public String register(User user) {
		if(userServ.accountExist(user.getUsername())){
			return "account exist";
		}
		Long id = userServ.addUser(user);
		if(id<1)
			return "register fail";
		return "register success ,id = "+id;
	}

}

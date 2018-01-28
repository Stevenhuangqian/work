package com.core.work.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.core.work.annotation.login.LoginRequired;
import com.core.work.model.User;
import com.core.work.service.*;

@RestController
public class UserController extends BaseController {
	
	@Autowired
	IUserService userServ;
	

	/**
	 * 推荐使用实体封装的方法，前端传递的参数最好是用数据实体模型的方式提前定义，这样还可以做数据模型的注解
	 * @param user
	 * @return
	 */
	@LoginRequired
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

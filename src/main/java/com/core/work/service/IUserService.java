package com.core.work.service;

import com.core.work.model.User;
import com.core.work.service.IBaseService;

public interface IUserService extends IBaseService {

	/**
	 * 针对这部分可以增加缓存注解
	 * @param username
	 * @return
	 */

	Boolean accountExist(String username);

	Long addUser(User user);

}
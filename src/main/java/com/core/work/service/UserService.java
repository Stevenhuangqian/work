package com.core.work.service;

import org.springframework.stereotype.Service;

import com.core.work.model.User;

@Service
public class UserService extends BaseService {
	
	
	/**
	 * 针对这部分可以增加缓存注解
	 * @param username
	 * @return
	 */
	public User getUserByAccount(String username){
		User queryCondition = new User();
		queryCondition.setUsername(username);
		return dao.querySingleResult(queryCondition);
	}
	
	
	public Boolean accountExist(String username){
		if(null==getUserByAccount(username))
			return false;
		else
			return true;
	}
	
	
	public Long addUser(User user){
		return dao.insert(user);
	}
	

}

package com.core.work.service;

import org.springframework.stereotype.Service;

import com.core.work.cache.Cacheable;
import com.core.work.constants.RedisKey;
import com.core.work.model.User;
import com.core.work.service.impl.BaseService;

@Service
public class UserService extends BaseService implements IUserService {
	


	
	/* (non-Javadoc)
	 * @see com.core.work.service.impl.IUserService#accountExist(java.lang.String)
	 */
	@Cacheable(key=RedisKey.USER_EXISTS+"_#username")
	public Boolean accountExist(String username){
		User queryCondition = new User();
		queryCondition.setUsername(username);
		User u = dao.querySingleResult(queryCondition);
		if(null==u)
			return false;
		else
			return true;
	}
	
	
	/* (non-Javadoc)
	 * @see com.core.work.service.impl.IUserService#addUser(com.core.work.model.User)
	 */
	public Long addUser(User user){
		return dao.insert(user);
	}
	
	
	

}

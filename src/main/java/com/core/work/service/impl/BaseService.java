package com.core.work.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.core.work.service.IBaseService;
import com.dexcoder.dal.JdbcDao;

public  abstract class BaseService implements IBaseService {
	
	protected final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	protected JdbcDao dao ;
	
	
}

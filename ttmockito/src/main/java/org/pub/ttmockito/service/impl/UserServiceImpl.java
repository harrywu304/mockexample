package org.pub.ttmockito.service.impl;

import javax.annotation.Resource;

import org.pub.ttmockito.dao.UserDao;
import org.pub.ttmockito.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
	
	@Resource
	private UserDao userDao;

	@Override
	public String getUserNameById(String userId) {
		return userDao.selectUserNameById(userId);
	}

}

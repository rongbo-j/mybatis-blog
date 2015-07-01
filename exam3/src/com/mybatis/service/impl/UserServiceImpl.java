package com.mybatis.service.impl;

import com.mybatis.dao.UserDao;
import com.mybatis.domain.User;
import com.mybatis.service.UserService;

public class UserServiceImpl implements UserService{
	private UserDao userDao;
	
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public boolean checkUser(String username,String password) {
		User user = userDao.queryUserByName(username);
		
		if(user != null && user.getPassword().equals(password))
		{
			return true;
		}
		return false;
	}
	
}

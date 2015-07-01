package com.mybatis.dao.impl;

import org.mybatis.spring.SqlSessionTemplate;

import com.mybatis.dao.UserDao;
import com.mybatis.domain.User;

public class UserDaoImpl implements UserDao{
	private SqlSessionTemplate sqlSessionTemplate;

	public SqlSessionTemplate getSqlSessionTemplate() {
		return sqlSessionTemplate;
	}

	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	@Override
	public void saveUser(User u) {
		sqlSessionTemplate.insert("User.saveUser", u);
	}

	@Override
	public User queryUserByName(String username) {
		User user = (User)sqlSessionTemplate.selectOne("User.queryUserByName",username);
		return user;
	}
	
	
	

}

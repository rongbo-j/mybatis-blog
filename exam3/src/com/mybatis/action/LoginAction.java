package com.mybatis.action;

import com.mybatis.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private UserService userService;
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String execute() throws Exception {
		return this.SUCCESS;
	}

	@Override
	public void validate() {
		if(!userService.checkUser(username, password))
		{
			this.addFieldError("ErrorInfo", "用户名或密码不正确");
		}
	}
	

}

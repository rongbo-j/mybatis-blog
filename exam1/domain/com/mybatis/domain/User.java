package com.mybatis.domain;

public class User {

	private String username;
	private String password;
	private String phone;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	//为方便输出信息，我们重写toString方法
	@Override
	public String toString() {
		return  "username:" + username + ",password:" + password + ",phone" + phone;
	}
	
}

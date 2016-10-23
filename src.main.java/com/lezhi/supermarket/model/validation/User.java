package com.lezhi.supermarket.model.validation;

import com.lezhi.supermarket.model.util.Table;




@Table(value = "sys_user")
public class User{

	private String id;
    private String userName;
    private String password;
    
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
}

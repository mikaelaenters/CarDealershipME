package com.revature.cardealership.pojo;

import java.io.Serializable;

public abstract class User implements Serializable {
	//Fields;
	protected String userId,
	                 password;
	
	//Getters &setters;
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getUserId() {
		return this.userId;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassword() {
		return this.password;
	}
}

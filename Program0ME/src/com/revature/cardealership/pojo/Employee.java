package com.revature.cardealership.pojo;

import java.io.Serializable;

public class Employee extends User implements Serializable {
	
	
	public Employee(String userId, String password) {
		this.userId = userId;
		this.password = password;
	}
}

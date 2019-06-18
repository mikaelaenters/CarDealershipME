package com.revature.cardealership.pojo;

import java.io.Serializable;

public class Employee extends User implements Serializable {
	
	private int employeeKey;
	
	public Employee(String userId, String password) {
		this.userId = userId;
		this.password = password;
	}

	public int getEmployeeKey() {
		return employeeKey;
	}

	public void setEmployeeKey(int employeeKey) {
		this.employeeKey = employeeKey;
	}
	
	
}

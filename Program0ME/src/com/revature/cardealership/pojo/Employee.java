package com.revature.cardealership.pojo;

public class Employee extends User {
	
	
	public Employee(String firstName, String lastName, String userId, String password) {
		this.userId = userId;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}
}

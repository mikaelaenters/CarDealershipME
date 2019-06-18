package com.revature.cardealership.pojo;

import java.util.ArrayList;
import java.util.List;

public class Customer extends User{
	//Fields;
	//private static int currentIndex = 0;
	private int numberOfPayments = 0;
	private int customerKey;

	//Constructors;
	public Customer() {
		super();
	}
	
	public Customer(String userId, String password) {
		this.userId = userId;
		this.password = password;
	}

	//Getters &Setters;
	public int getCustomerKey() {
		return customerKey;
	}

	public void setCustomerKey(int customerKey) {
		this.customerKey = customerKey;
	}
	
//	public int getNextIndex() {
//		return currentIndex + 1;
//	}
	
	public int getNumberOfPayments() {
		return numberOfPayments;
	}

	public void setNumberOfPayments(int numberOfPayments) {
		this.numberOfPayments = numberOfPayments;
	}
	
	
}

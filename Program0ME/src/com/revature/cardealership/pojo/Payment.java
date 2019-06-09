package com.revature.cardealership.pojo;

import java.io.Serializable;

public class Payment implements Serializable{
	private Customer customer; 
	private int customerID;
	private double paymentAmount;
	private Car customerCar;
	
	
	public Payment(Customer customer, double paymentAmount, Car customerCar) {
		this.customer = customer;
		this.paymentAmount = paymentAmount;
		this.customerCar = customerCar;
		this.customerID = customer.getCustomerIndex();
	}


	@Override
	public String toString() {
		return "Payment [customerID=" + customerID + ", paymentAmount=" + paymentAmount + ", customerCar=" + customerCar.toString()
				+ "]";
	}
	
	
}

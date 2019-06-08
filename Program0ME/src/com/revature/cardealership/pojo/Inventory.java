package com.revature.cardealership.pojo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Inventory {
	
	//Fields;
	private List<Employee> employeeList;
	private List<Customer> customerList;
	private Map<Car,List<Offer>> currentCarOffers;
	
	
	public Inventory() {
		currentCarOffers = new HashMap<Car, List<Offer>>();
	}
	//Getters &Setters;
	public Map<Car, List<Offer>> getCurrentCarOffers() {
		return currentCarOffers;
	}

	public void setCurrentCarOffers(Map<Car, List<Offer>> currentCarOffers) {
		this.currentCarOffers = currentCarOffers;
	}

	public void setEmployeeList(List<Employee> employeeList) {
		this.employeeList = employeeList;
	}

	public void setCustomerList(List<Customer> customerList) {
		this.customerList = customerList;
	}

	public List<Employee> getEmployeeList() {
		return employeeList;
	}
	
	public List<Customer> getCustomerList() {
		return customerList;
	}
	
	
	
}

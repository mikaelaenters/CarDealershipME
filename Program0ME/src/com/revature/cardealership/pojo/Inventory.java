package com.revature.cardealership.pojo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Inventory {
	
	//Fields;
	private List<Employee> employeeList;
	private List<Customer> customerList;
	private Map<Car,List<Offer>> currentCarOffers;
	private CarLot carLot;

	
	
	public Inventory() {
		employeeList = new ArrayList<Employee>();
		customerList = new ArrayList<Customer>();
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

	public CarLot getCarLot() {
		return carLot;
	}

	public void setCarLot(CarLot carLot) {
		this.carLot = carLot;
	}

	
	
	
}

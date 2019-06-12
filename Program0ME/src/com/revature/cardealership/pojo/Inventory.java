package com.revature.cardealership.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Inventory implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2525346013999190313L;
	//Fields;
	private List<Employee> employeeList;
	private List<Customer> customerList;
	private List<Car> currentCarsWithOffers;
	private CarLot carLot;
	private List<Payment> allPayments;

	
	
	public Inventory() {
		employeeList = new ArrayList<Employee>();
		customerList = new ArrayList<Customer>();
		currentCarsWithOffers = new ArrayList<Car>();
		carLot = new CarLot();
		allPayments = new ArrayList<Payment>();
	}
	


	//Getters &Setters;
	public List<Car> getCurrentCarsWithOffers() {
		return currentCarsWithOffers;
	}

	public void setCurrentCarsWithOffers(List<Car> currentCarsWithOffers) {
		this.currentCarsWithOffers = currentCarsWithOffers;
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

	public List<Payment> getAllPayments() {
		return allPayments;
	}

	public void setAllPayments(List<Payment> allPayments) {
		this.allPayments = allPayments;
	}

	
	
	
}

package com.revature.cardealership.pojo;

import java.io.Serializable;

public class Offer implements Serializable{

	//Fields;
	private Customer customer;
	private Car car;
	private double offerAmount;
	private int offerId;
	private int customerId; 
	private int carId;
	
	//Constructors;
	public Offer() {}
	
	public Offer(int customerId, int carId, double offerAmount) {
		this.customerId = customerId;
		this.carId = carId;
		this.offerAmount = offerAmount;
	}
	
	public Offer(int offerId, int customerId, int carId, double offerAmount) {
		this.offerId = offerId;
		this.customerId = customerId;
		this.carId = carId;
		this.offerAmount = offerAmount;
	}
	
	//Getters &Setters;
	public Customer getCustomer() {
		return this.customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Car getCar() {
		return this.car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getCarId() {
		return carId;
	}
	public void setCarId(int carId) {
		this.carId = carId;
	}
	public double getOfferAmount() {
		return this.offerAmount;
	}
	public void setOfferAmount(double offerAmount) {
		this.offerAmount = offerAmount;
	}
	
	public int getOfferId() {
		return offerId;
	}

	public void setOfferId(int offerId) {
		this.offerId = offerId;
	}

	@Override
	public String toString() {
		return "Offer [ offerId=" + offerId + ", offerAmount=" + offerAmount + ", carId=" + carId + "]";
	}

	
	
}

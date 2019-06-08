package com.revature.cardealership.pojo;

import java.io.Serializable;

public class Offer implements Serializable{

	//Fields;
	private Customer customer;
	private Car car;
	private double offerAmount;
	private int offerId;
	private boolean accepted;
	private boolean rejected;
	private boolean pending;

	//Constructors;
	public Offer(Customer customer, Car car, double offerAmount) {
		this.customer = customer;
		this.car = car;
		this.offerAmount = offerAmount;
		this.pending = true;
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
	public double getOfferAmount() {
		return this.offerAmount;
	}
	public void setOfferAmount(double offerAmount) {
		this.offerAmount = offerAmount;
	}
	public boolean isAccepted() {
		return this.accepted;
	}

	public void setAccepted(boolean accepted) {
		this.accepted = accepted;
	}

	public boolean isRejected() {
		return this.rejected;
	}

	public void setRejected(boolean rejected) {
		this.rejected = rejected;
	}
	
	public void setPending(boolean pending) {
		this.pending = pending;
	}
	
	public boolean isPending() {
		return this.pending;
	}
	
	public int getOfferId() {
		return this.offerId;
	}
	public void setOfferId(int offerId) {
		this.offerId = offerId;
	}

	@Override
	public String toString() {
		return "Offer [customer=" + customer + ", car=" + car + ", offerAmount=" + offerAmount + ", offerId=" + offerId
				+ ", accepted=" + accepted + "]";
	}
	
}

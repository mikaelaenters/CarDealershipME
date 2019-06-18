package com.revature.cardealership.pojo;

import java.io.Serializable;

public class Payment implements Serializable{
	private int paymentId;
	private double paymentAmount;
	private int carId;
	
	//Constructors;
	public Payment(int paymentId, double paymentAmount, int carId) {
		this.paymentId = paymentId;
		this.paymentAmount = paymentAmount;
		this.carId = carId;
	}

	//Getters &Setters;
	public int getPaymentId() {
		return paymentId;
	}


	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}


	public double getPaymentAmount() {
		return paymentAmount;
	}


	public void setPaymentAmount(double paymentAmount) {
		this.paymentAmount = paymentAmount;
	}


	public int getCarId() {
		return carId;
	}


	public void setCarId(int carId) {
		this.carId = carId;
	}

	//Methods;
	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", paymentAmount=" + paymentAmount + ", carId=" + carId + "]";
	}
	
}

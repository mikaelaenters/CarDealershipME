package com.revature.cardealership.daos;

import java.util.List;

import com.revature.cardealership.pojo.Payment;

public interface PaymentDAO {
	
	public void createPayment(int carId, double paymentAmount);
	public List<Payment> getAllPayments();
	public List<Payment> getPaymentsByCarId(int carId);
}

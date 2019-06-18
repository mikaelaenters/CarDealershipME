package com.revature.cardealership.daos;

import com.revature.cardealership.pojo.Customer;

public interface CustomerDAO {
	
	public void createCustomer(Customer customer);
	public int getCustomerKeyByUsername(String username);
	public boolean customerValidation(String username, String password);
}

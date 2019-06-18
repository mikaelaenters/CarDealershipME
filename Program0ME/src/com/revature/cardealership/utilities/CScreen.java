package com.revature.cardealership.utilities;

import com.revature.cardealership.pojo.Customer;

public interface CScreen {
	
	public Customer display();
	public int menuOptions(Customer customer);
}

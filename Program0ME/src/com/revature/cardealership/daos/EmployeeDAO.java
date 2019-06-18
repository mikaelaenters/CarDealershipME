package com.revature.cardealership.daos;

import com.revature.cardealership.pojo.Employee;

public interface EmployeeDAO {
	
	public void createEmployee(Employee employee);
	public int getEmployeeKeyByUsername(String username);
	public boolean employeeValidation(String username, String password);
}

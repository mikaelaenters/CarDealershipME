package com.revature.cardealership.managerimpl;

import com.revature.cardealership.daos.CarDAO;
import com.revature.cardealership.daos.CarDAOPostgresImpl;
import com.revature.cardealership.daos.CustomerDAO;
import com.revature.cardealership.daos.CustomerDAOPostgresImpl;
import com.revature.cardealership.daos.OfferDAO;
import com.revature.cardealership.daos.OfferDAOPostgresImpl;
import com.revature.cardealership.daos.PaymentDAO;
import com.revature.cardealership.daos.PaymentDAOPostgresImpl;
import com.revature.cardealership.managerinterface.CustomerManager;
import com.revature.cardealership.pojo.Car;
import com.revature.cardealership.pojo.Customer;

public class CustomerManagerImpl implements CustomerManager {

	private static CarDAO cardao = new CarDAOPostgresImpl();
	private static OfferDAO offerdao = new OfferDAOPostgresImpl();
	private static CustomerDAO customerdao = new CustomerDAOPostgresImpl();
	private static PaymentDAO paymentdao = new PaymentDAOPostgresImpl();

	@Override
	public void viewAllCars() {	
		for (Car car : cardao.getAllCarsOnLot()) {
			System.out.println(car.toString());
		}
	}

	@Override
	public void viewOwnedCars(Customer customer) {
		if(cardao.getCarsByCustomerId(customerdao.getCustomerKeyByUsername(customer.getUserId())).size() == 0) {
			System.out.println("You Don't Own Any Cars!\n");
		}
		
		else {
			for(Car car : cardao.getCarsByCustomerId(customerdao.getCustomerKeyByUsername(customer.getUserId()))){
				System.out.println(car.toString());
			}
		}
	}

	@Override
	public void createAnAccount(String userId, String password) {
		Customer customer = new Customer(userId, password);
		customerdao.createCustomer(customer);
	}

	@Override
	public void makeAMonthlyPayment(double paymentAmount, int carId) {
		paymentdao.createPayment(carId, paymentAmount);
	}
}

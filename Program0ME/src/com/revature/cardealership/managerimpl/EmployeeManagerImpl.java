package com.revature.cardealership.managerimpl;

import java.util.List;

import com.revature.cardealership.daos.CarDAO;
import com.revature.cardealership.daos.CarDAOPostgresImpl;
import com.revature.cardealership.daos.EmployeeDAO;
import com.revature.cardealership.daos.EmployeeDAOPostgresImpl;
import com.revature.cardealership.daos.OfferDAO;
import com.revature.cardealership.daos.OfferDAOPostgresImpl;
import com.revature.cardealership.managerinterface.EmployeeManager;
import com.revature.cardealership.pojo.Car;
import com.revature.cardealership.pojo.Employee;
import com.revature.cardealership.pojo.Offer;

public class EmployeeManagerImpl implements EmployeeManager {
	
	private static CarDAO cardao = new CarDAOPostgresImpl();
	private static OfferDAO offerdao = new OfferDAOPostgresImpl();
	private static EmployeeDAO employeedao = new EmployeeDAOPostgresImpl();
	
	@Override
	public Offer acceptOffer(int offerId) {
		int carId = offerdao.getOfferById(offerId).getCarId();
		
			offerdao.updateAccepted(offerId);
		
			for(Offer offer: offerdao.getAllPendingCarOffers(carId)) {
				offerdao.updateRejected(offer.getOfferId());
			}
			
			return offerdao.getOfferById(offerId);
	}


	@Override
	public Offer rejectOffer(int offerId) {
	
		offerdao.updateRejected(offerId);
		
		return offerdao.getOfferById(offerId);
	}
	
	@Override
	public void addCar(String carMake, String carModel, int year) {
		Car newCar = new Car(carMake, carModel, year);
		cardao.createCar(newCar);
		
	}

	@Override
	public void removeCar(int carId) {
		cardao.updateCarActiveStatus(carId);
	}


	@Override
	public void createAnAccount(String userId, String password) {

		Employee newEmployee = new Employee(userId, password);
		employeedao.createEmployee(newEmployee);
		
		

	}

}

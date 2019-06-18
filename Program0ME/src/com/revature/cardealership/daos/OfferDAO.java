package com.revature.cardealership.daos;

import java.util.List;

import com.revature.cardealership.pojo.Offer;

public interface OfferDAO {
	
	public void createOffer(Offer offer);
	public void updateRejected(int offerId);
	public void updateAccepted(int offerId);
	public List<Offer> getAllPendingCarOffers(int carId);
	public Offer getOfferById(int offerId);
	public List<Offer> getAllPendingOffers();
}

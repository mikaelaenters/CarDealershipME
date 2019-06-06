package com.revature.cardealership.pojo;

import java.util.List;

public abstract class OfferList {
	
	//Fields;
	protected List<Offer> offerList;

	
	//Getters &Setters;
	public List<Offer> getOfferList() {
		return this.offerList;
	}

	public void setOfferList(List<Offer> offerList) {
		this.offerList = offerList;
	}
	
	
}

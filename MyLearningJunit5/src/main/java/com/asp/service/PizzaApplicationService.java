package com.asp.service;

import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

@Service
public class PizzaApplicationService {
	
	private static final Set<String>  values = new HashSet<>();
	
	public PizzaApplicationService() {
		for(PizzaName name:PizzaName.values()) {
			values.add(name.name());
		}
	}
	
	private static final Logger logger = Logger.getLogger(PizzaApplicationService.class.getName());

	
	public boolean checkPizzaName(String pizzaName) {
		if(values.contains(pizzaName)) {
				logger.info("The "+pizzaName +"Present in List");
				
		return true;
		}
		else {
			logger.info("The "+pizzaName +" Not Present in List");
			return false;
		}
	}
	
	public int pizzaonDine(int quantity ,int price) {
		
	int pizzaonDineAmount =	quantity * price;
	logger.info("The pizzaonDineAmount is "+pizzaonDineAmount);
		return pizzaonDineAmount;
	}
	
	public int pizzaOnDelivery(int quantity ,int price, int deliveryPrice) {
		int pizzaOnDeliveryAmount = (quantity*price)+deliveryPrice;
		logger.info("The pizzaOnDeliveryAmount is "+pizzaOnDeliveryAmount);
		return pizzaOnDeliveryAmount;
	}
	
	
	public int sundayOffer(int quantity, int price, int offer) {
	 int total	= quantity*price;
	  int sundayOfferAmount =  total -(total* offer)/100;
	 logger.info("The sundayOfferAmount is "+sundayOfferAmount);
	 return sundayOfferAmount;
	}
}

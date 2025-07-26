package com.asp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.asp.service.PizzaApplicationService;

@RestController
public class PizzaApplicationcontroller {

	@Autowired
	private PizzaApplicationService pizzaApplicationService;

	@GetMapping("/pizzaonDine")
	public ResponseEntity<String> pizzaonDine(@RequestParam(name = "quantity") int quantity,
			@RequestParam(name = "price") int price) {
		int pizzaonDineAmount = pizzaApplicationService.pizzaonDine(quantity, price);
		return ResponseEntity.ok("\"Pizza order placed successfully for dine-in the Amount is => " + pizzaonDineAmount);
	}

	@GetMapping("/pizzaOnDelivery")
	public ResponseEntity<String> pizzaOnDelivery(@RequestParam(name = "quantity") int quantity,
			@RequestParam(name = "price") int price, @RequestParam(name = "deliveryPrice") int deliveryPrice) {
		int pizzaOnDeliveryAmount = pizzaApplicationService.pizzaOnDelivery(quantity, price, deliveryPrice);
		return ResponseEntity
				.ok("\"Pizza order placed successfully for pizzaOnDelivery the Amount is .=>" + pizzaOnDeliveryAmount);

	}

	@GetMapping("/sundayOffer")
	public ResponseEntity<String> sundayOffer(@RequestParam(name = "quantity") int quantity,
			@RequestParam(name = "price") int price, @RequestParam(name = "offer") int offer) {
		int sundayOfferAmount = pizzaApplicationService.sundayOffer(quantity, price, offer);
		return ResponseEntity
				.ok("\"Pizza order placed successfully for sundayOffer the Amount is .=> " + sundayOfferAmount);
	}
	
	@GetMapping("/checkPizzaName")
	public ResponseEntity<String> checkPizzaName(@RequestParam(name = "pizzaName") String name) {
		boolean checkPizzaPresentInList = pizzaApplicationService.checkPizzaName(name);
		if (checkPizzaPresentInList) {
			return ResponseEntity.ok("Pizza is present " + name);
		} else {
			return ResponseEntity.ok("Pizza Not present ");
		}
	}

}

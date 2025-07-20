package com.asp.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class PizzaApplicationTest {

	PizzaApplicationService pizzaApplicationService = new PizzaApplicationService();

	@Test
	public void pizzaonDineTest() {
		int actualPrice = pizzaApplicationService.pizzaonDine(2, 250);
		int expectedPrice = 500;
		assertEquals(actualPrice, expectedPrice);
	}

	@Test
	public void pizzaOnDeliveryTest() {
		int actualPrice = pizzaApplicationService.pizzaOnDelivery(2, 250, 50);
		int expectedPrice = 550;
		assertEquals(actualPrice, expectedPrice);
	}

	@Test
	public void sundayOfferTest() {
		int actualPrice = pizzaApplicationService.sundayOffer(2, 250, 20);
		int expectedPrice = 400;
		assertEquals(actualPrice, expectedPrice);
	}

}

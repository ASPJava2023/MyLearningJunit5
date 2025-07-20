package com.asp.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PizzaApplicationTest {

	PizzaApplicationService pizzaApplicationService = new PizzaApplicationService();
	
	@DisplayName("Test for  pizzaonDine")
	@Test
	public void pizzaonDineTest() {
		int actualPrice = pizzaApplicationService.pizzaonDine(2, 250);
		int expectedPrice = 500;
		assertEquals(actualPrice, expectedPrice);
	}
	
	@DisplayName("Test for pizzaOnDelivery")
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
	
	@DisplayName("Test for Getting Env varriable")
	@Test
	@Disabled
	public void envTest() {
		assertTrue(System.getenv("ENV").startsWith("D"));
	}
	@DisplayName(" Test to learn Assume")
	@Test
	public void partyForDeveloperTeamTest() {
		assumeTrue("Dev".equals(System.getenv("ENV")),
				()->"Not from Developer Team");
		int actualPrice = pizzaApplicationService.sundayOffer(2, 250, 20);
		int expectedPrice = 400;
		assertEquals(actualPrice, expectedPrice);
		}

	//Get The GRE
	@DisplayName("Get Java runtime Env my code")
	@Test
	
	public void  getGRE() {
		System.out.println(System.getProperty("java.runtime.version"));
	}
	
	@Test
	public void sundayOfferTestForGRE() {
		int actualPrice = pizzaApplicationService.sundayOffer(2, 250, 20);
		assumeTrue(System.getProperty("java.runtime.version").startsWith("17"));
		int expectedPrice = 400;
		assertEquals(actualPrice, expectedPrice);
	}

}

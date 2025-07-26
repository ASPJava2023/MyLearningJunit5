package com.asp.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import java.util.logging.Logger;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("Test For Pizza Application")
@TestInstance(Lifecycle.PER_CLASS)
//@Tag(value = "Pass")

public class PizzaApplicationTest {
	static PizzaApplicationService pizzaApplicationService; 
	
	private static final Logger logger =Logger.getLogger(PizzaApplicationTest.class.getName());
	int quantity,price,deliveryPrice,offer;
		
	@BeforeAll
	static void serviceObjectCreate() {
		logger.info("Before All");
		 pizzaApplicationService = new PizzaApplicationService();
	}
	
	@BeforeEach
	void SetvalueforEveryTestCase() {
		quantity = 2;
		price = 250;
		deliveryPrice =50;
		offer =20;
		logger.info("Before each Test");
	}
	
	@DisplayName("Test for  pizzaonDine")
	@Test
	@Order(value = 2)
	@Tag(value ="Pass")
	public void pizzaonDineTest() {
		
		int actualPrice = pizzaApplicationService.pizzaonDine(quantity, price);
		int expectedPrice = 500;
		assertEquals(actualPrice, expectedPrice);
	}
	
	@DisplayName("Test for pizzaOnDelivery")
	@Test
	@Order(value = 3)
	@Tag(value ="Pass")
	public void pizzaOnDeliveryTest() {
		int actualPrice = pizzaApplicationService.pizzaOnDelivery(quantity, price, deliveryPrice);
		int expectedPrice = 550;
		assertEquals(actualPrice, expectedPrice);
	}
	
	@DisplayName("Test for pizzaOnDelivery FailTest")
	@Test
	@Tag(value = "Fail")
	public void pizzaOnDeliveryFailTest() {
		int actualPrice = pizzaApplicationService.pizzaOnDelivery(quantity, price, deliveryPrice);
		int expectedPrice = 450;
		assertEquals(actualPrice, expectedPrice);
	}

	@Test
	@Order(value = 4)
	@Tag(value ="Pass")
	public void sundayOfferTest() {
		int actualPrice = pizzaApplicationService.sundayOffer(quantity, price, offer);
		int expectedPrice = 400;
		assertEquals(actualPrice, expectedPrice);
	}
	
	@Order(value = 5)
	@DisplayName("Test for Getting Env varriable")
	@Test
	@Disabled("Custom Env is not set as of Now")
	public void envTest() {
		assertTrue(System.getenv("ENV").startsWith("D"));
	}
	
	@DisplayName(" Test to learn Assume")
	@Test
	@Order(value = 1)
	public void partyForDeveloperTeamTest() {
		assumeTrue("Dev".equals(System.getenv("ENV")),
				()->"Not from Developer Team");
		int actualPrice = pizzaApplicationService.sundayOffer(quantity, price, offer);
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
		int actualPrice = pizzaApplicationService.sundayOffer(quantity, price, offer);
		assumeTrue(System.getProperty("java.runtime.version").startsWith("17"));
		int expectedPrice = 400;
		assertEquals(actualPrice, expectedPrice);
	}

	@AfterAll
	static void TaskToCleanPizzaApplicationServiceObject() {
		pizzaApplicationService =null;
		logger.info("After All clearn the object of  pizzaApplicationService");
	}
	
	@AfterEach
	void taskAllClean() {
		logger.info("After  each Test");
//		quantity =(Integer) null;
//		price =(Integer) null;
//		deliveryPrice =(Integer) null;
//		offer = (Integer) null;
	}
	
	}

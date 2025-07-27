package com.asp.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.logging.Logger;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvFileSources;
import org.junit.jupiter.params.provider.CsvSource;

public class PizzaApplicationCSVTest {
	static PizzaApplicationService pizzaApplicationService;

	private static final Logger logger = Logger.getLogger(PizzaApplicationCSVTest.class.getName());

	@BeforeAll
	static void serviceObjectCreate() {
		logger.info("Before All");
		pizzaApplicationService = new PizzaApplicationService();
	}
	
	@CsvSource({"2,250,500","3,150,450"})
	@ParameterizedTest
		void pizzaonDineCSVTest(int quantity, int price, int expectedPrice) {
						int actualPrice = pizzaApplicationService.pizzaonDine(price,quantity);
						assertEquals(expectedPrice,actualPrice);
	}
	
	@CsvFileSource(resources = "/Input.csv",delimiter = ';')
	@ParameterizedTest
		void pizzaonDineCSVFileTest(int quantity, int price, int expectedPrice) {
						int actualPrice = pizzaApplicationService.pizzaonDine(price,quantity);
						assertEquals(expectedPrice,actualPrice);
	}

}

package com.asp.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.logging.Logger;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;


@DisplayName("Test PizzaName")
public class PizzNameTestValueSource {
	
	
	static PizzaApplicationService pizzaApplicationService;
	
	private static final Logger logger =Logger.getLogger(PizzNameTestValueSource.class.getName());
	
	@BeforeAll
	static void serviceObjectCreate() {
		logger.info("Before All");
		 pizzaApplicationService = new PizzaApplicationService();
	}
	
	@ParameterizedTest
	@NullAndEmptySource
	@ValueSource(strings = {"PANEER","INDIA","MAXICAN","GREEK","OLIVE"," "})
	void isPizzaAvailableTest(String pizzaName) {
		if(pizzaName ==null || pizzaName.isEmpty()) {
			assertFalse(pizzaApplicationService.checkPizzaName(pizzaName));
		}
		else {
		assertTrue(pizzaApplicationService.checkPizzaName(pizzaName));
	}
}
	@ParameterizedTest
	@EnumSource(PizzaName.class)
	void isPizzaAvaliableUsingEnumTest(PizzaName pizzaName) {
		assertTrue(pizzaApplicationService.checkPizzaName(pizzaName.name()));
	}
	@ParameterizedTest
	@EnumSource(value= PizzaName.class, names = {"INDIA"} )
	void isPizzaAvaliableUsingSpacificEnumTest(PizzaName pizzaName) {
		assertTrue(pizzaApplicationService.checkPizzaName(pizzaName.name()));
	}
}

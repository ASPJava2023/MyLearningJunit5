package com.asp.service;

import java.util.logging.Logger;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;

public class PizzaApplicationArgumentSourcetest {

	@DisplayName("Test PizzaApplicationArgumentSourcetest")
	public class PizzNameTestValueSource {
		
		
		static PizzaApplicationService pizzaApplicationService;
		
		private static final Logger logger =Logger.getLogger(PizzaApplicationArgumentSourcetest.class.getName());
		
		@BeforeAll
		static void serviceObjectCreate() {
			logger.info("Before All");
			 pizzaApplicationService = new PizzaApplicationService();
		}
			
		
		
	}
}


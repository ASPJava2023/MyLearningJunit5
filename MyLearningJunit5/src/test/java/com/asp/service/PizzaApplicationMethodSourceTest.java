package com.asp.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.logging.Logger;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class PizzaApplicationMethodSourceTest {

	static PizzaApplicationService pizzaApplicationService;

	private static final Logger logger = Logger.getLogger(PizzaApplicationMethodSourceTest.class.getName());

	@BeforeAll
	static void serviceObjectCreate() {
		logger.info("Before All");
		pizzaApplicationService = new PizzaApplicationService();
	}

	@MethodSource("inputMethod")
	@ParameterizedTest
	void pizzaonDineSingleMethodArgumentTest(int quantity, int price) {
		int actualPrice = pizzaApplicationService.pizzaonDine(quantity, price);
		int expectedPrice = 500;
		assertEquals(expectedPrice, actualPrice);
	}

	// we are using this method to provide argument
	static Stream<Arguments> inputMethod() {
		return Stream.of(Arguments.of(2, 250));

	}

	@MethodSource("inputMethod2")
	@ParameterizedTest
	void pizzaonDineMultipleMethodArgumentTest(int quantity, int price, int expectedPrice) {
		int actualPrice = pizzaApplicationService.pizzaonDine(quantity, price);
		assertEquals(expectedPrice, actualPrice);
	}

	// we are using this method to provide Mutiple argument method in same class
	static Stream<Arguments> inputMethod2() {
		return Stream.of(Arguments.of(2, 250, 500), Arguments.of(3, 150, 450));
	}


	@MethodSource("com.asp.service.MethodInputClassForTest#methodInput3")
	@ParameterizedTest
	void pizzaonDineMultipleMethodArgumentFromDiffrentClassTest(int quantity, int price, int expectedPrice) {
		int actualPrice = pizzaApplicationService.pizzaonDine(quantity, price);
		assertEquals(expectedPrice, actualPrice);
	}
}
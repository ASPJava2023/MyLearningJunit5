package com.asp.service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;
import org.junit.jupiter.api.function.Executable;

public class PizzaApplicationDynamicTest {

    @DisplayName("Test PizzaApplicationArgumentSource test")
    public static class PizzaNameTestValueSource {

        static PizzaApplicationService pizzaApplicationService;

        private static final Logger logger = Logger.getLogger(PizzaApplicationDynamicTest.class.getName());

        @BeforeAll
        static void serviceObjectCreate() {
            logger.info("Before All - Creating Service Object");
            pizzaApplicationService = new PizzaApplicationService();
        }

        @TestFactory
        Collection<DynamicTest> pizzaPriceTest() {
            List<Integer> quantities = new ArrayList<>();
            List<Integer> prices = new ArrayList<>();
            List<Integer> expectedResults = new ArrayList<>();

            Scanner sc = new Scanner(System.in);
            System.out.print("Enter number of test cases: ");
            int val = sc.nextInt();

            for (int i = 0; i < val; i++) {
                System.out.print("Enter Quantity: ");
                quantities.add(sc.nextInt());
                System.out.print("Enter Price: ");
                prices.add(sc.nextInt());
                System.out.print("Enter Expected Result: ");
                expectedResults.add(sc.nextInt());
            }

            sc.close(); // good practice to close Scanner

            Collection<DynamicTest> dynamicTests = new ArrayList<>();

            for (int i = 0; i < quantities.size(); i++) {
                Integer quantity = quantities.get(i);
                Integer price = prices.get(i);
                Integer expected = expectedResults.get(i);

                Executable executable = () -> assertEquals(expected,
                        pizzaApplicationService.pizzaonDine(quantity, price));

                String testName = "Test with quantity=" + quantity + ", price=" + price;

                DynamicTest dynamicTest = dynamicTest(testName, executable);
                dynamicTests.add(dynamicTest);
            }

            return dynamicTests;
        }
    }
}

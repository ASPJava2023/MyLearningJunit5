package com.asp.service;

import java.util.stream.Stream;

import org.junit.jupiter.params.provider.Arguments;



public class MethodInputClassForTest {
	
	static Stream<Arguments> methodInput3() {
		return Stream.of(
				Arguments.of(2,400,800),
				Arguments.of(3,250,750)
				);
	}

}

package com.asp.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
public class MyService {
	
	@GetMapping("/add")
	public double addNumber(double firstNumber, double secondNumber) {
		return firstNumber+secondNumber;
	}
	
	@GetMapping("/sub")
	public double subtractNumber(double firstNumber, double secondNumber) {
		return firstNumber -secondNumber;
	}

}

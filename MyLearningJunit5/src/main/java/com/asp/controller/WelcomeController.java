package com.asp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
	
	@GetMapping("/msg")
	public String greeting() {
		return "wellcome from Ankit";
	}

}

package com.project.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	
	@RequestMapping("/")
	public String index() {
		return "Welcome From index";
	}
	
	@RequestMapping("/home")
	public String home() {
		return "Hello From Home";
	}
}

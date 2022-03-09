package com.project.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Home")
public class HomeController {
	

	@RequestMapping("/")
	public String index() {
		return "Index";
	}
	
	@RequestMapping("/homePage")
	public String home() {
		return "Home Page";
	}
}

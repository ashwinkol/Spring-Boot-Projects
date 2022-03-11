package com.project.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	@PostMapping("/")
	public String index() {
		return "Index";
	}

}

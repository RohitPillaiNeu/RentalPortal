package com.portal.RentalApp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class HomeController {
	@GetMapping("/home")
	public ModelAndView handleGet(HttpServletRequest request) {
		
		return new ModelAndView("adminHome");
	}
	
}

package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HelloController {
	
	@GetMapping("/hello.htm")
	public ModelAndView handleGet() {
		return new ModelAndView("defaultLanding-view");
	}
//	@GetMapping("/hello.htm")
//	public String handleGet() {
//		return "wqe ";
//	}
}

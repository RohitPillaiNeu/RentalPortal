package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.support.SessionStatus;

import com.example.pojo.User;
import com.example.validator.UserValidator;

@Controller
public class UserFormController {
	
	@Autowired
	UserValidator validator;
	
	@GetMapping("/user.htm")
	public String showForm(ModelMap model, User user) {
		model.addAttribute("user", user);
		return "user-form";
	}

	@PostMapping("/user.htm")
	public String showSuccess(@ModelAttribute("user")User user, BindingResult result, SessionStatus status) {
		
		 validator.validate(user, result);
	        
	        if(result.hasErrors())
	            return "user-form";
	        
	        status.setComplete();
		return "user-success";
	}
	
}

package com.portal.RentalApp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;

import com.portal.RentalApp.dao.UserDAO;
import com.portal.RentalApp.pojo.User;

@RestController
public class LoginController {
	
	@GetMapping("/login.htm")
	public ModelAndView handleGet(HttpServletRequest request) {

		UserDAO userdao = new UserDAO();
		User user = new User();
        user.setAdmin(true);
        user.setName("User1");
        user.setUserName("user@1");
        user.setUserPassword("user@1");
        
        userdao.saveUser(user);
        
        request.getSession().setAttribute("user", user); 
		return new ModelAndView("login-view");
	}
}
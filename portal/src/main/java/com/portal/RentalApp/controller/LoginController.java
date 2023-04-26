package com.portal.RentalApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;

import com.portal.RentalApp.dao.UserDAO;
import com.portal.RentalApp.pojo.User;

@RestController
public class LoginController {

	@Autowired
	UserDAO userDAO;
	
	@GetMapping("/login")
	public ModelAndView handleGet(HttpServletRequest request) {
		request.getSession().invalidate();
		return new ModelAndView("login");
	}
	
	@GetMapping("/logout")
	public ModelAndView logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return new ModelAndView("logout");
	}
	
	@PostMapping("/login")
	public ModelAndView handlePost(HttpServletRequest request) {

		String userName  = (String) request.getParameter("userName");
		String password = (String) request.getParameter("userPassword");
		User checkUser = userDAO.getUser(userName);
		
		System.out.println(checkUser.getName());
		if(checkUser != null && checkUser.getUserPassword().equals(password)) {
			request.getSession().setAttribute("loggedUser", userName);
			return new ModelAndView("redirect:/home");
		}
		else {
	        request.setAttribute("error", true);
			return new ModelAndView("login");
		}
	}
}
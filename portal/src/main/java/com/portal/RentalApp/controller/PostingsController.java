package com.portal.RentalApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.portal.RentalApp.dao.UserDAO;
import com.portal.RentalApp.pojo.User;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class PostingsController {

	@Autowired
	UserDAO userDAO;
	
	@GetMapping("/post")
	public ModelAndView handleGet(HttpServletRequest request) {
		
		String userName = (String) request.getSession().getAttribute("loggedUser");
		User currentUser = userDAO.getUser(userName);
		
		if(currentUser == null)
			return new ModelAndView("redirect:/listing");
		else if(currentUser.isAdmin()) {
			
			return new ModelAndView("managePosting");
		}
		else {
			
			return new ModelAndView("redirect:/home");
		}	
	}
	
	@GetMapping("/listing")
	public ModelAndView getListings(HttpServletRequest request) {
		
		return new ModelAndView("listingsPublic");
	}
}

package com.portal.RentalApp.controller;

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
	
	@GetMapping("/login")
	public ModelAndView handleGet(HttpServletRequest request) {
//		UserDAO userdao = new UserDAO();
		return new ModelAndView("login");
	}
	
	@PostMapping("/login")
	public ModelAndView handlePost(HttpServletRequest request) {

//      request.getSession().setAttribute("user", user);
//		
//		UserDAO userdao = new UserDAO();
//		User user = new User();
//        user.setAdmin(true);
//        user.setName("User1");
//        user.setUserName("user@1");
//        user.setUserPassword("user@1");
//        
//        userdao.saveUser(user);
        
//        request.getSession().setAttribute("user", user); 
//		return "AdminHome-view.jsp";
		
//		if(true) {
//			String id  = (String) request.getParameter("userName");
//			String password = (String) request.getParameter("userPassword");
//	        request.setAttribute("userid", id);
//	        
//	        request.setAttribute("error", true);
//			return new ModelAndView("login");
//		}
		return new ModelAndView("redirect:/home");
	}
}
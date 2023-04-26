package com.portal.RentalApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.portal.RentalApp.dao.AnnouncementDAO;
import com.portal.RentalApp.dao.UserDAO;
import com.portal.RentalApp.pojo.Announcement;
import com.portal.RentalApp.pojo.User;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class HomeController {
	
	@Autowired
	UserDAO userDAO;
	
	@Autowired
	AnnouncementDAO announcementDAO;
	
	@GetMapping("/home")
	public ModelAndView handleGet(HttpServletRequest request) {
		String userName = (String) request.getSession().getAttribute("loggedUser");
		User currentUser = userDAO.getUser(userName);
		
		if(currentUser == null)
			return new ModelAndView("redirect:/home");
		else if(currentUser.isAdmin()) {
			return getAdminHome(request);
		}
		else {
			return getUserHome(request);
		}		
	}
	
	public ModelAndView getAdminHome(HttpServletRequest request) {
		String userName = (String) request.getSession().getAttribute("loggedUser");
		request.setAttribute("userName", userName);
		return new ModelAndView("adminHome");
	}
	
	public ModelAndView getUserHome(HttpServletRequest request) {
		String userName = (String) request.getSession().getAttribute("loggedUser");
		request.setAttribute("userName", userName);
		
		List<Announcement> announcements = announcementDAO.getAnnouncements();
		request.setAttribute("announcements", announcements);
		return new ModelAndView("userHome");
	}
}

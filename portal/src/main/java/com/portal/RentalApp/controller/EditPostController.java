package com.portal.RentalApp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class EditPostController {
	@GetMapping({"/post?action=create", "/post?action=edit"})
	public ModelAndView handleGet(HttpServletRequest request) {
		
		String action = request.getParameter("action");
		String postId = request.getParameter("postId");
		boolean isCreate = false;
		if(action.equalsIgnoreCase("create") || postId == null) {
			isCreate = true;
		}
		else {
			isCreate = false;
			
			
		}
		request.setAttribute("isCreate",isCreate);
		return new ModelAndView("editPosting");
	}
	
	@PostMapping("/post?action=edit")
	public ModelAndView handlePost(HttpServletRequest request) {

//		contactDao.delete(contact);
		return new ModelAndView("editPosting");
	}
}

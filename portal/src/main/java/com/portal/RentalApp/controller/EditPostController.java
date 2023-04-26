package com.portal.RentalApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.portal.RentalApp.dao.PostingDAO;
import com.portal.RentalApp.dao.UserDAO;
import com.portal.RentalApp.pojo.User;
import com.portal.RentalApp.pojo.Posting;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class EditPostController {

	@Autowired
	UserDAO userDAO;
	@Autowired
	PostingDAO postingDAO;

	@GetMapping("/editpost")
	public ModelAndView handleGet(HttpServletRequest request) {
		
		String action = request.getParameter("action");
		String postId = request.getParameter("postid");
		boolean isCreate = false;
		if(action.equalsIgnoreCase("create") || postId == null) {
			isCreate = true;
		}
		else {
			isCreate = false;
			Posting post = postingDAO.getPosting(Integer.parseInt(postId));
			request.setAttribute("postid", postId);
			request.setAttribute("name", post.getName());
			request.setAttribute("description", post.getDescription());
			request.setAttribute("address", post.getAddress());
			request.setAttribute("pincode", post.getPincode());
			request.setAttribute("cost", post.getCost());
			request.setAttribute("isAvailable", post.isAvailable());
		}
		request.setAttribute("isCreate",isCreate);
		return new ModelAndView("editPosting");
	}
	
	@PostMapping("/editpost")
	public ModelAndView postEditPost(HttpServletRequest request, @RequestParam("image") MultipartFile file) {
		
		
		String postid  = (String) request.getParameter("postid");
		String name  = (String) request.getParameter("name");
		String description = (String) request.getParameter("description");
		String address = (String) request.getParameter("address");
		String pincode = (String) request.getParameter("pincode");
		String isAvailable = (String) request.getParameter("priority");
		
		double cost = 0;
		if(request.getParameter("cost") != null)
			cost = Double.parseDouble(request.getParameter("cost"));
		

		String userName = (String) request.getSession().getAttribute("loggedUser");
		User currentUser = userDAO.getUser(userName);
		
		Posting adminPosting = new Posting();
		System.out.println(postid);
		if(postid != null && postid.length() > 0)
			adminPosting = postingDAO.getPosting(Integer.parseInt(postid));

		adminPosting.setName(name);
		adminPosting.setDescription(description);
		adminPosting.setAddress(address);
		adminPosting.setPincode(pincode);
		adminPosting.setCost(cost);
		adminPosting.setUser(currentUser);
		adminPosting.setAvailable(true);
		if(isAvailable == "isAvailable")
			adminPosting.setAvailable(false);
		
		postingDAO.savePosting(adminPosting);
		
		if(postid != null)
			return new ModelAndView("redirect:/viewpost?key=" + postid);
		
		return new ModelAndView("redirect:/post");
	}
}

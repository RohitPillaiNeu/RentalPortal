package com.portal.RentalApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.portal.RentalApp.dao.EnquiryDAO;
import com.portal.RentalApp.dao.PostingDAO;
import com.portal.RentalApp.dao.UserDAO;
import com.portal.RentalApp.pojo.User;
import com.portal.RentalApp.pojo.Enquiry;
import com.portal.RentalApp.pojo.Posting;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class PostingsController {

	@Autowired
	UserDAO userDAO;
	@Autowired
	PostingDAO postingDAO;
	@Autowired
	EnquiryDAO enquiryDAO;
	
	@GetMapping("/post")
	public ModelAndView handleGet(HttpServletRequest request) {
		
		String userName = (String) request.getSession().getAttribute("loggedUser");
		User currentUser = userDAO.getUser(userName);
		
		if(currentUser == null)
			return new ModelAndView("redirect:/listing");
		else if(currentUser.isAdmin()) {
			int userid = currentUser.getUserId();
			List<Posting> postings = postingDAO.getUserPosting(userid);
	        request.setAttribute("postings", postings);
			return new ModelAndView("managePosting");
		}
		else {
			
			return new ModelAndView("redirect:/home");
		}		
	}
	
	@GetMapping("/viewpost*")
	public ModelAndView getAdminViewPost(HttpServletRequest request) {
		
		String postid  = request.getParameter("key");
		if(postid != null)
		{
			Posting posting = postingDAO.getPosting(Integer.parseInt(postid));
	        request.setAttribute("posting", posting);
	        
	        List<Enquiry> enquiries = enquiryDAO.getEnquiries(Integer.parseInt(postid));
	        request.setAttribute("enquiries", enquiries);
		}

        request.setAttribute("key", postid);
		return new ModelAndView("adminViewPosting");
	}
	
	
	@PostMapping("/viewpost?*toggle=*")
	public ModelAndView ToggleAvailability(HttpServletRequest request) {
		
		String postid  = request.getParameter("key");
		if(postid != null)
		{
			Posting posting = postingDAO.getPosting(Integer.parseInt(postid));
			posting.setAvailable((!posting.isAvailable()));
			postingDAO.update(posting);
		}
		
		return new ModelAndView("redirect:/viewpost?key=" + postid);
	}
	
	@PostMapping("/viewpost?key=*&delete=*")
	public ModelAndView DeletePost(HttpServletRequest request) {
		
		String postid  = request.getParameter("key");
		if(postid != null)
		{
			Posting posting = postingDAO.getPosting(Integer.parseInt(postid));
			postingDAO.delete(posting);
		}
		return new ModelAndView("redirect:/post");
	}
}

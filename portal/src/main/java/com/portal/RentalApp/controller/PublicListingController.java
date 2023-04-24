package com.portal.RentalApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.portal.RentalApp.dao.EnquiryDAO;
import com.portal.RentalApp.dao.PostingDAO;
import com.portal.RentalApp.pojo.Enquiry;
import com.portal.RentalApp.pojo.Posting;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class PublicListingController {
	@Autowired
	PostingDAO postingDAO;
	@Autowired
	EnquiryDAO enquiryDAO;
	
	
	@GetMapping("/listings")
	public ModelAndView getListings(HttpServletRequest request) {

		List<Posting> postings = postingDAO.getPosting();
        request.setAttribute("postings", postings);
		return new ModelAndView("listingsPublic");
	}
	
	@GetMapping("/viewListing")
	public ModelAndView getIndividualListing(HttpServletRequest request) {

		String postid  = request.getParameter("key");
		if(postid != null)
		{
			Posting posting = postingDAO.getPosting(Integer.parseInt(postid));
	        request.setAttribute("posting", posting);
		}
		return new ModelAndView("publicViewPosting");
	}
	
	@PostMapping("/enquiry")
	public ModelAndView postEnquiry(HttpServletRequest request) {

		int postingid  = Integer.parseInt(request.getParameter("postingid"));
		String name  = (String) request.getParameter("name");
		long phoneno = Long.parseLong(request.getParameter("phoneNo"));
		String email = (String) request.getParameter("email");
		String comment = (String) request.getParameter("comment");
		
		Posting enquiryPost = postingDAO.getPosting(postingid);
		
		Enquiry newEnquiry = new Enquiry();
		newEnquiry.setName(name);
		newEnquiry.setPhoneNo(phoneno);
		newEnquiry.setEmail(email);
		newEnquiry.setComment(comment);
		newEnquiry.setPosting(enquiryPost);
		
		enquiryDAO.saveEnquiry(newEnquiry);
		
		return new ModelAndView("enquirySuccess");
	}
	
}

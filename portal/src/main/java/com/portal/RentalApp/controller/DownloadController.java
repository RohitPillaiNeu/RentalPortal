package com.portal.RentalApp.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.portal.RentalApp.dao.EnquiryDAO;
import com.portal.RentalApp.dao.PostingDAO;
import com.portal.RentalApp.dao.UserDAO;
import com.portal.RentalApp.pojo.Enquiry;
import com.portal.RentalApp.pojo.Posting;

import com.portal.RentalApp.util.XlsUtil;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
public class DownloadController {
	@Autowired
	EnquiryDAO enquiryDAO;
	@GetMapping("/exportenquiry")
	public ModelAndView ExportEnquiries(HttpServletRequest request, HttpServletResponse response) throws IOException {	
		String postid  = request.getParameter("key");
		List<Enquiry> enquiries = enquiryDAO.getEnquiries(Integer.parseInt(postid));
      
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");  
		LocalDateTime now = LocalDateTime.now();  
		String currentDateTime = dtf.format(now);
		
		response.setContentType("application/octet-stream");
		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=enquiries_" + postid + "_" + currentDateTime + ".xlsx";
		response.setHeader(headerKey, headerValue);
		
		XlsUtil excelExporter = new XlsUtil(enquiries);
		excelExporter.export(response);
		
		request.setAttribute("key", postid);
		return new ModelAndView("redirect:/exportsuccess");
	}
	
	@GetMapping("/exportsuccess")
	public ModelAndView ExportSuccess(HttpServletRequest request) { 
		String postid  = request.getParameter("key");
		request.setAttribute("key", postid);
		return new ModelAndView("exportSuccess");
	}
}

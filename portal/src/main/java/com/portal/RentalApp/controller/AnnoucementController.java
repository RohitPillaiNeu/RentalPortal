package com.portal.RentalApp.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.portal.RentalApp.dao.AnnouncementDAO;
import com.portal.RentalApp.dao.UserDAO;
import com.portal.RentalApp.pojo.Announcement;
import com.portal.RentalApp.pojo.Posting;
import com.portal.RentalApp.pojo.User;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class AnnoucementController {

	@Autowired
	UserDAO userDAO;

	@Autowired
	AnnouncementDAO announcementDAO;
	
	@Value("${image.directory}")
	private String imageDirectory;
	
	@GetMapping("/announcement")
	public ModelAndView CreateAnnouncement() {
        return new ModelAndView("createAnnouncement");
	}
	
	@PostMapping("/announcement")
	public ModelAndView SaveAnnouncement(@ModelAttribute("announcement") Announcement announcement, 
            @RequestParam("imageFile") MultipartFile imageFile, HttpServletRequest request) throws IOException {
		
        // Save image to file system
        String imageName = imageFile.getOriginalFilename();
        announcement.setImageName(imageName);
        File image = new File(imageDirectory + imageName);
        imageFile.transferTo(image);
        
        announcement.setDateCreated(getCurrentDate());
        
		String userName = (String) request.getSession().getAttribute("loggedUser");
		User currentUser = userDAO.getUser(userName);
        announcement.setUser(currentUser);
        
        announcementDAO.saveAnnouncement(announcement);
        
        return new ModelAndView("aAnnouncementSuccess");
    }
	
	public String getCurrentDate() {
		try {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");  
			LocalDateTime now = LocalDateTime.now();  
			return dtf.format(now);
		}
		catch (Exception e) {
			return "";
		}
	}
}

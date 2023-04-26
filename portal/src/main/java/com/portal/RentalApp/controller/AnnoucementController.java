package com.portal.RentalApp.controller;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
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
	
//	@PostMapping("/announcement")
//	public ModelAndView SaveAnnouncement(@ModelAttribute("announcement") Announcement announcement, 
//            @RequestParam("imageFile") MultipartFile imageFile, HttpServletRequest request) throws IOException {
//		
//        // Save image to file system
//        String imageName = imageFile.getOriginalFilename();
//        announcement.setImageName(imageName);
//        File image = new File(imageDirectory + imageName);
//        imageFile.transferTo(image);
//        
//        announcement.setDateCreated(getCurrentDate());
//        
//		String userName = (String) request.getSession().getAttribute("loggedUser");
//		User currentUser = userDAO.getUser(userName);
//        announcement.setUser(currentUser);
//        
//        announcementDAO.saveAnnouncement(announcement);
//        
//        return new ModelAndView("announcementSuccess");
//    }
	
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
	
	@PostMapping("/creataAnnouncement")
    public ModelAndView handleFileUpload(@RequestParam("image") MultipartFile file, HttpServletRequest request) throws IOException {
		
		Announcement announcement = new Announcement();
//		// Save image to file system
//        if (file != null && !file.isEmpty()) { 
////            String imageName = file.getOriginalFilename();
////            announcement.setImageName(imageName);
////            File image = new File(imageDirectory + imageName);
//            
////            file.transferTo(image);
//        	
//        	String fileName = StringUtils.cleanPath(file.getOriginalFilename());
//        	announcement.setImageName(fileName);
//     
//            String uploadDir = "user-photos/";
////            String uploadDir = imageDirectory + "images";
//
//            System.out.println(uploadDir);
//            saveFile(uploadDir, fileName, file);
//        }
        announcement.setDateCreated(getCurrentDate());
		String userName = (String) request.getSession().getAttribute("loggedUser");
		User currentUser = userDAO.getUser(userName);
        announcement.setUser(currentUser);
        announcement.setName(request.getParameter("title"));
        announcement.setBody(request.getParameter("body"));
        announcement.setDateCreated(getCurrentDate());
        
        announcementDAO.saveAnnouncement(announcement);
        
        return new ModelAndView("announcementSuccess");
    }
//	
//	public void saveFile(String uploadDir, String fileName,
//            MultipartFile multipartFile) throws IOException {
//        Path uploadPath = Paths.get(uploadDir);
//
//        if (!Files.exists(uploadPath)) {
//            Files.createDirectories(uploadPath);
//        }
//         
//        try (InputStream inputStream = multipartFile.getInputStream()) {
//            Path filePath = uploadPath.resolve(fileName);
//            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
//            System.out.println(filePath);
//        } catch (IOException ioe) {        
//            throw new IOException("Could not save image file: " + fileName, ioe);
//        }      
//    }
}

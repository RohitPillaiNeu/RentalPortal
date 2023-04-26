package com.portal.RentalApp.controller;


import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component	
public class SessionInterceptor implements HandlerInterceptor {
	
	private List<String> sessionlessPages = Arrays.asList("login", "logout", "listings", "viewlisting", "enquiry");
	@Override
	   public boolean preHandle
	      (HttpServletRequest request, HttpServletResponse response, Object handler) 
	      throws Exception {
	      
		String requestURL = request.getRequestURL().toString();
		String pageName = requestURL.substring(requestURL.lastIndexOf("/") + 1);
		System.out.println("Pre Handle method is Calling for : " + requestURL);
//		System.out.println(pageName);

		String userName = (String) request.getSession().getAttribute("loggedUser");
		if(!sessionlessPages.contains(pageName.toLowerCase())) {
			if(userName == null || userName.length() == 0)
				response.sendRedirect("login");
		}
		return true;
	   }
	@Override
	   public void postHandle(
	      HttpServletRequest request, HttpServletResponse response, Object handler, 
	      ModelAndView modelAndView) throws Exception {}
	   
    @Override
	   public void afterCompletion(HttpServletRequest request, HttpServletResponse response, 
	      Object handler, Exception exception) throws Exception {}
}

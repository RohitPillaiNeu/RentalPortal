package com.portal.RentalApp.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.portal.RentalApp.dao.TicketDAO;
import com.portal.RentalApp.dao.UserDAO;
import com.portal.RentalApp.pojo.User;
import com.portal.RentalApp.pojo.Ticket;
import com.portal.RentalApp.pojo.TicketConversation;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class TicketController {

	@Autowired
	UserDAO userDAO;

	@Autowired
	TicketDAO ticketDAO;
	
	@GetMapping("/ticket")
	public ModelAndView handleGet(HttpServletRequest request) {
		String userName = (String) request.getSession().getAttribute("loggedUser");
		User currentUser = userDAO.getUser(userName);
		
		if(currentUser == null)
			return new ModelAndView("redirect:/home");
		else if(currentUser.isAdmin()) {
			return getAdminTicket(request, currentUser);
		}
		else {
			return getUserTicket(request, currentUser);
		}		
	}
	
	public ModelAndView getUserTicket(HttpServletRequest request, User currentUser) {
		String userName = (String) request.getSession().getAttribute("loggedUser");
		int userId = userDAO.getUser(userName).getUserId();
		
		List<Ticket> openTickets = ticketDAO.getUserTickets(userId, false);
		List<Ticket> closedTickets = ticketDAO.getUserTickets(userId, true);
        request.setAttribute("openTickets", openTickets);
        request.setAttribute("closedTickets", closedTickets);
		
		return new ModelAndView("userTicket");
	}
	
	public ModelAndView getAdminTicket(HttpServletRequest request, User currentUser) {
		

		List<Ticket> openTickets = ticketDAO.getUserTickets(0, false);
		List<Ticket> closedTickets = ticketDAO.getUserTickets(0, true);
        request.setAttribute("openTickets", openTickets);
        request.setAttribute("closedTickets", closedTickets);
		return new ModelAndView("adminTicket");
	}
	
	@GetMapping("/ticketCreate")
	public ModelAndView createTicket(HttpServletRequest request) {
		return new ModelAndView("createTicket");
	}
	
	@PostMapping("/ticketCreate")
	public ModelAndView submitTicket(HttpServletRequest request) {
		String userName = (String) request.getSession().getAttribute("loggedUser");
		User currentUser = userDAO.getUser(userName);
		
		Ticket ticket = new Ticket();
		ticket.setTitle(request.getParameter("title"));
		ticket.setDescription(request.getParameter("description"));
		ticket.setPriority(Integer.parseInt(request.getParameter("priority")));
		ticket.setResolved(false);
		ticket.setCreateDate(getCurrentDate());
		ticket.setUser(currentUser);
		
		ticketDAO.saveTicket(ticket);

		return new ModelAndView("ticketSuccess");
	}
	
	@GetMapping("/viewticket")
	public ModelAndView ViewTicket(HttpServletRequest request) {
		String userName = (String) request.getSession().getAttribute("loggedUser");
		User currentUser = userDAO.getUser(userName);
		
		// Get ticket
		int ticketid  = Integer.parseInt(request.getParameter("key"));
		Ticket ticket = ticketDAO.getUserTicket(ticketid);
		
		// Get its conversations
		List<TicketConversation> conversations = ticketDAO.getTicketConversation(ticketid);
		
        request.setAttribute("ticket", ticket);
        request.setAttribute("isAdmin", currentUser.isAdmin());
        request.setAttribute("conversations", conversations);

		return new ModelAndView("viewTicket");
	}
	
	@GetMapping("/ticketreopen")
	public ModelAndView ReopenTiccket(HttpServletRequest request) {
		Ticket ticket = ticketDAO.getUserTicket(Integer.parseInt(request.getParameter("key"))); 
		ticket.setResolved(false);
		ticket.setResolvedDate(null);
		ticketDAO.saveTicket(ticket);
		return new ModelAndView("redirect:/viewticket?key=" + ticket.getTicketid());
	}
	
	@GetMapping("/ticketresolve")
	public ModelAndView ResolveTicket(HttpServletRequest request) {
		Ticket ticket = ticketDAO.getUserTicket(Integer.parseInt(request.getParameter("key"))); 
		ticket.setResolved(true);
		ticket.setResolvedDate(getCurrentDate());
		ticketDAO.saveTicket(ticket);
		return new ModelAndView("redirect:/viewticket?key=" + ticket.getTicketid());
	}
	
	@PostMapping("/ticketcomment")
	public ModelAndView SendMessage(HttpServletRequest request) {
		String userName = (String) request.getSession().getAttribute("loggedUser");
		
		Ticket ticket = ticketDAO.getUserTicket(Integer.parseInt(request.getParameter("ticketid"))); 
		TicketConversation conversation = new TicketConversation();
		conversation.setDate(getCurrentDate());
		conversation.setTime(getCurrentTime());
		conversation.setMessage(request.getParameter("comment"));
		conversation.setSender(userDAO.getUser(userName));
		conversation.setTicket(ticket);

		ticketDAO.saveConversation(conversation);
		return new ModelAndView("redirect:/viewticket?key=" + ticket.getTicketid());
	}
	
	public String getCurrentTime() {
		try {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss"); 
			LocalDateTime now = LocalDateTime.now();  
			return dtf.format(now);
		}
		catch (Exception e) {
			return "";
		} 
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

package com.portal.RentalApp.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.stereotype.Component;

import com.portal.RentalApp.pojo.Enquiry;
import com.portal.RentalApp.pojo.Posting;
import com.portal.RentalApp.pojo.Ticket;
import com.portal.RentalApp.pojo.TicketConversation;

@Component
public class TicketDAO extends DAO{
	public void saveTicket(Ticket ticket) {
        try {
        	begin(); //inherited from super class DAO
            getSession().save(ticket);
            commit();
        } catch(Exception e) {
			rollback();
            System.out.println("Exception: " + e.getMessage());
        }
    }
	
	public List<Ticket> getUserTickets(int userid, boolean isResolved) {
		try {
			Query<Ticket> query = getSession().createQuery("SELECT t FROM Ticket t WHERE t.user.id = :userId AND t.isResolved = :isResolved", Ticket.class);
			
			if(userid == 0 )
			{
				// admin login
				query = getSession().createQuery("SELECT t FROM Ticket t WHERE t.isResolved = :isResolved", Ticket.class);
				query.setParameter("isResolved", isResolved);
			}
			else {
				query.setParameter("userId", userid);
				query.setParameter("isResolved", isResolved);
			}
			
			List<Ticket> lisTickets = query.getResultList();
			return lisTickets;
		} catch (HibernateException e) {
			rollback();
            System.out.println("Exception: " + e.getMessage());
		}
		return null;
	}
	
	public Ticket getUserTicket(int ticketid) {
		try {
			Ticket ticket = (Ticket) getSession().get(Ticket.class, ticketid);
			return ticket;
		} catch (HibernateException e) {
			rollback();
            System.out.println("Exception: " + e.getMessage());
		}
		return null;
	}
	
	public List<TicketConversation> getTicketConversation(int ticketid) {
		try {
			String hql = "from TicketConversation where ticket.ticketid = :ticketid";
			Query<TicketConversation> query = getSession().createQuery(hql, TicketConversation.class);
			query.setParameter("ticketid", ticketid);
			List<TicketConversation> conversations = query.getResultList();
			return conversations;
		} catch (HibernateException e) {
			rollback();
            System.out.println("Exception: " + e.getMessage());
		}
		return null;
	}
	
	public void saveConversation(TicketConversation conversation) {
        try {
        	begin(); //inherited from super class DAO
            getSession().save(conversation);
            commit();
        } catch(Exception e) {
			rollback();
            System.out.println("Exception: " + e.getMessage());
        }
    }
	
	public void updateTicket(Ticket ticket) {
		try {
			begin();
			getSession().update(ticket);
			commit();
		} catch (HibernateException e) {
			rollback();
			e.printStackTrace();
		}
	}
}

package com.portal.RentalApp.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.stereotype.Component;

import com.portal.RentalApp.pojo.Announcement;
import com.portal.RentalApp.pojo.TicketConversation;

@Component
public class AnnouncementDAO extends DAO {
	public void saveAnnouncement(Announcement announcement) {
        try {
        	begin(); //inherited from super class DAO
            getSession().save(announcement);
            commit();
        } catch(Exception e) {
			rollback();
            System.out.println("Exception: " + e.getMessage());
        }
    }
	
	public List<Announcement> getAnnouncements() {
		try {
			String hql = "from Announcement";
			return getSession().createQuery(hql, Announcement.class).getResultList();
		} catch (HibernateException e) {
            System.out.println("Exception: " + e.getMessage());
		}
		return null;
	}
}

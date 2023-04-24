package com.portal.RentalApp.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.stereotype.Component;

import com.portal.RentalApp.pojo.Enquiry;
import com.portal.RentalApp.pojo.Posting;
import com.portal.RentalApp.pojo.User;

@Component
public class EnquiryDAO extends DAO {
	public void saveEnquiry(Enquiry enquiry) {
        try {
        	begin(); //inherited from super class DAO
            getSession().save(enquiry);
            commit();
        } catch(Exception e) {
			rollback();
            System.out.println("Exception: " + e.getMessage());
        }
    }
	
	public List<Enquiry> getEnquiries(int postid) {
		try {
			begin();
//			String hql = "FROM Enquiry e where e.posting.postid = :postid";
//			Query<Enquiry> query = getSession().createQuery(hql, Enquiry.class);
//			query.setParameter("postid", postid);
//			List<Enquiry> enquiries = query.getResultList();
			
		    Query<Enquiry> query = getSession().createQuery("FROM Enquiry e WHERE e.posting.postid = :postId", Enquiry.class);
		    query.setParameter("postId", postid);
		    return query.getResultList();
		} catch (HibernateException e) {
			rollback();
            System.out.println("Exception: " + e.getMessage());
		}
		return null;
	}
}

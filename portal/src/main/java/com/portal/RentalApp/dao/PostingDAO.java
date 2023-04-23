package com.portal.RentalApp.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.stereotype.Component;

import com.portal.RentalApp.pojo.Posting;
import com.portal.RentalApp.pojo.User;

@Component
public class PostingDAO extends DAO{
    public void savePosting(Posting posting) {
        try {
        	begin(); //inherited from super class DAO
            getSession().save(posting);
            commit();
        } catch(Exception e) {
			rollback();
            System.out.println("Exception: " + e.getMessage());
        }
    }
    
    public List<Posting> getUserPosting(int userId) {
		try {
//			begin();
			String hql = "FROM Posting p WHERE p.user.id = :userId";
			Query<Posting> query = getSession().createQuery(hql, Posting.class);
			query.setParameter("userId", userId);
			List<Posting> postings = query.getResultList();
//			commit();
			return postings;
		} catch (HibernateException e) {
			rollback();
            System.out.println("Exception: " + e.getMessage());
		}
		return null;
	}
    
    public List<Posting> getPosting() {
		try {
			List<Posting>  postings= getSession().createQuery("FROM Posting", Posting.class).getResultList();
			return postings;
		} catch (HibernateException e) {
			rollback();
            System.out.println("Exception: " + e.getMessage());
		}
		return null;
	}
    
    public Posting getPosting(int postId) {
		try {
			Posting posting = (Posting) getSession().get(Posting.class, postId);
			return posting;
		} catch (HibernateException e) {
			rollback();
            System.out.println("Exception: " + e.getMessage());
		}
		return null;
	}

	public void update(Posting posting) {
		try {
			begin();
			getSession().update(posting);
			commit();
		} catch (HibernateException e) {
			rollback();
			e.printStackTrace();
		}
	}

	public void delete(Posting posting) {
		try {
			begin();
			getSession().delete(posting);
			commit();
		} catch (HibernateException e) {
			rollback();
			e.printStackTrace();
		}
	}
}

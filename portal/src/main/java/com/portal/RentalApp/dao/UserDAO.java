package com.portal.RentalApp.dao;

import org.hibernate.HibernateException;
import org.springframework.stereotype.Component;

import com.portal.RentalApp.dao.DAO;
import com.portal.RentalApp.pojo.User;

@Component
public class UserDAO extends DAO {

    public void saveUser(User user) {
        try {
        	begin(); //inherited from super class DAO
            getSession().save(user);
            commit();
        } catch(Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
    
    public void deleteUser(User user) {
    	try {
            begin();
            getSession().delete(user);
            commit();
    	} catch(HibernateException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }

    public User getUser(int userid) {
        User user = getSession().get(User.class, userid);
        return user;
    }
}

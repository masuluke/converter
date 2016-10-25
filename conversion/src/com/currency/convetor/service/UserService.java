package com.currency.convetor.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.currency.convetor.util.HibernateUtil;
import com.currency.convetor.model.User;


public class UserService {
	
	
	public UserService() {}

	public boolean isUserExists(User user){
		 Session session = HibernateUtil.openSession();
		 boolean result = false;
		 Transaction tx = null;
		 try{
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("from User where email='"+user.getEmail()+"'");
			 user = (User)query.uniqueResult();
			 tx.commit();
			 if(user!=null) result = true;
		 }catch(Exception ex){
			 if(tx!=null){
				 tx.rollback();
			 }
		 }finally{
			 session.close();
		 }
		 return result;
	}
	
	public boolean register(User user){
		 Session session = HibernateUtil.openSession();
		 if(isUserExists(user))			 
		 return false;
		 
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();			 
			 session.saveOrUpdate(user);			
			 tx.commit();
		 } catch (Exception e) {
			 if (tx != null) {
				 tx.rollback();
			 }
			 e.printStackTrace();
		 } finally {
			 session.close();
		 }	
		 return true;
	}
	
	public User loginDetails(User user){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;
		 try{
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("from User where email='"+user.getEmail()+"'");
			 user = (User)query.uniqueResult();
			 tx.commit();
			
		 }catch(Exception ex){
			 if(tx!=null){
				 tx.rollback();
			 }
		 }finally{
			 session.close();
		 }
		 return user;
	}
	
	public List<User> readAllUser(){
        List<User> list = new ArrayList<User>();
        Session session = HibernateUtil.openSession();
        Transaction tx = null;        
        try {
            tx = session.getTransaction();
            tx.begin();
            list = session.createQuery("from User").list();                        
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return list;
    }

	public User getUserById(String idNumber){
		 Session session = HibernateUtil.openSession();
		 User user = null;
		 Transaction tx = null;
		 try{
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("from User where idNumber='"+idNumber+"'");
			 user = (User)query.uniqueResult();
			 tx.commit();
			
		 }catch(Exception ex){
			 if(tx!=null){
				 tx.rollback();
			 }
		 }finally{
			 session.close();
		 }
		 return user;
	}
	
	public boolean updateUser(User user){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();			 
			 session.saveOrUpdate(user);			
			 tx.commit();
		 } catch (Exception e) {
			 if (tx != null) {
				 tx.rollback();
			 }
			 e.printStackTrace();
		 } finally {
			 session.close();
		 }	
		 return true;
	}
}

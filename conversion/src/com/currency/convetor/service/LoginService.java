package com.currency.convetor.service;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.currency.convetor.model.User;
import com.currency.convetor.util.HibernateUtil;

public class LoginService {
	
	public boolean authenticateUserDetails(String email,String password) {
		boolean validstion = true;
		User user = userDetails(email);
		
		
		if (user != null && user.getEmail().equals(email) && user.getPassword().equals(password)) 
		{
			
			validstion = true;
		
		}
		else {
		
			validstion = false;
		}
		
		
		return validstion;
		
	}
	
	public User userDetails(String email){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;
		 User user = null;
		 try{
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("from User where Email='"+email+"'");
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

}

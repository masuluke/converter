package com.currency.convetor.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.currency.convetor.model.Currency;
import com.currency.convetor.util.HibernateUtil;


public class CurrencyService {
	
	
	
	public CurrencyService() {super();}

	public boolean isCurrencyExists(Currency currency){
		 Session session = HibernateUtil.openSession();
		 boolean result = false;
		 Transaction tx = null;
		 try{
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("from Currency currencyName = '"+currency.getCurrencyName()+"'");
			 currency = (Currency)query.uniqueResult();
			 tx.commit();
			 if(currency!=null) result = true;
		 }catch(Exception ex){
			 if(tx!=null){
				 tx.rollback();
			 }
		 }finally{
			 session.close();
		 }
		 return result;
	}

	public boolean addorUpdateCurrency(Currency currency){
		 Session session = HibernateUtil.openSession();
		 if(isCurrencyExists(currency))			 
		 return false;
		 
		 Transaction tx = null;	
		 try {
			 tx = session.getTransaction();
			 tx.begin();			 
			 session.saveOrUpdate(currency);			
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
	
	public Currency readCurrency(String currencyName){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;
		 Currency currency = null;
		 try{
			 tx = session.getTransaction();
			 tx.begin();
			 Query query = session.createQuery("from Currency where CurrencyName='"+currencyName+"'");
			 currency = (Currency)query.uniqueResult();
			 tx.commit();
			
		 }catch(Exception ex){
			 if(tx!=null){
				 tx.rollback();
			 }
		 }finally{
			 session.close();
		 }
		 return currency;
	}
	
    public List<Currency> readAllCurrency(){
        List<Currency> list = new ArrayList<Currency>();
        Session session = HibernateUtil.openSession();
        Transaction tx = null;        
        try {
            tx = session.getTransaction();
            tx.begin();
            list = session.createQuery("from Currency").list();                        
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
    
    public boolean defaultCurrency(){
		 Session session = HibernateUtil.openSession();
		 Transaction tx = null;	
		 
		 Currency Rand = new Currency("zar","Rand", 13.98);
		 Currency us_Dollar = new Currency("usd","US dollar",0.07);
		 
			
		 try {
			 tx = session.getTransaction();
			 tx.begin();			 
			 session.saveOrUpdate(Rand);	
			 session.saveOrUpdate(us_Dollar);	
			 
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

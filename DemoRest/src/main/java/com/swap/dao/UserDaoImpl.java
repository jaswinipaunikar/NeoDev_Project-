package com.swap.dao;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.swap.model.User;

@Transactional
@Repository(value="UserDao")
public class UserDaoImpl implements UserDao{

	@Autowired
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public boolean saveUser(User user) {
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		if(user != null)
		{
			try{
				session.save(user);
				transaction.commit();
				System.out.println("User Saved in UserDaoImpl");
				session.close();
				
			}catch(Exception e)
			{
				e.printStackTrace();
				System.out.println("Error saving user in UserDaoImpl");
				transaction.rollback();
				session.close();
				
			}
			return true;
		}else{return false;}
		
	}

	public boolean validateUser(String email,String password) {
		
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		User user=null;
		String hql="from User where email='"+email+"' and password='"+password+"'";
		
			Query query=session.createQuery(hql);			
			user=(User)query.uniqueResult();
			
			transaction.commit();			
			session.close();
		
		if(user==null)
			return false;
			else
				return true;
		
	}

}

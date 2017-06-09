package com.niit.backendproject.Backend.DAO;
import org.hibernate.SessionFactory;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.backendproject.Backend.model.Authorization;
import com.niit.backendproject.Backend.model.Customer;
import com.niit.backendproject.Backend.model.User;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

@Repository("userDAO")
	@Transactional
	public class UserDAOImpl implements UserDAO {

		@Autowired
		SessionFactory sessionFactory;
		public boolean addUser(User u) {
			Session ss=sessionFactory.getCurrentSession();
			Authorization auth=new Authorization();
			u.setUserid(u.getUname());
			auth.setUname(u.getUserid());
			auth.setRole("ROLE_USER");
			u.setActive(1);
			try{ss.persist(auth);
				ss.persist(u);
			return true;
			}
			catch(Exception e){return false;}
			
		}
		public List<User> getAllUser() {
			Session ss=sessionFactory.getCurrentSession();
			Query qu=ss.createQuery("from User");
			
			List<User> listUser=(List<User>)qu.list();
			return listUser;
		}
		public Customer getUserByCustomerName(String username) {
			
			try {
				@SuppressWarnings("rawtypes")
				Query query = sessionFactory.getCurrentSession()
						.createQuery("from Customer where username= '" + username + "'");
				Customer customer = (Customer) query.uniqueResult();

				return customer;
			} catch (HibernateException e) {
				
				e.printStackTrace();
				throw e;
			}		}
		
		

}


package com.niit.backendproject.Backend.DAO;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.backendproject.Backend.model.Customer;
import com.niit.backendproject.Backend.model.CustomerOrder;

@Repository("customerOderDAO")
@Transactional
public class CustomerOrderDAOImpl implements CustomerOrderDAO{
	

	@Autowired
	private SessionFactory sessionFactory;

	
	public boolean addCustomerOrder(CustomerOrder customerOrder) {
		try {
			Session session = sessionFactory.getCurrentSession();

			Customer customer = customerOrder.getCustomer();
			customerOrder.setBillingAddress(customer.getBillingAddress());
			customerOrder.setShippingAddress(customer.getShippingAddress());
			customerOrder.setOrderStatus("Placed");
			session.saveOrUpdate(customerOrder);
			session.saveOrUpdate(customer);
			session.saveOrUpdate(customer.getBillingAddress());
			session.saveOrUpdate(customer.getShippingAddress());

			return true;
		} catch (HibernateException e) {
			
			e.printStackTrace();
			
			throw e;
		}
	}

	public List<CustomerOrder> getAllOrders() {
		
		try {
                                            //HQL
			return sessionFactory.getCurrentSession().createQuery("FROM CustomerOrder").list();

		} catch (HibernateException e) {
			// TODO: handle exception
			e.printStackTrace();
		
			throw e;
		}
	}

	public CustomerOrder getCustomerOrderById(int id) {
		
		
		return sessionFactory.getCurrentSession().get(CustomerOrder.class, id);
	}

	
	public int changeOrderStatus(int id, String status) {
		
		
		try {

			Query query = sessionFactory.getCurrentSession()
					.createQuery("UPDATE CustomerOrder SET orderStatus = '" + status + "' where id = " + id);
			return query.executeUpdate();
		} catch (HibernateException e) {
			// TODO: handle exception
			e.printStackTrace();
			
			throw e;
		}
	
}
}


package com.niit.backendproject.Backend.DAO;

import java.io.IOException;


import java.util.List;



import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.backendproject.Backend.model.Cart;


@Repository("cartDAO")
@Transactional

public class CartDAOImpl implements CartDAO{
	
	@Autowired
	SessionFactory sessionFactory;

	

	public List<Cart> getCartList(String username) {
		try {
			Query query = sessionFactory.getCurrentSession()
					.createQuery("from Cart where username = '" + username + "' and status='NEW'");
			return query.list();
		} catch (HibernateException e) {
			throw e;
		}
	}

	public boolean save(Cart cart) {
		// TODO Auto-generated method stub
		System.out.println("cartdao save method is invoked ");
		try {
			sessionFactory.getCurrentSession().save(cart);
			return true;
		} catch (HibernateException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		}
	}

	
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().delete(getCartById(id));
			return true;
		} catch (HibernateException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		}
	}

	
	public boolean update(Cart cart) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().update(cart);
			return true;
		} catch (HibernateException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		}
	}

	
	public long getTotalAmount(String username) {
		// TODO Auto-generated method stub
		try {
			Query query = sessionFactory.getCurrentSession().createQuery(
					"SELECT SUM(price*quantity) FROM Cart where username='" + username + "' and status = 'NEW'");
			if (query.uniqueResult() == null) {
				return 0;
			} else {
				long result =  (Long) query.uniqueResult();
				return result;
			}

		} catch (HibernateException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		}
	}

	
	public Cart getCartByUsername(String username, String productname) {
		// TODO Auto-generated method stub
		try {

			Query query = sessionFactory.getCurrentSession().createQuery("from Cart WHERE username='" + username
					+ "' and product_name='" + productname + "' and status = 'NEW'");
			return (Cart) query.uniqueResult();
		} catch (HibernateException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		}
	}

	public int getQuantity(String username, String productname) {
		// TODO Auto-generated method stub
		try {

			Query query = sessionFactory.getCurrentSession().createQuery("SELECT quantity from Cart WHERE username='"
					+ username + "' and product_name='" + productname + "' and status = 'NEW'");
			return  (Integer) query.uniqueResult();
		} catch (HibernateException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		}
	}

	
	public long getNumberOfProducts(String username) {
		try {
			Query query = sessionFactory.getCurrentSession()
					.createQuery("SELECT SUM(quantity) FROM Cart where username='" + username + "' and status = 'NEW'");
			if (query.uniqueResult() == null) {
				return 0;
			} else {
				long result =  (Long) query.uniqueResult();
				return result;
			}
		} catch (HibernateException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		}
	}

	
	public Cart getCartById(int id) {
		// TODO Auto-generated method stub
		try {
			return sessionFactory.getCurrentSession().get(Cart.class, id);
		} catch (HibernateException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		}
	}

	
	public int clearCart(String username) {
		// TODO Auto-generated method stub
		try {
			/*
			 * Query query = sessionFactory.getCurrentSession()
			 * .createQuery("UPDATE Cart SET status='OLD' where username = '" +
			 * username + "'");
			 */
			Query query = sessionFactory.getCurrentSession()
					.createQuery("DELETE from Cart where username = '" + username + "'");
			return query.executeUpdate();

		} catch (HibernateException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		}
	}

	public Cart validate(int cartId) throws IOException {
		Cart cart = getCartById(cartId);
		if (cart == null) {
			throw new IOException(cartId + "");
		}
		update(cart);
		return cart;
	}

	



}
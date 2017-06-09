package com.niit.backendproject.Backend.DAO;

import java.util.List;



import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.backendproject.Backend.model.Product;

@Repository("productDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO {


	@Autowired
	SessionFactory sessionFactory;

	public boolean addProduct(Product p) {
		Session ss=sessionFactory.getCurrentSession();
		
		
		try{
			ss.persist(p);
		return true;
		}
		catch(Exception e){return false;}
			}

	public List<Product> getAllProduct() {
		Session ss=sessionFactory.getCurrentSession();
		Query qu=ss.createQuery("from Product");
		@SuppressWarnings("unchecked")
		List<Product> listProduct=(List<Product>)qu.list();
		return listProduct;
	
	}

	public List<Product> getproductbyCategory(String catId) {
		Session ss=sessionFactory.getCurrentSession();
		Query qu=ss.createQuery("from Product where catId=?");
		qu.setString(0,catId);
		List<Product> listProducts=(List<Product>)qu.list();
		return listProducts;
		
		
	}

	public Product getProductId(int id) {
	
		Session s=sessionFactory.getCurrentSession();
		Query q=s.createQuery("from Product where proId=?");
			q.setInteger(0, id);	
		
		return (Product) q.list().get(0);
		//return s.get(Product.class,name);
	}

	public Product getProductName(String name) {
		Session s=sessionFactory.getCurrentSession();
		Query q=s.createQuery("from Product where proName=?");
		q.setString(0, name);
		return (Product) q.list().get(0);
		//return s.get(Product.class,name);
	
		
	}
}


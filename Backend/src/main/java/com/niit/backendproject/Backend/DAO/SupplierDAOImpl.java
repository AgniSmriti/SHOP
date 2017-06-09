package com.niit.backendproject.Backend.DAO;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.backendproject.Backend.model.Category;
import com.niit.backendproject.Backend.model.Supplier;

@Repository("supplierDAO")
@Transactional
public class SupplierDAOImpl implements SupplierDAO {


	@Autowired
	SessionFactory sessionFactory;
	
	public boolean addSupplier(Supplier s) {
		
		Session ss=sessionFactory.getCurrentSession();
		
		s.setSupId(s.getSupName());
		
		try{ss.persist(s);
		return true;
		}
		catch(Exception e){return false;}
		
		
		
		
	}

	public List<Supplier>getAllSupplier() {
		Session ss=sessionFactory.getCurrentSession();
		
		Query qu=ss.createQuery("from Supplier");
		List<Supplier> listSupplier=(List<Supplier>)qu.list();
		return listSupplier;
	
	}

	public boolean updateSupplier(Supplier s) {
		Session ss=sessionFactory.getCurrentSession();
		
		
		try{ss.update(s);
		return true;
		}
		catch(Exception e){return false;}
		
	}

	public Supplier getSupplierById(String id) {
		Session ss=sessionFactory.getCurrentSession();
		return ss.get(Supplier.class, id);
	}

	public boolean deleteSupplier(String id) {
		Session ss=sessionFactory.getCurrentSession();
		 ss.delete(getSupplierById(id));
		 return true;       	
	}

}

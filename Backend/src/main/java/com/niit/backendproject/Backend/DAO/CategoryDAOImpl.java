package com.niit.backendproject.Backend.DAO;
import java.util.List;



import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.backendproject.Backend.model.Category;


@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {
	

		@Autowired
		SessionFactory sessionFactory;
		
		
		public boolean addCategory(Category c) {
			Session ss=sessionFactory.getCurrentSession();
			
			c.setCatId(c.getName());
			
			try{ss.persist(c);
			return true;
			}
			catch(Exception e){return false;}
			
		}
		public List<Category>getAllCategory() {
			Session ss=sessionFactory.getCurrentSession();
			
			Query qu=ss.createQuery("from Category");
			List<Category> listCategory=(List<Category>)qu.list();
			return listCategory;
		}
		
		
		
	public boolean updateCategory(Category c) {
			Session ss=sessionFactory.getCurrentSession();
			
		
			try{ss.update(c);
			return true;
			}
			catch(Exception e){return false;}
		}
		
		
		public Category getCategoryById(String id) {
			Session ss=sessionFactory.getCurrentSession();
			return ss.get(Category.class, id);
		}

		
		public boolean deleteCategory(String id) {
			Session ss=sessionFactory.getCurrentSession();
	 ss.delete(getCategoryById(id));
	 return true;       
		
		}



}
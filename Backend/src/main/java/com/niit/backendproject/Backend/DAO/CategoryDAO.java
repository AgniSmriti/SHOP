package com.niit.backendproject.Backend.DAO;
import java.util.List;

import org.springframework.stereotype.Service;

import com.niit.backendproject.Backend.model.Category;

@Service
public interface CategoryDAO {

	boolean addCategory(Category c);
	boolean updateCategory(Category c);
    public Category getCategoryById(String id);	
	boolean deleteCategory(String id);

    List<Category>getAllCategory();
	
		
	}


package com.niit.backendproject.Backend.DAO;

import java.util.List;

import org.springframework.stereotype.Service;

import com.niit.backendproject.Backend.model.Category;
import com.niit.backendproject.Backend.model.Product;

public interface ProductDAO {

	boolean addProduct(Product p);
	
	
	List<Product>getAllProduct();
	List<Product>getproductbyCategory(String catid);


	Product getProductId(int id);	
	public Product getProductName(String name); 
	
	
	
}

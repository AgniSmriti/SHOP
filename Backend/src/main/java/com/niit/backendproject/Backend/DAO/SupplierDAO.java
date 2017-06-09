package com.niit.backendproject.Backend.DAO;

import java.util.List;

import org.springframework.stereotype.Service;

import com.niit.backendproject.Backend.model.Category;
import com.niit.backendproject.Backend.model.Supplier;

@Service
public interface SupplierDAO {
	boolean addSupplier(Supplier s);
	
	boolean updateSupplier(Supplier s);
    public  Supplier getSupplierById(String id);	
	boolean deleteSupplier(String id);

	List<Supplier>getAllSupplier();
}

package com.niit.backendproject.Backend.model;

import java.util.Set;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Supplier {
	
	@Id
    
	private String supId;
	

	@NotEmpty(message="name can't be null")
	@Column(unique=true)
	private String supName; 
    
	@OneToMany(mappedBy = "supplier", fetch=FetchType.EAGER,cascade=CascadeType.REMOVE)
    public Set<Product> product;
	
public Set<Product> getProduct() {
		return product;
	}

	public void setProduct(Set<Product> product) {
		this.product = product;
	}

public String getSupId() {
		return supId;
	}

	public void setSupId(String supId) {
		this.supId = supId;
	}

	public String getSupName() {
		return supName;
	}

	public void setSupName(String supName) {
		this.supName = supName;
	}
	
}

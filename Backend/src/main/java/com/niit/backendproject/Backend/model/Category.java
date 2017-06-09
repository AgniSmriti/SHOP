package com.niit.backendproject.Backend.model; 



import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.NotEmpty;
 
 
@Entity
public class Category {
	
   	@Id
   	
   private String catId;
    

    @OneToMany(mappedBy = "category", fetch=FetchType.EAGER,cascade=CascadeType.REMOVE)
    
    public Set<Product> product;
   	
    @Column(unique=true)
    @NotEmpty(message="name can't be null")
	private String name;
    
    private String catDesc;
    
   	public String getCatDesc() {
		return catDesc;
	}

	public void setCatDesc(String catDesc) {
		this.catDesc = catDesc;
	}

	public String getCatId() {
		return catId;
	}

	public void setCatId(String catId) {
		this.catId = catId;
	}

	public Set<Product> getProduct() {
		return product;
	}

	public void setProduct(Set<Product> product) {
		this.product = product;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
 
	    
    

    
    
    
   	 
	}
 
    

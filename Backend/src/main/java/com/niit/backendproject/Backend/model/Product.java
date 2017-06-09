package com.niit.backendproject.Backend.model; 

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
@Component 
@Entity
@Table(name = "PRODUCT")
public class Product  implements Serializable {
    
	private static final long serialVersionUID = 6620547542099192995L;


	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="generator")
	@SequenceGenerator(name="generator",sequenceName="myseq3",allocationSize=1)
    private int proId;
	
	@Column(unique=true)
    private String proName;
    
	private String descp;
	private int qty;
	private Long price;
	
    public String getDescp() {
		return descp;
	}







	public void setDescp(String descp) {
		this.descp = descp;
	}







	public int getQty() {
		return qty;
	}







	public void setQty(int qty) {
		this.qty = qty;
	}







	





	public void setPrice(Long price) {
		this.price = price;
	}







	private String catId;
    private String supId;
    
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "catId",insertable=false,nullable=false,updatable=false)
    private Category category;
    
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "supId",insertable=false,nullable=false,updatable=false)
    private Supplier supplier;
    
    @Transient
     private MultipartFile image ;



	public int getProId() {
		return proId;
	}

	





	public String getProName() {
		return proName;
	}

	public void setProId(int proId) {
		this.proId = proId;
	}



	public void setProName(String proName) {
		this.proName = proName;
	}

	public String getCatId() {
		return catId;
	}

	


	public void setCatId(String catId) {
		this.catId = catId;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}







	public String getSupId() {
		return supId;
	}







	public void setSupId(String supId) {
		this.supId = supId;
	}







	public Supplier getSupplier() {
		return supplier;
	}







	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}







	public MultipartFile getImage() {
		return image;
	}







	public void setImage(MultipartFile image) {
		this.image = image;
	}







	public Long getPrice() {
			return price;
	}






	






    
    
 
}
package com.niit.backendproject.Backend.model;



import java.io.Serializable;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "CUSER")
public class User implements Serializable  {


@Id
@Column

private String userid;

private String upassword;

@NotEmpty(message="name can't be null")
@Column(unique=true)
private String Uname;

private int active;

@OneToOne

@JoinColumn(name = "id")
	
private Customer customer;



@Column
public String getUpassword() {
	return upassword;
}
public void setUpassword(String upassword) {
	this.upassword = upassword;
}
public Customer getCustomer() {
	return customer;
}
public void setCustomer(Customer customer) {
	this.customer = customer;
}
public String getUname() {
	return Uname;
}




public void setUname(String uname) {
	Uname = uname;
}
public String getUserid() {
	return userid;
}
public void setUserid(String userid) {
	this.userid = userid;
}
public int getActive() {
	return active;
}
public void setActive(int active) {
	this.active = active;
}


	
}


package com.ofs.model;

import java.sql.Date;

public class User {

	 private int id;	
	 private String name;
	 private Date dateOfBirth;
	 private String userName;
	 private String password;
	 private String gender;
	 private String address;
	 private String city;
	 private int    pincode;
	 private String emailId;
	 private String userType;
	 private String status;
	 
	 public User(String name, Date dateofBirth, String username, String password, 
			 String gender, String address, String city, int pincode, String usertype,	String emailid ) {
 
		this.name = name;
		this.dateOfBirth = dateofBirth;
		this.userName = username;
		this.password = password;
		this.gender = gender;
		this.address = address;   
		this.city = city;
		this.pincode = pincode;
		this.userType = usertype;
		this.emailId =emailid;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDateofbirth() {
		return dateOfBirth;
	}

	public void setDateofbirth(Date dateofbirth) {
		this.dateOfBirth = dateofbirth;
	}

	public String getUsername() {
		return userName;
	}
	
	public void setUsername(String username) {
		this.userName = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public String getEmailid() {
		return emailId;
	}


	public void setEmailid(String emailid) {
		this.emailId = emailid;
	}

	public String getUsertype() {
		return userType;
	}

	public void setUsertype(String usertype) {
		this.userType = usertype;
	}

	public String getStatus() {
		 return status;
	}
	 
	public void setStatus (String status) {
		 this.status=status;
	}
	
	public User() {	}

	public User(String username, String password) {

	}

	public User(String password, String address, String city, int pincode, int id) {
		this.password = password;
		this.address = address;   
		this.city = city;
		this.pincode = pincode;
		this.id = id;
	 }

	
}

package com.ofs.model;

import java.sql.Blob;

public class Product {

	private int pId;
	private String productName;
	private int productPrice;
	private int productQty;
	private int productDiscount;
	private Blob productImage;
	public Category cId;

	public Product(String 	productName, int productPrice, int productQty, int productDiscount, Category cId) {
		this.productName=productName;
		this.productPrice=productPrice;
		this.productQty=productQty;
		this.productDiscount=productDiscount;
		this.cId=cId;
		
	}

	public Product() {
		
	}
	
	public int getPId() {
		return pId;
	}

	public void setPId(int pId) {
		this.pId = pId;
	}


	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public int getProductQty() {
		return productQty;
	}

	public void setProductQty(int productQty) {
		this.productQty = productQty;
	}

	public int getProductDiscount() {
		return productDiscount;
	}

	public void setProductDiscount(int productDiscount) {
		this.productDiscount = productDiscount;
	}

	public Blob getProductImage(){
		return productImage;
	}
	
	public void setProductImage(Blob productImage){
		this.productImage=productImage;
	}
}

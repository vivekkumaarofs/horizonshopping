package com.ofs.model;

public class Product {

	private int pId;
	private String productName;
	private int productPrice;
	private int productQty;
	private int productDiscount;

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

}

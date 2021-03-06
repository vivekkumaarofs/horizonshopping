package com.ofs.model;

import java.sql.Timestamp;

public class Product {

	User user = new User();
	
	private int pId;
	private String productName;
	private int productPrice;
	private int productQty;
	private int productDiscount;
	private double discountPrice;
	public int cId;
	
	private String CategoryName;
	private int mpId;
	private String parentCategoryName;
	private byte[] ProductImage;
	private int cartId;
	private int productCount;
	private int totalAmount;
	private Timestamp OrderDate;

	public int id = user.getId();
	public String userName = user.getName();
	public String gender = user.getGender();
	public String address = user.getAddress();
	public String city = user.getCity();
	public int pincode = user.getPincode();

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
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

	public void setDiscountPrice(double discountPrice){
		this.discountPrice = discountPrice;
	}
	
	public double getDiscountprice() {
		return discountPrice;
	}

	public int getProductDiscount() {
		return productDiscount;
	}

	public void setProductDiscount(int productDiscount) {
		this.productDiscount = productDiscount;
	}

	public Product(){}
	
	/** Categoroy **/
	public int getcId() {
		return cId;
	}

	public void setcId(int cId) {
		this.cId=cId;
	}

	public String getCategoryName() {
		return CategoryName;
	}
	
	public void setCategoryName(String categoryName) {
		CategoryName = categoryName;
	}
	
	/** Parent Categoroy **/	
	public int getmpId() {
		return mpId;
	}
	
	public void setmpId(int mpId) {
		this.mpId = mpId;
	}
	
	public String getParentCategoryName() {
		return parentCategoryName;
	}
	
	public void setParentCategoryName(String parentCategoryName) {
		this.parentCategoryName = parentCategoryName;
	}

	public byte[] getProductImage() {
		return ProductImage;
	}

	public void setProductImage(byte[] productImage){
		this.ProductImage=productImage;
	}

	/**shopping cart **/
	public int getcartId() {
		return cartId;
	}

	public void setcartId(int cartId) {
		this.cartId = cartId;
	}

	public int getProductCount() {
		return productCount;
	}

	public void setProductCount(int productCount) {
		this.productCount = productCount;
	}

	public int getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Timestamp getOrderDate() {
		return OrderDate;
	}
	
	public void setOrderDate(Timestamp OrderDate){
		this.OrderDate=OrderDate;
	}
	
}

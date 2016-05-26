package com.ofs.model;

import java.io.ByteArrayInputStream;
import java.sql.Blob;


public class Product {

	private int pId;
	private String productName;
	private int productPrice;
	private int productQty;
	private int productDiscount;
//	private byte[] byteArray;
	public int cId;
	private String CategoryName;
	private int mpId;
	private String parentCategoryName;
	private byte[] ProductImage;

//	ByteArrayInputStream productImage = new ByteArrayInputStream(byteArray);

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

//	public ByteArrayInputStream getProductImage(){
//		return productImage;
//	}
//	
//	public void setProductImage(ByteArrayInputStream productImage){
//		this.productImage=productImage;
//	}

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
	
//	private Blob productImage;
//	public void setbProductImage(Blob productImage) {
//		this.productImage = productImage;
//	}

}

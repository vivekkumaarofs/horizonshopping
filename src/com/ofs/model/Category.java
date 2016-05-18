package com.ofs.model;

public class Category {

	private int cId;
	private String CategoryName;
	private int mpId;
	private String parentCategoryName;

	public int getcID() {
		return cId;
	}
	
	public void setcID(int cID) {
		this.cId = cID;
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

}

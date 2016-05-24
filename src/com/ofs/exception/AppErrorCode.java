package com.ofs.exception;


public enum AppErrorCode {
	
	INVALID_NAME(101,"Please Enter valid Name"),
	INVALID_GENDER(102,"Please Enter gender"),
	INVALID_DATE_OF_BIRTH(103,"Please enter Date of Birth"), 
	INVALID_USER_NAME(104,"Please Enter Username"), 
	INVALID_PASSWORD(105,"Please Enter Password"), 
	INVALID_ADDRESS(106,"Please Enter Address"),
	INVALID_CITY(107,"Please Enter City"),
	INVALID_PINCODE(108,"Please Enter pincode"),
	INVALID_EMAILID(109,"Please Enter valid Email-id"),
	DETAILS_NOT_FOUND(110,"Sorry Details not found"),
	UNKNOWN_ERROR(300,"Unknown Error"),
	INVALID_USERNAME_AND_PASSWORD(201,"Please Enter valid username and password"), 
	USERNAME_AND_PASSWORD_DOESNT_EXIST(202,"Username and password doesnt Exist"),
	UNAUTHORIZED_TO_USER(203,"Unauthorized Access"),
	
	INVALID_PRODUCT_NAME(111,"Please Enter valid product Name"), 
	INVALID_PRODUCT_PRICE(112,"Please Enter product price"),
	INVALID_PRODUCT_QUANTITY(113,"Please Enter product quantity"),
	
	INVALID_CATEGORY_NAME(114,"Please Enter Category Name"),
	INVALID_PRODUCT_DISCOUNT(115,"Please Enter Discount") ,
	INVALID_PRODUCT_IMAGE(116,"Please upload product Image");

	private final int code;
	private final String message;
	
	AppErrorCode(int code,String message) {
		this.code= code;
		this.message=message;
	}

	public int getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}
}
 
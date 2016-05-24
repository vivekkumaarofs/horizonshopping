package com.ofs.util;

import java.util.Calendar;
import com.ofs.exception.AppErrorCode;
import com.ofs.exception.AppException;
import com.ofs.model.Product;
import com.ofs.model.User;


public class ValidationHorizonShopping {

	public void validateUserDetails(User user) {

		String passwordpattern= "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";
		String emailidpattern ="^[A-Za-z0-9+_.-]+@(.+)$";
		String namepattern ="^[A-Za-z]+";
		
		if((user.getName() == null ||user.getName().isEmpty()) || !(user.getName().matches(namepattern))) {
			throw new AppException(AppErrorCode.INVALID_NAME); 
		}

		validateDateOfBirth(user);

		if(user.getUsername() == null || user.getUsername().isEmpty()) {
			throw new AppException(AppErrorCode.INVALID_USER_NAME);
		}
		
		if(user.getPassword() == null || user.getPassword().isEmpty() || 
				!(user.getPassword().matches(passwordpattern))) { 
			throw new AppException(AppErrorCode.INVALID_PASSWORD); 
		}		

		if(user.getGender() == null || user.getGender().isEmpty()) {
			throw new AppException(AppErrorCode.INVALID_GENDER); 
		}
 
		if(user.getAddress() == null || user.getAddress().isEmpty()) {
			throw new AppException(AppErrorCode.INVALID_ADDRESS); 
		}

		if(user.getCity() == null || user.getCity().isEmpty() || !(user.getCity().matches(namepattern))) {
			throw new AppException (AppErrorCode.INVALID_CITY); 
		}

		if(user.getEmailid()== null || user.getEmailid().isEmpty() || 
				!(user.getEmailid().matches(emailidpattern))) {
			throw new AppException(AppErrorCode.INVALID_EMAILID);
		}

		validatePhonenumber(user);
	}

	public void validatePhonenumber(User user) {

		String numberpattern = "[0-9]+";
		int getphonenumber =  user.getPincode();
		String sphone = Integer.toString(getphonenumber);

		if(!(sphone.matches(numberpattern)) || user.getPincode()==0 ) {
			throw new AppException(AppErrorCode.INVALID_PINCODE);
		}
	}

	public void validateDateOfBirth(User user ) {

		Calendar dateofbirth = Calendar.getInstance();  
		dateofbirth.setTime(user.getDateofbirth());  
		Calendar today = Calendar.getInstance();  
		int age = today.get(Calendar.YEAR) - dateofbirth.get(Calendar.YEAR);  

		if(today.get(Calendar.MONTH) == dateofbirth.get(Calendar.MONTH)
				&& today.get(Calendar.DAY_OF_MONTH) < dateofbirth.get(Calendar.DAY_OF_MONTH)) {
			age--;  
		} else if (age < 18 ) {
			throw new AppException(AppErrorCode.INVALID_DATE_OF_BIRTH);
		}
	}
	
	
	public void validateProduct(Product product) {
		
		String namePattern ="^[A-Za-z]+";
		
		if(product.getProductName() == null || product.getProductName().isEmpty()||
				!(product.getProductName().matches(namePattern))) {
			throw new AppException(AppErrorCode.INVALID_PRODUCT_NAME); 
		}
		
		if(product.getProductPrice() == 0 ) {
			throw new AppException(AppErrorCode.INVALID_PRODUCT_PRICE); 
		}
		
		if(product.getProductQty() == 0 ) {
			throw new AppException(AppErrorCode.INVALID_PRODUCT_QUANTITY); 
		}
		
		if(product.getProductDiscount()==0 ) {
			throw new AppException(AppErrorCode.INVALID_PRODUCT_DISCOUNT); 
		}

		if(product.getProductImage()==null) {
			throw new AppException(AppErrorCode.INVALID_PRODUCT_IMAGE);
		}
	}

	public void validateCategory(Product category){
		
		String namePattern ="^[A-Za-z]+";

		if(category.getCategoryName() == null || category.getCategoryName().isEmpty() || !(category.getCategoryName().matches(namePattern))){
			throw new AppException(AppErrorCode.INVALID_CATEGORY_NAME);
		}

	}
	
	public void validateParentCategory(Product category){
		
		String namePattern ="^[A-Za-z]+";

		if(category.getParentCategoryName() == null || category.getCategoryName().isEmpty() || !(category.getCategoryName().matches(namePattern))){
			throw new AppException(AppErrorCode.INVALID_CATEGORY_NAME);
		}

	}

}

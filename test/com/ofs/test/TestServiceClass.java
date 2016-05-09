package com.ofs.test;

import org.junit.Test;
import static org.junit.Assert.*;
import java.sql.Date;
import java.sql.SQLException;

import com.ofs.exception.AppErrorCode;
import com.ofs.exception.AppException;
import com.ofs.model.User;
import com.ofs.serviceImpl.UserServiceImpl;
import com.ofs.services.UserService;


public class TestServiceClass {

	UserService service = new UserServiceImpl();

	@Test
	public void testName() throws Exception {

		User  user = new User(" ", Date.valueOf("1993-01-01"), "ram234", "pass123","male", "tnagar", 
				"chennai", 600002, "user", "sat1993@gmail.com");
		try {
			service.addUser(user);
		} catch(AppException e) {
			assertEquals("INVALID_NAME",AppErrorCode.INVALID_NAME.toString());
		}
	}

	@Test
	public void testUserName() throws Exception {

		User user = new User("ram ", Date.valueOf("1993-01-01"), " ", "pass123","male", "tnagar",
				"chennai", 600002, "user", "sat1993@gmail.com");
		try {
			service.addUser(user);
		} catch(AppException e) {
			assertEquals("INVALID_USER_NAME",AppErrorCode.INVALID_USER_NAME.toString());
		}
	}

	@Test 
	public void testPassword() throws Exception  {
		
		User user = new User("ram ", Date.valueOf("1993-01-01"), "ram123", " ", "male", "tnagar", "chennai",
				600002, "user", "sat1993@gmail.com");
		try {
			service.addUser(user);
		} catch (AppException e) {
			assertEquals("INVALID_PASSWORD",AppErrorCode.INVALID_PASSWORD.toString());
		}
	}

	@Test
	public void testGender() throws Exception {
		User  user = new User("ram ", Date.valueOf("1993-01-01"), "ram123", "pass123", " ", "tnagar",
				"chennai", 600002, "user", "sat1993@gmail.com");
		try {
			service.addUser(user);
		} catch(AppException e) {
			assertEquals("INVALID_GENDER",AppErrorCode.INVALID_GENDER.toString());
		}
	}

	@Test 
	public void testAddress() throws Exception {

		User  user = new User("ram ", Date.valueOf("1993-01-01"), "ram123", "pass123", "male", " ", 
				"chennai", 600002, "user", "sat1993@gmail.com");
		try {
			service.addUser(user);
		} catch(AppException e) {
			assertEquals("INVALID_ADDRESS", AppErrorCode.INVALID_ADDRESS.toString());
		}
	}

	@Test
	public void testCity() throws Exception {
		
		User  user = new User("ram ", Date.valueOf("1993-01-01"), "ram123", "pass123", "male", "tnagar", " ",
				600002, "user", "sat1993@gmail.com");
		try {
			service.addUser(user);
		} catch(AppException e) {
			assertEquals("INVALID_CITY", AppErrorCode.INVALID_CITY.toString());
		}
	}

	@Test
	public void testPincode() throws Exception {
		User  user = new User("ram ", Date.valueOf("1993-01-01"), "ram123", "pass123", "male", "tnagar",
				"Chennai",0 , "user", "sat1993@gmail.com");
		try {
			service.addUser(user);
		} catch (AppException e) {
			assertEquals("INVALID_PINCODE", AppErrorCode.INVALID_PINCODE.toString());
		}
	}

	@Test 
	public void testEmailid() throws Exception {
		User  user = new User("ram ", Date.valueOf("1993-01-01"), "ram123", "pass123", "male", "tnagar",
				"Chennai",0 , "user", "fasdf@gmail");
		try{
			service.addUser(user);
		} catch (AppException e) {
			assertEquals("INVALID_EMAILID",AppErrorCode.INVALID_EMAILID.toString());
		}
	}

	@Test 
	public void validationDateOfBirth() throws SQLException, Exception {
		
		User  user = new User("Ram", Date.valueOf("2016-01-01"), "sat234", "pass123","male", "tnagar", 
				"chennai", 600002, "user", "sat1993@gmail.com");
		try {
			service.addUser(user);
		} catch(AppException e)	{
			assertEquals("INVALID_DATE_OF_BIRTH",AppErrorCode.INVALID_DATE_OF_BIRTH.toString());
		}
	}
	
	@Test 
	public void testUpdateUser() throws SQLException, Exception {
		
		User user = new User("pass@100","Mahabalipuram", "chennai" ,600008 , 45);
		try {
			service.updateOneUserService(user);
		} catch (AppException e) {
			assertEquals("DETAILS_NOT_FOUND",110);
		}
	}

}

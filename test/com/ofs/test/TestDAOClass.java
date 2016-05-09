package com.ofs.test;

import static org.junit.Assert.assertNotNull;

import java.sql.Date;
import org.junit.Test;
import com.ofs.DAO.UserDAO;
import com.ofs.DAOImpl.UserDAOImpl;
import com.ofs.model.User;


public class TestDAOClass {

	@Test
	public void testAddUser() throws Exception {
		
		User user = new User();
		user.setName("ravi");
		user.setDateofbirth(Date.valueOf("1993-01-01"));
		user.setGender("Male");
		user.setAddress("TNAGAR");
		user.setCity("Chennai");
		user.setPincode(600081);
		user.setEmailid("ravi123@gmail.com");
		user.setUsername("ravismart123");
		user.setPassword("Pasdf@101");
		UserDAO userdo = new UserDAOImpl();
		int id = userdo.addUser(user);
		assertNotNull(id);
	}

	@Test
	public void testUpdateUser() throws Exception {
		
		User user = new User();
		user.setId(45);
		user.setPassword("Pass@100");
		user.setAddress("Mahabalipuram");
		user.setCity("Madurai");
		user.setPincode(61111046);
		UserDAO userdo = new UserDAOImpl(); 
		int id =userdo.updateUser(user);
		assertNotNull(id);
	}

	@Test 
	public void testReadOneUser() throws Exception {

		UserDAO userdo = new UserDAOImpl();
		User user = userdo.readOneUser(1);
		assertNotNull(user);
	}

	public void testRealAllUser() throws Exception {
		//TODO
	}
}

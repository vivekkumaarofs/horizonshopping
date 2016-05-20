package com.ofs.test;

import static org.junit.Assert.assertNotNull;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.ofs.DAO.ProductDAO;
import com.ofs.DAO.UserDAO;
import com.ofs.DAOImpl.ProductDAOImpl;
import com.ofs.DAOImpl.UserDAOImpl;
import com.ofs.model.Category;
import com.ofs.model.Product;
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

	@Test
	public void testCreateProduct() throws Exception {

		List<Object> listObject = new ArrayList<Object>();
		ProductDAO product = new ProductDAOImpl();
		Category category = new Category();
		Product prod = new Product();
		category.setcId(3);
		prod.setProductName("HE MAN");
		prod.setProductPrice(200);
		prod.setProductQty(200);
		prod.setProductDiscount(5);

		listObject.add(category);
		listObject.add(prod);

//		int id = product.addProduct(listObject);
//		assertNotNull(id);
	}
}

package com.ofs.serviceImpl;

import java.sql.SQLException;
import java.util.List;
import com.ofs.DAO.CategoryDAO;
import com.ofs.DAOImpl.CategoryDAOImpl;
import com.ofs.model.Product;
import com.ofs.services.CategoryService;
import com.ofs.util.ValidationHorizonShopping;

public class CategoryServiceImpl implements CategoryService {

	CategoryDAO categoryDAO = new CategoryDAOImpl();

	public void addCategoryService(Product category) throws SQLException, Exception {
		
	ValidationHorizonShopping validation = new ValidationHorizonShopping();
	validation.validateCategory(category);
	categoryDAO.addCategory(category);

	}
	
	public List<Product> readAllCategoryService() throws Exception{
		return categoryDAO.readAllCategory();
	}

	public void addParentCategoryService(Product category) throws SQLException, Exception{

		ValidationHorizonShopping validation = new ValidationHorizonShopping();
		validation.validateParentCategory(category);
		categoryDAO.addParentCategory(category);
	}

	public List<Product> readAllParentCategoryService() throws Exception{
		return categoryDAO.readAllParentCategory();
	}

}

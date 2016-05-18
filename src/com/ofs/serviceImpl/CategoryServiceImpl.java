package com.ofs.serviceImpl;

import java.sql.SQLException;
import java.util.List;
import com.ofs.DAO.CategoryDAO;
import com.ofs.DAOImpl.CategoryDAOImpl;
import com.ofs.model.Category;
import com.ofs.services.CategoryService;
import com.ofs.util.ValidationHorizonShopping;

public class CategoryServiceImpl implements CategoryService {

	public void addCategoryService(Category category) throws SQLException, Exception{
		
	ValidationHorizonShopping validation = new ValidationHorizonShopping();
	CategoryDAO categoryDAO = new CategoryDAOImpl();
	validation.validateCategory(category);
	categoryDAO.addCategory(category);

	}
	
	public List<Category> readAllCategoryService() throws Exception{
	
		CategoryDAO categoryDAO = new CategoryDAOImpl();
		return categoryDAO.readAllCategory();
	}

	public void addParentCategoryService(Category category) throws SQLException, Exception{

		ValidationHorizonShopping validation = new ValidationHorizonShopping();
		validation.validateParentCategory(category);
		CategoryDAO categoryDAO = new CategoryDAOImpl();
		categoryDAO.addParentCategory(category);
	}

	public List<Category> readAllParentCategoryService() throws Exception{

		CategoryDAO categoryDAO = new CategoryDAOImpl();
		return categoryDAO.readAllParentCategory();
	}

}

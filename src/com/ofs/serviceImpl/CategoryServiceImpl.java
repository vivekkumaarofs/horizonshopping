package com.ofs.serviceImpl;

import java.sql.SQLException;
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
}

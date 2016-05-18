package com.ofs.services;

import java.sql.SQLException;
import java.util.List;

import com.ofs.model.Category;


public interface CategoryService {

	public void addCategoryService(Category category) throws SQLException, Exception;

	public List<Category> readAllCategoryService() throws Exception;

	public void addParentCategoryService(Category category) throws SQLException, Exception;

	public List<Category> readAllParentCategoryService() throws Exception;

}

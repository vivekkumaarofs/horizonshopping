package com.ofs.services;

import java.sql.SQLException;
import java.util.List;
import com.ofs.model.Product;


public interface CategoryService {

	public void addCategoryService(Product category) throws SQLException, Exception;

	public List<Product> readAllCategoryService() throws Exception;

	public void addParentCategoryService(Product category) throws SQLException, Exception;

	public List<Product> readAllParentCategoryService() throws Exception;

}

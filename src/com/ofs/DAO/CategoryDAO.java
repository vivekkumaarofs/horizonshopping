package com.ofs.DAO;

import java.sql.SQLException;
import java.util.List;

import com.ofs.model.Category;

public interface CategoryDAO {

	/**Add Category **/
	int addCategory(Category category) throws SQLException, Exception;

	/**View Category **/
	public List<Category> readAllCategory() throws SQLException, Exception;

	/** Add Parent Category **/
	int addParentCategory(Category category) throws SQLException, Exception;
	
	/** view Parent Category **/
	public List<Category> readAllParentCategory() throws SQLException, Exception;
}

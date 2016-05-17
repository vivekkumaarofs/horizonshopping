package com.ofs.DAO;

import java.sql.SQLException;
import java.util.List;

import com.ofs.model.Category;

public interface CategoryDAO {

	/**Add Category **/
	int addCategory(Category category) throws SQLException, Exception;

	/**View Category **/
	public List<Category> readAllCategory() throws SQLException, Exception;
}

package com.ofs.DAO;

import java.sql.SQLException;

import com.ofs.model.Category;

public interface CategoryDAO {

	/**Add Category **/
	int addCategory(Category category) throws SQLException, Exception;
}

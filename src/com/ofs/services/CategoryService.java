package com.ofs.services;

import java.sql.SQLException;
import com.ofs.model.Category;

public interface CategoryService {

	public void addCategoryService(Category category) throws SQLException, Exception;
}

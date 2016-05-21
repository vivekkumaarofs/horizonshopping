package com.ofs.DAO;

import java.sql.SQLException;
import java.util.List;
import com.ofs.model.Product;

public interface CategoryDAO {

	/**Add Category **/
	int addCategory(Product category) throws SQLException, Exception;

	/**View Category **/
	public List<Product> readAllCategory() throws SQLException, Exception;

	/** Add Parent Category **/
	int addParentCategory(Product category) throws SQLException, Exception;
	
	/** view Parent Category **/
	public List<Product> readAllParentCategory() throws SQLException, Exception;
}

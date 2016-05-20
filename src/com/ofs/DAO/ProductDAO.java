package com.ofs.DAO;

import java.sql.SQLException;
import java.util.List;

import com.ofs.exception.AppException;
import com.ofs.model.Category;
import com.ofs.model.Product;

public interface ProductDAO {

	/**Add Product **/ 
	int addProduct(Object object) throws SQLException, AppException, Exception;

	/**VIEW Product **/
	public List<Product> readAllProduct() throws Exception, AppException;
}

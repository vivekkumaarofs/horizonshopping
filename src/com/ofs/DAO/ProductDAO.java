package com.ofs.DAO;

import java.sql.SQLException;
import com.ofs.exception.AppException;
import com.ofs.model.Product;

public interface ProductDAO {

	/**Add Product **/ 
	int addProduct(Product product) throws SQLException, AppException, Exception;

}

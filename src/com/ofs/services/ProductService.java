package com.ofs.services;

import java.sql.SQLException;
import com.ofs.exception.AppException;
import com.ofs.model.Product;

public interface ProductService {

	void addProductService(Product user)throws SQLException, AppException, Exception;
	
}

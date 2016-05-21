package com.ofs.services;

import java.sql.SQLException;
import java.util.List;
import com.ofs.exception.AppException;
import com.ofs.model.Product;

public interface ProductService {

	void addProductService(Product product)throws SQLException, AppException, Exception;

	public List<Product> readAllProductService() throws Exception ;
}

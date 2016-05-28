package com.ofs.services;


import java.util.List;
import com.ofs.exception.AppException;
import com.ofs.model.Product;

public interface ProductService {

	void addProductService(Product product)throws  AppException,Exception;

	public List<Product> readAllProductService() throws Exception;
	
	void addShoppingCartService(Product shoppingcart) throws AppException,Exception;
}

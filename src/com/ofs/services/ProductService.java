package com.ofs.services;


import java.util.List;
import com.ofs.exception.AppException;
import com.ofs.model.Product;

public interface ProductService {

	void addProductService(Product product)throws  AppException,Exception;

	public List<Product> readAllProductService() throws AppException, Exception;
	
	void addShoppingCartService(Product shoppingcart) throws AppException,Exception;
	
	void addMainCategoryService(Product category)throws AppException,Exception;
	
	public List<Product> readAllShoppingCartService() throws Exception;

	public List<Product> readOneShoppingCartService(int id) throws AppException,Exception;	

	public void deleteShoppingCartService(Product product)throws AppException,Exception;

	public void updateShoppingCartService(Product shoppingCart)throws AppException,Exception;
	
	public List<Product> viewPurchaseOrderService() throws AppException, Exception; 
}

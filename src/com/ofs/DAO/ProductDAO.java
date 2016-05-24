package com.ofs.DAO;


import java.util.List;
import com.ofs.exception.AppException;
import com.ofs.model.Product;

public interface ProductDAO {

	/**Add Product **/ 
	int addProduct(Product product) throws  AppException, Exception;

	/**VIEW Product **/
	public List<Product> readAllProduct() throws AppException, Exception;
}

package com.ofs.DAO;


import java.util.List;
import com.ofs.exception.AppException;
import com.ofs.model.Product;

public interface ProductDAO {

	/**Add Product **/ 
	int addProduct(Product product) throws  Exception;

	/**VIEW Product **/
	public List<Product> readAllProduct() throws AppException, Exception;

	/** Add Shopping Cart **/
	public int addShoppingCart(Product shoppingcart) throws Exception;
	
	/**View Shopping Cart List**/
	public List<Product>readAllShoppingCart() throws Exception;

	/**View One Shopping Cart Details**/
	public List<Product> readOneShoppingCart(int id) throws Exception;

	/**Delete one Shopping Cart Detail**/
	public int deleteOneShoppingCart(int id) throws Exception; 
}

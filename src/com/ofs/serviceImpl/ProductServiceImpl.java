package com.ofs.serviceImpl;


import java.util.List;
import com.ofs.DAO.ProductDAO;
import com.ofs.DAOImpl.ProductDAOImpl;
import com.ofs.exception.AppException;
import com.ofs.model.Product;
import com.ofs.services.ProductService;
import com.ofs.util.ValidationHorizonShopping;


public class ProductServiceImpl implements ProductService {

	ProductDAO productdao = new ProductDAOImpl();
	ValidationHorizonShopping validation = new ValidationHorizonShopping();

	public void addProductService(Product product)throws AppException,Exception{

	
		validation.validateProduct(product);
		productdao.addProduct(product);
	}

	public List<Product> readAllProductService() throws Exception {
		
		
		return productdao.readAllProduct();
	
	}
	
	public void addShoppingCartService(Product shoppingcart) throws AppException,Exception{

		validation.validateShoppingCart(shoppingcart);
		productdao.addShoppingCart(shoppingcart);
	}
}

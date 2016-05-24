package com.ofs.serviceImpl;

import java.sql.SQLException;
import java.util.List;
import com.ofs.DAO.ProductDAO;
import com.ofs.DAOImpl.ProductDAOImpl;
import com.ofs.exception.AppException;
import com.ofs.model.Product;
import com.ofs.services.ProductService;
import com.ofs.util.ValidationHorizonShopping;


public class ProductServiceImpl implements ProductService {

	ProductDAO productdao = new ProductDAOImpl();

	public void addProductService(Product product)throws SQLException, AppException, Exception{

		ValidationHorizonShopping validation = new ValidationHorizonShopping();
		validation.validateProduct(product);
		productdao.addProduct(product);
	}

	public List<Product> readAllProductService() throws Exception {
		
		
		return productdao.readAllProduct();
	
	}	
}

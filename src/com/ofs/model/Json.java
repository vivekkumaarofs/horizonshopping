package com.ofs.model;

import java.util.ArrayList;
import java.util.List;

import com.ofs.serviceImpl.CategoryServiceImpl;
import com.ofs.serviceImpl.ProductServiceImpl;
import com.ofs.services.CategoryService;
import com.ofs.services.ProductService;

public class Json {

	private List <Product> product;
	private List<Product> category;
	private List<Product> parentCategory;
	private List<Product> shoppingCart;
	
	public List<Object> getDetails() throws Exception {
	
		ProductService productservice = new ProductServiceImpl();
		CategoryService categoryservice = new CategoryServiceImpl();
		ProductService shoppingcartservice = new ProductServiceImpl();
		
		List<Object> list = new ArrayList<Object>();

		product = productservice.readAllProductService();
		category = categoryservice.readAllCategoryService();
		parentCategory = categoryservice.readAllParentCategoryService();
		shoppingCart = shoppingcartservice.readAllShoppingCartService();

		list.add(product);
		list.add(category);
		list.add(parentCategory);
		list.add(shoppingCart);
		return list;

	}
 

}

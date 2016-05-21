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

	public List<Object> getDetails() throws Exception {
	
		ProductService productservice = new ProductServiceImpl();
		CategoryService categoryservice = new CategoryServiceImpl();
		List<Object> list = new ArrayList<Object>();

		product = productservice.readAllProductService();
		category = categoryservice.readAllCategoryService();
		parentCategory = categoryservice.readAllParentCategoryService();
		
		list.add(product);
		list.add(category);
		list.add(parentCategory);

		return list;
		
	}
 

}

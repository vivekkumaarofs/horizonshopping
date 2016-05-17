package com.ofs.servlet;


import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ofs.exception.AppException;
import com.ofs.model.Category;
import com.ofs.model.HorrizonShoppingJson;
import com.ofs.model.Product;
import com.ofs.serviceImpl.CategoryServiceImpl;
import com.ofs.serviceImpl.ProductServiceImpl;
import com.ofs.services.CategoryService;
import com.ofs.services.ProductService;


public class ProductServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	

	public void doPost(HttpServletRequest request, HttpServletResponse response) {

		response.setContentType("application/json");
		StringBuffer requestJson = new StringBuffer();
		String line = null;

		try {
			BufferedReader reader = request.getReader();
			while((line = reader.readLine()) !=null)
				requestJson.append(line);
			Product product = HorrizonShoppingJson.fromJSON(requestJson.toString(), Product.class);
			ProductService productService = new ProductServiceImpl();
			productService.addProductService(product);

			Category cateogrystring = HorrizonShoppingJson.fromJSON(requestJson.toString(), Category.class);
			CategoryService categoryservice = new CategoryServiceImpl();
			categoryservice.addCategoryService(cateogrystring);

			PrintWriter printwriter = response.getWriter();        
			printwriter.print("Saved successfully"); 
			printwriter.close();

		} catch(Exception e) {
			throw new AppException(e);
		}
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) {

		response.setContentType("application/json");
		List<Product> product;
		List<Category> category;
		ProductService productservice = new ProductServiceImpl();
		CategoryService categoryservice = new CategoryServiceImpl();
		try {
			product = productservice.readAllProductService();
			String productstring = HorrizonShoppingJson.toJSON(product);
			
			category = categoryservice.readAllCategoryService();
			String categorystring = HorrizonShoppingJson.toJSON(category);
			
			PrintWriter printwriter = response.getWriter();
			printwriter.print(productstring);
			printwriter.print(categorystring);
			printwriter.close();
		} catch (Exception e) {
			throw new AppException(e);
		}
		
	}

}

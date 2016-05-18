package com.ofs.servlet;

import java.io.BufferedReader;
import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ofs.exception.AppException;
import com.ofs.model.Category;
import com.ofs.model.HorrizonShoppingJson;
import com.ofs.model.Json;
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

			Category parentcateogrystring = HorrizonShoppingJson.fromJSON(requestJson.toString(), Category.class);
			categoryservice.addParentCategoryService(parentcateogrystring);

			PrintWriter printwriter = response.getWriter();        
			printwriter.print("Saved successfully"); 
			printwriter.close();

		} catch(Exception e) {
			throw new AppException(e);
		}
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) {

		response.setContentType("application/json");
		try {
			Json  json = new Json();
			json.getDetails();
			String categorystring = HorrizonShoppingJson.toJSON(json);
			PrintWriter printwriter = response.getWriter();			
			printwriter.print(categorystring);
			printwriter.close();
		} catch (Exception e) {
			throw new AppException(e);
		}
	}

}

//jsonsstring.append(category.get(0).getCategoryName()).append(category.get(0).getcID()).append(category.get(0).getmpId())
//.append(category.get(0).getParentCategoryName());
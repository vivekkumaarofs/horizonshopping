package com.ofs.servlet;


import java.io.BufferedReader;
import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ofs.exception.AppException;
import com.ofs.model.HorrizonShoppingJson;
import com.ofs.model.Json;
import com.ofs.model.Product;
import com.ofs.serviceImpl.ProductServiceImpl;
import com.ofs.services.ProductService;


public class ProductServlet extends HttpServlet {
	 
	private static final long serialVersionUID = 1L;
//	private static final ObjectMapper mapper = new ObjectMapper();

	public void doPost(HttpServletRequest request, HttpServletResponse response) {

		response.setContentType("multipart/form-data");
		StringBuffer requestJson = new StringBuffer();
		String line = null;

		try {
			BufferedReader reader = request.getReader();
			while((line = reader.readLine()) !=null)
				requestJson.append(line);
			Product product = HorrizonShoppingJson.fromJSON(requestJson.toString(), Product.class);	
			ProductService productService = new ProductServiceImpl();
			productService.addProductService(product);
			PrintWriter printwriter = response.getWriter();        
			printwriter.print("Saved successfully"); 
			printwriter.close();
		} catch(Exception e) {
			throw new AppException(e);
		}
	}

//	private Product fromJSON(String product) throws Exception {
//
//		Product prod = mapper.readValue(product, Product.class);
//		return prod;
//	}
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

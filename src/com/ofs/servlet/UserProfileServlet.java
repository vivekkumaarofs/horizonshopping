package com.ofs.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ofs.exception.AppException;
import com.ofs.model.HorrizonShoppingJson;
import com.ofs.model.Product;
import com.ofs.serviceImpl.ProductServiceImpl;
import com.ofs.services.ProductService;


public class UserProfileServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	ProductService shoppingCartService = new ProductServiceImpl();
	StringBuffer requestJson = new StringBuffer();
	String line = null;

	public void doPost (HttpServletRequest request, HttpServletResponse response) 
     throws IOException, ServletException {

		response.setContentType("multipart/form-data");
		try {
			BufferedReader reader = request.getReader();
			while((line = reader.readLine()) !=null)
				requestJson.append(line);
			Product shoppingcart = HorrizonShoppingJson.fromJSON(requestJson.toString(), Product.class);	
			shoppingCartService.addShoppingCartService(shoppingcart);
			PrintWriter printwriter = response.getWriter();        
			printwriter.close();
		} catch (Exception e){
			throw new AppException(e);
		}
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) {

		response.setContentType("appication/json");
		String requestid = request.getParameter("id");
		
		try {
			List<Product> shopcart = shoppingCartService.readOneShoppingCartService(Integer.parseInt(requestid));
			String shopcartstring = HorrizonShoppingJson.toJSON(shopcart);
	        PrintWriter pw = response.getWriter();
	        pw.print(shopcartstring);
	        pw.close();

		} catch (Exception e) {
			throw new AppException(e);
		}
	}

	public void doDelete(HttpServletRequest request, HttpServletResponse response) {

		response.setContentType("application/json");
		try {
			BufferedReader reader = request.getReader();
			while((line = reader.readLine()) != null){
				requestJson.append(line);
			}
			Product product = HorrizonShoppingJson.fromJSON(requestJson.toString(),Product.class); 
			shoppingCartService.deleteShoppingCartService(product);
		}  catch (Exception e) {
			throw new AppException(e);
		}
	}
	
	public void doPut(HttpServletRequest request, HttpServletResponse response) {

		response.setContentType("application/json");
		try {
			BufferedReader reader = request.getReader();
			while((line = reader.readLine())!=null){
				requestJson.append(line);
			}
			Product shoppingCart = HorrizonShoppingJson.fromJSON(requestJson.toString(), Product.class);
			shoppingCartService.updateShoppingCartService(shoppingCart);
		}catch(Exception e) {
			throw new AppException(e);
		}
	}

}

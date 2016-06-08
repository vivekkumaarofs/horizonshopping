package com.ofs.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

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

	public void doPost (HttpServletRequest request, HttpServletResponse response) 
     throws IOException, ServletException {

		response.setContentType("multipart/form-data");
		StringBuffer requestJson = new StringBuffer();
		String line = null;

		try {
			BufferedReader reader = request.getReader();
			while((line = reader.readLine()) !=null)
				requestJson.append(line);
			Product shoppingcart = HorrizonShoppingJson.fromJSON(requestJson.toString(), Product.class);	
			ProductService shoppingCartService = new ProductServiceImpl();
			shoppingCartService.addShoppingCartService(shoppingcart);
			PrintWriter printwriter = response.getWriter();        
			printwriter.close();

		} catch (Exception e){
			throw new AppException(e);
		}
	}

	public void doGet(HttpServletRequest request, HttpServletResponse respone) {

		//TODO:
	}

}

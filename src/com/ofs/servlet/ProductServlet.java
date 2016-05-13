package com.ofs.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ofs.serviceImpl.ProductServiceImpl;
import com.ofs.services.ProductService;

public class ProductServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	

	public void doPut(HttpServletRequest request, HttpServletResponse response) {

		response.setContentType("application/json");
		ProductService product = new ProductServiceImpl();
	
	
	
	}

}

package com.ofs.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class HmsServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private String servicePackageName = "com.ofs.services.";
	private String apiPackageName = "com.ofs.DAO.";

	public void doGet(HttpServletRequest request, HttpServletResponse response) {

		
	}
}

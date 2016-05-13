package com.ofs.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ofs.exception.AppException;
import com.ofs.model.User;
import com.ofs.model.HorrizonShoppingJson;
import com.ofs.serviceImpl.UserServiceImpl;
import com.ofs.services.UserService;


public class AccessServlet extends HttpServlet {

	private static final long serialVersionUID = -4536912329600357460L;
	private static final ObjectMapper mapper = new ObjectMapper();

	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException {

		response.setContentType("text/html");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		PrintWriter out = response.getWriter();
		UserService userservice = new UserServiceImpl();

		try {
			User user = userservice.loginService(username, password);
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			out.println(HorrizonShoppingJson.toJSON(user));
		} catch (Exception e) {
			out.print("INVALID USERNAME AND PASSWORD");
			System.out.println("INVALID PASSWORD");
			out.close();
		}
	}

	public void doGet (HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		response.setContentType("application/json");    
		try {
			String id = request.getParameter("id");
			UserService userservice = new UserServiceImpl();
			User user = userservice.readOneService(Integer.parseInt(id));
			String userstring = HorrizonShoppingJson.toJSON(user);
			PrintWriter printwriter = response.getWriter();
			printwriter.print(userstring);    	
		} catch (Exception e) {
			throw new AppException(e);
		}
	}

	public void doPut(HttpServletRequest request,HttpServletResponse response) { 

		response.setContentType("application/json");
		StringBuffer requestJSON = new StringBuffer();
		String line = null;
		try {
			BufferedReader reader = request.getReader();
			while ((line = reader.readLine()) != null)
				requestJSON.append(line);
			UserService editprofile = new UserServiceImpl();	        
			User user = fromJSON(requestJSON.toString());
			editprofile.updateOneUserService(user);
		} catch (Exception e) {
			throw new AppException(e);
		}
	}

	private User fromJSON(String user) throws Exception {

		User user1 = mapper.readValue(user, User.class);
		return user1;
	}

}

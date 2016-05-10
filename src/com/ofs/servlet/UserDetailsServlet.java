package com.ofs.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ofs.exception.AppException;
import com.ofs.model.User;
import com.ofs.model.UserJson;
import com.ofs.serviceImpl.UserServiceImpl;
import com.ofs.services.UserService;


public class UserDetailsServlet extends HttpServlet {

	private static final long serialVersionUID = -4536912329600357460L;
	private static final ObjectMapper mapper = new ObjectMapper();
	private String line= null;

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

    	StringBuffer requestJSON = new StringBuffer();
		BufferedReader reader = request.getReader(); 
	    while((line = reader.readLine()) != null)
	    requestJSON.append(line);
	    User user = UserJson.fromJSON(requestJSON.toString(), User.class);
	    UserService userservice = new UserServiceImpl();
	 	try {
			userservice.addUser(user);
		} catch (Exception e) { 
			throw new AppException(e);
		}
        PrintWriter printwriter = response.getWriter();        
        printwriter.print("Saved successfully"); 
        printwriter.close();
    }
 
    public void doGet(HttpServletRequest request , HttpServletResponse response) 
    throws IOException, ServletException {

    	response.setContentType("application/json");
		UserService userservice = new UserServiceImpl();
		
		try {
			List<User> user;
			user = userservice.readAllUserService();
			String userstring = UserJson.toJSON(user);
			PrintWriter printwriter = response.getWriter();
			printwriter.print(userstring);
			printwriter.close();
		} catch (Exception e) {
			throw new AppException(e);
		}		
    }

    public void doPut(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException {
    
    	response.setContentType("application/json");
		StringBuffer requestJSON = new StringBuffer();
		String line = null;
		try {

			BufferedReader reader = request.getReader();
			while ((line = reader.readLine()) != null)
				requestJSON.append(line);
			UserService editApproval = new UserServiceImpl();	        
			User user = fromJSON(requestJSON.toString());
			editApproval.updateApprovalService(user);
		} catch(Exception e){
			throw new AppException(e);
    	}
    }
    
	private User fromJSON(String user) throws Exception {

		User user1 = mapper.readValue(user, User.class);
		return user1;
	}

}

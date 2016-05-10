package com.ofs.services;

import java.sql.SQLException;
import java.util.List;

import com.ofs.exception.AppException;
import com.ofs.model.User;

public interface UserService {

	void addUser(User user)throws SQLException, AppException, Exception;
	User loginService(String username, String password) throws Exception;
	List<User> readAllUserService() throws Exception;
	User readOneService(int id) throws Exception;
	void updateOneUserService(User user) throws Exception;
	public void updateApprovalService(User user) throws Exception;
}

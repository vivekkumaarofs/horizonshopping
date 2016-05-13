package com.ofs.DAO;

import java.sql.SQLException;
import java.util.List;
import com.ofs.exception.AppException;
import com.ofs.model.User;


public interface UserDAO {

	/**  Signup User * @return **/
	int addUser(User user) throws SQLException, Exception;

	/** Login Form **/
	User login(String userName, String password) throws SQLException, Exception;

	/**  Delete User Records **/
	public void deleteUser(int id) throws Exception, AppException;

	/** VIEW USER Records **/
	public List<User> readAllUser() throws Exception, AppException; 
	
	/** Read OneUserProfile Records **/
	public User readOneUser(int id) throws Exception, AppException;
	
	/** Update User profile Records **/
	public int updateUser( User user) throws Exception, AppException; 
	
	/** Edit  User Approval Records **/
	public int editApproval(User user) throws Exception, AppException;
	
}

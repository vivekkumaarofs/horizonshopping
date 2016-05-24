package com.ofs.serviceImpl;

import java.sql.SQLException;
import java.util.List;
import com.ofs.DAO.UserDAO;
import com.ofs.DAOImpl.UserDAOImpl;
import com.ofs.exception.AppErrorCode;
import com.ofs.exception.AppException;
import com.ofs.model.User;
import com.ofs.services.UserService;
import com.ofs.util.ValidationHorizonShopping;


public class UserServiceImpl implements UserService {

	public void addUser(User user) throws SQLException, Exception {

		ValidationHorizonShopping validation = new ValidationHorizonShopping();
		validation.validateUserDetails(user);
		UserDAO userDaoImpl = new UserDAOImpl();
		userDaoImpl.addUser(user);
	}
	
	public User loginService(String username, String password) throws AppException {

		try {
			UserDAO userDao = new UserDAOImpl();
			User user = new User();
			loginValidation(username,password);
			user = userDao.login(username, password);
			if(user.getId() > 0){
				return user;
			} else {				
				throw new AppException(AppErrorCode.USERNAME_AND_PASSWORD_DOESNT_EXIST);
			}
		} catch(Exception e) {
			throw new AppException(e);
		}
	}

	private void loginValidation(String username,String password){

		if(username.isEmpty()) {
			throw new AppException(AppErrorCode.INVALID_USER_NAME);
		} else if(password.isEmpty()) {
			throw new AppException(AppErrorCode.INVALID_PASSWORD);
		}
	}

	public List<User> readAllUserService() throws Exception {
		UserDAO user = new UserDAOImpl();
		return user.readAllUser();
	}

	public User readOneService(int id) throws AppException {

		try {
			UserDAO userdao = new UserDAOImpl();
			User user = userdao.readOneUser(id);
			return user;
		} catch(Exception e) {
			throw new AppException(e);
		}
	}
	
	public void updateOneUserService(User user) throws AppException {
		
		try {
			UserDAO userDAO = new UserDAOImpl();
		    userDAO.updateUser(user); 
		} catch(Exception e) {
			throw new AppException(e);
		}
	}
	
	public void updateApprovalService(User user) throws Exception {

		try {
			UserDAO userDAO = new UserDAOImpl();
			userDAO.editApproval(user);
		} catch(Exception e) {
			throw new AppException(e);
		}
	}

}

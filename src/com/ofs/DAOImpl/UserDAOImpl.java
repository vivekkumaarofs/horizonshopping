package com.ofs.DAOImpl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.ofs.exception.AppErrorCode;
import com.ofs.exception.AppException;
import com.ofs.DAO.UserDAO;
import com.ofs.model.User;
import com.ofs.util.DAOQueries;
import com.ofs.util.DatabaseUtil;

public class UserDAOImpl implements UserDAO {

	private static final String USER_TYPE = "User";
	boolean values = false;

	public int addUser(User user) throws Exception {

		Connection connection = DatabaseUtil.getDbCon();
		PreparedStatement ps = connection.prepareStatement(DAOQueries.ADD_DETAILS, Statement.RETURN_GENERATED_KEYS);
		ps.setString(1, user.getName());
		ps.setDate(2, user.getDateofbirth());
		ps.setString(3, user.getUsername());
		ps.setString(4, user.getPassword());
		ps.setString(5, user.getGender());
		ps.setString(6, user.getAddress());
		ps.setString(7, user.getCity());
		ps.setInt(8, user.getPincode());
		ps.setString(9, USER_TYPE);
		ps.setString(10, user.getEmailid());
		ps.executeUpdate();
		ResultSet rs = ps.getGeneratedKeys();
		rs.next();
		int id = rs.getInt(1);
		return id;
	}

	public User login(String username, String password) throws Exception {

		User user = new User();
		Connection connection = DatabaseUtil.getDbCon();
		PreparedStatement ps = connection.prepareStatement(DAOQueries.VIEW_DETAILS);
		ps.setString(1, username);
		ps.setString(2, password);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			user.setId(rs.getInt("id"));
			user.setUsertype(rs.getString("user_type"));
		}
		return user;
	}

	public int updateUser(User user) throws Exception, AppException {
		
		//int id = (Integer) user.getId();
		Connection connection = DatabaseUtil.getDbCon();
		PreparedStatement ps = connection.prepareStatement(DAOQueries.UPDATE_USER_DETAILS);
		ps.setString(1, user.getPassword());
		ps.setString(2, user.getAddress());
		ps.setString(3, user.getCity());
		ps.setInt(4, user.getPincode());
		ps.setInt(5, user.getId());
		int rowsAffected = ps.executeUpdate();
		return rowsAffected; 

	}

	public User readOneUser(int id) throws Exception, AppException {

		User user = new User();
		Connection connection = DatabaseUtil.getDbCon();
		PreparedStatement ps = connection.prepareStatement(DAOQueries.VIEW_USER_DETAILS);
		ps.setInt(1, id);
		ResultSet resultset = ps.executeQuery();
		while (resultset.next()) {
			user.setName(resultset.getString("name"));
			user.setDateofbirth(resultset.getDate("date_of_birth"));
			user.setUsername(resultset.getString("user_name"));
			user.setPassword(resultset.getString("password"));
			user.setAddress(resultset.getString("address"));
			user.setGender(resultset.getString("gender"));
			user.setAddress(resultset.getString("address"));
			user.setCity(resultset.getString("city"));
			user.setPincode(resultset.getInt("pincode"));
			user.setEmailid(resultset.getString("email_id"));
		}
		return user;
	}

	public List<User> readAllUser() throws Exception, AppException {
		
		
		List<User> userList = new ArrayList<User>();
		Connection connection = DatabaseUtil.getDbCon();
		PreparedStatement ps = connection.prepareStatement(DAOQueries.VIEW__ALL_USER_DETAILS);
		ResultSet resultset = ps.executeQuery();
		while (resultset.next()) {
			User user = new User();
			user.setId(resultset.getInt("id"));
			user.setName(resultset.getString("name"));
			user.setDateofbirth(resultset.getDate("date_of_birth"));
			user.setUsername(resultset.getString("user_name"));
			user.setPassword(resultset.getString("password"));
			user.setAddress(resultset.getString("address"));
			user.setGender(resultset.getString("gender"));
			user.setAddress(resultset.getString("address"));
			user.setCity(resultset.getString("city"));
			user.setPincode(resultset.getInt("pincode"));
			user.setEmailid(resultset.getString("email_id"));
			userList.add(user);	
		}
		
		return userList;
	}

	public int editApproval(int id) throws Exception, AppException {

		User user = new User();
		Connection connection = DatabaseUtil.getDbCon();
		PreparedStatement ps = connection.prepareStatement(DAOQueries.USER_APPROVAL);
		ps.setBoolean(1, user.getApprove());
		ps.setInt(2, user.getId());
		int rowsAffected = ps.executeUpdate();
		return rowsAffected; 
	}
	
	public void deleteUser(int id) throws Exception, AppException {
		
		Connection connection = DatabaseUtil.getDbCon();
		PreparedStatement ps = connection.prepareStatement(DAOQueries.DELETE_DETAILS);
		ps.setInt(1, id);
		int rowsAffected = ps.executeUpdate();
		if (!(rowsAffected == 1)) {
			throw new AppException(AppErrorCode.DETAILS_NOT_FOUND);
		}
		ps.executeUpdate();
	}

}

// while(rs.next()){ if((rs.getString("user_name").equals(username)) &&
// rs.getString("password").equals(password)) {
// System.out.println(rs.getString("user_type")); }
// if((rs.getString("user_name").equals(username)) &&
// rs.getString("password").equals(password)) {
// System.out.println(rs.getString("user_type")); } else { throw new
// AppException(AppErrorCode.USERNAME_AND_PASSWORD_DOESNT_EXSIST); }
// }

// while(rs.next()) {
// if((rs.getString("user_type").equalsIgnoreCase("Admin"))) {
// String userrole = rs.getString("user_type");
// System.out.println(userrole);
// } if((rs.getString("user_type").equalsIgnoreCase("User"))) {
// String usertyps = rs.getString("user_type");
// System.out.println(usertyps);
// } else {
// throw new AppException(AppErrorCode.INVALID_USERNAME_AND_PASSWORD);
// }
// }
// }

package com.ofs.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import com.ofs.DAO.CategoryDAO;
import com.ofs.model.Category;
import com.ofs.util.DAOQueries;
import com.ofs.util.DatabaseUtil;

public class CategoryDAOImpl implements CategoryDAO {

	public int addCategory (Category category)throws Exception {

		Connection connection = DatabaseUtil.getDbCon();
		PreparedStatement ps = connection.prepareStatement(DAOQueries.ADD_CATEGORY,Statement.RETURN_GENERATED_KEYS);
		ps.setString(1, category.getCategoryName());	
		ResultSet rs = ps.getGeneratedKeys();
		int cId = rs.getInt(1);
		return cId;
	}

}

package com.ofs.DAOImpl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.ofs.DAO.CategoryDAO;
import com.ofs.exception.AppException;
import com.ofs.model.Product;
import com.ofs.util.DAOQueries;
import com.ofs.util.DatabaseUtil;

public class CategoryDAOImpl implements CategoryDAO {

	public int addCategory (Product category)throws Exception {

		Connection connection = DatabaseUtil.getDbCon();
		PreparedStatement ps = connection.prepareStatement(DAOQueries.ADD_CATEGORY,Statement.RETURN_GENERATED_KEYS);
		ps.setInt(1, category.getmpId());
		ps.setString(2, category.getCategoryName());
		ResultSet rs = ps.getGeneratedKeys();
		int cId = rs.getInt(1);
		return cId;
	}
 
	public List<Product> readAllCategory() throws AppException,Exception{
		
		List<Product> categorylist = new ArrayList<Product>();
		Connection connection = DatabaseUtil.getDbCon();
		PreparedStatement ps = connection.prepareStatement(DAOQueries.VIEW_ALL_CATEGORY);
		ResultSet resultset = ps.executeQuery();
		while (resultset.next()) {
			Product category = new Product();
			category.setcId(resultset.getInt("cid"));
			category.setmpId(resultset.getInt("mpId"));
			category.setCategoryName(resultset.getString("category_name"));
			categorylist.add(category);
		}
		return categorylist;
	}

	public int addParentCategory(Product category) throws SQLException, Exception{
		
		Connection connection = DatabaseUtil.getDbCon();
		PreparedStatement ps = connection.prepareStatement(DAOQueries.ADD_MAIN_CATEGORY,Statement.RETURN_GENERATED_KEYS);
		ps.setString(1, category.getParentCategoryName());
		ResultSet resultset = ps.getGeneratedKeys();
		int mpId = resultset.getInt(1);
		return mpId;
	}

	public List<Product> readAllParentCategory() throws SQLException, Exception{

		List<Product> categorylist = new ArrayList<Product>();
		Connection connection = DatabaseUtil.getDbCon();
		PreparedStatement ps = connection.prepareStatement(DAOQueries.VIEW_ALL_MAIN_CATEGORY);
		ResultSet resultset = ps.executeQuery();
		while (resultset.next()) {
			Product category = new Product();
			category.setmpId(resultset.getInt("mpId"));
			category.setParentCategoryName(resultset.getString("parent_category_name"));
			categorylist.add(category);
		}
		return categorylist;
	}

}

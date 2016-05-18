package com.ofs.DAOImpl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.ofs.DAO.CategoryDAO;
import com.ofs.model.Category;
import com.ofs.util.DAOQueries;
import com.ofs.util.DatabaseUtil;

public class CategoryDAOImpl implements CategoryDAO {

	public int addCategory (Category category)throws Exception {

		Connection connection = DatabaseUtil.getDbCon();
		PreparedStatement ps = connection.prepareStatement(DAOQueries.ADD_CATEGORY,Statement.RETURN_GENERATED_KEYS);
		ps.setInt(1, category.getmpId());
		ps.setString(2, category.getCategoryName());
		ResultSet rs = ps.getGeneratedKeys();
		int cId = rs.getInt(1);
		return cId;
	}

	public List<Category> readAllCategory() throws Exception{
		
		List<Category> categorylist = new ArrayList<Category>();
		Connection connection = DatabaseUtil.getDbCon();
		PreparedStatement ps = connection.prepareStatement(DAOQueries.VIEW_ALL_CATEGORY);
		ResultSet resultset = ps.executeQuery();
		while (resultset.next()) {
			Category category = new Category();
			category.setcID(resultset.getInt("cid"));
			category.setmpId(resultset.getInt("mpId"));
			category.setCategoryName(resultset.getString("category_name"));
			categorylist.add(category);
		}
		return categorylist;
	}

	public int addParentCategory(Category category) throws SQLException, Exception{
		
		Connection connection = DatabaseUtil.getDbCon();
		PreparedStatement ps = connection.prepareStatement(DAOQueries.ADD_MAIN_CATEGORY,Statement.RETURN_GENERATED_KEYS);
		ps.setString(1, category.getParentCategoryName());
		ResultSet resultset = ps.getGeneratedKeys();
		int mpId = resultset.getInt(1);
		return mpId;
	}

	public List<Category> readAllParentCategory() throws SQLException, Exception{

		List<Category> categorylist = new ArrayList<Category>();
		Connection connection = DatabaseUtil.getDbCon();
		PreparedStatement ps = connection.prepareStatement(DAOQueries.VIEW_ALL_MAIN_CATEGORY);
		ResultSet resultset = ps.executeQuery();
		while (resultset.next()) {
			Category category = new Category();
			category.setmpId(resultset.getInt("mpId"));
			category.setParentCategoryName(resultset.getString("parent_category_name"));
			categorylist.add(category);
		}
		return categorylist;
	}

}

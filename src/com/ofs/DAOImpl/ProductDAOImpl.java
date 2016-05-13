package com.ofs.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import com.ofs.model.Product;
import com.ofs.util.DAOQueries;
import com.ofs.util.DatabaseUtil;
import com.ofs.DAO.ProductDAO;


public class ProductDAOImpl implements ProductDAO {

	public int addProduct(Product product) throws Exception {

		Connection connection = DatabaseUtil.getDbCon();
		PreparedStatement ps = connection.prepareStatement(DAOQueries.ADD_PRODUCT,Statement.RETURN_GENERATED_KEYS);
		ps.setString(1, product.getProductName());
		ps.setString(2, product.getProductPrice());
		ps.setString(3, product.getProductQty());
		ps.setString(4, product.getProductDiscount());
		ResultSet rs = ps.getGeneratedKeys();
		int pId = rs.getInt(1);
		return pId;
	}
	

}

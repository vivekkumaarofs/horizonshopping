package com.ofs.DAOImpl;


import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
//import java.util.Base64;
import java.util.List;
import com.ofs.model.Product;
import com.ofs.util.DAOQueries;
import com.ofs.util.DatabaseUtil;
import com.ofs.DAO.ProductDAO;
import com.ofs.exception.AppException;

import javax.sql.rowset.serial.SerialBlob;


public class ProductDAOImpl implements ProductDAO {

	public int addProduct(Product product) throws Exception, AppException {

		Connection connection = DatabaseUtil.getDbCon();
		PreparedStatement ps = connection.prepareStatement(DAOQueries.ADD_PRODUCT,Statement.RETURN_GENERATED_KEYS);
		ps.setInt(1, product.getcId());
		ps.setString(2, product.getProductName());
		ps.setInt(3, product.getProductPrice());
		ps.setInt(4, product.getProductQty());
		ps.setInt(5, product.getProductDiscount());
		byte [] productImage = product.getProductImage();
		Blob blob = new SerialBlob(productImage);
		ps.setBlob(6,blob);
		ps.executeUpdate();
		ResultSet rs = ps.getGeneratedKeys();
		rs.next();
		int pId = rs.getInt(1);
		return pId;

	}

	public List<Product> readAllProduct() throws Exception { 

		List<Product> productList = new ArrayList<Product>();
		Connection connection = DatabaseUtil.getDbCon();
		PreparedStatement ps = connection.prepareStatement(DAOQueries.VIEW_ALL_PRODUCT);
		ResultSet resultset = ps.executeQuery();
		while (resultset.next()) {
			Product product = new Product();
			product.setpId(resultset.getInt("pid"));
			product.setcId(resultset.getInt("cid"));
			product.setProductName(resultset.getString("product_name"));
			product.setProductPrice(resultset.getInt("product_price"));
			product.setProductQty(resultset.getInt("product_qty"));
			product.setProductDiscount(resultset.getInt("product_discount"));	
			byte[] productimage =resultset.getBytes("product_image");
			//String decoded = new String(Base64.getDecoder().decode(productimage));
			product.setProductImage(productimage); 
			productList.add(product);
		}
		return productList;
	}

	public int addShoppingCart(Product shoppingcart) throws Exception {
	
		Connection connection = DatabaseUtil.getDbCon();
		PreparedStatement ps = connection.prepareStatement(DAOQueries.ADD_SHOPPING_CART,Statement.RETURN_GENERATED_KEYS);
		ps.setInt(1, shoppingcart.id);
		ps.setInt(2, shoppingcart.getpId());
		ps.setInt(3, shoppingcart.getProductCount());
		ps.setInt(4, shoppingcart.getTotalAmount());
		ps.executeUpdate();
		ResultSet rs = ps.getGeneratedKeys();
		rs.next();
		int sId = rs.getInt(1);
		return sId;
	}

	public List<Product>readAllShoppingCart() throws Exception {

		Connection connection = DatabaseUtil.getDbCon();
		List<Product> shoppingCartList = new ArrayList<Product>();
		PreparedStatement ps = connection.prepareStatement(DAOQueries.VIEW_ALL_SHOPPING_CART);
		ResultSet resultset = ps.executeQuery();
		while (resultset.next()) {
			Product shoppingcart = new Product();
			shoppingcart.setCartId(resultset.getInt("cart_id"));
			shoppingcart.setpId(resultset.getInt("pId"));
			shoppingcart.setProductCount(resultset.getInt("product_count"));
			shoppingcart.setTotalAmount(resultset.getInt("total_amount"));
			shoppingcart.setOrderDate(resultset.getTimestamp("order_date"));
			shoppingCartList.add(shoppingcart);
		}
		return shoppingCartList;
	}

}
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
		ps.setDouble(6, product.getDiscountprice());
		byte [] productImage = product.getProductImage();
		Blob blob = new SerialBlob(productImage);
		ps.setBlob(7,blob);
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
			product.setDiscountPrice(resultset.getDouble("discount_price"));
			product.setProductQty(resultset.getInt("product_qty"));
			product.setProductDiscount(resultset.getInt("product_discount"));	
			byte[] productimage = new byte[Byte.MAX_VALUE];
			productimage = resultset.getBytes("product_image");		
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

	public int addMainCategory(Product category)throws AppException,Exception{

		Connection connection = DatabaseUtil.getDbCon();
		PreparedStatement ps = connection.prepareStatement(DAOQueries.ADD_MAIN_CATEGORY,Statement.RETURN_GENERATED_KEYS);
		ps.setString(1, category.getParentCategoryName());
		ps.executeUpdate();
		ResultSet rs = ps.getGeneratedKeys();
		rs.next();
		int cId = rs.getInt(1);
		return cId;
	}

	public List<Product>readAllShoppingCart() throws Exception {

		Connection connection = DatabaseUtil.getDbCon();
		List<Product> shoppingCartList = new ArrayList<Product>();
		PreparedStatement ps = connection.prepareStatement(DAOQueries.VIEW_ALL_SHOPPING_CART);
		ResultSet resultset = ps.executeQuery();
		while (resultset.next()) {
			Product shoppingcart = new Product();
			shoppingcart.setcartId(resultset.getInt("cart_id"));
			shoppingcart.setpId(resultset.getInt("pId"));
			shoppingcart.id = (resultset.getInt("id"));
			shoppingcart.setProductCount(resultset.getInt("product_count"));
			shoppingcart.setTotalAmount(resultset.getInt("total_amount"));
			shoppingcart.setOrderDate(resultset.getTimestamp("order_date"));
			shoppingCartList.add(shoppingcart);
		}
		return shoppingCartList;
	}

	public List<Product> readOneShoppingCart(int id) throws Exception {

		Connection connection = DatabaseUtil.getDbCon();
		List<Product> shopcartlist= new ArrayList<Product>();
		PreparedStatement ps = connection.prepareStatement(DAOQueries.VIEW_ONE_SHOPPING_CART);
		ps.setInt(1, id);
		ResultSet resultset = ps.executeQuery();
		while(resultset.next()) {
			Product shopCart = new Product();
			shopCart.setProductCount(resultset.getInt("shop_cart.product_count"));
			shopCart.setcartId(resultset.getInt("shop_cart.cart_id"));
			shopCart.setpId(resultset.getInt("shop_cart.pId"));
			shopCart.setTotalAmount(resultset.getInt("shop_cart.total_amount"));
			shopCart.setProductName(resultset.getString("product.product_name"));
			shopCart.setProductPrice(resultset.getInt("product.product_price"));		
			shopcartlist.add(shopCart);
		}
		return shopcartlist;
	}

	public int deleteOneShoppingCart(Product product) throws Exception {

		Connection connection = DatabaseUtil.getDbCon();
		PreparedStatement ps = connection.prepareStatement(DAOQueries.DELETE_SHOPPING_CART);
		ps.setInt(1, product.id);
		ps.setInt(2, product.getpId());
		int rowsAffected  = ps.executeUpdate();
		return rowsAffected;
	}

	public int updateOneShoppingCart(Product shoppingCart) throws Exception {

		Connection connection = DatabaseUtil.getDbCon();
		PreparedStatement ps = connection.prepareStatement(DAOQueries.MODIFY_SHOPPING_CART);
		ps.setInt(1, shoppingCart.getProductCount());
		ps.setInt(2, shoppingCart.getTotalAmount());
		ps.setInt(3, shoppingCart.getpId());
		ps.setInt(4, shoppingCart.id);
		int rowsAffected = ps.executeUpdate();
		return rowsAffected;
	}

	public List<Product> purchaseOrder() throws Exception,AppException{

		Connection connection = DatabaseUtil.getDbCon();
		List<Product> purchaseOrderList = new ArrayList<Product>();
		PreparedStatement ps = connection.prepareStatement(DAOQueries.VIEW_PURCHASE_ORDER);
		ResultSet resultset = ps.executeQuery();
		while(resultset.next()) {
		Product purchaseOrder = new Product();
			purchaseOrder.id = resultset.getInt("user_info.id");
			purchaseOrder.userName = resultset.getString("user_info.name");
			purchaseOrder.gender = resultset.getString("user_info.gender");
			purchaseOrder.address = resultset.getString("user_info.address");
			purchaseOrder.city = resultset.getString("user_info.city");
			purchaseOrder.pincode = resultset.getInt("user_info.pincode");
			purchaseOrder.setCategoryName(resultset.getString("product_category.category_name"));
			purchaseOrder.setProductName(resultset.getString("product.product_name"));
			purchaseOrder.setProductCount(resultset.getInt("shop_cart.product_count"));
			purchaseOrder.setTotalAmount(resultset.getInt("shop_cart.total_amount"));
			purchaseOrder.setOrderDate(resultset.getTimestamp("shop_cart.order_date"));
			purchaseOrderList.add(purchaseOrder);
		}
		return purchaseOrderList;
	}

}

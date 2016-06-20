package com.ofs.util;

public class DAOQueries {

	public final static String ADD_DETAILS = new StringBuilder().
			append(" INSERT INTO user_info     ").
			append("             (name,        ").
			append("             date_of_birth,").
			append("             user_name,    ").
			append("             password,     ").
			append("             gender,       ").
			append("             address,      ").
			append("             city,         ").
			append("             pincode,      ").
			append("             user_type,    ").
			append("             email_id,     ").
			append("             status)       ").
			append(" VALUES     (?, ?,         ").
			append("             ?, ?,         ").
			append("             ?, ?,         ").
			append("             ?, ?,         ").
			append("             ?, ?, ?);     ").
			toString(); 

	public final static String ADD_PRODUCT = new StringBuilder().
			append(" INSERT INTO product         ").
			append("          (cId,              ").
			append("           product_name,     ").	
			append("           product_price,    ").
			append("           product_qty,      ").
			append("           product_discount, ").
			append("           discount_price,   ").
			append("           product_image )   ").
			append(" VALUES  ( ?, ?, ?,          ").
			append("           ?, ?,?,? );           ").
			toString();
	
	public final static String ADD_CATEGORY = new StringBuilder().
			append("INSERT INTO product_category     ").
			append("            (mpId,category_name) ").
			append(" VALUES     ( ?, ? );            ").
			toString();
	
	public final static String ADD_MAIN_CATEGORY = new StringBuilder().
			append(" INSERT INTO product_main_category ").
			append("            (parent_category_name) ").
			append(" VALUES     (?);                   ").
			toString();
	

	public final static String ADD_SHOPPING_CART = new StringBuilder().
			append(" INSERT INTO shop_cart    ").
			append("          (id,            ").
			append("     	   pId,	          ").
			append("     	   product_count, ").
			append("           total_amount)  ").
			append(" VALUES   ( ? , ?,        ").
			append("            ? , ?      ); ").
			toString();

	public final static String UPDATE_USER_DETAILS = new StringBuilder().
			append(" UPDATE user_info      ").
			append(" SET	password =?,   ").
			append("		address =?,    ").
			append("		city =?,       ").
			append("		pincode =?     ").
			append(" WHERE id = ?;         ").
			toString();

	public final static String MODIFY_DETAILS = new StringBuilder().
			append(" UPDATE user_info       ").
			append(" SET    (user_name = ?, ").
			append("         password  = ?, ").
			append("         address   = ?, ").
			append("         city      = ?, ").
			append("         email_id  = ?, ").
			append("         pincode   = ?) ").
			append(" WHERE   id = ? ;       ").
			toString(); 

	public final static String MODIFY_SHOPPING_CART = new StringBuilder().
			append(" UPDATE shop_cart           ").
			append(" SET    product_count = ?,  ").
			append("        total_amount = ?    ").
			append(" WHERE  pId = ? and id = ?; ").
			toString();

	public static final String USER_APPROVAL = new StringBuilder().
			append(" UPDATE user_info  ").
			append(" SET    status = ? ").
			append(" WHERE  id= ?;     ").
			toString();


	public final static String VIEW_ALL_MAIN_CATEGORY = new StringBuilder().
			append(" SELECT  mpId,                  ").
			append("         parent_category_name   ").
			append(" FROM    product_main_category; ").
			toString();

	public final static String VIEW_DETAILS = new StringBuilder().
			append(" SELECT   status,user_type,id ").
			append(" FROM  user_info 		      ").
			append(" WHERE user_name =?     	  ").
			append(" AND   password  =?;   		  ").
			toString();
	
	public final static String VIEW_USER_DETAILS = new StringBuilder().
			append(" SELECT name,          ").
			append("		date_of_birth, ").
			append("		user_name,     ").    
			append("		password,      ").     
			append("		gender,        ").      
			append("		address,       ").      
			append("		city,          ").      
			append("		pincode,       ").      
			append("		email_id       ").     
			append(" FROM  user_info       ").
			append(" WHERE id = ?;         ").	
			toString();
	
	public final static String VIEW__ALL_USER_DETAILS = new StringBuilder().
			append(" SELECT id,            ").			
			append("        name,          ").
			append("		date_of_birth, ").
			append("		user_name,     ").    
			append("		password,      ").     
			append("		gender,        ").      
			append("		address,       ").      
			append("		city,          ").      
			append("		pincode,       ").      
			append("		email_id,      ").
			append("		status,        ").
			append("		approve        ").
			append(" FROM  user_info;      ").
			toString();

	public final static String VIEW_ALL_PRODUCT = new StringBuilder().
			append(" SELECT pId,             ").
			append("        cId,             ").
			append("        product_name,    ").
			append("        product_price,   ").
			append("        product_qty,     ").
			append("        product_discount,").
			append("		discount_price,  ").
			append("        product_image    ").
			append(" FROM   product;         ").
			toString();

	public final static String VIEW_ALL_CATEGORY = new StringBuilder().
			append(" SELECT cId,mpId,         ").
			append("        category_name     ").
			append(" FROM   product_category; ").
			toString();


	public final static String VIEW_ALL_SHOPPING_CART = new StringBuilder().
			append(" SELECT cart_id,		").
			append("		id,				").
			append("		pId,			").
			append("		product_count,	").
			append("		total_amount,	").
			append("		order_date		").
			append(" FROM shop_cart;		").
			toString();

	public final static String DELETE_SHOPPING_CART = new StringBuilder().
			append(" DELETE FROM  shop_cart ").
			append("        WHERE  id =?    ").
			append("        and    pId= ?;  ").
			toString();

	public final static String VIEW_ONE_SHOPPING_CART = new StringBuilder().
			append(" SELECT shop_cart.product_count, ").
			append("        shop_cart.pId,           ").
			append("        shop_cart.cart_id,       ").
			append("        shop_cart.total_amount,  ").
			append("        product.product_name,    ").	
			append("        product_price            ").
			append(" FROM   shop_cart    			 ").
			append(" JOIN   product ON    		     ").
			append("        shop_cart.pId =          ").
			append("        product.pId              ").
			append(" WHERE  shop_cart.id= ?;         ").
			toString();
	
}

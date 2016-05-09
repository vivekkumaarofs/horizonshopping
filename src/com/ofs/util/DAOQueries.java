package com.ofs.util;

public class DAOQueries {

	public final static String ADD_DETAILS = new StringBuilder().
			append("INSERT INTO user_info      ").
			append("            (name,         ").
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
			append("VALUES      (?, ?,         ").
			append("             ?, ?,         ").
			append("             ?, ?,         ").
			append("             ?, ?,         ").
			append("             ?, ?, ?);     ").
			toString(); 
  
	public final static String MODIFY_DETAILS = new StringBuilder().
		    append("UPDATE user_info       ").
		    append("SET    (user_name = ?, ").
		    append("        password  = ?  ").
		    append("        address   = ?  ").
		    append("        city      = ?  ").
		    append("        email_id  = ?  ").
		    append("        pincode   = ?,)").
		    append("WHERE   id = ? ;       ").
		toString(); 

	public final static String VIEW_DETAILS = new StringBuilder().
			append(" SELECT    user_type,id ").
			append(" FROM  user_info        ").
			append(" WHERE user_name =?     ").
			append(" AND   password  =?;    ").
			toString();
	
	public final static String DELETE_DETAILS = new StringBuilder().
			append(" DELETE user_info   ").
			append("      WHERE  id =?; ").
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
 
	public final static String UPDATE_USER_DETAILS = new StringBuilder().
			append(" UPDATE user_info      ").
			append(" SET	password =?,   ").     
			append("		address =?,    ").      
			append("		city =?,       ").      
			append("		pincode =?     ").      
			append(" WHERE id = ?;         ").
			toString();

	public static final String USER_APPROVAL = new StringBuilder().
			append(" UPDATE user_info    ").
			append(" SET    approval = ? ").
			append(" WHERE  id= ?;       ").
			toString();

} 

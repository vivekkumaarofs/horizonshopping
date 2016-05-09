package com.ofs.util;

import java.sql.Connection;
import java.sql.DriverManager;


public class DatabaseUtil {

    public Connection connection;
    public static DatabaseUtil db;

    private DatabaseUtil() throws Exception {
    	
        	String connectionUrl = "jdbc:mysql://localhost:3306/online_sho?user=root&password=MYsql123$";            
            String driver = "com.mysql.jdbc.Driver";
            Class.forName(driver);
            this.connection = (Connection)DriverManager.getConnection(connectionUrl);
    }

    public static synchronized Connection getDbCon() throws Exception {

    	if (db == null) {
            db = new DatabaseUtil();
        }
        return db.connection;
    }

}

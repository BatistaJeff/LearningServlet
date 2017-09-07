package br.com.uninove.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

	public static Connection getConnection() throws Exception {
		
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/uninove";
		String user = "root";
		String passwd = "root";
		
		Class.forName(driver);
		
		Connection result = DriverManager.getConnection(url,user,passwd);
		
		return result;
	}
	
}

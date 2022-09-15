package com.bridgelabz.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDB {   
	static Connection con;
	public static Connection createCP() throws Exception   {   
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost/payroll_service", "root", "1234");
		
		return con;
		
	}

}

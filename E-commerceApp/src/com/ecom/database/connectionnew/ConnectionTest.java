package com.ecom.database.connectionnew;

import java.sql.Connection;  
import java.sql.DriverManager;

public class ConnectionTest {

	Connection connection = null ;
	
	public Connection getConnectionDetails()
	{
		try {
			//Loading the Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
		  connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecom", "root", "1224");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		return connection;
	}
}

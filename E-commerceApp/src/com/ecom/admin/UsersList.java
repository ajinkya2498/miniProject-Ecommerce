package com.ecom.admin;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.ecom.database.connectionnew.ConnectionTest;

public class UsersList {
	
	
	public void userdata()throws ClassNotFoundException, SQLException {

		ConnectionTest test= new  ConnectionTest();
	    Connection con=test.getConnectionDetails();
		
		Statement statement = con.createStatement();
		
		ResultSet rs= statement.executeQuery("select * from users");
		
		while (rs.next()) {
			
			System.out.println("FirstName " + rs.getString(2)+"  " +  "Surname " + rs.getString(3)+ "  " + "Email id " + rs.getString(4)+"  " + "Password " + rs.getString(5) +"  " + "  "  );
		
		System.out.println("----------------------------------------------------------------------------------------");
		}
		
		con.close();
		
		rs.close();
		
		statement.close();
			
		}

	}
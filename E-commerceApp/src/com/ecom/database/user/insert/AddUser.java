package com.ecom.database.user.insert;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.ecom.database.connectionnew.ConnectionTest;

public class AddUser {
Connection con=null;
PreparedStatement prepareStatement = null;


public  void AddUserdata() throws SQLException {
		
		
		try {// load driver  and get connection object
			ConnectionTest test=new ConnectionTest();
			
			con=test.getConnectionDetails();
			//scaneer for user input
			Scanner sc=new Scanner(System.in);
			// inserting user data into database
			prepareStatement =con.prepareStatement("insert into users (fname,lname,email,password) values(?,?,?,?)");
			System.out.println("enter your firstname");
			String fname=sc.next();
			System.out.println("enter your Lasttname");
			String lname=sc.next();
			System.out.println("enter your emailID");
			String email=sc.next();
			System.out.println("enter your password");
			String password=sc.next();
			prepareStatement.setString(1, fname);
			prepareStatement.setString(2, lname);
			prepareStatement.setString(3, email);
			prepareStatement.setString(4, password);
			int i = prepareStatement.executeUpdate();
			 System.out.println("Record is inserted : " +i);
			 System.out.println("signup is successfull  ");
			 System.out.println("please restart the app");
			 sc.close();
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		finally {
			con.close();
			prepareStatement.close();
		}
	
	}
	
}

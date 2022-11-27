package com.ecom.admin;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.ecom.database.connectionnew.ConnectionTest;

public class AdminLogin {
public void adminlog() throws ClassNotFoundException, SQLException  {
	Scanner sc=new Scanner(System.in);
	//Load Driver and get conectionObject
	ConnectionTest test= new ConnectionTest();
	Connection con=test.getConnectionDetails();
	
	Statement P = con.createStatement();
	
	//select data of registered user

	ResultSet rs = P.executeQuery("select * from admin");
	while(rs.next()) {
		//get username from admin i.e. email
		System.out.println("welcome to ADMIN login");
		System.out.println("Enter your admin email: ");
        String email = sc.next();
		
		//take Password from admin
		
		System.out.println("Enter your adminPassword: ");

		String password = sc.next();
		// verify username (email address) and password 
		// allow only verified admin to website
		if((email.contentEquals(rs.getString(3)))&& (password.contentEquals(rs.getString(4)))) {
			String fname=rs.getString(2);
			System.out.println("hi" +fname+"welcome to admin panel");
			
			
			System.out.println("Select any option to get information");
			
			System.out.println("Enter 1: To see Product Quantity ");
			
			System.out.println("Enter 2: To see User Purchase History");
			
			System.out.println("Enter 3: To see UserRegistered List");
			System.out.println("Enter 4: To add prodcuts");
			
			int option = sc.nextInt();
			
			switch(option) {
			
			case 1: 
				ProductQuantityCheck productQuantity =new ProductQuantityCheck();
				
				productQuantity.ProductCheck();
				
				break;
			
			case 2:
				
				UserHistory userhistroy = new UserHistory();
				
				userhistroy.userDataDetails();
				
				break;
				
			case 3:
				UsersList userlist = new UsersList();
				
				userlist.userdata();
				
				break;
				
			case 4:
				 AddProducts ap=new AddProducts();
				 ap.productsAdd();
				 break;
		
			default:
				
				System.out.println("Please Select Correct Option");
			}
		
	}}}}



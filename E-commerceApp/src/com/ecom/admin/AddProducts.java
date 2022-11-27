package com.ecom.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.ecom.database.connectionnew.ConnectionTest;

public class AddProducts {
 public void productsAdd()  {
	 
		PreparedStatement P;
		try {   Scanner sc=new Scanner(System.in);
		//Load Driver and get conectionObject
		ConnectionTest test= new ConnectionTest();
		Connection con=test.getConnectionDetails();
			P = con.prepareStatement("insert into product(name,description,price,quantity,category) values(?,?,?,?,?)");
			System.out.println("Enter Product name: ");
			
			String name = sc.next();
			
			P.setString(1, name);
			
			System.out.println("Enter Product description: ");
			
			String des = sc.next();
			
			P.setString(2, des);
			
			System.out.println("Enter Product price: ");
			
			int price = sc.nextInt();
			
			P.setInt(3, price);
			
			System.out.println("Enter Product quantity: ");
			
			int quantity = sc.nextInt();
			
			P.setInt(4, quantity);
			
	        System.out.println("Enter Product category: ");
			
			String category = sc.next();
			
			P.setString(5, category);
			
			int o = P.executeUpdate();
			
			System.out.println("Product Added........ " + o);
			
			P.close();
			con.close();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
		
 }
}

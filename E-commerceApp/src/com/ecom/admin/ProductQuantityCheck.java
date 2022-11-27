package com.ecom.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.ecom.database.connectionnew.ConnectionTest;

public class ProductQuantityCheck {
	
	
	Connection con=null;
	PreparedStatement prepareStatement = null;
	public void ProductCheck() throws ClassNotFoundException,SQLException {
	   
		ConnectionTest test= new  ConnectionTest();
        con=test.getConnectionDetails();
        Scanner scaa=new Scanner(System.in);
        prepareStatement=con.prepareStatement("select quantity from products where id=? ");
        System.out.println("Enter ProductId to know Quantity of Product");
        int pid=scaa.nextInt();
        prepareStatement.setInt(1, pid);
         ResultSet rs= prepareStatement.executeQuery();
		
		while(rs.next()) {
			
			System.out.println("Product Quantity for " + pid + " is = "+ rs.getInt(1));
		}

		con.close();
		prepareStatement.close();
	
	
	
	}

	
	
}

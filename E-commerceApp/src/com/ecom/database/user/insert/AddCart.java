package com.ecom.database.user.insert;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.ecom.database.connectionnew.ConnectionTest;
import com.ecom.product.purchase.CalculateTotal;

public class AddCart {
	
	Connection con=null;
	PreparedStatement prepareStatement = null;
	PreparedStatement ps = null;
	PreparedStatement pp = null;
	 public void AddtoCart(String name,int userid) throws SQLException {
		
		
	   try { 
	    	ConnectionTest test= new  ConnectionTest();
	        con=test.getConnectionDetails();
			prepareStatement=con.prepareStatement("insert into cart(id,name,description,price) select id,name,description,price from products where name = ?");
			Scanner sc=new Scanner(System.in);
			System.out.println("enter the name of product to add to cart  >>>> or calculate total Bill,Please relogin :\" ");
		    String pname=sc.next();
		    prepareStatement.setString(1,pname);
		    prepareStatement.executeUpdate();
		    
		    ps=con.prepareStatement("update cart set uid=? where name=?");
		    ps.setInt(1, userid);
		    ps.setString(2, pname);
		    ps.executeUpdate();
			System.out.println("Product added to cart");
			
	    
	    } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	    finally {
			con.close();
			prepareStatement.close();
		}
	}}


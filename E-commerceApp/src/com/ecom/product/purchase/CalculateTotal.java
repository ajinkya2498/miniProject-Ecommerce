package com.ecom.product.purchase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.ecom.database.connectionnew.ConnectionTest;

public class CalculateTotal {
	Connection con=null;
	PreparedStatement S = null;
	
	public void totalBill(int userid) {
		
	try { 	
	    	  //load Driver class & create connection 
	    		ConnectionTest test=new ConnectionTest();
	    		
	    		con=test.getConnectionDetails();
	    	         
	    			// create statement
	            S=con.prepareStatement("select Sum(price) from ecom.cart where uid=?");
			//execute query
			S.setInt(1, userid);
			ResultSet rs= S.executeQuery();
			
			//print total bill amount
			
			while(rs.next()) {
	       
			System.out.println("Your total Bill Amount: " + rs.getInt(1));
			}
			}
			catch (SQLException e) 
	      {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	      
	      
		} 
		
		
		  
		
}


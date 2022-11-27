package com.ecom.database.user.insert;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.ecom.database.connectionnew.ConnectionTest;


public class GetALLProducts {

	
	Connection con=null;
	public void getProducts() {
		
		try { 
		    ConnectionTest test= new  ConnectionTest();
		    con=test.getConnectionDetails();
			Statement stmt=con.createStatement();
			String s="select * from products";
			ResultSet rs=stmt.executeQuery(s);
			while(rs.next()) {
				
System.out.println("id "+rs.getInt(1)+""
+"name "+rs.getString(2)+" " + "Price "+rs.getInt(4)+" " + "category "+rs.getString(6)+" " + "    quantity "+rs.getInt(5)+" " + "    description= "+rs.getString(3) );
			}
			
			//System.out.println("productid= " + rs.getInt(1)+" " + "productname= "+ rs.getString(2)+" "+ "Description= "+ rs.getString(3)+" " + "Price= "+ rs.getInt(5));
			
	
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	
}

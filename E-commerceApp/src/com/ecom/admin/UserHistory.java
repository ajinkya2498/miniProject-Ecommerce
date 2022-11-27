package com.ecom.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.Scanner;

import com.ecom.database.connectionnew.ConnectionTest;

public class UserHistory {
	
	
	Connection con=null;
	PreparedStatement ps2= null;
	PreparedStatement ps=null;
public void userDataDetails() throws SQLException {
	ConnectionTest test= new  ConnectionTest();
    con=test.getConnectionDetails();
	
	
	
	
	Scanner sc=new Scanner(System.in);
	ps=con.prepareStatement("select fname,lname from users where uid=?");
	ps2=con.prepareStatement("select * from cart where uid=?");
	System.out.println("eneter users id");
	int uid=sc.nextInt();
	ps.setInt(1, uid);
	ps2.setInt(1, uid);
	ResultSet rs1=ps.executeQuery();
	ResultSet rscart=ps2.executeQuery();    
	while (rs1.next()) {

		System.out.println("Customer Name >> " + rs1.getString(1) + " " + rs1.getString(2));

		System.out.println("Customer Purchase details as below: ");

		System.out.println("----------------------------------------------------------");
	}
	
	while (rscart.next()) {

		System.out.println("cartid" + " " + rscart.getInt(1) + " " + "Product Name " + " " + rscart.getString(2) + "  "
				+ "Price " + rscart.getString(4));

	}
	con.close();
	ps.close();
	ps2.close();
}
}

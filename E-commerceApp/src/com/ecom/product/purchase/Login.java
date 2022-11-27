package com.ecom.product.purchase;

import java.io.IOException;
import java.sql.Connection; 
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.NoSuchElementException;
import java.util.Scanner;

import com.ecom.admin.AdminLogin;
import com.ecom.database.connectionnew.ConnectionTest;
import com.ecom.database.user.insert.AddUser;

public class Login {
	
	public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException  {
		// TODO Auto-generated method stub
		
		System.out.println("Welcome to ecom ");
		Scanner sc=new Scanner(System.in);
		//Load Driver and get conectionObject
		ConnectionTest test= new ConnectionTest();
		Connection con=test.getConnectionDetails();
		
		Statement P = con.createStatement();
		
		//select data of registered user from user database

		ResultSet rs = P.executeQuery("select * from users");
		//get username from user
		System.out.println("Enter your registered user email: ");
         String email = sc.next();
		
		//take Password from user
		
		System.out.println("Enter your Password: ");

	    String password = sc.next();
		
		while(rs.next()) {
			
			
			
			// verify username (email address) and password 
			// allow only verified users to website
			if((email.contentEquals(rs.getString(4))) && (password.contentEquals(rs.getString(5)))) {
				String fname=rs.getString(2);
				int userid=rs.getInt(1);
			
				System.out.println("hi" +fname+   "  welcome to ecom shop ");
                 System.out.println("Press Enter to continue");
				
				System.in.read();
				// option to select desired operation
				System.out.println("select any option from below to continue shopping");
                
				System.out.println("Enter 1: Select & add product to cart");
				
				System.out.println("Enter 2: Calculate your Bill amount");
				
				System.out.println("Enter 3: Admin Section");

				int option = sc.nextInt();
				switch(option) {
				case 1:
					Purchase purchase=new Purchase(fname,userid);
					purchase.getPurchase();
					break;
					
                case 2:
					
					CalculateTotal calculateTotal = new CalculateTotal();
					
					calculateTotal.totalBill(userid);
					break;
                case 3:
                	 AdminLogin adminlogin=new AdminLogin(); 
                
						adminlogin.adminlog();
			
					
                	 break;
                	 
                default:
                	System.out.println("enter correct option");
				}
			}
			
			
			else {
				System.out.println("check your email and a password or if you dont have account then signup  below");
			    System.out.println("press 1 to sign up");
			    int sn=sc.nextInt();
			    switch(sn) {
			    case 1:
			    	AddUser adduser=new AddUser();
			    	adduser.AddUserdata();
		             break;
					
				default:
					
				System.exit(0);
					
			    }
			    
			}
		}
	}

}
